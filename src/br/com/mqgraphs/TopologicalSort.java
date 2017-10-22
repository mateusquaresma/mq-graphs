package br.com.mqgraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Não faz sentido realizar uma ordenação topológica em um grafo não-direcionado
 *
 * O algoritmo é possível, mas a relação de dependência que define a topologia não fica clara
 *
 * FIXME Implementar o grafo direcionado e corrigir este algoritmo, que deve aceitar apenas grafos direcionados.
 */
public class TopologicalSort {

    private List<Pair> items;

    public TopologicalSort(Graph graph, int source) {
        DepthFirstSearch search = new DepthFirstSearch(graph, source);

        items = new ArrayList<>();

        for (int v = 0; v < graph.V(); v++)
            items.add(new Pair(v, search.order(v)));

        /*
            FIXME
            Esta ordenação custa nlogn e foi pedido custo linear
         */

        Collections.sort(items, Comparator.comparing(Pair::getValue));
    }

    public List<Pair> items() {
        return items;
    }
}
