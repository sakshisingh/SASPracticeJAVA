package DataStructures;

import java.util.ArrayList;

public class Graph {

	/*
	 * A graph is a list of graph nodes
	 * Each node in a graph has some data value and a list of its neighbors known as adjacency list
	 */
	ArrayList<GraphNode> nodes;
	
	public Graph() {
		nodes = new ArrayList<>();
	}
	
	public Graph(GraphNode node) {
		nodes.add(node);
	}
	
	public Graph(ArrayList<GraphNode> nodes) {
		nodes.addAll(nodes);
	}
	
	public void addNode(GraphNode node) {
		nodes.add(node);
	}
	
	public void addNode(int data, ArrayList<GraphNode> neighbors) {
		GraphNode node = new GraphNode(data, neighbors);
		nodes.add(node);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
