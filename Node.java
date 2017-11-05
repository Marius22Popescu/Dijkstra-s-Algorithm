import java.util.ArrayList;
//class to create nodes
public class Node {
  private int distanceFromSource = Integer.MAX_VALUE; //assign initial the infinite value 
  private boolean visited;
  private ArrayList<Path> edges = new ArrayList<Path>(); 
  public int getDistanceFromSource() {
    return distanceFromSource;
  }
  public void setDistanceFromSource(int distanceFromSource) {
    this.distanceFromSource = distanceFromSource;
  }
  public boolean isVisited() {
    return visited;
  }
  public void setVisited(boolean visited) {
    this.visited = visited;
  }
  public ArrayList<Path> getEdges() {
    return edges;
  }
  public void setEdges(ArrayList<Path> edges) {
    this.edges = edges;
  }
}
