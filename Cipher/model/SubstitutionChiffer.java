package model;

public class SubstitutionChiffer implements Chiffer {
  final static String subKey = "]kYV}(!7P$n5_0i R:?jOWtF/=-pe'AD&@r6%ZXs\"v*N"
  + "[#wSl9zq2^+g;LoB`aGh{3.HIu4fbK)mU8|dMET><,Qc\\C1yxJ";

  
  public String encode(String text, int key) {
    StringBuilder alteredText = new StringBuilder(text.length());
    System.out.println("Encrypting your file..");
    for(char character : text.toCharArray()) {
      int index = subKey.indexOf(Character.toString(character));
      if((index - key) < 0) {
        alteredText.append(subKey.charAt(subKey.length() - (key - index)));
      } else {
        alteredText.append(subKey.charAt(index - key));
      }
    }
    System.out.println(text);
    System.out.println(alteredText.toString());
    return alteredText.toString();
  }

  public String decode(String text, int key) {
    StringBuilder alteredText = new StringBuilder(text.length());
    for(char character : text.toCharArray()) {
      int index = subKey.indexOf(Character.toString(character));
      if((index + key > subKey.length())) {
        alteredText.append(subKey.charAt((index + key) - subKey.length()));
      } else {
        alteredText.append(subKey.charAt(index + key));
      }
    }
    System.out.println("Decrypting your file..");
    System.out.println(text);
    System.out.println(alteredText.toString());
    return alteredText.toString();
  }
  
}
