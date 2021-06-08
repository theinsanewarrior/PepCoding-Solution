import java.util.*;
public class WordsKLength1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
    
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.contains(ch) == false) {
            unique.add(ch);
            ustr += ch;
          }
        }
        Character[] arr = new Character[k];
        wordsKLength(0, ustr, arr, 0);
        
      }
      
      public static void wordsKLength(int idx, String ustr, Character[] arr, int occupied){
          if(idx == ustr.length()){
              if(occupied == arr.length){
                  for(int i=0; i<arr.length; i++){
                      System.out.print(arr[i]);
                  }
                  System.out.println();
              }
              return;
          }
          for(int i=0; i<arr.length; i++){
              if(arr[i] == null){
                  arr[i] = ustr.charAt(idx);
                  wordsKLength(idx+1, ustr, arr, occupied+1);
                  arr[i] = null;
              }
          }
          wordsKLength(idx+1, ustr, arr, occupied);
      }
}
