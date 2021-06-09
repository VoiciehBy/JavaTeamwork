package dbclass;

import java.sql.Date;

public class Employee {
    private int id;
    private String firstName;
    private String secondName;
    private String surname;
    private Date birthDate;

    public Employee(){
        id = 0;
        firstName = "";
        secondName = "";
        surname = "";
        birthDate = Date.valueOf("1999-01-01");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
