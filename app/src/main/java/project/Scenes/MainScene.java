package project.Scenes;

import javafx.scene.image.ImageView;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScene {
    private Stage stage;
    private VBox rightSide;

    public MainScene(Stage stage) {
        this.stage = stage;
    }
    public void show() {

    Text tTitle = new Text("PILIH MENU OLAHRAGA");
        Button bOlahraga1 = new Button("RUNNING");
        Button bOlahraga2 = new Button("CYCLING");
        Button bOlahraga3 = new Button("SWIMMING");

        Region space = new Region();
        space.setPrefHeight(12);
        tTitle.getStyleClass().add("title");
        bOlahraga1.getStyleClass().add("bOlahraga1");
        bOlahraga2.getStyleClass().add("bOlahraga2");
        bOlahraga3.getStyleClass().add("bOlahraga3");

        VBox sectionRight1 = new VBox(tTitle);
        sectionRight1.setSpacing(50);
        sectionRight1.setAlignment(Pos.CENTER);
        sectionRight1.setPrefWidth(30);

        VBox sectionRight2 = new VBox(bOlahraga1);
        sectionRight2.setSpacing(70);
        sectionRight2.setAlignment(Pos.CENTER);
        sectionRight2.setPrefWidth(70);

        VBox sectionRight3 = new VBox(bOlahraga2);
        sectionRight3.setSpacing(70);
        sectionRight3.setAlignment(Pos.CENTER);
        sectionRight3.setPrefWidth(70);

        VBox sectionRight4 = new VBox(bOlahraga3);
        sectionRight4.setSpacing(70);
        sectionRight4.setAlignment(Pos.CENTER);
        sectionRight4.setPrefWidth(70);

        // Action untuk Button
        bOlahraga1.setOnAction(v -> {
            CyclingScene CyclingScene = new CyclingScene(stage);
            CyclingScene.show();
        });

        bOlahraga2.setOnAction(v -> {
            RunningScene RunningScene = new RunningScene(stage);
            RunningScene.show();
        });

        bOlahraga3.setOnAction(v -> {
            SwimingScene SwimingScene = new SwimingScene(stage);
            SwimingScene.show();
        });

        // section
        ImageView ivBanner1 = new ImageView("/images/lari.png");
        ivBanner1.setFitWidth(100);
        ivBanner1.setFitHeight(100);
        ivBanner1.setPreserveRatio(true);

        ImageView ivBanner2 = new ImageView("/images/sepeda.png");
        ivBanner2.setFitWidth(100);
        ivBanner2.setFitHeight(100);
        ivBanner2.setPreserveRatio(true);

        ImageView ivBanner3 = new ImageView("/images/renang.png");
        ivBanner3.setFitWidth(100);
        ivBanner3.setFitHeight(100);
        ivBanner3.setPreserveRatio(true);

        // rootNode
        VBox rootNode = new VBox(sectionRight1, space, ivBanner1, sectionRight2, ivBanner2, sectionRight3, ivBanner3,
                sectionRight4);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getStyleClass().add("Bg");

        Scene scene = new Scene(new StackPane(rootNode), 640, 640);

        // atur css
        scene.getStylesheets().add(getClass().getResource("/styles/main.css").toExternalForm());
        stage.setScene(scene);
        
    }
}
