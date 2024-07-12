/**
 *  Certificates class will organize all certificate info into a single object
 *  Author: Kyle Zyler Cayanan
 *  E-mail Address: kcayanan@uci.edu
 *  Last Changed: October 19, 2021.
 */

import java.util.ArrayList;

public class Certificates {
    private ArrayList<String> certTitles;
    private ArrayList<String> certDates;

    //Constructor, similar to projects
    public Certificates(ArrayList<String> titles,
                    ArrayList<String> dates) {
        certTitles = titles;
        certDates = dates;

    }

    //Allows customization of data at any time
    public void setCerts(ArrayList<String> newCertTitles,
                            ArrayList<String> newCertDates) {
        certTitles = newCertTitles;
        certDates = newCertDates;
    }

    //Accessor Methods
    public ArrayList<String> getCertTitles(){
        return certTitles;
    }

    public String getCertTitle(int index){
        return certTitles.get(index);
    }


    public String getCertDate(int index) {
        return certDates.get(index);
    }
}
