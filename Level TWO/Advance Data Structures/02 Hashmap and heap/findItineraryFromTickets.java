import java.util.*;
public class findItineraryFromTickets {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}
        
		//write your code here
        
        HashMap<String, Boolean> hm = new HashMap();
        for(String src : map.keySet()){
            if(!hm.containsKey(src))
                hm.put(src, true);
            hm.put(map.get(src), false);
        }
        
        String start = "";
        for(String str : hm.keySet()) if(hm.get(str)) start = str;
        
        while(map.containsKey(start)){
            System.out.print(start + " -> ");
            start = map.get(start);
        }
        System.out.println(start + ".");
	}
}
