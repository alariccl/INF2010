package Maze;

import java.util.*;
import java.util.stream.Collectors;

import Maze.Graph;

public class Maze {
    /** TODO
     * Returns the distance of the shortest path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the shortest path within the maze, null if not solvable
     */

    public static Integer findShortestPath(ArrayList<ArrayList<Tile>> maze) {
        if (maze.isEmpty()) return null;

        UndirectedGraph graph = new UndirectedGraph(maze);

        if (graph.source() == -1 || graph.end() == -1) {
            return null;
        }

        Paths paths = new Paths(graph, graph.source());
        Stack<Integer> path = paths.bfsPathTo(graph.end());

        if (path == null) {
            return null;
        }

        return path.size() - 1;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}

