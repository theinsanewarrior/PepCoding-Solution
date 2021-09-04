import java.util.*;
public class numberOfEmployeesUnderManagers {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        char ceo = '0';
        HashMap<Character, ArrayList<Character>> hm = new HashMap();
        for(int i=0; i<n; i++){
            char emp = scn.next().charAt(0);
            char man = scn.next().charAt(0);
            if(emp == man){
                ceo = man;
                if(!hm.containsKey(emp)) hm.put(emp, new ArrayList());
                continue;
            }
            if(hm.containsKey(man)){
                hm.get(man).add(emp);
            }else{
                hm.put(man, new ArrayList());
                hm.get(man).add(emp);
            }
            
            if(!hm.containsKey(emp)) hm.put(emp, new ArrayList());
        }
        
        HashMap<Character, Integer> ans = new HashMap();
        
        size(ceo, hm, ans);
        for(char curr : ans.keySet()) System.out.println(curr + " " + ans.get(curr));
        
    }
    
    public static int size(char emp, HashMap<Character, ArrayList<Character>> hm, HashMap<Character, Integer> ans){
        int val = 0;
        for(char ch : hm.get(emp)){
            val += size(ch, hm, ans);
        }
        ans.put(emp, val);
        return val+1;
    }
}
