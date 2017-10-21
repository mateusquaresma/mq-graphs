package br.com.mqgraphs;

import java.util.LinkedList;

public class Graph {


    private final int V; // número de vértices

    private int E; // Número de arestas

    /*
      lista de adjacencia de todos os vértices do grafo

      NT: A representação de um array de listas é um pouco confusa, mas a implementação é mais clara quando comparada a um ArrayList
     */
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = V + " vértices, " + E + " arestas\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }

}
