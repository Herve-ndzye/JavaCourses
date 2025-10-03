package rw.rca.FirstProject.examples;

public class Exercises {

    public static class Computer {
        String brandName;
        int CPU;
        int hardDisk;

        public Computer() {
            System.out.println("In Computer");
        }

        public Computer(String brandName) {
            this.brandName = brandName;
        }

        public void show() {
            System.out.println("The computer brand is " + brandName);
        }
    }

    public static class Laptop extends Computer {
        public Laptop() {
            System.out.println("Display in Laptop");
        }

        public Laptop(String brandName) {
            super(brandName);
            this.brandName = brandName;
        }

        public Laptop(int CPU) {
            super();
            this.CPU = CPU;
        }
    }

    public static void main(String[] args) {
        Computer c = new Computer("Dell");
        c.show();

        Laptop l = new Laptop("HP");
        l.show();
    }
}
