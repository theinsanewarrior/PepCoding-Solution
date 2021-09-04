import java.util.*;
public class infixConversions {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    Stack<String> pre = new Stack();
    Stack<Character> operators = new Stack();
    Stack<String> post = new Stack();
    
    for(int i=0; i<exp.length(); i++){
        char ch = exp.charAt(i);
        if((ch>='0' && ch <='9') ||(ch>='a' && ch<='z')){
            pre.push(ch+"");
            post.push(ch+"");
        }
        else if(ch == '(') operators.push(ch);
        else if(ch == ')'){
            while(operators.peek()!='('){
                String preval2 = pre.pop();
                String preval1 = pre.pop();
                String postval2 = post.pop();
                String postval1 = post.pop();
                char op = operators.pop();
                post.push(postval1+postval2+op);
                pre.push(op+preval1+preval2);
            }
            operators.pop();
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operators.size()>0 && operators.peek()!='(' && precedence(ch) <= precedence(operators.peek())){
                String preval2 = pre.pop();
                String preval1 = pre.pop();
                String postval2 = post.pop();
                String postval1 = post.pop();
                char op = operators.pop();
                post.push(postval1+postval2+op);
                pre.push(op+preval1+preval2);
            }
            operators.push(ch);
        }
    }
    
    while(operators.size()>0){
        String preval2 = pre.pop();
        String preval1 = pre.pop();
        String postval2 = post.pop();
        String postval1 = post.pop();
        char op = operators.pop();
        post.push(postval1+postval2+op);
        pre.push(op+preval1+preval2);
    }
    
    String postAns = "";
    while(post.size()>0) postAns+=post.pop();
    System.out.println(postAns);
    
    String preAns = "";
    while(pre.size()>0) preAns+=pre.pop();
    System.out.println(preAns);
    
 }
 
 public static int precedence(char ch){
     if(ch == '*' || ch == '/') return 2;
     else if(ch == '+' || ch == '-') return 1;
     else return 0;
 }
}
