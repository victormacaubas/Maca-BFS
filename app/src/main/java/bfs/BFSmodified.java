
package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSmodified {

    private static final int WHITE = -1;
    private static final int GRAY = 0;
    private static final int BLACK = 1;

    public Integer[] pred;
    public int[] color;
    public int[] level;
    private Queue<Integer> queue;
    private LinkedList<LinkedList<Integer>> graph;

    public BFSmodified(LinkedList<LinkedList<Integer>> graph) {
        this.graph = graph;
        int graphSize = graph.size();
        this.color = new int[graphSize];
        this.level = new int[graphSize];
        this.pred = new Integer[graphSize];
        this.queue = new LinkedList<>();
    }

    public void printShortestDistance(int source, int dest) {

        if (BFS_startShortest(source, dest) == false) {
            System.out.println("Given source and destination are not connected");

            return;
        }

        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);

        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        System.out.println("Shortest path length is: " + level[dest]);

        // Print path
        System.out.println("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }

    }

    public boolean BFS_startShortest(int source, int dest) {

        for (int u = 0; u < graph.size(); u++) {
            color[u] = WHITE;
            level[u] = Integer.MAX_VALUE;
            pred[u] = -1;

        }

        color[source] = GRAY;
        level[source] = 0;
        queue.add(source);

        while (queue.size() != 0) {
            int u = queue.poll();

            for (Integer v : graph.get(u)) {
                if (color[v] == WHITE) {
                    color[v] = GRAY;
                    level[v] = level[u] + 1;
                    pred[v] = u;
                    queue.add(v);

                    if (v == dest) {
                        color[u] = BLACK;
                        return true;
                    }
                }
            }

            color[u] = BLACK;

        }

        return false;

    }

}
