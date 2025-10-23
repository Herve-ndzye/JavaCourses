package MyStudies;

import java.io.*;

public class studentsMarks {
    private String Name;
    private int score;
    private double percentage;
    private boolean pass;

    public studentsMarks(String Name, int score, double percentage, boolean pass) {
        this.Name = Name;
        this.score = score;
        this.percentage = percentage;
        this.pass = pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }
}
class StudentMarksMain{
    public static void main(String[] args){
        File file = new File("./src/MyStudies/Marks.dat");

        studentsMarks Herve = new studentsMarks("Herve",40,80.0,true);
        studentsMarks Bana = new studentsMarks("Bana",35,70.0,true);
        studentsMarks Brian = new studentsMarks("Brian",10,20.0,false);
        studentsMarks Samuel = new studentsMarks("Samuel",20,40.0,false);

        try(DataOutputStream printMarks = new DataOutputStream(new FileOutputStream(file))){
            printMarks.writeUTF(Herve.getName());
            printMarks.writeInt(Herve.getScore());
            printMarks.writeDouble(Herve.getPercentage());
            printMarks.writeBoolean(Herve.isPass());
            printMarks.writeUTF(Bana.getName());
            printMarks.writeInt(Bana.getScore());
            printMarks.writeDouble(Bana.getPercentage());
            printMarks.writeBoolean(Bana.isPass());
            printMarks.writeUTF(Brian.getName());
            printMarks.writeInt(Brian.getScore());
            printMarks.writeDouble(Brian.getPercentage());
            printMarks.writeBoolean(Brian.isPass());
            printMarks.writeUTF(Samuel.getName());
            printMarks.writeInt(Samuel.getScore());
            printMarks.writeDouble(Samuel.getPercentage());
            printMarks.writeBoolean(Samuel.isPass());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(DataInputStream outMarks  = new DataInputStream(new FileInputStream(file))){
            System.out.println("Name    Score(/50)    Percentage    Pass/Fail");
            while((outMarks.available())!=0){
                System.out.printf("%-12s",outMarks.readUTF());
                System.out.printf("%-12s",outMarks.readInt());
                System.out.printf("%-13s",outMarks.readDouble());
                boolean b = outMarks.readBoolean();
                if(b){
                    System.out.print("Pass\n");
                }else{
                    System.out.print("Fail\n");
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
