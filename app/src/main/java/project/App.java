/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import project.models.Cycling;
import project.models.Running;
import project.models.Swimming;

public class App extends Application {
    private Stage stage;

    @Override
    public void start(Stage mainStage) {
        //handling stage
        stage = mainStage;
        
        //stage
        stage.setTitle("Tugas Projek OOP");
        stage.setScene(getScene1());
        stage.show();
    }

    private Scene getScene1(){

        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 640, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/home.css").toExternalForm());

        //Setting background
        ImageView ivBackground = new ImageView("/images/Background.jpg");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        //Text Tittle
        Text tLeft = new Text("Code");
        tLeft.getStyleClass().add("title-text-left");
        Text tRight = new Text("Altletics");
        tRight.getStyleClass().add("title-text-right");
        TextFlow tfTitle = new TextFlow(tLeft, tRight);

        // Text deskripsi
        Label lDesk = new Label(
                "Mau mengetahui Kalori yang dikeluarkan ketika olahraga? Gunakan Aplikasi ini untuk menghitung Kalori");
        lDesk.getStyleClass().add("desc-text");
        lDesk.setWrapText(true);
        lDesk.setMaxWidth(355);

        //Button Mulai
        Region space = new Region();
        space.setPrefHeight(12);
        Button bMulai = new Button("Mulai");
        bMulai.getStyleClass().add("btn-explore");

        // Vbox layout
        VBox vLayout = new VBox( tfTitle, lDesk, space, bMulai);
        vLayout.setSpacing(10);
        spLayout.getChildren().add(vLayout);
        vLayout.setPadding(new Insets(70));
        vLayout.setAlignment(Pos.CENTER);

        //Action untuk Button
        bMulai.setOnAction(v->{
            stage.setScene(getScene2());
        });
        return scene;
    }

    private Scene getScene2() {
        Text tTitle = new Text("PILIH MENU OLAHRAGA");
        Button bOlahraga1 = new Button("RUNNING");
        Button bOlahraga2 = new Button("CYCLING");
        Button bOlahraga3 = new Button("SWIMMING");
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

        //Action untuk Button
        bOlahraga1.setOnAction(v -> {
            stage.setScene(getScene3());
        });

        bOlahraga2.setOnAction(v -> {
            stage.setScene(getScene4());
        });

        bOlahraga3.setOnAction(v -> {
            stage.setScene(getScene5());
        });

        //section
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

        //rootNode
        VBox rootNode = new VBox(sectionRight1, ivBanner1, sectionRight2, ivBanner2, sectionRight3, ivBanner3,
                sectionRight4);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.getStyleClass().add("Bg");

        Scene scene = new Scene(new StackPane(rootNode), 640, 480);

        //atur css
        scene.getStylesheets().add(getClass().getResource("/styles/main.css").toExternalForm());
        return scene;
    }
    
    private Scene getScene3() {

        Text tTitle = new Text("Perhitungan Kalori Olahraga Lari");
        Label lName = new Label("Masukkan Nama");
        TextField tName = new TextField();
        Label lDuration = new Label("Durasi Berlari");
        TextField tDuration = new TextField();
        Label lDistance = new Label("Jarak Berlari");
        TextField tDistance = new TextField();
        Button bCalculate = new Button("Calculate Calori");
        Label lResults = new Label();
        Button bBack = new Button("Kembali Halaman Utama");
        VBox sectionRight = new VBox(tTitle, lName, tName, lDuration, tDuration, lDistance, tDistance,bCalculate,lResults, bBack);
        sectionRight.setSpacing(50);
        sectionRight.setAlignment(Pos.CENTER);
        sectionRight.setPrefWidth(30);

        //Action untuk Button
        bBack.setOnAction(v -> {
            stage.setScene(getScene2());
        });

        bCalculate.setOnAction(v -> {
        try {
            String name = tName.getText();
            int duration = Integer.parseInt(tDuration.getText());
            double distance = Double.parseDouble(tDistance.getText());
            duration /= 60; // Menyimpan hasil pembagian ke variabel duration

            Running running = new Running(name, duration, distance);
            running.setCaloriePerKm();
            double caloriesBurned = running.calculateCaloriesBurned();
            lResults.setText("Kalori yang Dibakar: " + caloriesBurned);
        } catch (NumberFormatException e) {
            lResults.setText("Input tidak valid!");
        }
        });


        // rootNode
        VBox rootNode = new VBox(tTitle, lName, tName, lDuration, tDuration, lDistance, tDistance,bCalculate,lResults, bBack);
        rootNode.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(new StackPane(rootNode), 640, 480);

        return scene;
    }

    private Scene getScene4() {

        Text tTitle = new Text("Perhitungan Kalori Olahraga Sepeda");
        Label lName = new Label("Masukkan Nama");
        TextField tName = new TextField();
        Label lDuration = new Label("Durasi Bersepeda");
        TextField tDuration = new TextField("");
        Label lDistance = new Label("Jarak Tempuh");
        TextField tDistance = new TextField("");
        Button bCalculate = new Button("Calculate Calori");
        Label lResults = new Label("");
        Button bBack = new Button("Kembali Halaman Utama");
        VBox sectionRight = new VBox(tTitle, lName, tName, lDuration, tDuration, lDistance, tDistance, bCalculate, lResults, bBack);
        sectionRight.setSpacing(50);
        sectionRight.setAlignment(Pos.CENTER);
        sectionRight.setPrefWidth(30);

        //Action untuk Button
        bBack.setOnAction(v -> {
            stage.setScene(getScene2());
        });

        bCalculate.setOnAction(v -> {
            try {
                String name = tName.getText();
                int duration = Integer.parseInt(tDuration.getText());
                double distance = Double.parseDouble(tDistance.getText());

                Cycling cycling = new Cycling(name, duration, distance);
                double caloriesBurned = cycling.calculateCaloriesBurned();

                lResults.setText("Kalori yang Dibakar: " + caloriesBurned);
            } catch (NumberFormatException e) {
                lResults.setText("Input tidak valid!");
            }
        });

        // rootNode
        VBox rootNode = new VBox(tTitle, lName, tName, lDuration, tDuration, lDistance, tDistance, bCalculate, lResults, bBack);
        rootNode.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(new StackPane(rootNode), 640, 480);

        return scene;
    }

    private Scene getScene5() {

        Text tTitle = new Text("Perhitungan Kalori Olahraga Renang");
        Label lName = new Label("Masukkan Nama");
        TextField tName = new TextField();
        Label lDuration = new Label("Durasi Berenang");
        TextField tDuration = new TextField();
        Label lGaya = new Label("Gaya Renang (Bebas, Dada, Punggung, Kupu-Kupu)");
        TextField tGaya = new TextField();
        Label lIntensitas = new Label("Intensitas (Sedang atau Tinggi)");
        TextField tIntensitas = new TextField();
        Button bCalculate = new Button("Calculate Calori");
        Label lResults = new Label();
        Button bBack = new Button("Kembali Halaman Utama");
        VBox sectionRight = new VBox(tTitle, lName, tName, lDuration, tDuration, lGaya, tGaya, lIntensitas, tIntensitas,
                bCalculate, lResults, bBack);
        sectionRight.setSpacing(50);
        sectionRight.setAlignment(Pos.CENTER);
        sectionRight.setPrefWidth(30);

        //Action untuk Button
        bBack.setOnAction(v -> {
            stage.setScene(getScene2());
        });

        bCalculate.setOnAction(v -> {
            try {
                String name = tName.getText();
                int duration = Integer.parseInt(tDuration.getText());
                String style = tGaya.getText();
                String intensity = tIntensitas.getText();
                duration /= 60;

                Swimming swimming = new Swimming(name, duration, style, intensity);
                double caloriesBurned = swimming.calculateCaloriesBurned();

                lResults.setText("Kalori yang Dibakar: " + caloriesBurned);
            } catch (NumberFormatException e) {
                lResults.setText("Input tidak valid!");
            }
        });

        // rootNode
        VBox rootNode = new VBox(tTitle, lName, tName, lDuration, tDuration, lGaya, tGaya, lIntensitas, tIntensitas,
                bCalculate, lResults, bBack);
        rootNode.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(new StackPane(rootNode), 640, 480);

        return scene;
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
