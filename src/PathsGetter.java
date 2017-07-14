import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class PathsGetter {
    private List<String> paths;

    List<String> getPaths() {
        return paths;
    }

    PathsGetter(String filePath) {
        Path path = Paths.get(filePath);
        try {
            this.paths = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
