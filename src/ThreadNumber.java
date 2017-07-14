import java.io.File;

class ThreadNumber {
    private static long counter = 1;

    static synchronized void printInfo(FileCounter fc, File curFile){
        StringBuilder sb = new StringBuilder();
        sb.append(counter++)
                .append("\t")
                .append(fc.getCounter())
                .append("\t")
                .append(curFile.getAbsolutePath());
        System.out.println(sb.toString());
    }
}
