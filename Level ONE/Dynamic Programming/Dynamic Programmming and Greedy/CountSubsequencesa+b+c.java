// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class CountSubsequencesa+b+c {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int a = 0, ab=0, abc = 0;
        for(int i=0; i<str.length(); i++ ){
            char ch = str.charAt(i);
            if(ch == 'a'){
                a = a + a + 1; //two cases with inclusion and exclusion of new a alongwith old a, and third for single new a
            }
            else if(ch == 'b'){
                ab = ab + ab + a;
            }
            else if(ch == 'c'){
                abc = abc + abc + ab;
            }
            
        }
        System.out.println(abc);
    }
}
