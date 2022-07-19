package task3;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static final int N = 10;
    public static final  File file = new File("Result.txt");

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        file.createNewFile();

        for(int i = 0; i < N; i++){
            executorService.execute(new ThreadWriter(file, atomicInteger));
        }
        executorService.shutdown();
    }
}