package controller;

import model.Chiffer;
import model.Filereader;
import model.SubstitutionChiffer;
import model.TransPositionChiffer;
import model.WriteToFile;
import view.Console;

public class Creator {
  private Console console;
  private Filereader filereader;
  private WriteToFile fileWriter;
  private Chiffer chiffer;
  private String fileName;
  private int key;
  private String message;
  
  Creator(Console c, Filereader fr, WriteToFile wtf) {
    console = c;
    filereader = fr;
    fileWriter = wtf;
  }

  public void createEnOrDecryption() {
    console.displayStartMessage();
    view.Console.StartMessage action = console.getAction();
    fileName = console.getFileName();
    String stringKey = console.getKey();
    key = Integer.parseInt(stringKey);
    switch (action) {
      case Sub:
        chiffer = new SubstitutionChiffer();
        System.out.println("S");
        break;
      case Trans:
        chiffer = new TransPositionChiffer();
        System.out.println("T");
        break;
    }
    doChiffer(getFileAsString());
  }

  public String getFileAsString() {
    filereader.readFile(fileName);
    return filereader.getFileTextAsString();
  }

  public void doChiffer(String text) {
    view.Console.EncryptOrDecypt action = console.getInput();
    switch (action) {
      case Encrypt:
        message = chiffer.encode(text, key);
        break;
      case Decrypt:
        message = chiffer.decode(text, key);
        break;
    }
  }

  public void writeToFile() {
    fileWriter.writeToFile(message);
  }
}
