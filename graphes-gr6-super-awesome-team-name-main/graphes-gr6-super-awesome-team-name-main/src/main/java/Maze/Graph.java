package Maze;
import java.util.HashSet;

public interface Graph {
    void initialize(int V);
    int V();
    int E();
    void connect(int v1, int v2);
    HashSet<Integer> adj(int v);
    String toString();
}
