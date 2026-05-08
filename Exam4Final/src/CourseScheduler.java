
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;

	public class CourseScheduler {

	    private static ArrayList<String> topologicalSort(Graph graph) {
	        int n = graph.getNodeCount();
	        ArrayList<String> ordering = new ArrayList<>();

	        // Count in-degrees for all nodes
	        int[] inDegree = new int[n];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (graph.hasEdge(i, j)) {
	                    inDegree[j]++;
	                }
	            }
	        }

	        // Initialize the active set with nodes
	        Queue<Integer> activeSet = new LinkedList<>();
	        for (int i = 0; i < n; i++) {
	            if (inDegree[i] == 0) {
	                activeSet.add(i);
	            }
	        }

	        // Process nodes: move from active set to ordered
	        while (!activeSet.isEmpty()) {
	            int node = activeSet.poll();
	            ordering.add(graph.getLabel(node));

	            // Remove all edges going out of this node
	            for (int neighbor = 0; neighbor < n; neighbor++) {
	                if (graph.hasEdge(node, neighbor)) {
	                    graph.removeEdge(node, neighbor);
	                    inDegree[neighbor]--;

	                    // If neighbor now has no remaining prereqs, add it
	                    if (inDegree[neighbor] == 0) {
	                        activeSet.add(neighbor);
	                    }
	                }
	            }
	        }

	        // If edges remain, there was a cycle — no valid ordering exists
	        if (graph.hasEdges()) {
	            return null;
	        }

	        return ordering;
	    }

	    private static void addNodes(String filename, Graph graph)
	            throws FileNotFoundException {
	        Scanner scanner = new Scanner(new File(filename));
	        int numCourses = scanner.nextInt();

	        for (int i = 0; i < numCourses; i++) {
	            String courseName = scanner.next();
	            graph.addNode(courseName);

	            // Skip over the prereq count and prereq names
	            int numPrereqs = scanner.nextInt();
	            for (int j = 0; j < numPrereqs; j++) {
	                scanner.next(); // discard prereq on this pass
	            }
	        }

	        scanner.close();
	    }

	    private static void addEdges(String filename, Graph graph)
	            throws FileNotFoundException {
	        Scanner scanner = new Scanner(new File(filename));
	        int numCourses = scanner.nextInt();

	        for (int i = 0; i < numCourses; i++) {
	            String courseName = scanner.next();
	            int courseIndex = graph.getIndex(courseName);

	            int numPrereqs = scanner.nextInt();
	            for (int j = 0; j < numPrereqs; j++) {
	                String prereqName = scanner.next();
	                int prereqIndex = graph.getIndex(prereqName);

	                // Edge goes from prerequisite → course
	                if (prereqIndex >= 0 && courseIndex >= 0) {
	                    graph.addEdge(prereqIndex, courseIndex);
	                }
	            }
	        }

	        scanner.close();
	    }

	    public static void main(String[] args) {
	        // Validate command-line arguments
	        if (args.length != 1) {
	            System.out.println("Usage: java CourseScheduler <inputfile>");
	            return;
	        }

	        String filename = args[0];

	        // Read the number of courses to size the graph
	        int numCourses;
	        try {
	            Scanner countScanner = new Scanner(new File(filename));
	            numCourses = countScanner.nextInt();
	            countScanner.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Error: File '" + filename + "' not found.");
	            return;
	        }

	        // Build the graph with two passes over the file
	        Graph graph = new Graph(numCourses);

	        try {
	            addNodes(filename, graph);  // Pass 1: add all nodes
	            addEdges(filename, graph);  // Pass 2: add all edges
	        } catch (FileNotFoundException e) {
	            System.out.println("Error: File '" + filename + "' not found.");
	            return;
	        }

	        // Run sort and print results
	        ArrayList<String> ordering = topologicalSort(graph);

	        if (ordering == null) {
	            System.out.println("These courses cannot be completed due to a cycle in prerequisites.");
	        } else {
	            System.out.println("A valid course ordering:");
	            for (String course : ordering) {
	                System.out.println("  " + course);
	            }
	        }
	    }
	}
