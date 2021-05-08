public class LargestAreaHistogram {
    public static int lah(int[] arr){
        int[] left = nsol(arr);
        int[] right = nsor(arr);
        
        int area = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int val = (right[i] - left[i] - 1)*arr[i];
            if(val > area)
                area = val;
        }
        return area;
    }
    
    public static int[] nsol(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(0);
        ans[0] = -1;
        for(int i=1; i<arr.length; i++){
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.size() == 0)
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public static int[] nsor(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = arr.length;
        st.push(arr.length-1);
        for(int i=arr.length-2; i>=0; i--){
            while(st.size()>0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.size() == 0)
                ans[i] = arr.length;
            else
                ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // code
    System.out.println(lah(a));
 }
}
