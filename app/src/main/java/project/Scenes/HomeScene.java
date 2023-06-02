package project.Scenes;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class HomeScene {
    private Stage stage;

    public HomeScene(Stage stage) {
        this.stage = stage;
    }

    public void show() throws FileNotFoundException {
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/home.css").toExternalForm());

        // Setting background
        ImageView ivBackground = new ImageView("/images/homesceneBG.png");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        // Text Tittle
        Text tLeft = new Text("Calorie");
        tLeft.getStyleClass().add("title-text-left");
        Text tRight = new Text("Tracker");
        tRight.getStyleClass().add("title-text-right");
        TextFlow tfTitle = new TextFlow(tLeft, tRight);

        // // Top Logo
        // ImageView ivLogo = new ImageView("/images/smartwatch.png");
        // ivLogo.setFitWidth(32);
        // ivLogo.setFitHeight(32);

        // Text deskripsi
        Label lDesk = new Label(
                "Anda dapat memantau \nasupan kalori Anda \ndengan cepat dan akurat");
        lDesk.getStyleClass().add("desc-text");
        lDesk.setWrapText(true);
        lDesk.setMaxWidth(355);

        // Button Mulai
        Region space = new Region();
        space.setPrefHeight(12);
        Button bMulai = new Button("Mulai");
        bMulai.getStyleClass().add("btn-explore");

        // Vbox layout
        VBox vLayout = new VBox(tfTitle, lDesk, space, bMulai);
        vLayout.setSpacing(8);
        spLayout.getChildren().add(vLayout);
        vLayout.setPadding(new Insets(53));
        vLayout.setAlignment(Pos.CENTER_LEFT);

        // Action untuk Button
        bMulai.setOnAction(v -> {
            MainScene mainScene = new MainScene(stage);
            mainScene.show();
        });
        stage.setScene(scene);

    }
}
