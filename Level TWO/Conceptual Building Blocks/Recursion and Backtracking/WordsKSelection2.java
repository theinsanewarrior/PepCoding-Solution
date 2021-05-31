import java.util.*;
public class WordsKSelection2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        HashSet<Character> set = new HashSet<>();
        String unique = "";
        for(int i=0; i<str.length(); i++){
            if(!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
                unique+=str.charAt(i);
            }
        }
        wordSelection(0, k, unique, -1, "");
      }
      
      public static void wordSelection(int count, int k, String unique, int last, String asf){
          if(count == k){
              System.out.println(asf);
              return;
          }
          for(int i=last+1; i<unique.length(); i++){
              char ch = unique.charAt(i);
              wordSelection(count+1, k, unique, i, asf+ch);
          }
      }
}
