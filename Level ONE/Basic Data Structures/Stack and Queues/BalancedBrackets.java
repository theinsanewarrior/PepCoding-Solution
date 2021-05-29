// package Stack and Queues;
import java.util.*;
public class BalancedBrackets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack <Character> st = new Stack<>();
        boolean ans = true;
        for(int i=0; i<str.length(); i++ ){
            char ch = str.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                st.push(ch);
            }
            else if(ch == ']' || ch == '}' || ch == ')' ){
                if(st.size() == 0){
                    ans = false;
                    break;
                }
                if(st.peek() == '[' && ch == ']'){
                    st.pop();
                    continue;
                }
                else if(st.peek() == '(' && ch == ')'){
                    st.pop();
                    continue;
                }
                else if(st.peek() == '{' && ch == '}'){
                    st.pop();
                    continue;
                }
                else{
                    ans = false;
                    break;
                }
            }
        }
        if(st.size() !=0)
            ans = false;
        System.out.println(ans);
        
    }
}
