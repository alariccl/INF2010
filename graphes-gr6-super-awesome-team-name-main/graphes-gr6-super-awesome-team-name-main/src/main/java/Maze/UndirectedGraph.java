package Maze;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.ArrayList;

public class UndirectedGraph implements Graph {

    private HashSet<Integer>[] neighbors;
    private int V, E;
    private int source, end;

    public UndirectedGraph(int V) {
        initialize(V);
    }

    public UndirectedGraph(ArrayList<ArrayList<Tile>> maze) {
        int rows = maze.size();
        int cols = maze.get(0).size();
        initialize(rows * cols);

        source = -1;
        end = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze.get(i).get(j) != Tile.Wall) {
                    int current = i * cols + j;
                    if (i > 0 && maze.get(i - 1).get(j) != Tile.Wall) {
                        connect(current, (i - 1) * cols + j);
                    }
                    if (i < rows - 1 && maze.get(i + 1).get(j) != Tile.Wall) {
                        connect(current, (i + 1) * cols + j);
                    }
                    if (j > 0 && maze.get(i).get(j - 1) != Tile.Wall) {
                        connect(current, i * cols + (j - 1));
                    }
                    if (j < cols - 1 && maze.get(i).get(j + 1) != Tile.Wall) {
                        connect(current, i * cols + (j + 1));
                    }

                    if (maze.get(i).get(j) == Tile.Exit) {
                        if (source == -1) {
                            source = current;
                        } else {
                            end = current;
                        }
                    }
                }
            }
        }
    }

    public void initialize(int V) {
        if (V < 0) throw new InvalidParameterException();
        E = 0;
        this.V = V;
        neighbors = new HashSet[V];
        for (int v = 0; v < V; v++) {
            neighbors[v] = new HashSet<>();
        }
    }

    public int V() { return V; }
    public int E() { return E; }
    public int source() { return source; }
    public int end() { return end; }

    public void connect(int v1, int v2) {
        if (v1 < 0 || v1 >= V) return;
        if (v2 < 0 || v2 >= V) return;
        if (neighbors[v1].contains(v2)) return;
        neighbors[v1].add(v2);
        neighbors[v2].add(v1);
        E++;
    }

    public HashSet<Integer> adj(int v) {
        if (v < 0 || v >= V) return null;
        return neighbors[v];
    }

    public String toString() {
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(V).append(ln).append(E).append(ln);
        for (int v = 0; v < V; v++) {
            for (int w : neighbors[v]) {
                o.append(v).append("-").append(w).append(ln);
            }
        }
        return o.toString();
    }
}