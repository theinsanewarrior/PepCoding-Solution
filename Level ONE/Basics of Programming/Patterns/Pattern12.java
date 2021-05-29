package Basics of Programming.Patterns;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // write ur code here
        int first = 0, second = 1, val = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(i==0)
                    System.out.print(first+"	");
                else if(i==1){
                    System.out.print(second+"	");
                }
                else{
                    first = second;
                    second = val;
                    val = first+second;
                    System.out.print(val+"	");
                }
            }
            System.out.println();
        }

    }
}
