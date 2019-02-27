package application;

import com.gargoylesoftware.css.parser.HandlerBase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.MotFromWeb;
import model.Toggle;
import model.Vocabulaire;
import util.UrlReader;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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

    @FXML
    public VBox vbox_des_mots;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        testButton.setOnAction(a -> {
            updateVue();
        } );

        tailleMin.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!testField.getText().isEmpty() && oldValue.intValue() != newValue.intValue()){
                updateVue();
            }
        });

    }

    private void updateVue(){
        vbox_des_mots.getChildren().clear();
        vbox_des_mots.setSpacing(5d);
        try {
            Vocabulaire vocabulaire = UrlReader.readURL(testField.getText(), (int) Math.round(tailleMin.getValue()), (int) Math.round(nbMin.getValue()));
            areaPhrases.textProperty().setValue(vocabulaire.getPhrases());
            areaMots.textProperty().setValue(vocabulaire.getMots());
            List<String> lignes_sorted = Arrays.asList(vocabulaire.getMots().split("\\n"));
            lignes_sorted.sort((o1, o2) -> Integer.valueOf(o2.split(" : ")[0]).compareTo(Integer.valueOf(o1.split(" : ")[0])));
            for (String ligne : lignes_sorted){
                //System.out.println("--> " + ligne);
                VBox vBox = new VBox();
                vBox.setMinHeight(10d);
                Label label = new Label(ligne.split(" : ")[0] + " occurences :");
                ListView<HBox> listView= new ListView<>();
                listView.setMinHeight(10d);
                ObservableList<HBox> hBoxes = FXCollections.observableArrayList();
                listView.setItems(hBoxes);
                for (String mot : ligne.split(" : ")[1].split(", ")){
                    HBox hBox = new HBox();
                    Label labelMot = new Label(mot);
                    labelMot.setMinWidth(180d);
                    Toggle imageView = new Toggle("images/toggle_on.png");
                    imageView.setOnMouseClicked(event -> {
                        if (imageView.switchValue()){
                            labelMot.setOpacity(1d);

                        }
                        else {
                            labelMot.setOpacity(0.5d);
                        }

                    });
                    hBox.getChildren().addAll(labelMot, imageView);
                    hBoxes.add(hBox);
                }
                vBox.getChildren().addAll(label, listView);
                VBox.setVgrow(listView, Priority.NEVER);
                vbox_des_mots.getChildren().add(vBox);
                VBox.setVgrow(vBox, Priority.NEVER);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
