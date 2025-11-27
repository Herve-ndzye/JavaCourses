package MyStudies.ConsumerProducer;

import java.util.List;
import java.util.concurrent.*;

class TaskCallable implements Callable<String> {
    String name;

    public TaskCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return "hello "+name;
    }
}
public class TaskCallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService =  Executors.newFixedThreadPool(1);
        List<TaskCallable>  tasks = List.of(new TaskCallable("Angello"),new TaskCallable("Brian"));
        List<Future<String>> messages = executorService.invokeAll(tasks);
        executorService.shutdown();
        for(Future<String> mes : messages){
            System.out.println(mes.get());
        }
    }
}
