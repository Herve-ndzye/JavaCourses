package MyStudies.ConsumerProducer;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProducer {
    int capacity;
    Queue<Integer> storage = new LinkedList<>();

    public ConsumerProducer(int capacity) {
        this.capacity = capacity;
    }
    public synchronized void producer(int value) throws InterruptedException {
        if(storage.size() == capacity){
            wait();
        }
        storage.add(value);
        System.out.println("produced "+ value);
        notify();
    }
    public synchronized int consumer() throws InterruptedException {
        if(storage.isEmpty())
            wait();
        int value = storage.poll();
        System.out.println("Consumed "+value);
        notify();
        return value;
    }
    public static void main(String[] args){
        ConsumerProducer cp = new ConsumerProducer(10);
        Thread t1 = new Thread(()->{
            for( int i = 1; i <= 50; i++){
                try {
                    cp.producer(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(()->{
            for( int i = 1; i <= 50; i++){
                try {
                    cp.consumer();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
