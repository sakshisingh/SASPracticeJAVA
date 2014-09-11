package DataStructures;

import java.util.ArrayList;

public class GraphNode {
	private int data;
	private ArrayList<GraphNode> adjList;
	public GraphNode() {
		data = (Integer) null;
		adjList = new ArrayList<>();
	}
	
	public GraphNode(int data) {
		this.data = data;
	}

	public GraphNode(int data, ArrayList<GraphNode> neighbors) {
		data = (Integer) null;
		adjList = neighbors;
	}
	
	public int getData() {
		return data;
	}
	
	public ArrayList<GraphNode> getNeighbors() {
		return adjList;
	}
	
	public ArrayList<GraphNode> getAdjList() {
		return adjList;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNeighbors(ArrayList<GraphNode> neighbors) {
		adjList = neighbors;
	}
	
	public void setAdjList(ArrayList<GraphNode> neighbors) {
		adjList = neighbors;
	}
	
	public void addNeighbor(GraphNode neighbor) {
		adjList.add(neighbor);
	}
	
	public void addNeighbors(ArrayList<GraphNode> neighbors) {
		adjList.addAll(neighbors);
	}
}
