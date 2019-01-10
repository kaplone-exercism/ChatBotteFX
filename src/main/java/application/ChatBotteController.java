package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import DAO.Check;
import DAO.Mapper;
import DAO.mapper.QuestionMapper;
import DAO.Reader;
import DAO.mapper.TypeReponseMapper;
import model.Cellule;
import model.Question;
import model.TypeReponse;
import util.CelluleToPane;
import util.PopUp;
import util.SQLiteJDBC;
import util.UrlReader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static model.Constantes.Type.QUESTION;
import static model.Constantes.Type.REPONSE;

public class ChatBotteController implements Initializable {

    @FXML
    public ListView<VBox> listeSession;
    private ObservableList<Cellule> cellules;
    private ObservableList<VBox> cellulesPane;

    @FXML
    public Button okButton;

    @FXML
    public TextField textField1;

    @FXML
    public MenuItem newSession;

    @FXML
    public MenuItem testVocabulaire;

    private String user;
    private NewSessionController newSessionController;
    private TestVocabulaireController testVocabulaireController;

    private Reader reader= new Reader();
    private Mapper<Question> questionMapper = new QuestionMapper();
    private Mapper<TypeReponse> typeReponseMapper = new TypeReponseMapper();
    private PopUp popUp = new PopUp();

    public void setUser(String user) {
        this.user = user;
    }

    public ObservableList<VBox> getCellulesPane() {
        return cellulesPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SQLiteJDBC test = new SQLiteJDBC();

        Check.testIfInitialized();

        //test.insertIntoTable();

        try {
            UrlReader.readURL("dialogue", 4, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        user = "Réponse";

        cellules = FXCollections.observableArrayList();
        cellulesPane = FXCollections.observableArrayList();

        listeSession.setItems(cellulesPane);


        Question question = reader.getElement("ID = 1", questionMapper);
        TypeReponse typeReponse = reader.getElement("ID = 1", typeReponseMapper);
        cellulesPane.add(CelluleToPane.convert(new Cellule(QUESTION, question.getTexte(), null)));

        okButton.onActionProperty().setValue(a -> {
            cellulesPane.add(CelluleToPane.convert(new Cellule(REPONSE, textField1.getText(), user)));
            textField1.clear();
        });
        textField1.onKeyPressedProperty().setValue(a -> {
            if (a.getCode().equals(KeyCode.ENTER)){
                cellulesPane.add(CelluleToPane.convert(new Cellule(REPONSE, textField1.getText(), user)));
                textField1.clear();
            }
        });

        newSession.onActionProperty().setValue(a -> {
            try {
                popUp.createPopUp("newSession.fxml", "Nouvelle session", this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        testVocabulaire.onActionProperty().setValue(a -> {
            try {
                popUp.createPopUp("testVocabulaire.fxml", "Test de recherche de vocabulaire", this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

    }
}
