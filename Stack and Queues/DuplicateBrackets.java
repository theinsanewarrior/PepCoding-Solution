// package Stack and Queues;
import java.util.*;
public class DuplicateBrackets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack <Character> st = new Stack<>();
        boolean ans = false;
        for(int i=0; i<str.length(); i++){
            char chr = str.charAt(i);
            if(chr == ')'){
                int pc = 0;
                while(st.peek() != '('){
                    st.pop();
                    pc++;
                }
                // System.out.println(pc);
                if(pc==0){
                    ans = true;
                    break;
                }
                else{
                    st.pop();
                }
            }
            else{
                st.push(chr);
            }
        }
        System.out.println(ans);
    }
}
