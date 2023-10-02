package bfs;

import java.util.LinkedList;

public class App {

    public static void main(String[] args) {

        LinkedList<LinkedList<Integer>> grafo;
        int tamanho_grafo = 8;

        grafo = new LinkedList<>();
        for (int i = 0; i < tamanho_grafo; i++) {
            grafo.add(new LinkedList<Integer>());
        }

        grafo.get(0).add(1);
        grafo.get(0).add(3);

        grafo.get(1).add(2);

        grafo.get(3).add(4);
        grafo.get(3).add(7);

        grafo.get(4).add(5);
        grafo.get(4).add(6);
        grafo.get(4).add(7);

        grafo.get(5).add(6);

        grafo.get(6).add(7);

        BFSmodified s = new BFSmodified(grafo);
        int source = 0;
        int dest = 7;
        
        s.printShortestDistance(source, dest);
    }
    
}
