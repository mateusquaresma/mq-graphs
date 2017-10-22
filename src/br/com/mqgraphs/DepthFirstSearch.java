package br.com.mqgraphs;

public class DepthFirstSearch {

    private boolean[] marked;

    private int[] order;

    private int count;

    private boolean cycle;

    public DepthFirstSearch(Graph graph, int source) {
        marked = new boolean[graph.V()];
        order = new int[graph.V()];
        dfs(graph, source, source);
    }

    public boolean marked(int vertex) {
        return marked[vertex];
    }

    /**
     * Marca o vértice como visitado no inicio da busca.
     * Equivalente à marcação em cinza vista em aula
     * @param vertex
     * @return A iteração na qual o vertice foi visitado
     */
    public int order(int vertex) {
        return order[vertex];
    }

    public int count() {
        return count;
    }

    /**
     * @return true quando o grafo possui ao menos 1 ciclo
     */
    public boolean hasCycle() {
        return cycle;
    }

    private void dfs(Graph graph, int source, int parent) {
        marked[source] = true;
        order[source] = count++;
        for (Integer vertex : graph.adj(source)) {
            if (!marked[vertex]) {
                dfs(graph, vertex, source);
            } else {
                /*
                    O ciclo é detectado quando existe um vértice adjacente marcado
                    e o mesmo não é o vértice que me trouxe até aqui.

                    Para relembrar, basta desenhar um grafo pequeno com ciclo e fazer o teste de mesa no papel
                 */

                if (vertex != parent)
                    cycle = true;
            }
        }
    }
}
