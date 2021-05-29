import java.util.*;
public class CelebrityProblem {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {   
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }
        while(st.size()>1){
            int x = st.pop();
            int y = st.pop();
            if(arr[x][y] == 0)
                st.push(x);
            else
                st.push(y);
        }
        int idx = st.pop();
        for(int i=0; i<n; i++){
            if(i==idx)
                continue;
            if(arr[i][idx] == 0 || arr[idx][i] == 1){
                System.out.println("none");
                return;
            }
        }
        System.out.println(idx);
    }
}
