import java.util.*;
public class PermutationWords1 {
    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
        // write your code here
        if(cs>ts){
            System.out.println(asf);
            return;
        }
        Set<Character> set = fmap.keySet();
        for(char ch: set){
            int freq = fmap.get(ch);
            if(freq>0){
                fmap.put(ch, freq-1);
                generateWords(cs+1, ts, fmap, asf+ch);
                fmap.put(ch, freq);
            }
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
    
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(char ch: str.toCharArray()){
          if(fmap.containsKey(ch)){
            fmap.put(ch, fmap.get(ch) + 1);
          } else {
            fmap.put(ch, 1);
          }
        }
    
        generateWords(1, str.length(), fmap, "");
      }
}
