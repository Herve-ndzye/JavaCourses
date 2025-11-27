package MyStudies.ConsumerProducer;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Task "+num+" has started!");
        for(int i = num; i < num*10; i++){
            System.out.println(i);
        }
        System.out.println("Task "+num+" completed!");
    }
    int num;
    public Task(int num){
        this.num = num;
    }
}
class Hello implements Runnable{
    @Override
    public void run() {
        Scanner c = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = c.nextLine();
        System.out.println("Hello "+ name);
    }
}
public class ExecutorFramDemo {
    public static void main(String[] args){
        ExecutorService executorService =  Executors.newFixedThreadPool(1);
        executorService.execute(new Hello());
        executorService.execute(new Hello());
        executorService.execute(new Hello());
        executorService.execute(new Hello());
        executorService.execute(new Hello());
        executorService.shutdown();
    }
}
