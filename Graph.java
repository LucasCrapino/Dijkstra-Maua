import java.util.*;

public class Graph {
    private final int[][] adjMatrix;
    private final String[] locations;
    private final int numLocations;

    public Graph(String[] locations) {
        this.numLocations = locations.length;
        this.locations = locations;
        this.adjMatrix = new int[numLocations][numLocations];
        
        for (int i = 0; i < numLocations; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }
    }

    public void addEdge(int source, int destination, int weight) {
        if (source >= 0 && source < numLocations && destination >= 0 && destination < numLocations) {
            adjMatrix[source][destination] = weight;
            adjMatrix[destination][source] = weight;
        } else {
            System.out.println("Erro: Índice de localização inválido.");
        }
    }

    private void dijkstra(int start, int[] predecessors) {
        int[] distances = new int[numLocations];
        boolean[] visited = new boolean[numLocations];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < numLocations - 1; i++) {
            int u = minDistance(distances, visited);
            visited[u] = true;

            for (int v = 0; v < numLocations; v++) {
                if (!visited[v] && adjMatrix[u][v] != Integer.MAX_VALUE && distances[u] != Integer.MAX_VALUE &&
                    distances[u] + adjMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjMatrix[u][v];
                    predecessors[v] = u;
                }
            }
        }
    }

    private int minDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numLocations; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public List<String> findShortestPath(int start, int end) {
        if (start < 0 || start >= numLocations || end < 0 || end >= numLocations) {
            System.out.println("Erro: Índice de localização inválido.");
            return Collections.emptyList();
        }

        int[] predecessors = new int[numLocations];
        Arrays.fill(predecessors, -1);
        dijkstra(start, predecessors);
        
        List<String> path = new ArrayList<>();
        for (int at = end; at != -1; at = predecessors[at]) {
            path.add(locations[at]);
        }

        Collections.reverse(path);
        return path.get(0).equals(locations[start]) ? path : Collections.emptyList();
    }
}
