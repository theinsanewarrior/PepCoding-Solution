// package Basic Data Structures.Stack and Queues;
import java.util.*;
public class SmallerorGreaterElementstoLeftorRight {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int[] ans1 = NextGreaterIndexonRight(arr);
        int[] ans2 = NextGreaterElementonLeft(arr);
        int[] ans3 = NextSmallerElementonRight(arr);
        int[] ans4 = NextSmallerIndexonLeft(arr);

        for(int i=0; i<n; i++){
            System.out.print(ans4[i] + " ");
        }
        System.out.println();
    }

    public static int[] NextGreaterIndexonRight(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack <Integer> stck = new Stack<>();

        stck.push(n-1);
        ans[n-1] = -1;
        for(int i=n-2; i>=0; i--){
            while( stck.size() > 0 && arr[stck.peek()] < arr[i] ){
                stck.pop();
            }
            if(stck.size() == 0 )
                ans[i] = -1;
            else{
                ans[i] = stck.peek();
            }
            stck.push(i);
        }
        return ans;

    }

    public static int[] NextGreaterElementonLeft(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack <Integer> st = new Stack<>();
        st.push(arr[0]);
        ans[0] = -1;
        for(int i=1; i<n; i++){
            while(st.size() > 0 && st.peek()<arr[i] ){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static int[] NextSmallerElementonRight(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack <Integer> stck = new Stack<>();

        stck.push(n-1);
        ans[n-1] = -1;
        for(int i=n-2; i>=0; i--){
            while( stck.size() > 0 && stck.peek() > arr[i] ){
                stck.pop();
            }
            if(stck.size() == 0 )   
                ans[i] = -1;
            else{
                ans[i] = stck.peek();
            }
            stck.push(arr[i]);
        }
        return ans;

    }

    public static int[] NextSmallerIndexonLeft(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack <Integer> stck = new Stack<>();

        stck.push(0);
        ans[0] = -1;
        for(int i=1; i<n; i++){
            while( stck.size() > 0 && arr[stck.peek()] > arr[i] ){
                stck.pop();
            }
            if(stck.size() == 0 )
                ans[i] = -1;
            else{
                ans[i] = stck.peek();
            }
            stck.push(i);
        }
        return ans;

    }

}
