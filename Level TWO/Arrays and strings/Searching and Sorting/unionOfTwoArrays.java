import java.util.*;
import java.io.*;
public class unionOfTwoArrays {
    public static ArrayList<Integer> union(int[] a,int[] b) {
        //write your code here
        ArrayList<Integer> arr = new ArrayList();
        int p1=0, p2=0;
        while(p1<a.length && p2<b.length){
            if(arr.size()>0){
                while(p1<a.length && a[p1]==arr.get(arr.size()-1)) p1++;
                while(p2<b.length && b[p2]==arr.get(arr.size()-1)) p2++;
            }
            if(a[p1] == b[p2]){
                arr.add(a[p1]);
                p1++;
                p2++;
            }
            else if(a[p1] > b[p2]){
                arr.add(b[p2]);
                p2++;
            }
            else{
                arr.add(a[p1]);
                p1++;
            }
        }
        
        while(p1<a.length){
            if(a[p1]!=arr.get(arr.size()-1)){
                arr.add(a[p1]);
                p1++;
            }
            else p1++;
        }
        
        while(p2<b.length){
            if(b[p2]!=arr.get(arr.size()-1)){
                arr.add(b[p2]);
                p2++;
            }
            else p2++;
        }
        return arr;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i < n;i++) {
            a[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]b = new int[m];
        for(int i=0;i < m;i++) {
            b[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = union(a,b);

        //print answer list
        for(int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
