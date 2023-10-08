package JsonOI;

import com.google.gson.Gson;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println(path);
        try {
            read = new FileReader(path);
        }
        catch (FileNotFoundException read) {
            System.out.println(file+" not found");
        }
        return this.file.fromJson(read, frame);


    }
    public Object[] LoadAllJsonInDirectory(String dir, Class frame) throws IOException {
        
        Set<String> files = listFiles(dir);
        int numFiles = files.size();
        Object[] objArray = new Object[numFiles];
        System.out.println("Num files: "+numFiles);

        
        int ptr = 0;
        for(String fName : files){
            System.out.println("File "+ptr+": "+fName);

            objArray[ptr] = LoadByFileName(dir+"/"+fName,frame);
            ptr++;
        }
        System.out.println("Dir load complete");
        return objArray;


    }


    private Set<String> listFiles(String dir) throws IOException {
        String dirPath = fullPath + "/" + dir;
        System.out.println("Reading Directory: "+dirPath);
        try (Stream<Path> stream = Files.list(Paths.get(dirPath))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }catch(IOException ex){
            throw new IOException("Failed to stream Directory");
        }
    }
}
