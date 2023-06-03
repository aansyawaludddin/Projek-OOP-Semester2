package project.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.models.Result2;
import project.utils.DataBaseConfig2;

public class resultDao2 {
    private Connection conn;
    private Statement stmt;

    public resultDao2() {
        conn = DataBaseConfig2.getConnection();
        setupTable();
    }

    private void setupTable() {
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS exerciseRecords2 " +
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

    

    public List<Result2> getAll() throws SQLException {
        try {
            List<Result2> exerciseRecords2 = new ArrayList<>();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM exerciseRecords2");
            while (rs.next()) {
                String name = rs.getString("name");
                String sport = rs.getString("sport");
                double duration = rs.getDouble("duration");
                double distance = rs.getDouble("distance");
                double calori = rs.getDouble("calori");
                double recommed = rs.getDouble("recommed");
                exerciseRecords2.add(new Result2(name, sport, duration, distance, calori, recommed  ));
            }
            return exerciseRecords2;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void syncData(List<Result2> exerciseRecords2) {
        try {
            stmt.executeUpdate("DELETE FROM exerciseRecords2");
            stmt = conn.createStatement();
            for (Result2 result : exerciseRecords2) {
                String sql = String.format("""
                        INSERT INTO exerciseRecords2(name, sport, duration, distance, calori, recommed)
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
