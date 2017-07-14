import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String fileSavePath = args[1];
        List<Thread> threadsList = new ArrayList<>();
        PathsGetter pathsGetter = new PathsGetter(filePath);
        List<String> list = pathsGetter.getPaths();
        createThread(threadsList, list, fileSavePath);
        startThreads(threadsList);
    }

    private static void createThread(List<Thread> threadsList, List<String> list, String fileSavePath) {
        Thread thread;
        for (int i = 0; i < list.size(); i++) {
            MyThread myThread = new MyThread(list.get(i), fileSavePath);
            thread = new Thread(myThread, "MyThread " + i);
            threadsList.add(thread);
        }
    }

    private static void startThreads(List<Thread> threadsList) {
        for (Thread curThread : threadsList) {
            curThread.start();
        }
    }
}
