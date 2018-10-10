import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;

public class Expand {
  public static void main(String [] args) {

    File f = new File("dictionary");

    try {
      Scanner sk = new Scanner(f);
      StringSet x = new StringSet();

      // Read in the entire dictionary...
      while (sk.hasNext()) {
        String word = sk.next().toUpperCase();
        x.insert(word);
      }
      System.out.println("Dicitonary loaded...");
      sk = new Scanner(System.in);
      char[] vowels = {'A', 'E', 'I', 'O', 'U'};

      // Keep suggesting expansions as long as the user makes an input.
      while (sk.hasNext()) {
          String word = sk.next().toUpperCase();
          //if word is already a word return
          if (x.find(word)){
            System.out.println(word + " is correct.");
          }
          //else find alternatives
          else {
              System.out.println("Suggesting alternate expansions...");
              for (int i = 1; i <= word.length(); i++){
                  StringBuilder test = new StringBuilder(word);
                  test.insert(i, 'A');
                  //for (char vow : vowels) {
                  for (int j = 0; j<=26; j++) {
                      test.setCharAt(i, (char)('A'+j));
                      if (x.find(test.toString())) {
                          System.out.println(test.toString());
                      }
                  }
              }
          }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    }
  }
}
