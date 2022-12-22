package org.example.grading;

import org.example.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Students {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);




    public static boolean createStudentsTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE students(" +
                    "id serial," +
                    "name varchar(255)," +
                    "age int" +
                    "PRIMARY KEY(id))");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }



    public static boolean createNewStudent() {
        // add prompts to tell the user what data they need
        // to enter next

        System.out.print("Enter the students name");
        String name = scanner.nextLine();

        System.out.print("Enter the students age");
        int age = scanner.nextInt();

        try {
            ps = connection.prepareStatement("INSERT INTO students(name,age) " +
                    "VALUES('" + name + "'," + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




    public static void getAllStudents() {
        try {
            ps = connection.prepareStatement("SELECT * FROM students");
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String name = "name: " + rs.getString("name");
                String age = "age: " + rs.getInt("age");
                System.out.println(id + " " + name + " " + age + " " );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean deleteStudent() {
        System.out.println("Please enter the id of the student you want to delete");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM students" + " WHERE id = " + id);
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

}
