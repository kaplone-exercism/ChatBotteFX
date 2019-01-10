package util;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Cellule;

import static model.Constantes.Type.QUESTION;

public class CelluleToPane {

    public static VBox convert (Cellule cellule) {

        VBox vBox = new VBox();


        if (cellule.getTypeCellule().equals(QUESTION)) {
            Label label = new Label();
            vBox.getChildren().add(label);
            label.textProperty().setValue("Question : ");
            label.setFont(Font.font("sans",FontWeight.BOLD, 14));
            Label label2 = new Label();
            vBox.getChildren().add(label2);
            label2.setText(cellule.getTexte(30));
            vBox.alignmentProperty().setValue(Pos.CENTER_LEFT);
            label.textFillProperty().setValue(cellule.getCouleur_texte());
            label2.textFillProperty().setValue(cellule.getCouleur_texte());
        } else {
            Label label = new Label();
            vBox.getChildren().add(label);
            label.textProperty().setValue(cellule.getUser());
            label.setFont(Font.font("sans",FontWeight.BOLD, 14));
            Label label2 = new Label();
            vBox.getChildren().add(label2);
            label2.setText(cellule.getTexte(30));
            vBox.alignmentProperty().setValue(Pos.CENTER_RIGHT);
            label.textFillProperty().setValue(cellule.getCouleur_texte());
            label2.textFillProperty().setValue(cellule.getCouleur_texte());
        }

        return vBox;
    }
}
