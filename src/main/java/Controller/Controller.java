package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Controller {
    private Stage stage;
    @FXML
    private ImageView profilePicture;
    @FXML
    private GridPane backgroundPane;
    @FXML
    private ImageView homeView;
    @FXML
    private ImageView uploadView;
    @FXML
    private ImageView writeView;
    @FXML
    private ImageView settingView;
    @FXML
    private ImageView messageView;
    @FXML
    private ImageView tweetImage1;
    @FXML
    private ImageView tweetImage2;

    private File file = null;

    public void init(Stage primaryStage) {
        this.stage = primaryStage;
        buildMenu();

    }

    public void openFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
        file = fileChooser.showOpenDialog(stage);
    }

    public void readFile() {
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
                //YourTextArea.appendText(s.nextInt() + " "); // display the found integer
            }
        } catch (FileNotFoundException ex) {
            exceptionBox();
        }
    }

    public void x(ActionEvent event) throws IOException {
        System.out.println("HI");
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("readTweets.fxml"));
        Parent root = loader.load();
        Scene main = new Scene(root);
        stage.setScene(main);
        stage.show();
        System.out.println("bye");

    }

    public void exceptionBox(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Look, an Exception Dialog");
        alert.setContentText("Could not find file");

        Exception ex = new FileNotFoundException("Could not find file");

        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

        public void buildMenu() {
            Image image = new Image(String.valueOf(Controller.class.getResource("/images/guy.jpg")));
            profilePicture.setImage(image);
            Image backgroundImage = new Image(String.valueOf(Controller.class.getResource("/images/bg_head.jpg")));
            BackgroundSize bs = new BackgroundSize(1,1,true,true,true,true);
            backgroundPane.setBackground(new Background(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER , bs)));

            Image homeImg = new Image(String.valueOf(Controller.class.getResource("/images/home_hover.png")));
            homeView.setImage(homeImg);
            Tooltip.install(homeView, new Tooltip("Home"));

            Image msgImg = new Image(String.valueOf(Controller.class.getResource("/images/message.png")));
            messageView.setImage(msgImg);
            Tooltip.install(messageView, new Tooltip("Messages"));

            Image writeImg = new Image(String.valueOf(Controller.class.getResource("/images/write.png")));
            writeView.setImage(writeImg);
            Tooltip.install(writeView, new Tooltip("Write a Tweet"));

            Image uploadImg = new Image(String.valueOf(Controller.class.getResource("/images/upload.png")));
            uploadView.setImage(uploadImg);
            Tooltip.install(uploadView, new Tooltip("Upload"));

            Image settingImg = new Image(String.valueOf(Controller.class.getResource("/images/bulleted_list.png")));
            settingView.setImage(settingImg);
            Tooltip.install(settingView, new Tooltip("Settings"));

            Circle circle = new Circle(40, 40, 40);
            profilePicture.setClip(circle);

            Circle circle2 = new Circle(30, 30, 30);

            tweetImage1.setImage(image);
            tweetImage1.setClip(circle2);

            Circle circle3 = new Circle(30, 30, 30);

            tweetImage2.setImage(image);
            tweetImage2.setClip(circle3);

    }
}
