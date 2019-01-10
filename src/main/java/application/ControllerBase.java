package application;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public interface ControllerBase extends Initializable {

    public void setStage(Stage stage);

    public void setController(ChatBotteController controller);
}
