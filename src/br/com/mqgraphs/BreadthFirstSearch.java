package br.com.mqgraphs;

import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearch {

    private boolean[] marked;

    private int[] order;

    private int[] parent;

    private Queue<Integer> queue;

    private boolean cycle;

    public BreadthFirstSearch(Graph graph, int source) {

        marked = new boolean[graph.V()];

        queue = new PriorityQueue<>();

        order = new int[graph.V()];

        parent = new int[graph.V()];
        for (int i = 0; i < parent.length; i++) parent[i] = -1;

        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
        int count = 0;

        queue.offer(source);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            marked[vertex] = true;
            order[vertex] = count++;

            for (Integer a : graph.adj(vertex)) {

                if (!marked[a]){
                    parent[a] = vertex;
                    queue.offer(a);
                }


                // Aplico a mesma técnica da busca em profundidade para detectar o ciclo
                cycle = marked[a] && parent[vertex] != a;
            }
        }


    }

    public boolean marked(int vertex) {
        return marked[vertex];
    }

    public int order(int vertex) {
        return order[vertex];
    }

    public boolean hasCycle() {
        return cycle;
    }
}
