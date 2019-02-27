package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Toggle extends ImageView {

    private static Image on;
    private static Image off;

    static {
        on = new Image("images/toggle_on.png");
        off = new Image("images/toggle_off.png");
    }

    private Boolean active;
    public Toggle(String url){
        super(url);
        active = true;

    }

    public Boolean switchValue(){
        active = !active;
        this.setImage(active ? on : off);
        return active;
    }
}
