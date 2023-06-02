package project;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
import project.Scenes.HomeScene;

public class App extends Application {

    public void start(Stage stage) throws FileNotFoundException {
        // stage
        HomeScene homeScene = new HomeScene(stage);
        homeScene.show();
        stage.setTitle("Tugas Projek OOP");
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
