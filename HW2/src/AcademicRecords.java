/**
 * AcademicRecords class will organize all academic info into a single object
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: October 19, 2021.
 */

import java.util.ArrayList;

public class AcademicRecords {
    private ArrayList<String> courseNames;
    private ArrayList<Double> courseGrades;
    private ArrayList<String> researchTopics;
    private ArrayList<String> researchDates;

    //Constructor
    public AcademicRecords(ArrayList<String> courses,
                           ArrayList<Double> grades,
                           ArrayList<String> research,
                           ArrayList<String> dates) {
        courseNames = courses;
        courseGrades = grades;
        researchTopics = research;
        researchDates = dates;

    }

    //Calculate GPA
    public double calcGPA (ArrayList<Double> grades){
        int l = grades.size();
        double sum = 0;
        for (double i: grades){
            sum += i;
        }
        double avg = sum/l;

        return avg;
    }
    //Allows customization of data at any time
    public void setAcademicRecords(ArrayList<String> newCourses,
                                   ArrayList<Double> newGrades,
                                   ArrayList<String> newResearch,
                                   ArrayList<String> newDates) {
        courseNames = newCourses;
        courseGrades = newGrades;
        researchTopics = newResearch;
        researchDates = newDates;
    }

    //Accessor methods
    public ArrayList<String> getCourses(){
        return courseNames;
    }

    public String getCourse(int index){
        return courseNames.get(index);
    }

    public ArrayList<Double> getGrades(){
        return courseGrades;
    }

    public Double getGrade(int index){
        return courseGrades.get(index);
    }

    public ArrayList<String> getResearch(){
        return researchTopics;
    }

    public String getTopic(int index){
        return researchTopics.get(index);
    }

    public String getResearchDate(int index){
        return researchDates.get(index);
    }
}
