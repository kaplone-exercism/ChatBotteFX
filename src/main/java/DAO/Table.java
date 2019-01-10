package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Table {

    Check check = new Check();
    static Writer writer = new Writer();
    static String sql;

    public static void checkAllTables(){
        createTableTypeReponse();
        createTableReponse();
        createTableQuestion();
        createTableMatch();
        createTableSource();
        createTableVocabulaire();
        createTableLien();
    }

    public static void createTableReponse() {

        String nom = "REPONSE";
        String ddl = "CREATE TABLE REPONSE" +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"  +
                "TEXTE TEXT NOT NULL, " +
                "ID_TYPE INTEGER NOT NULL)";

        Boolean nouvelleTable = createTable(nom, ddl);

        if (nouvelleTable){
            sql = "INSERT INTO REPONSE (ID,TEXTE, ID_TYPE)" +
                    "VALUES (null , 'OUI', 1);";
            writer.insertIntoTable(sql);

            sql = "INSERT INTO REPONSE (ID,TEXTE, ID_TYPE)" +
                    "VALUES (null , 'NON', 2);";
            writer.insertIntoTable(sql);
        }
    }

    public static void createTableTypeReponse() {

        String nom = "SOURCE";
        String ddl = "CREATE TABLE TYPE_REPONSE (\n" +
                "ID INTEGER NOT NULL, \n" +
                "TYPE VARCHAR(20) NOT NULL, \n" +
                "CONSTRAINT TYPE_REPONSE_PK PRIMARY KEY (ID))";

        Boolean nouvelleTable = createTable(nom, ddl);

        if (nouvelleTable) {

            sql = "INSERT INTO TYPE_REPONSE (ID,TYPE)" +
                    "VALUES (null , 'Positif');";
            writer.insertIntoTable(sql);

            sql = "INSERT INTO TYPE_REPONSE (ID,TYPE)" +
                    "VALUES (null , 'Négatif');";
            writer.insertIntoTable(sql);

            sql = "INSERT INTO TYPE_REPONSE (ID,TYPE)" +
                    "VALUES (null , 'Neutre');";
            writer.insertIntoTable(sql);

            sql = "INSERT INTO TYPE_REPONSE (ID,TYPE)" +
                    "VALUES (null , 'Inconnu');";
            writer.insertIntoTable(sql);
        }
    }

    public static void createTableQuestion() {

        String nom = "QUESTION";
        String ddl = "CREATE TABLE QUESTION(ID  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "TEXTE  TEXT NOT NULL)";

        Boolean nouvelleTable = createTable(nom, ddl);

        if (nouvelleTable) {
            sql = "INSERT INTO QUESTION (ID,TEXTE)" +
                    "VALUES (null , 'On commence ?');";
            writer.insertIntoTable(sql);
        }
    }

    public static void createTableMatch() {

        String nom = "MATCH";
        String ddl = "CREATE TABLE MATCH (\n" +
                "ID INTEGER NOT NULL,\n" +
                "QUALITE INTEGER NOT NULL,\n" +
                "    QUESTION_ID INTEGER NOT NULL,\n" +
                "    REPONSE_ID INTEGER NOT NULL,\n" +
                "CONSTRAINT MATCH_PK PRIMARY KEY (ID),\n" +
                "CONSTRAINT MATCH_QUESTION_FK FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION(ID),\n" +
                "CONSTRAINT MATCH_REPONSE_FK FOREIGN KEY (REPONSE_ID) REFERENCES REPONSE(ID)\n" +
                ")";

        createTable(nom, ddl);
    }

    public static void createTableVocabulaire() {

        String nom = "VOCABULAIRE";
        String ddl = "CREATE TABLE VOCABULAIRE (\n" +
                "ID INTEGER NOT NULL,\n" +
                "QUALITE INTEGER NOT NULL,\n" +
                "VALEUR VARCHAR(30) NOT NULL,\n" +
                "MOTS TEXT NOT NULL,\n" +
                "PHRASES TEXT NOT NULL,\n" +
                "CONSTRAINT VOCABULAIRE_PK PRIMARY KEY (ID)\n" +
                ")";
        createTable(nom, ddl);
    }

    public static void createTableLien() {

        String nom = "LIEN";
        String ddl = "CREATE TABLE LIEN (\n" +
                "ID INTEGER NOT NULL,\n" +
                "QUALITE INTEGER NOT NULL,\n" +
                "VOCABULAIRE_REQUETE_ID INTEGER NOT NULL,\n" +
                "VOCABULAIRE_RESULTAT_ID INTEGER NOT NULL,\n" +
                "COMPTE INTEGER NOT NULL,\n" +
                "CONSTRAINT LIEN_PK PRIMARY KEY (ID),\n" +
                "CONSTRAINT LIEN_REQUETE_FK FOREIGN KEY (VOCABULAIRE_REQUETE_ID) REFERENCES VOCABULAIRE(ID),\n" +
                "CONSTRAINT LIEN_RESULTAT_FK FOREIGN KEY (VOCABULAIRE_RESULTAT_ID) REFERENCES VOCABULAIRE(ID)\n" +
                ")";
        createTable(nom, ddl);
    }



    public static void createTableSource() {

        String nom = "SOURCE";
        String ddl = "CREATE TABLE SOURCE (\n" +
                "ID INTEGER NOT NULL,\n" +
                "URL VARCHAR(100) NOT NULL,\n" +
                "CONSTRAINT SOURCE_PK PRIMARY KEY (ID)\n" +
                ")";

        createTable(nom, ddl);
    }

    public static Boolean createTable(String nom, String ddl){

        Boolean aCreer = !Check.isTablePresente(nom);
        if (aCreer) {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:db/chatbotte.db");

                stmt = c.createStatement();
                stmt.executeUpdate(ddl);
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Table " + nom + " créée");
        }
        else {
            System.out.println("Table " + nom + " présente");
        }
        return aCreer;
    }
}
