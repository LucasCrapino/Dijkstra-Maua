import java.util.List;

public class MainDijkstra {
    public static void main(String[] args) {
        String[] locations = {"Casa", "Padaria", "Supermercado", "Biblioteca", "Parque", "IMT"};
        Graph graph = new Graph(locations);

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 10);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 6);
        graph.addEdge(3, 5, 8);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 15);

        List<String> shortestPath = graph.findShortestPath(0, 5);
        System.out.println("Caminho mais curto de Casa até a Mauá: " + shortestPath);
    }
}
