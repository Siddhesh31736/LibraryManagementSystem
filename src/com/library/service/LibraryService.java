package com.library.service;
import java.sql.Connection;
import com.library.config.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class LibraryService {
    public void addBook(String title, String author){
        String sql = "INSERT INTO books(title, author, is_available) VALUES (?, ?, ?)";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setBoolean(3, true);

            ps.executeUpdate();
            System.out.println("Book added successfully");
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayBooks() {
        String sql = "SELECT * FROM books";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                System.out.println("-------------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Available: " + rs.getBoolean("is_available"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrowBook(int id) {

        String sql =
                "UPDATE books SET is_available = false WHERE id = ?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book borrowed successfully!");
            else
                System.out.println("Book not found!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void returnBook(int id) {

        String sql =
                "UPDATE books SET is_available = true WHERE id = ?";

        try (
                Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book returned successfully!");
            else
                System.out.println("Book not found!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}