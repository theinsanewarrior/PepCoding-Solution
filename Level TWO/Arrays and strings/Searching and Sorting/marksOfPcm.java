import java.util.*;
import java.io.*;
public class marksOfPcm {
    public static class marks implements Comparable<marks>{
        int p;
        int c;
        int m;
        
        marks(int p, int c, int m){
            this.p = p;
            this.c = c;
            this.m = m;
        }
        
        public int compareTo(marks o){
            if(this.p != o.p) return this.p-o.p;
            else{
                if(this.c != o.c) return o.c-this.c;
                else return this.m-o.m;
            }
        }
    }
    public static void customSort(int[]phy,int[]chem,int[]math) {
        //write your code here
        int n = phy.length;
        marks[] mark = new marks[n];
        for(int i=0; i<n; i++){
            mark[i] = new marks(phy[i], chem[i], math[i]);
        }
        Arrays.sort(mark);
        for(int i=0; i<n; i++){
            phy[i] = mark[i].p;
            chem[i] = mark[i].c;
            math[i] = mark[i].m;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math);

        //output
        for(int i=0; i < N;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}
