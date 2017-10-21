package br.com.mqgraphs;

import java.util.*;

public class TopologicalSort {

    private List<Pair> items;

    public TopologicalSort(Graph graph, int source) {
        DepthFirstSearch search = new DepthFirstSearch(graph, source);

        items = new ArrayList<>();

        for (int v = 0; v < graph.V(); v++)
            items.add(new Pair(v, search.order(v)));

        Collections.sort(items, Comparator.comparing(Pair::getValue));
    }

    public List<Pair> items() {
        return items;
    }
}
