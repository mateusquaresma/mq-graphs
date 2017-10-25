package br.com.mqgraphs;

public class Main {


    public static void main(String[] args) {

        Graph graph = new Graph(13);


//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(2,3);
//        graph.addEdge(3,1);


        graph.addEdge(4, 3);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        graph.addEdge(6, 7);
        graph.addEdge(8, 10);

        DepthFirstSearch search = new DepthFirstSearch(graph, 0);

        for (int v = 0; v < graph.V(); v++) {
            if (search.marked(v))
                System.out.print(v + " ");
        }

        System.out.println();

        if (search.count() != graph.V())
            System.out.print("NOT ");

        System.out.println("connected");

        System.out.println("Has Cycle = " + search.hasCycle());

        TopologicalSort sort = new TopologicalSort(graph, 0);

        for (Pair pair : sort.items()) {
            System.out.print(pair);
        }

        System.out.println();

        BreadthFirstSearch bsearch = new BreadthFirstSearch(graph, 0);

        for (int v = 0; v < graph.V(); v++) {
            if (bsearch.marked(v))
                System.out.print(v + " ");
        }





    }

}
