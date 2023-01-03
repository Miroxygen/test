package controller;

import model.Filereader;
import model.WriteToFile;
import view.Console;

public class App {
  
  
  public static void main(String[] args) {
    Filereader fileReader = new Filereader();
    WriteToFile fileWriter = new WriteToFile();
    Console console = new Console();
    Creator creator = new Creator(console, fileReader, fileWriter);
    creator.createEnOrDecryption();
    creator.writeToFile();
  }
}
