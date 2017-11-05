import java.util.ArrayList;

public class Graph {
  private Node[] N;
  private Path[] P;
  private int Nodes; //will keep count of number of nodes
  private int noOfEdges;
  //the constructor that will create the graph
  public Graph(Path[] edges) {
    this.P = edges;
    // This will create the nodes. 
    this.Nodes = calculateNoOfNodes(edges);
    this.N = new Node[this.Nodes];
    for (int n = 0; n < this.Nodes; n++) {
      this.N[n] = new Node();
    }
    // adding edges to nodes
    this.noOfEdges = edges.length;
    for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
      this.N[edges[edgeToAdd].getPrevious()].getEdges().add(edges[edgeToAdd]);
      this.N[edges[edgeToAdd].getNext()].getEdges().add(edges[edgeToAdd]);
    }
  }
  //This method will calculate the calculate the number o nodes from the edges passed
  //as parameters. It returns a integer: the number of nodes. 
  private int calculateNoOfNodes(Path[] edges) {
    int noOfNodes = 0;
    for (Path e : edges) {
      if (e.getNext() > noOfNodes)
        noOfNodes = e.getNext();
      if (e.getPrevious() > noOfNodes)
        noOfNodes = e.getPrevious();
    }
    noOfNodes++;
    return noOfNodes;
  }
  
  public void calculateShortestDistances() {
    // node 0 as source
    this.N[0].setDistanceFromSource(0);
    int nextNode = 0;
    // visit every node
    for (int i = 0; i < this.N.length; i++) {
      // loop around the edges of current node
      ArrayList<Path> currentNodeEdges = this.N[nextNode].getEdges();
      for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
        int neighbourIndex = currentNodeEdges.get(joinedEdge).findNeighbour(nextNode);
        // only if not visited
        if (!this.N[neighbourIndex].isVisited()) {
          int tentative = this.N[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();
          if (tentative < N[neighbourIndex].getDistanceFromSource()) {
            N[neighbourIndex].setDistanceFromSource(tentative);
          }
        }
      }
      // all neighbours checked so node visited
      N[nextNode].setVisited(true);
      // next node must be with shortest distance
      nextNode = getNodeShortestDistanced();
   }
  }

  private int getNodeShortestDistanced() {
    int storedNodeIndex = 0;
    int storedDist = Integer.MAX_VALUE;
    for (int i = 0; i < this.N.length; i++) {
      int currentDist = this.N[i].getDistanceFromSource();
      if (!this.N[i].isVisited() && currentDist < storedDist) {
        storedDist = currentDist;
        storedNodeIndex = i;
      }
    }
    return storedNodeIndex;
  }
  // display result
  public void showResult() {
	  String output = "";  
    for (int i = 0; i < this.N.length; i++) {
    output += ("\nThe shortest distance from source node to node " + i + " is " + N[i].getDistanceFromSource());
    }
    System.out.println(output);
  }
  public Node[] getNodes() {
    return N;
  }
  public int getNoOfNodes() {
    return Nodes;
  }
  public Path[] getEdges() {
    return P;
  }
  public int getNoOfEdges() {
    return noOfEdges;
  }
}