package br.com.mqgraphs;

public class DepthFirstSearch {

    private boolean[] marked;

    private int[] order;

    private int iteration;

    private int count;

    public DepthFirstSearch(Graph graph, int source) {
        marked = new boolean[graph.V()];
        order = new int[graph.V()];
        dfs(graph, source);
    }

    public boolean marked(int vertex){
        return marked[vertex];
    }

    public int order(int vertex) {
        return order[vertex];
    }

    public int count(){
        return count;
    }

    private void dfs(Graph graph, int source) {
        marked[source] = true;
        order[source] = iteration++;
        count++;
        for (Integer vertex : graph.adj(source)) {
            if (!marked[vertex]) dfs(graph, vertex);
        }
    }


}
