package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    //MediaPlayer mp;
    @Override
    public void start(Stage primaryStage) throws Exception{

        //Media m = new Media(new File("Stayin alive.mp3").toURI().toString());
        //mp = new MediaPlayer(m);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 736, 254);

        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        //mp.play();
        //mp.setVolume(0.1);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
