package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cellule;
import util.CelluleToPane;

import java.net.URL;
import java.util.ResourceBundle;

import static model.Constantes.Type.QUESTION;

public class NewSessionController implements ControllerBase {

    private Stage stage;
    private ChatBotteController controller;

    @FXML
    public TextField newNom;

    @FXML
    public Button newNomAnnuler;
    @FXML
    public Button newNomCreer;

    @FXML
    public AnchorPane modalNew;

    public NewSessionController() {
    }

    public NewSessionController(Stage stage, ChatBotteController controller) {
        this.stage = stage;
        this.controller = controller;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setController(ChatBotteController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        newNom.onKeyPressedProperty().setValue(a -> {
            if (a.getCode().equals(KeyCode.ENTER)) {
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
