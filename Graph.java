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
        adjMatrix[source][destination] = weight;
        adjMatrix[destination][source] = weight;
    }

    public int[] dijkstra(int start) {
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
                }
            }
        }
        return distances;
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
        int[] distances = dijkstra(start);
        List<String> path = new ArrayList<>();

        if (distances[end] == Integer.MAX_VALUE) return path;

        int current = end;
        path.add(locations[current]);

        while (current != start) {
            for (int i = 0; i < numLocations; i++) {
                if (adjMatrix[i][current] != Integer.MAX_VALUE && distances[current] - adjMatrix[i][current] == distances[i]) {
                    path.add(locations[i]);
                    current = i;
                    break;
                }
            }
        }

        Collections.reverse(path);
        return path;
    }
}
