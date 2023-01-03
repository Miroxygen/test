package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Filereader {
  public String textData;
  

  public void readFile(String fileName) {
    try {
      InputStream input = getClass().getResourceAsStream(fileName);
      Scanner myReader = new Scanner(input);
      while (myReader.hasNextLine()) {
        if(textData == null) {
          textData = myReader.nextLine();
        } else {
          textData = textData + myReader.nextLine();
        }
      }
      myReader.close(); 
    } catch (Exception e) {
      System.out.println("File not found.");
      return;
    }
  }

  public String getFileTextAsString() {
    return textData;
  }
}
