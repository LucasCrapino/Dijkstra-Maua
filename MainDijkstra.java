import java.util.List;

public class MainDijkstra {
    public static void main(String[] args) {
        String[] locations = {"Casa", "Padaria", "Supermercado", "Biblioteca", "Parque", "Laboratório", "Escola", "Hospital", "Farmácia", "Shopping", "Clube", "Estação de Trem", "Restaurante", "Praça", "IMT"};
        Graph graph = new Graph(locations);
    
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 10);
        graph.addEdge(0, 6, 4);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 5, 15);
        graph.addEdge(2, 8, 6);
        graph.addEdge(3, 5, 8);
        graph.addEdge(3, 7, 10);
        graph.addEdge(4, 9, 20);
        graph.addEdge(4, 10, 5);
        graph.addEdge(5, 11, 12);
        graph.addEdge(6, 2, 7);
        graph.addEdge(6, 8, 4);
        graph.addEdge(7, 9, 15);
        graph.addEdge(8, 11, 8);
        graph.addEdge(9, 10, 6);
        graph.addEdge(10, 11, 5);
        graph.addEdge(1, 12, 8);
        graph.addEdge(12, 5, 10);
        graph.addEdge(6, 13, 9);
        graph.addEdge(13, 5, 7);
        graph.addEdge(7, 14, 10);
        graph.addEdge(14, 5, 12);
        graph.addEdge(10, 14, 5);
        graph.addEdge(13, 8, 3);
        graph.addEdge(12, 10, 9);
    
        List<String> shortestPath = graph.findShortestPath(0, 14);
        System.out.println("Caminho mais curto de Casa até o IMT: " + shortestPath);
    }    
}
