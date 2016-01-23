package Initial;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {
    private Stage stage;
    @FXML
    private ImageView profilePicture;
    @FXML
    private GridPane backgroundPane;
    @FXML
    private ImageView homeImage;
    @FXML
    private ImageView messageView;
    @FXML
    private ImageView tweetImage1;
    @FXML
    private ImageView tweetImage2;

    public void init(Stage primaryStage) {
        this.stage = primaryStage;

        Image image = new Image(String.valueOf(Controller.class.getResource("/guy.jpg")));
        profilePicture.setImage(image);
        Image backgroundImage = new Image(String.valueOf(Controller.class.getResource("/bg_head.jpg")));
        BackgroundSize bs = new BackgroundSize(1,1,true,true,true,true);
        backgroundPane.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER , bs)));

        Image homeImg = new Image(String.valueOf(Controller.class.getResource("/home_hover.png")));
        homeImage.setImage(homeImg);

        Image msgImg = new Image(String.valueOf(Controller.class.getResource("/ic_action_mdpi_message.png")));
        messageView.setImage(msgImg);

        Circle circle = new Circle(40, 40, 40);
        profilePicture.setClip(circle);

        Circle circle2 = new Circle(30, 30, 30);

        tweetImage1.setImage(image);
        tweetImage1.setClip(circle2);

        Circle circle3 = new Circle(30, 30, 30);

        tweetImage2.setImage(image);
        tweetImage2.setClip(circle3);

    }


        public void openFile(){
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Text File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt")
            );
            File file = fileChooser.showOpenDialog(stage);
            if (file != null){

            }
        }


}
