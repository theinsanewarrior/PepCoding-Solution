import java.util.*;
public class busRoutes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
    
        int[][] arr = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          String[] st = br.readLine().split(" ");
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));
    
      }
    
        public static int numBusesToDestination(int[][] routes, int source, int target) {
            HashSet<Integer> busv = new HashSet();
            HashSet<Integer> standv = new HashSet();
    //         hashmap of bus stand vs bus number
            HashMap<Integer, ArrayList<Integer>> hm = new HashMap();
            for(int i=0; i<routes.length; i++){
                for(int j=0; j<routes[i].length; j++){
                    if(hm.containsKey(routes[i][j])){
                        hm.get(routes[i][j]).add(i);
                    }
                    else{
                        hm.put(routes[i][j], new ArrayList());
                        hm.get(routes[i][j]).add(i);
                    }
                }
            }
                
            Queue<Integer> q = new ArrayDeque();
            int bcount = -1;
            q.add(source);
            while(q.size()>0){                                                  
                int size = q.size();
                bcount++;
                while(size-->0){
                    int rem = q.remove();
                    if(!standv.contains(rem)){
                        standv.add(rem);
                        if(rem == target)
                            return bcount;
                        for(int busno : hm.get(rem)){
                            if(!busv.contains(busno)){
                                busv.add(busno);
                                for(int i=0; i<routes[busno].length; i++){
                                    q.add(routes[busno][i]);
                                }
                            }
                        }   
                    }
                }
            }
            return -1;
        }
}
