import java.util.*;
public class WordsKSelection3 {
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
        
        wordsKSelection(ustr, 0, unique, "", k);
       
      }
      
      public static void wordsKSelection(String ustr, int idx, HashMap<Character, Integer> fm, String asf, int k){
          if(idx == ustr.length()){
              if(k==asf.length())
                System.out.println(asf);
              return;
          }
        //   yes
          char ch = ustr.charAt(idx);
          int freq = fm.get(ch);
          for(int i=freq; i>=1; i--){
              fm.put(ch, freq-i);
              String str = "";
              for(int j=0; j<i; j++){
                  str+=ch;
              }
              if(asf.length()+str.length() <= k)
                  wordsKSelection(ustr, idx+1, fm, asf+str, k);
              fm.put(ch, freq);
          }
        //   no
          wordsKSelection(ustr, idx+1, fm, asf, k);
      }
}
