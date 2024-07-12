/**
 * Program creates a student's profile using text file input for multiple students'
 * and outputs the profile for each student to their own respective file.
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: October 19, 2021.
 */

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner filename = new Scanner(System.in); //Scanning for user input in case the file is elsewhere
        System.out.println("Please enter filepath to input file");
        String file = filename.nextLine();
        Student s = new Student(file);

        System.out.println("All done! Please check your directory for output files");
    }
}
