package view;

import java.util.Scanner;

public class Console {
  final String sub = "S";
  final String trans = "T";
  final String encrypt = "E";
  final String decrypt = "D";
  Scanner userInput = new Scanner(System.in, "utf-8");

  public static enum StartMessage {
    Sub,
    Trans
  }

  public static enum EncryptOrDecypt {
    Encrypt,
    Decrypt
  }

  /**
   * Displays a welcome message.
   */
  public void displayStartMessage() {
    System.out.println("|| Welcome to this encryption app. ||");
    System.out.println("|| Press " + sub + " for creating a substitution cipher ||");
    System.out.println("|| Press " + trans + " for creating a transposition cipher ||");
  }

  public String getFileName() {
    System.out.println("|| Please enter name of file you wish to encrypt/decrypt ||");
    String fileName = userInput.nextLine();
    return fileName;
  }

  public String getKey() {
    try {
      System.out.println("|| Please enter a key ||");
      String key = userInput.nextLine();
      int keyInt = Integer.parseInt(key);
      if(keyInt < -256 || keyInt > 256) {
        throw new Exception("Please use a key value between -256 and 256.");
      }
      return key;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public EncryptOrDecypt getInput() {
    System.out.println("|| Do you want to encrypt " + encrypt + " or decrypt " + decrypt + " ? ||");
    String input = userInput.nextLine();
    if(input.equals(encrypt)) {
      return EncryptOrDecypt.Encrypt;
    } else if(input.equals(decrypt)) {
      return EncryptOrDecypt.Decrypt;
    }
    return null;
  }

  /**
   * Get action from user.
   *
   * @return User choice enum.
   */
  public StartMessage getAction() {
    String input = userInput.nextLine();
    if(input.equals(sub)) {
      return StartMessage.Sub;
    } else if(input.equals(trans)) {
      return StartMessage.Trans;
    }
    return null;
  }
}
