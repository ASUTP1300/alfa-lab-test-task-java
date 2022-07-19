package task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWriter implements Runnable {
    private final File file;
    private AtomicInteger aInteger;

    private FileWriter writerToCommon;

    public ThreadWriter(File file, AtomicInteger aInteger) throws IOException {
        this.file = file;
        this.aInteger = aInteger;
        this.writerToCommon = new FileWriter(file.getAbsoluteFile(), true);
    }

    @Override
    public void run() {


        try (FileWriter writerToOwn = new FileWriter(formatThreadName(Thread.currentThread().getName()) + ".txt",
                true);) {

            synchronized (file) {
                int current = aInteger.incrementAndGet();

                writerToOwn.write(current + " ");
                writerToOwn.flush();
                writerToCommon.write(current + " ");
                writerToCommon.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String formatThreadName(String threadName) {
        String prefix = "thread-";
        int i = threadName.indexOf(prefix);
        return "Thread" + threadName.substring(i + prefix.length());
    }

}
