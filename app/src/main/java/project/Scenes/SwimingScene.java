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
import project.dao.resultDao3;
import project.models.Result3;
import project.models.Swimming;

public class SwimingScene {
    private Stage stage;
    ObservableList<Result3> exerciseRecords3 = FXCollections.observableArrayList();


    public SwimingScene(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        StackPane spLayout = new StackPane();
        Scene scene = new Scene(spLayout, 640, 640);

        // Setting background
        ImageView ivBackground = new ImageView("/images/renang.jpg");
        ivBackground.setFitWidth(scene.getWidth());
        ivBackground.setFitHeight(scene.getHeight());
        spLayout.getChildren().add(ivBackground);

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
        Label lRecommendedCalories = new Label();
        Button bBack = new Button("Kembali Halaman Utama");
        VBox sectionRight = new VBox(tTitle, lName, tName, lDuration, tDuration, lGaya, tGaya, lIntensitas, tIntensitas,
                bCalculate, lResults,lRecommendedCalories, bBack);
        sectionRight.setSpacing(50);
        sectionRight.setAlignment(Pos.CENTER);
        sectionRight.setPrefWidth(30);

        tTitle.getStyleClass().add("title");
        tName.getStyleClass().add("tName");
        tDuration.getStyleClass().add("tDuration");
        tGaya.getStyleClass().add("tGaya");
        tIntensitas.getStyleClass().add("tIntensitas");
        bCalculate.getStyleClass().add("bCalculate");
        bBack.getStyleClass().add("back");

        // mbil data dari database
        resultDao3 resultDao3 = new resultDao3();
        try {
            exerciseRecords3.clear();
            exerciseRecords3.addAll(resultDao3.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Action untuk Button
        bBack.setOnAction(v -> {
            resultDao3.syncData(exerciseRecords3);
            MainScene MainScene = new MainScene(stage);
            MainScene.show();
        });

        bCalculate.setOnAction(v -> {
            try {
                String name = tName.getText();
                int duration = Integer.parseInt(tDuration.getText());
                String style = tGaya.getText();
                String intensity = tIntensitas.getText();

                Swimming swimming = new Swimming(name, duration, style, intensity);
                double caloriesBurned = swimming.calculateCaloriesBurned();

                lResults.setText("Kalori yang Dibakar: " + caloriesBurned);

                double recommendedCalories = caloriesBurned * 1.2;
                lRecommendedCalories.setText("Asupan Kalori yang Direkomendasikan: " + recommendedCalories + " kkal");

                exerciseRecords3.add(new Result3(name, "Swimming", duration, style, intensity, caloriesBurned, recommendedCalories));
                
         
            } catch (NumberFormatException e) {
                lResults.setText("Input tidak valid!");
            }
        });

        // Create TableView and columns
        TableView<Result3> tableView = new TableView<>();
        TableColumn<Result3, String> nameColumn = new TableColumn<>("Nama");
        TableColumn<Result3, String> sportColumn = new TableColumn<>("Olahraga");
        TableColumn<Result3, Double> durationColumn = new TableColumn<>("Durasi");
        TableColumn<Result3, String> styleColumn = new TableColumn<>("Style");
        TableColumn<Result3, String> intensityColumn = new TableColumn<>("Intensity");
        TableColumn<Result3, Double> caloriColumn = new TableColumn<>("Calori");
        TableColumn<Result3, Double> recommendCaloriColumn = new TableColumn<>("Recommend Calori");

        // Set value factories for columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sportColumn.setCellValueFactory(new PropertyValueFactory<>("sport"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        styleColumn.setCellValueFactory(new PropertyValueFactory<>("style"));
        intensityColumn.setCellValueFactory(new PropertyValueFactory<>("intensity"));
        caloriColumn.setCellValueFactory(new PropertyValueFactory<>("calori"));
        recommendCaloriColumn.setCellValueFactory(new PropertyValueFactory<>("recommendCalori"));

        // Add columns to TableView
        tableView.getColumns().addAll(nameColumn, sportColumn, durationColumn, styleColumn, intensityColumn, caloriColumn, recommendCaloriColumn);
        
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
        styleColumn.setPrefWidth(columnWidth);
        intensityColumn.setPrefWidth(columnWidth);
        caloriColumn.setPrefWidth(columnWidth);
        recommendCaloriColumn.setPrefWidth(columnWidth);  

        // Add exercise records to the TableView
        tableView.setItems(exerciseRecords3);

        // rootNode
        VBox rootNode = new VBox(tTitle, lName, tName, lDuration, tDuration, lGaya, tGaya, lIntensitas, tIntensitas,
                bCalculate, lResults,lRecommendedCalories, bBack, tableView);
        rootNode.setAlignment(Pos.TOP_CENTER);
        spLayout.getChildren().add(rootNode);
        rootNode.getStyleClass().add("inputan");

        // atur css
        scene.getStylesheets().add(getClass().getResource("/styles/main.css").toExternalForm());
        stage.setScene(scene);
    }
}
