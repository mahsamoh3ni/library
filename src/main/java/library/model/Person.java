package library.model;


import java.io.Serializable;

abstract public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private int nationalCode;
    private Date birthday;
    private String password;

    public Person(String firstName, String lastName, int nationalCode, Date birthday, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "FirstName is:" + firstName + "\n" + "LastName is:" + lastName + "\n" + "NationalCode is:" + nationalCode + "\n" + "Birthday is:" + birthday;
    }


}
