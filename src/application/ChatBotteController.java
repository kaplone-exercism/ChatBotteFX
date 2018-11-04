package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cellule;
import util.CelluleToPane;
import util.UrlReader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static model.Type.QUESTION;
import static model.Type.REPONSE;

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

    public void setUser(String user) {
        this.user = user;
    }

    public ObservableList<VBox> getCellulesPane() {
        return cellulesPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            UrlReader.readURL("dialogue", 4, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        user = "Réponse";

        cellules = FXCollections.observableArrayList();
        cellulesPane = FXCollections.observableArrayList();

        listeSession.setItems(cellulesPane);

        cellulesPane.add(CelluleToPane.convert(new Cellule(QUESTION, "On commence ?", null)));

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
                Parent root = FXMLLoader.load(getClass().getResource("newSession.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Nouvelle session");
                stage.setScene(new Scene(root));
                if (newSessionController == null){
                    newSessionController = new NewSessionController();
                    newSessionController.setStage(stage);
                    newSessionController.setController(this);
                }
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } );

        testVocabulaire.onActionProperty().setValue(a -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("testVocabulaire.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Test de recherche de vocabulaire");
                stage.setScene(new Scene(root));
                if (testVocabulaire == null){
                    testVocabulaireController = new TestVocabulaireController();
                    testVocabulaireController.setStage(stage);
                    testVocabulaireController.setController(this);
                }
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } );

    }
}
