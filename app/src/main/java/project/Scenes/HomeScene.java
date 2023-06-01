package project.Scenes;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
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

    public void show() {
        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 640, 640);
        scene.getStylesheets().add(getClass().getResource("/styles/home.css").toExternalForm());

        // Setting background
        ImageView ivBackground = new ImageView("/images/Background.jpg");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        // Text Tittle
        Text tLeft = new Text("Code");
        tLeft.getStyleClass().add("title-text-left");
        Text tRight = new Text("Altletics");
        tRight.getStyleClass().add("title-text-right");
        TextFlow tfTitle = new TextFlow(tLeft, tRight);

        // Text deskripsi
        Label lDesk = new Label(
                "Aplikasi Hitung Kalori Aktivitas Olahraga adalah sebuah aplikasi yang dirancang untuk membantu pengguna dalam menghitung jumlah kalori yang mereka bakar selama melakukan berbagai jenis aktivitas olahraga.");
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
        vLayout.setSpacing(10);
        spLayout.getChildren().add(vLayout);
        vLayout.setPadding(new Insets(70));
        vLayout.setAlignment(Pos.CENTER);

        // Action untuk Button
        bMulai.setOnAction(v -> {
            MainScene mainScene = new MainScene(stage);
            mainScene.show();
        });
        stage.setScene(scene);

    }
}
