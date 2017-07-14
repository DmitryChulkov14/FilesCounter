import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyThread implements Runnable {

    private String fileLink;
    private String fileSavePath;

    MyThread(String fileLink, String fileSavePath) {
        this.fileLink = fileLink;
        this.fileSavePath = fileSavePath;
    }

    @Override
    public void run() {
        File file = new File(fileLink);
        countAndWriteResultInFile(file);
    }

    private synchronized void countAndWriteResultInFile(File curFile) {
        FileCounter fc = new FileCounter();
        StringBuffer sb = new StringBuffer();
        fc.processFilesFromFolder(curFile);
        try {
            Files.write(Paths.get("results.txt"), (curFile.getAbsolutePath() + ";" + fc.getCounter() + "\r\n").getBytes(), StandardOpenOption.APPEND); // fileSavePath передать СЮДА!
        } catch (IOException e) {
            e.printStackTrace();
        }

        ThreadNumber.printInfo(fc, curFile);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyThread myThread = (MyThread) o;

        if (fileLink != null ? !fileLink.equals(myThread.fileLink) : myThread.fileLink != null) return false;
        return fileSavePath != null ? fileSavePath.equals(myThread.fileSavePath) : myThread.fileSavePath == null;
    }

    @Override
    public int hashCode() {
        int result = fileLink != null ? fileLink.hashCode() : 0;
        result = 31 * result + (fileSavePath != null ? fileSavePath.hashCode() : 0);
        return result;
    }
}
