package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public static boolean [] visited = new boolean[100];
    public static int [] parent = new int[100];
    public static int acyclic, cc;
   
    public static int bfs(ArrayList<ArrayList<Integer>> adj, int n){
        int i;
        acyclic = 0;
        cc=0;
        for (i=0; i<n; ++i) {
            visited[i]=false;
            parent[i] = -1;
        }
        for (i=0; i<n; ++i) {
            if (!visited[i]) {
                bfs1(adj, i, n);
                ++cc;
            }
        }
        if (acyclic/2 == 1)
            System.out.println("This graph has a Single Simple Cycle");
        return acyclic/2;
    }
   
    public static void bfs1(ArrayList<ArrayList<Integer>> adj, int start, int n){
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(start);
        parent[start] = start;
        visited[start] = true;
       
        while(!Q.isEmpty()) {
            int f = Q.poll();
            int indexF = f;

            List<Integer> adjF = adj.get(indexF);
            for(Iterator<Integer> it = adjF.listIterator(); it.hasNext();) {
                Integer x = it.next();
                if (!visited[x]) {
                    parent[x]=f;
                    visited[x]=true;
                    Q.add(x);
                }
                else if (x!=parent[f])
                    ++ acyclic;
            }
        }
   }
}
