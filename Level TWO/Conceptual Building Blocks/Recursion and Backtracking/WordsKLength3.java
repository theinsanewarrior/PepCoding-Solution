import java.util.*;
public class WordsKLength3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> last = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            last.put(str.charAt(i), -1);
        }
        Character[] ans = new Character[k];
        wordsPermutation(0, str, last, 0, ans);
      }
      
      public static void wordsPermutation(int idx, String str, HashMap<Character, Integer> lastIdx, int ssf, Character[] ans){
          if(idx == str.length()){
              if(ssf == ans.length){
                  for(int i=0; i<ans.length; i++){
                      System.out.print(ans[i]);
                  }
                  System.out.println();
              }
              return;
          }
          char ch = str.charAt(idx);
          int lidx = lastIdx.get(ch);
        //   yes
          for(int i=lidx+1; i<ans.length; i++){
              if(ans[i] == null){
                  lastIdx.put(ch, i);
                  ans[i] = ch;
                  wordsPermutation(idx+1, str, lastIdx, ssf+1, ans);
                  ans[i] = null;
                  lastIdx.put(ch, lidx);
              }
          }
        //   no
          if(lidx == -1){
              wordsPermutation(idx+1, str, lastIdx, ssf, ans);
          }
    }
}
