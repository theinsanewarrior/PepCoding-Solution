package Basics of Programming.Getting Started;

public class RotateaNumber {
    public static void main(String[] args) {
        // write your code here  
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int count=0;
        int n1 = n;
        while(n1!=0){
            n1 /= 10;
            count++;
        }
        
        k = k%count;
        if (k<0){
            k += count;
        }
        
        int ten=1;
        for(int i=0; i<k; i++){
            ten *= 10;
        }
        
        int temp = n%ten;
        n = n/ten;
        int ans = n + (temp* (int)Math.pow(10,count-k));
        System.out.println(ans);
        
    }
}
