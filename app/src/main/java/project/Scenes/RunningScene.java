package project.Scenes;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.dao.resultDao;
import project.models.Result;
import project.models.Running;

public class RunningScene {
    private Stage stage;
    ObservableList<Result> exerciseRecords = FXCollections.observableArrayList();

    public RunningScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 640, 640);

        // Setting background
        ImageView ivBackground = new ImageView("/images/lari.jpg");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

        Text tTitle = new Text("Perhitungan Kalori Olahraga Lari");
        Label lName = new Label("Masukkan Nama");
        TextField tName = new TextField();
        Label lDuration = new Label("Durasi Berlari(Menit)");
        TextField tDuration = new TextField();
        Label lDistance = new Label("Jarak Berlari(KM)");
        TextField tDistance = new TextField();
        Button bCalculate = new Button("Calculate Calori");
        Label lResults = new Label();
        Label lRecommendedCalories = new Label();
        Button bBack = new Button("Kembali Halaman Utama");
        VBox sectionRight = new VBox(tTitle, lName, tName, lDuration, tDuration, lDistance, tDistance, bCalculate, lResults, lRecommendedCalories, bBack);
        sectionRight.setSpacing(50);
        sectionRight.setAlignment(Pos.CENTER);
        sectionRight.setPrefWidth(30);

        tTitle.getStyleClass().add("title");
        tName.getStyleClass().add("tName");
        tDuration.getStyleClass().add("tDuration");
        tDistance.getStyleClass().add("tDistance");
        bCalculate.getStyleClass().add("bCalculate");
        bBack.getStyleClass().add("back");

        // ambil data dari database
        resultDao resultDao = new resultDao();
        try {
            exerciseRecords.clear();
            exerciseRecords.addAll(resultDao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

           //Action untuk Button
           bBack.setOnAction(v -> {
            resultDao.syncData(exerciseRecords);
            MainScene MainScene = new MainScene(stage);
            
            MainScene.show();
        });



        bCalculate.setOnAction(v -> {
            try {
                String name = tName.getText();
                int duration = Integer.parseInt(tDuration.getText());
                double distance = Double.parseDouble(tDistance.getText());

                Running running = new Running(name, duration, distance);
                double caloriesBurned = running.calculateCaloriesBurned();

                lResults.setText("Kalori yang Dibakar: " + caloriesBurned);

                double recommendedCalories = caloriesBurned * 1.2;
                lRecommendedCalories.setText("Asupan Kalori yang Direkomendasikan: " + recommendedCalories + " kkal");

                exerciseRecords.add(new Result(name, "Running", duration, distance, caloriesBurned, recommendedCalories));

            } catch (NumberFormatException e) {
                lResults.setText("Input tidak valid!");
            }
        });

        // Create TableView and columns
        TableView<Result> tableView = new TableView<>();
        TableColumn<Result, String> nameColumn = new TableColumn<>("Nama");
        TableColumn<Result, String> sportColumn = new TableColumn<>("Olahraga");
        TableColumn<Result, Double> durationColumn = new TableColumn<>("Durasi");
        TableColumn<Result, Double> distanceColumn = new TableColumn<>("Distance");
        TableColumn<Result, Double> caloriColumn = new TableColumn<>("Calori");
        TableColumn<Result, Double> recommendCaloriColumn = new TableColumn<>("Recommend Calori");

        // Set value factories for columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sportColumn.setCellValueFactory(new PropertyValueFactory<>("sport"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distance"));
        caloriColumn.setCellValueFactory(new PropertyValueFactory<>("calori"));
        recommendCaloriColumn.setCellValueFactory(new PropertyValueFactory<>("recommed"));

        // Add columns to TableView
        tableView.getColumns().addAll(nameColumn, sportColumn, durationColumn, distanceColumn, caloriColumn, recommendCaloriColumn);

        // Set number of visible columns
        int numberOfColumns = 6;

        // Set column resize policy
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Set fixed cell size to evenly distribute the available height
        tableView.setFixedCellSize(220.0 / (numberOfColumns + 1));

        // Set preferred widths for columns
        double columnWidth = 640.0 / numberOfColumns;
        nameColumn.setPrefWidth(columnWidth);
        sportColumn.setPrefWidth(columnWidth);
        durationColumn.setPrefWidth(columnWidth);
        distanceColumn.setPrefWidth(columnWidth);
        caloriColumn.setPrefWidth(columnWidth);
        recommendCaloriColumn.setPrefWidth(columnWidth);

        // Add exercise records to the TableView
        tableView.setItems(exerciseRecords);

        // rootNode
        VBox rootNode = new VBox(tTitle, lName, tName, lDuration, tDuration, lDistance, tDistance, bCalculate, lResults, lRecommendedCalories, bBack, tableView);
        rootNode.setAlignment(Pos.TOP_CENTER);
        spLayout.getChildren().add(rootNode);
        rootNode.getStyleClass().add("inputan");

        //atur css
        scene.getStylesheets().add(getClass().getResource("/styles/main.css").toExternalForm());
        stage.setScene(scene);

    }
}
