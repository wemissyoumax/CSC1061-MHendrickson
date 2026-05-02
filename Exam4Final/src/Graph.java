
public class Graph {

    private boolean[][] adjMatrix;  // adjMatrix[i][j] = true means edge from i to j
    private String[] labels;        // labels[i] = name of node i
    private int nodeCount;          // current number of nodes added
    private int capacity;           // maximum number of nodes

    public Graph(int maxNodes) {
        capacity = maxNodes;
        nodeCount = 0;
        adjMatrix = new boolean[maxNodes][maxNodes];
        labels = new String[maxNodes];
    }
// addNode to graph
    public int addNode(String label) {
        if (nodeCount >= capacity) {
            return -1;
        }
        labels[nodeCount] = label;
        return nodeCount++;
    }
// get index from labels' array
    public int getIndex(String label) {
        for (int i = 0; i < nodeCount; i++) {
            if (labels[i].equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public String getLabel(int index) {
        return labels[index];
    }

    public void addEdge(int from, int to) {
        adjMatrix[from][to] = true;
    }

    public void removeEdge(int from, int to) {
        adjMatrix[from][to] = false;
    }

    public boolean hasEdge(int from, int to) {
        return adjMatrix[from][to];
    }

    public int inDegree(int node) {
        int count = 0;
        for (int i = 0; i < nodeCount; i++) {
            if (adjMatrix[i][node]) {
                count++;
            }
        }
        return count;
    }

    public int getNodeCount() {
        return nodeCount;
    }

// store and modify hasEdges in an array
    public boolean hasEdges() {
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
            	//if i and j are seen in the adjMatrix:
                if (adjMatrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
