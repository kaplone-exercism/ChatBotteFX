package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Vocabulaire;
import util.UrlReader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TestVocabulaireController implements ControllerBase {

    private Stage stage;
    private ChatBotteController controller;

    @FXML
    public TextField testField;

    @FXML
    public Button testButton;

    @FXML
    public TextArea areaPhrases;

    @FXML
    public TextArea areaMots;

    @FXML
    public Slider tailleMin;

    @FXML
    public Slider nbMin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        testButton.setOnAction(a -> {
            try {
                Vocabulaire vocabulaire = UrlReader.readURL(testField.getText(), (int) Math.round(tailleMin.getValue()), (int) Math.round(nbMin.getValue()));
                areaPhrases.textProperty().setValue(vocabulaire.getPhrases());
                areaMots.textProperty().setValue(vocabulaire.getMots());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void setController(ChatBotteController controller) {
        this.controller = controller;
    }
}
