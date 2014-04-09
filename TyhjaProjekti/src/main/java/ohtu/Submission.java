package ohtu;

// points on null joten en vaivaudu käsittelemään sitä
public class Submission {
    private String student_number;
    private String week;
    private String hours;
    private String created_at;
    String a1;
    // kentät a2 - a21 samalla lailla, en toteuta koska formaatti on typerä
    
    public String getStudent_number() {
        return student_number;
    }
    

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        
        return "Opiskelijanumero: " + student_number + " Viikko: " + week +
                " tunteja: " + getHours() + " luotu: " + getCreated_at() + "Onko tehtävä 1 tehty: " + a1
                ;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }


}