import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjList = new HashMap<>();
    
    public void addEdge(String source, String destination, int weight) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(new Edge(destination, weight));
        adjList.get(destination).add(new Edge(source, weight));
    }

    public Map<String,Integer> dijkstra(String start){
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        for(String vertex : adjList.keySet()){
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(start,0);

        minHeap.add(new Edge(start,0));

        while(!minHeap.isEmpty()){
            Edge current = minHeap.poll();
            String u = current.destination;

            for(Edge edge : adjList.get(u)){
                String v = edge.destination;
                int newDist = distances.get(u) + edge.weight;

                if (newDist < distances.get(v)) {
                    distances.put(v, newDist);
                    minHeap.add(new Edge(v, newDist));
                }
            }
        }

        return distances;
    }
}
