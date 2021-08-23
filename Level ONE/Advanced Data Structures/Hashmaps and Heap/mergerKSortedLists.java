import java.util.*;
public class mergerKSortedLists {
    public static class pair implements Comparable<pair>{
        int li;
        int idx;
        int val;
        
        pair(int li, int idx, int val){
            this.li = li;
            this.idx = idx;
            this.val = val;
        }
        
        public int compareTo(pair o){
            return this.val-o.val;
        }
    }
    
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        // write your code here
        PriorityQueue<pair> pq = new PriorityQueue();
        for(int i=0; i<lists.size(); i++) pq.add(new pair(i, 0, lists.get(i).get(0)));
        
        while(pq.size()>0){
            pair rem = pq.remove();
            rv.add(rem.val);
            if(lists.get(rem.li).size() > rem.idx+1) pq.add(new pair(rem.li, rem.idx+1, lists.get(rem.li).get(rem.idx+1)));
        }
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(elements[j]));
            }
            lists.add(list);
        }
        
        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
