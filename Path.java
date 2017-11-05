public class Path {
  private int Previous;
  private int Next;
  private int length;
  //create the path between two nodes a previous and a next
  public Path(int previous, int Next, int length) {
    this.Previous = previous;  //the previous node
    this.Next = Next;      //the next node
    this.length = length;  //the path length from previous to next nodes
  }
  public int getPrevious() {
    return Previous;
  }
  public int getNext() {
    return Next;
  }
  public int getLength() {
    return length;
  }
  // This method will find the neighboring node of a supplied node
  public int findNeighbour(int n) {
    if (this.Previous == n) {
      return this.Next;
    } else {
      return this.Previous;
   }
  }
}