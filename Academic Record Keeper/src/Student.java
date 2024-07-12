/**
 * Program creates a student's profile using text file input for multiple students'
 * and outputs the profile for each student to their own respective file.
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: October 19, 2021.
 */

import java.io.*;
import java.util.*;

public class Student {
    //input file
    private File textFile;
    private Scanner input = null;
    private int studentCount;
    private String[] parts = new String[2];

    //Personal info
    private String infoLine;
    private static String studentName;
    private static String studentPhone;
    private static String schoolName;

    //Academic Records
    private int courseNo;
    private String courseLine;
    private static ArrayList<String> courseNames = new ArrayList<String>();
    private static ArrayList<Double> courseGrades = new ArrayList<Double>();
    private int researchNo;
    private String researchLine;
    private static ArrayList<String> researchTopics = new ArrayList<String>();
    private static ArrayList<String> researchDates = new ArrayList<String>();

    //Projects
    private int projectNo;
    private String projectLine;
    private ArrayList<String> projectTitles = new ArrayList<String>();
    private ArrayList<String> projectDates = new ArrayList<String>();

    //Certificates
    private int certNo;
    private String certLine;
    private ArrayList<String> certTitles = new ArrayList<String>();
    private ArrayList<String> certDates = new ArrayList<String>();

    //Constructor Class
    public Student(String file) throws IOException {
        PersonalInfo studentInfo = new PersonalInfo(null, null, null);
        AcademicRecords academicRecords = new AcademicRecords(null, null, null, null);
        Projects projects = new Projects(null, null);
        Certificates certs = new Certificates(null, null);
        textFile = new File(file);
        int inputCounter = 0;
        int i;
        try {
            input = new Scanner(new FileInputStream(textFile));

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        //Total students in input file
        studentCount = input.nextInt();

        /*
        This while loop serves to gather all the information on a student.
        At the end of each iteration, all the information will be written to its own file
         */
        while (inputCounter < studentCount && input.hasNextLine()) {
            //obtaining personal info
            input.nextLine();
            infoLine = input.nextLine();
            parts = infoLine.split(", ");
            studentName = parts[0];
            studentPhone = parts[1];
            schoolName = input.nextLine();
            studentInfo.setPersonalInfo(studentName, studentPhone, schoolName);

            //obtaining Academic records
            courseNo = input.nextInt();
            input.nextLine();
            for (i = 0; i < courseNo; i++){
                courseLine = input.nextLine();
                parts = courseLine.split(": ");
                courseNames.add(parts[0]);
                courseGrades.add(Double.parseDouble(parts[1]));
            }

            researchNo = input.nextInt();
            input.nextLine();
            for(i = 0; i < researchNo; i++){
                researchLine = input.nextLine();
                parts = researchLine.split(": ");
                researchTopics.add(parts[0]);
                researchDates.add(parts[1]);
            }
            academicRecords.setAcademicRecords(courseNames, courseGrades, researchTopics, researchDates);


            //obtaining Projects
            projectNo = input.nextInt();
            input.nextLine();
            for(i = 0; i < projectNo; i++){
                projectLine = input.nextLine();
                parts = projectLine.split(": ");
                projectTitles.add(parts[0]);
                projectDates.add(parts[1]);
            }
            projects.setProjects(projectTitles, projectDates);


            //obtaining Certificates
            certNo = input.nextInt();
            input.nextLine();
            for(i = 0; i < certNo; i++){
                certLine = input.nextLine();
                parts = certLine.split(": ");
                certTitles.add(parts[0]);
                certDates.add(parts[1]);
            }
            certs.setCerts(certTitles, certDates);


            inputCounter++;
            write(("student No."+inputCounter), studentInfo, academicRecords, projects, certs);
        }
    }

    //file output method
    //Takes in several objects of each required class
    public void write(String filename, PersonalInfo personalInfo, AcademicRecords academicRecords, Projects projects, Certificates certs) throws IOException {
        int i;
        try {
            FileWriter output = new FileWriter(filename+".txt");
            //Writing personal information to the file
            output.write("Name: " + personalInfo.getName() + "\n");
            output.write("Phone Number: "+ personalInfo.getPhone() + "\n");
            output.write("\n");

            //Writing academic information to the file
            output.write("Academic:\n");
            output.write(personalInfo.getSchool() + ", ");
            output.write("GPA: "+ academicRecords.calcGPA(academicRecords.getGrades()) + "\n");
            for(i = 0; i < academicRecords.getCourses().size(); i++){
                if (i == academicRecords.getCourses().size()-1){
                    output.write(academicRecords.getCourse(i) +": " + academicRecords.getGrade(i)+ "\n");
                }
                else{
                    output.write(academicRecords.getCourse(i) +": " + academicRecords.getGrade(i) + ", ");
                }

            }

            output.write("\nResearch:\n");
            for(i = 0; i < academicRecords.getResearch().size(); i++){
                output.write(academicRecords.getResearchDate(i) + "\n");
                output.write(academicRecords.getTopic(i) + "\n");
            }

            //Writing project information to the file
            output.write("\nProjects\n");
            for(i = 0; i < projects.getProjectTitles().size(); i++){
                output.write(projects.getProjectDate(i) + "\n");
                output.write(projects.getProjectTitle(i) + "\n");
            }

            //Writing certificate information to the file
            output.write("\nCertifcates\n");
            for(i = 0; i < certs.getCertTitles().size(); i++){
                output.write(certs.getCertDate(i) + "\n");
                output.write(certs.getCertTitle(i) + "\n");
            }
            output.close();
        }
        catch (IOException e){
            System.out.println("ERROR!");
            e.printStackTrace();
        }

    }


}
