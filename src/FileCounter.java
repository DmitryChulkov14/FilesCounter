import java.io.File;

class FileCounter {
    private int counter;

    int getCounter() {
        return counter;
    }

    void processFilesFromFolder(File folder)
    {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry);
                continue;
            }
            counter++;
        }
    }


}

