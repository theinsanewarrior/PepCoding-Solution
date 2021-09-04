import java.util.*;
public class infixEvaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        
        Stack<Character> operators = new Stack();
        Stack<Integer> operands = new Stack();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(Character.isDigit(ch)) operands.push(ch-'0');
            else if(ch == '(') operators.push(ch);
            else if(ch == ')'){
                while(operators.peek()!='('){
                    char op = operators.pop();          
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    operands.push(evaluate(val1, op, val2));
                    // System.out.println(operands.peek());
                }
                operators.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch =='/'){
                while(operators.size()>0 && operators.peek()!='(' && opPrecedence(ch) <= opPrecedence(operators.peek())){
                    char op = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    operands.push(evaluate(val1, op, val2));
                    // System.out.println(operands.peek());
                }
                operators.push(ch);
            }
        }
        while(operators.size()>0){
            char op = operators.pop();
            int val2 = operands.pop();
            int val1 = operands.pop();
            operands.push(evaluate(val1, op, val2));
            // System.out.println(operands.peek()+" this"); 
        }
        System.out.println(operands.peek());
        
     }
     
     public static int evaluate(int val1, char op, int val2){
         if(op == '*') return (val1*val2);
         else if(op == '-') return (val1-val2);
         else if(op == '+') return (val1+val2);
         else return (val1/val2);
     }
     
     public static int opPrecedence(char ch){
         if(ch == '*' || ch == '/') return 2;
         else if(ch=='+' || ch == '-') return 1;
         else return 0;
     }
}
