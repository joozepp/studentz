package org.example;

//Create a table called Students and another table called Grades
// the columns on the  STUDENTS table should be as follows : id ,name, age
//complete the controllers for the students table by
// adding methods
//handle CR/D operations on a table
//

//On the grades table, store students id, score and the Grade where
// The columns on the grades table should be, student_id, score
// for each grade:
// 0-40 F
// 41-49 D
// 50-59 C
// 60-69 B
// 70 - 100 A

//Complete the controller for the Grades table so that you have CR/D
// for the read operation you should be able to see the students information as well


import org.example.db.Database;
import org.example.grading.Grades;
import org.example.grading.Students;

public class Main {
    public static void main(String[] args) {



        Grades.grades();

        System.out.println("Success!");
    }
}