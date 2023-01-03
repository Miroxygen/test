package model;

public class TransPositionChiffer implements Chiffer {

  public String encode(String text, int key) {
    int rows = (int) Math.ceil((double) text.length() / key);
    int columns = key;
    char[] textToCopy = text.toCharArray();
    char[][] rowsAndColumns = new char[rows][columns];
    int currentRow = 0;
    int currentColumn = 0;
    for(int i = 0; i < text.length(); i++) {
      currentColumn = i % columns;
      if (currentColumn == 0) {
        currentRow = i / columns;
    }
      rowsAndColumns[currentRow][currentColumn] = textToCopy[i];
    }
    String alteredText = "";
    for(int i = 0; i < columns; i++) {
      for(int j = 0; j < rows; j++) {
        alteredText += rowsAndColumns[j][i];
      }
    }
    System.out.println("Encrypting your file..");
    System.out.println(alteredText);
    return alteredText;
  }

  public String decode(String text, int key) {
    int rows = (int) Math.ceil((double) text.length() / key);
    int columns = key;
    char[][] rowsAndColumns = new char[rows][columns];
    int currentRow = 0;
    int currentColumn = 0;
    int currentIndex = 0;
    for(currentColumn = 0; currentColumn < columns; currentColumn++) {
      for(currentRow = 0; currentRow < rows; currentRow++) {
        if(text.length() > currentIndex) {
          rowsAndColumns[currentRow][currentColumn] = text.charAt(currentIndex++);
        }
      }
    }
    String alteredText = "";
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        alteredText += rowsAndColumns[i][j];
      }
    }
    System.out.println("Decrypting your file..");
    System.out.println(alteredText);
    return alteredText;
  }
  
}
