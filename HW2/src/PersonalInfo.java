/**
 * PersonalInfo class will organize all personal info into a single object
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: October 19, 2021.
 */
public class PersonalInfo {
    private String name;
    private String phone;
    private String school;

    //Constructor class
    public PersonalInfo (String studentName,
                         String studentPhone,
                         String schoolName) {
        name = studentName;
        phone = studentPhone;
        school = schoolName;
    }

    //Allows customization of data at any time
    public void setPersonalInfo(String newStudentName,
                                String newStudentPhone,
                                String newSchoolName) {
        name = newStudentName;
        phone = newStudentPhone;
        school = newSchoolName;
    }

    //Accessor methods
    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getSchool(){
        return school;
    }
}
