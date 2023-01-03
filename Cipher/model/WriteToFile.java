package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteToFile {
  
  public void writeToFile(String text) {
    try {
      Files.write(Paths.get("encrypted.txt"), text.getBytes());
      /*
      URL url = getClass().getResource(fileName);
      File myObj = new File(url.getPath());
      FileWriter myWriter = new FileWriter(url.getPath());
      myWriter.write(text);
      myWriter.close();*/
      System.out.println("Successfully encrypted/decrypted the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
