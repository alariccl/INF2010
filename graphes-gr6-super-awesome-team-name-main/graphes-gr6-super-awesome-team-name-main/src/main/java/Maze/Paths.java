package Maze;
import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Paths {

    boolean[] dfsMarked, bfsMarked;
    int [] dfsParent, bfsParent;
    int s;

    public Paths(Graph G, int s) {
        if (G == null || s < 0 || s >= G.V()) {
            throw new InvalidParameterException();
        }
        this.s = s;

    bfsMarked = new boolean[G.V()];
    bfsParent = new int[G.V()];
    bfs(G,s);

    dfsMarked = new boolean[G.V()];
    dfsParent = new int[G.V()];
    dfs(G,s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(s); bfsMarked[s] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v)) {
                if (!bfsMarked[w]) {
                    bfsMarked[w] = true;
                    bfsParent[w] = v;
                    q.add(w);
                }
            }
        }
    }

    public Stack<Integer> bfsPathTo(int v) {
        if (!bfsMarked[v]) return null;

        Stack<Integer> path = new Stack<Integer>();

        for (int x = v; x != s; x = bfsParent[x])
            path.push(x);
        path.push(s);

        return path;
    }

    private void dfs(Graph G, int v) {
        dfsMarked[v] = true;

        for (int w : G.adj(v)) {
            if (!dfsMarked[w]) {
                dfs(G, w);
                dfsParent[w] = v;
            }
        }
    }

    public Stack<Integer> dfsPathTo(int v) {
        if (!dfsMarked[v]) return null;

        Stack<Integer> path = new Stack<Integer>();

        for (int x = v; x != s; x = dfsParent[x])
            path.push(x);
        path.push(s);

        return path;
    }
}
