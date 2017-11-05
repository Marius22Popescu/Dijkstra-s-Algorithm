//This program is displaying the shortest path from the source node to each node from graph 
//to refer to the the problem P3 from chapter 5 the following nodes was renamed to a integer
//x = 0
//y = 1
//z = 2
//t = 3
//u = 4
//v = 5
//w = 6
public class DijkstraAlg {
	public static void main(String[] args) {
	    Path[] path = { 
	    	//the following code is filled with the data from P3/ch5
	      new Path(0, 2, 8), new Path(0, 1, 6), new Path(0, 5, 3), new Path(0, 6, 6),
	      new Path(1, 5, 8), new Path(1, 3, 7), new Path(1, 2, 12), new Path(3, 4, 2), 
	      new Path(3, 5, 4), new Path(4, 5, 3), new Path(4, 6, 3), new Path(5, 6, 4)
	    };
	    Graph MyGraph = new Graph(path); //create new graph
	    MyGraph.calculateShortestDistances();
	    MyGraph.showResult(); 
	  }
}

//Bibliography:
//https://medium.com/@ssaurel/calculate-shortest-paths-in-java-by-implementing-dijkstras
//algorithm-5c1db06b6541
//http://www.baeldung.com/java-dijkstra