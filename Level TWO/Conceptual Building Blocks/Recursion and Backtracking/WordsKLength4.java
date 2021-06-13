import java.util.*;
public class WordsKLength4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        String ustr = "";
        HashMap<Character, Integer> fm = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(fm.containsKey(ch))
                fm.put(ch, fm.get(ch)+1);
            else{
                fm.put(ch, 1);
                ustr+=ch;
            }
        }
        wordsKLength(0, k, ustr, fm, "");
      }
      
      public static void wordsKLength(int idx, int k, String ustr, HashMap<Character, Integer> fm, String asf){
          if(idx == k){
              System.out.println(asf);
              return;
          }
          for(int i=0; i<ustr.length(); i++){
              char ch = ustr.charAt(i);
              if(fm.get(ch) > 0){
                  fm.put(ch, fm.get(ch)-1);
                  wordsKLength(idx+1, k, ustr, fm, asf+ch);
                  fm.put(ch, fm.get(ch)+1);
              }
          }
      }
}
