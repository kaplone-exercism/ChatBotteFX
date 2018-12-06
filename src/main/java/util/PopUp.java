package main.java.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.application.ChatBotteController;
import main.java.application.ControllerBase;

import java.io.IOException;

public class PopUp {

    public void createPopUp(String urlFXML, String titre, ChatBotteController chatBotteController) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../application/" + urlFXML));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle(titre);
        stage.setScene(new Scene(root));
        ControllerBase controller = loader.getController();
        controller.setStage(stage);
        controller.setController(chatBotteController);
        stage.show();
    }
}
