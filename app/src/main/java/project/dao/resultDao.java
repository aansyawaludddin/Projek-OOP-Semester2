package project.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.models.Result;
import project.utils.DataBaseConfig;

public class resultDao {
    private Connection conn;
    private Statement stmt;

    public resultDao() {
        conn = DataBaseConfig.getConnection();
        setupTable();
    }

    private void setupTable() {
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS exerciseRecords " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " sport TEXT NOT NULL, " +
                    " duration INTEGER NOT NULL, " +
                    " distance INTEGER NOT NULL, " +
                    " calori INTEGER NOT NULL, " +
                    " recommed INTEGER NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public List<Result> getAll() throws SQLException {
        try {
            List<Result> exerciseRecords = new ArrayList<>();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM exerciseRecords");
            while (rs.next()) {
                String name = rs.getString("name");
                String sport = rs.getString("sport");
                double duration = rs.getDouble("duration");
                double distance = rs.getDouble("distance");
                double calori = rs.getDouble("calori");
                double recommed = rs.getDouble("recommed");
                exerciseRecords.add(new Result(name, sport, duration, distance, calori, recommed  ));
            }
            return exerciseRecords;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void syncData(List<Result> exerciseRecords) {
        try {
            stmt.executeUpdate("DELETE FROM exerciseRecords");
            stmt = conn.createStatement();
            for (Result result : exerciseRecords) {
                String sql = String.format("""
                        INSERT INTO exerciseRecords(name, sport, duration, distance, calori, recommed)
                        VALUES('%s', '%s', %f, %f, %f, %f);
                        """,
                        result.getName(),
                        result.getSport(),
                        result.getDuration(),
                        result.getDistance(),
                        result.getCalori(),
                        result.getRecommed());
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
