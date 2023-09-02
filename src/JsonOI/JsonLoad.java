package JsonOI;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonLoad {
    Gson file;
    Path currentRelativePath;
    String fullPath;
    Reader read;

    public JsonLoad() {
        this.file = new Gson();
        this.currentRelativePath = Paths.get("");
        this.fullPath = currentRelativePath.toAbsolutePath().toString();
        this.read = null;
    }

    public Object LoadByFileName(String file, Class frame){

        String path = fullPath +"/"+file;
        try {
            read = new FileReader(path);
        }
        catch (FileNotFoundException read) {
            System.out.println(file+" not found");
        }
        return this.file.fromJson(read, frame);


    }
}
