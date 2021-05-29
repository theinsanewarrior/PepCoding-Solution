public class SlidingWindowMaximum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
    
        // code
        slidingWindow(a, k);
        
     }
     
    public static int[] nextGreaterIndex(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(arr.length-1);
        for(int i=arr.length-2; i>=0; i--){
            while(st.size()>0 && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.size()==0)
                ans[i] = arr.length;
            else
                ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public static void slidingWindow(int[] arr, int k){
        int[] ngi = nextGreaterIndex(arr);
        int i=0, j=0;
        for(i=0; i<=arr.length-k; i++){
            j = i;
            while(ngi[j] < i+k){
                j = ngi[j];
            }
            System.out.println(arr[j]);
        }
    }
}
