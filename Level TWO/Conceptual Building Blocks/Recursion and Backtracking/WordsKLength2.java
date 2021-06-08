import java.util.*;
public class WordsKLength2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
    
        HashMap<Character, Boolean> hm = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (hm.containsKey(ch) == false) {
            hm.put(ch, false);
            ustr += ch;
          }
        }
        
        wordKLength(0, k, hm, ustr, "");
      }
      
      public static void wordKLength(int count, int k, HashMap<Character, Boolean> hm, String ustr, String asf){
          if(count == k){
              System.out.println(asf);
              return;
          }
          for(int i=0; i<ustr.length(); i++){
              char ch = ustr.charAt(i);
              if(hm.get(ch) == false){
                hm.put(ch, true);
                wordKLength(count+1, k, hm, ustr, asf+ch);
                hm.put(ch, false);
              }
          }
      }
}
