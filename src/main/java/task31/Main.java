package task31;

import task3.ThreadWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws IllegalStateException, InterruptedException, IOException {
        int count = 0;
        AtomicInteger integer = new AtomicInteger(0);
        File file = new File("Result.txt");
        file.createNewFile();

        Thread thread1 = new Thread(new TWriter(integer, file));
        Thread thread2 = new Thread(new TWriter(integer, file));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}

class TWriter implements Runnable {

    private File file;

    private AtomicInteger count;

    private FileWriter fileWriter;

    public TWriter(AtomicInteger count, File file) {
        this.count = count;
        this.file = file;

    }

    @Override
    public void run() {
        for (int i = 0; i < 100 / 2; i++) {
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                synchronized (file) {
                    increment();
                    System.out.println("Число " + count + " " + Thread.currentThread());
                    fileWriter.write("Число " + count + " " + Thread.currentThread() + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }


    }

    public void increment() {
        count.incrementAndGet();
    }
}
