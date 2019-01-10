package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Constantes.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static model.Constantes.Type.QUESTION;

public class Cellule extends Rectangle{

    private Type typeCellule;
    private String texte;
    private Color couleur_rectangle;
    private Color couleur_texte;
    private String user;

    public Type getTypeCellule() {
        return typeCellule;
    }

    public String getTexte(Integer longueur) {

        if (longueur == null){
            longueur = 25;
        }

        if (texte.length() < longueur){
            return texte;
        }

        String texteFormateBase = texte;
        List<String> parties  = new ArrayList<>();
        while (texteFormateBase.length() > 0){
            parties.add(texteFormateBase.substring(0, Math.min(texteFormateBase.length(),longueur)));
            texteFormateBase = texteFormateBase.substring(Math.min(texteFormateBase.length(), longueur),texteFormateBase.length());
            System.out.println(texteFormateBase);
        }

        //parties.add(texteFormateBase);
        //System.out.println(parties.stream().collect(Collectors.joining("\n")));
        return parties.stream().collect(Collectors.joining("\n"));
    }

    public Cellule(Type typeCellule, String texte, String user) {
        super();
        this.typeCellule = typeCellule;
        this.texte = texte;
        this.user = user;

        this.couleur_texte = typeCellule.equals(QUESTION) ? Color.BROWN : Color.GREEN;
        this.couleur_rectangle = typeCellule.equals(QUESTION) ? Color.CORAL : Color.LIMEGREEN;
        this.prefHeight(25);
        this.prefWidth(200);
        this.fillProperty().setValue(couleur_rectangle);
        this.arcHeightProperty().setValue(10);
        this.arcWidthProperty().setValue(10);
    }

    public Color getCouleur_texte() {
        return couleur_texte;
    }

    public String getUser() {
        return user;
    }
}
