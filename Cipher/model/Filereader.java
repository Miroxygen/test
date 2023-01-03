package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class Filereader {
  public String textData;
  

  public void readFile(String fileName) {
    try {
      URL url = getClass().getResource(fileName);
      File myObj = new File(url.getPath());
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        if(textData == null) {
          textData = myReader.nextLine();
        } else {
          textData = textData + myReader.nextLine();
        }
      }
      myReader.close(); 
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
      return;
    }
  }

  public String getFileTextAsString() {
    return textData;
  }
}
