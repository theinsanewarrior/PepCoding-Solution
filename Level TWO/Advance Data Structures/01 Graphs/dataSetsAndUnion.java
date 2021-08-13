import java.util.*;
public class dataSetsAndUnion {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args){
        int[][]relations = {{1,3},{3,2},{5,9},{6,3},{10,5},{7,5},{8,2},{5,2}};

        parent = new int[11];
        rank = new int[11];

        for(int i=1; i<parent.length; i++){
            parent[i] = i;
        }

        for(int i=0; i<relations.length; i++){
            union(relations[i][0], relations[i][1]);
        }

        for(int i=1; i<parent.length; i++) find(i); // path compression

        int comps = 0;
        for(int i=1; i<parent.length; i++) if(parent[i] == i) comps++;
        System.out.println(comps);
    }

    public static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        // union by rank
        if(px!=py){
            if(rank[px] > rank[py])
                parent[py] = px;
            else if(rank[py] > rank[px])
                parent[px] = py;
            else{
                parent[px] = py;
                rank[py]++;
            }
        }
    }

    public static int find(int x){
        if(parent[x] == x)
            return x;
        
        int px = find(parent[x]);

        // path compression 
        parent[x] = px;
        return px;
    }

}
