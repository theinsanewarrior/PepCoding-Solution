import java.util.*;
public class WordsKSelection4 {
    import java.io.*;
import java.util.*;

public class Main {

  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    
    wordsKSelection(0, k, ustr, unique, 0, "");
    
  }
  
  public static void wordsKSelection(int level, int k, String ustr, HashMap<Character, Integer> hm, int last, String asf){
      if(level == k){
          System.out.println(asf);
          return;
      }
      for(int i=last; i<ustr.length(); i++){
          char ch = ustr.charAt(i);
          if(hm.get(ch)>0){
            hm.put(ch, hm.get(ch)-1);
            wordsKSelection(level+1, k, ustr, hm, i, asf+ch);
            hm.put(ch, hm.get(ch)+1);
          }
      }
  }

}
}
