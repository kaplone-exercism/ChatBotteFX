package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cellule;
import util.CelluleToPane;

import java.net.URL;
import java.util.ResourceBundle;

import static model.Type.QUESTION;

public class NewSessionController implements Initializable {

    private static Stage stage;
    private static ChatBotteController controller;

    @FXML
    public TextField newNom;

    @FXML
    public Button newNomAnnuler;
    @FXML
    public Button newNomCreer;

    @FXML
    public AnchorPane modalNew;

    public static void setStage(Stage stage) {
        NewSessionController.stage = stage;
    }

    public static void setController(ChatBotteController controller) {
        NewSessionController.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        newNom.onKeyPressedProperty().setValue(a -> {
            if (a.getCode().equals(KeyCode.ENTER)){
                controller.setUser(newNom.getText());
                controller.getCellulesPane().clear();
                controller.getCellulesPane().add(CelluleToPane.convert(new Cellule(QUESTION, "Bonjour " + newNom.getText() + ". On commence ?", null)));
                stage.close();
            }
        });
        newNomAnnuler.onActionProperty().setValue(a -> stage.close());
        newNomCreer.onActionProperty().setValue(a -> {
            controller.setUser(newNom.getText());
            controller.getCellulesPane().clear();
            controller.getCellulesPane().add(CelluleToPane.convert(new Cellule(QUESTION, "Bonjour " + newNom.getText() + ". On commence ?", null)));
            stage.close();
        });
    }
}