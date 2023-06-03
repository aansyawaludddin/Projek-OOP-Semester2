package project.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.models.Result3;
import project.utils.DataBaseConfig3;

public class resultDao3 {
    private Connection conn;
    private Statement stmt;

    public resultDao3() {
        conn = DataBaseConfig3.getConnection();
        setupTable();
    }

    private void setupTable() {
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS exerciseRecords3 " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " sport TEXT NOT NULL, " +
                    " duration INTEGER NOT NULL, " +
                    " style TEXT NOT NULL, " +
                    " intensity TEXT NOT NULL, " +
                    " calori INTEGER NOT NULL, " +
                    " recommendCalori INTEGER NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public List<Result3> getAll() throws SQLException {
        try {
            List<Result3> exerciseRecords3 = new ArrayList<>();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM exerciseRecords3");
            while (rs.next()) {
                String name = rs.getString("name");
                String sport = rs.getString("sport");
                double duration = rs.getDouble("duration");
                String style = rs.getString("style");
                String intensity = rs.getString("intensity");
                double calori = rs.getDouble("calori");
                double recommendCalori = rs.getDouble("recommendCalori");
                exerciseRecords3.add(new Result3(name, sport, duration, style, intensity,calori, recommendCalori));
            }
            return exerciseRecords3;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public void syncData(List<Result3> exerciseRecords3) {
        try {
            stmt.executeUpdate("DELETE FROM exerciseRecords3");
            stmt = conn.createStatement();
            for (Result3 result : exerciseRecords3) {
                String sql = String.format("""
                        INSERT INTO exerciseRecords3(name, sport, duration, style,intensity, calori, recommendCalori)
                        VALUES('%s', '%s', %f, '%s', '%s', %f, %f);
                        """,
                        result.getName(),
                        result.getSport(),
                        result.getDuration(),
                        result.getStyle(),
                        result.getIntensity(),
                        result.getCalori(),
                        result.getRecommendCalori());
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

