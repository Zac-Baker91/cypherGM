package JsonOI;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonSave {

    Gson file;
    Path currentRelativePath;
    String fullPath;

    public JsonSave() {
        this.file = new Gson();
        this.currentRelativePath = Paths.get("");
        this.fullPath = currentRelativePath.toAbsolutePath().toString();
    }

     public void save(Object obj,String fileName) throws IOException {
         String filePath = fullPath+"/savefile/"+fileName+".json";
         System.out.println("Saving...: " + filePath);
         String saveFile = file.toJson(obj);
         BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

         writer.write(saveFile);

         writer.close();
         System.out.println("Player Saved to: "+ fileName);
     }





}
