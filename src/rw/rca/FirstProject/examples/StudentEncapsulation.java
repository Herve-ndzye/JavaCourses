package rw.rca.FirstProject.examples;

public class StudentEncapsulation {
    static class Student{
        private String lastName;
        private String firstName;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }
    class StudentMain{
        public static void main(String[] args){
            Student s = new Student();
            s.setLastName("Niyonkuru");
        }
    }
}

