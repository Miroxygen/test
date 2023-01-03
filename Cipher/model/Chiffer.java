package model;


/**
 * A chiffer for encryption.
 */
public interface Chiffer {

  /**
   * Encodes a plaintext.
   */
  public String encode(String text, int key);

  /**
   * Decodes a plaintext.
   */
  public String decode(String text, int key);
}