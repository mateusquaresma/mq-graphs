package br.com.mqgraphs;

import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearch {

    private boolean[] marked;

    private Queue<Integer> queue;

    public BreadthFirstSearch(Graph graph, int source) {

        marked = new boolean[graph.V()];

        queue = new PriorityQueue<>();

        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {

        queue.offer(source);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            marked[vertex] = true;
            for (Integer a : graph.adj(vertex))
                if (!marked[a]) queue.offer(a);


        }


    }

    public boolean marked(int vertex){
        return marked[vertex];
    }
}
