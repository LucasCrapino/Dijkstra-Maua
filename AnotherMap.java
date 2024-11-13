import java.util.List;

public class AnotherMap {
     public static void main(String[] args) {
        String[] locations = {"Casa", "Terminal de ônibus", "Supermercado", "Restaurante", "IMT"};
        Graph graph = new Graph(locations);
    
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 3, 9);
        graph.addEdge(1, 4, 12);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 8);
       
        List<String> shortestPath = graph.findShortestPath(0, 4);
        System.out.println("Caminho mais curto de Casa até o IMT: " + shortestPath);
    }    
}