/**
 * Projects class will organize all project info into a single object
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: October 19, 2021.
 */

import java.util.ArrayList;

public class Projects {
    private ArrayList<String> projectTitles;
    private ArrayList<String> projectDates;

    //Constructor
    public Projects(ArrayList<String> titles,
                    ArrayList<String> dates) {
        projectTitles = titles;
        projectDates = dates;

    }

    //Allows customization of data at any time
    public void setProjects(ArrayList<String> newProjectTitles,
                                   ArrayList<String> newProjectDates) {
        projectTitles = newProjectTitles;
        projectDates = newProjectDates;
    }

    //Accessor methods
    public ArrayList<String> getProjectTitles(){
        return projectTitles;
    }

    public String getProjectTitle(int index){
        return projectTitles.get(index);
    }


    public String getProjectDate(int index) {
        return projectDates.get(index);
    }
}
