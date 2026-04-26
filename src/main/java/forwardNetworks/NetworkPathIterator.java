package forwardNetworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public  class NetworkPathIterator implements Iterator<List<Integer>> {

    private final Iterator<List<Integer>> pathIterator;

    public NetworkPathIterator(
            Map<Integer, List<Edge>> graph,
            int sourceRouter,
            int destinationRouter,
            int latencyLimit
    ) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        dfs(graph, sourceRouter, destinationRouter, latencyLimit, 0,
                currentPath, visited, allPaths);

        allPaths.sort((a, b) -> {
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(a.size(), b.size());
        });

        this.pathIterator = allPaths.iterator();
    }

    private void dfs(
            Map<Integer, List<Edge>> graph,
            int current,
            int destination,
            int latencyLimit,
            int currentLatency,
            List<Integer> currentPath,
            Set<Integer> visited,
            List<List<Integer>> allPaths
    ) {
        if (currentLatency > latencyLimit) {
            return;
        }

        currentPath.add(current);
        visited.add(current);

        if (current == destination) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            List<Edge> neighbours = graph.getOrDefault(current, Collections.emptyList());

            for (Edge edge : neighbours) {
                int nextRouter = edge.to;
                int nextLatency = edge.latency;

                if (!visited.contains(nextRouter)) {
                    dfs(graph,
                        nextRouter,
                        destination,
                        latencyLimit,
                        currentLatency + nextLatency,
                        currentPath,
                        visited,
                        allPaths);
                }
            }
        }

        visited.remove(current);
        currentPath.remove(currentPath.size() - 1);
    }

    @Override
    public boolean hasNext() {
        return pathIterator.hasNext();
    }

    @Override
    public List<Integer> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return pathIterator.next();
    }
    
    public static void main(String[] args) {
		Map<Integer, List<Edge>> graph = Map.of(
			1, List.of(new Edge(2, 10), new Edge(3, 15)),
			2, List.of(new Edge(4, 20)),
			3, List.of(new Edge(4, 10)),
			4, List.of()
		);

		NetworkPathIterator iterator = new NetworkPathIterator(graph, 1, 4, 30);

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
