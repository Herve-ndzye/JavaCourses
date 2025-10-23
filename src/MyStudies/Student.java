package MyStudies;

import java.io.Serializable;

public class Student implements Serializable {
    //Serialisable(process of turning objects to bytes like for sending it to a network.) interface
    // interfaces: marker, function, normal
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
