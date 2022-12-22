package org.example.grading;

import org.example.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Grades {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);



    public static boolean createGradesTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE grades(" +
                    "id serial, " +
                    "student_id int, " +
                    "grade varchar(10), "+
                    "score int, " +
                    "FOREIGN KEY (student_id) REFERENCES students(id))");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    //I enter a score and receive the grade and then I need to assign it to the student

    public static boolean grades() {
        // add prompts to tell the user what data they need
        // to enter next
        // F <40
        // D 41-49
        // C 50-59
        // B 60-69
        // A 70-100
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("ENTER THE STUDENTS ID");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        int student_id = scanner.nextInt();

        System.out.print("What grade did you get?");
        int score = scanner.nextInt();
        String grade = null;

        if (score<40) {
            System.out.println("You failed :/ [F]");
            grade = "F";
        }
        if (score<49 && score>41) {
            System.out.println("eh but good 'nuf [D]");
            grade = "D";
        }
        if (score <59 && score>41) {
            System.out.println("mid bruh [C]");
            grade = "C";
        }
        if (score <69 && score> 61) {
            System.out.println("Norm! [B]");
            grade = "B";
        }
        if (score <100 && score>71) {
            System.out.println("timmis! [A]");
            grade = "A";
        }
        if (score>100){
            System.out.println("huH?");
            System.out.println("huH?");
            System.out.println("huH?");
            System.out.println("huH?");
            System.out.println("huH?");
            System.out.println("huH?");
            exit();
        }

        try {
            ps = connection.prepareStatement("INSERT INTO grades(student_id,grade,score) " +
                    "VALUES("+ student_id + ", '" + grade + "'," + score + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void exit() {
    }
}
