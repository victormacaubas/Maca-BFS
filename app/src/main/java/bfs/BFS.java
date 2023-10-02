
package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private static final int WHITE = -1;
    private static final int GRAY = 0;
    private static final int BLACK = 1;

    public Integer[] before;
    public int[] color;
    public int[] level;
    private Queue<Integer> queue;
    private LinkedList<LinkedList<Integer>> graph;

    public BFS(LinkedList<LinkedList<Integer>> graph) {
        this.graph = graph;
        int graphSize = graph.size();
        this.color = new int[graphSize];
        this.level = new int[graphSize];
        this.before = new Integer[graphSize];
        this.queue = new LinkedList<>();
    }

    public void BFS_start(int s) {

        for (int u = 0; u < graph.size(); u++) {
            color[u] = WHITE;
            level[u] = -1;
            before[u] = null;

        }

        color[s] = GRAY;
        level[s] = 0;
        queue.add(s);

        while (queue.size() != 0) {
            int u = queue.poll();

            for (Integer v : graph.get(u)) {
                if (color[v] == WHITE) {
                    color[v] = GRAY;
                    level[v] = level[u] + 1;
                    before[v] = u;
                    queue.add(v);
                }
            }

            color[u] = BLACK;

        }

    }

    public int[] getColor() {
        return color;
    }

    public static int getBlack() {
        return BLACK;
    }

    public int getWhite() {
        return WHITE;
    }

    public int getGray() {
        return GRAY;
    }

    public int[] getLevel() {
        return level;
    }

    public Integer[] getBefore() {
        return before;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

}
