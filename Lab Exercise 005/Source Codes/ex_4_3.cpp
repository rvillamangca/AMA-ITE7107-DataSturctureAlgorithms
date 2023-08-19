/* Graph Demo for Exercise 4-3 in C++ by Ramon Villamangca */

#include "graph.h"

void doNothing(Graph G) {}

bool isConnectedBFS(Graph G) {
	G.unVisitAll();
	G.bfs(G.getVertex(0), doNothing);
	G.reverseBfs(G.getVertex(0), doNothing);
	if (G.markedSize() < G.size()) return false;
	return true;
}

bool isConnectedSimple(Graph G) {					// applicable only to singly-directed graph
	int inDegZero = 0;
	for (int i = 0; i < G.size(); i++) {
		if (G.inDegree(G.getVertex(i)) == 0) inDegZero++;
	}
	if (inDegZero > 1) return false;
	return true;
}

int main(int argc, char** argv) {

	cout << endl;
	
	Graph myGraph(5);
	Graph yourGraph(5);
	
	vertex Vs[] = {'A', 'B', 'C', 'D', 'E'};
	
	myGraph.addVertices(5, Vs);
	yourGraph.addVertices(5, Vs);
	
	myGraph.addEdge('A','B');
	myGraph.addEdge('A','C'); myGraph.addEdge('A','D');
	myGraph.addEdge('C','E'); myGraph.addEdge('D','E');

	yourGraph.addEdge('A','C'); yourGraph.addEdge('A','D');
	yourGraph.addEdge('C','E'); yourGraph.addEdge('D','E');

	cout << "\t----- Using BFS Comparison -----\n";
	cout << "\tmyGraph is " << (isConnectedBFS(myGraph) ? "Connected..." : "Not Connected...");
	cout << "\tyourGraph is " << (isConnectedBFS(yourGraph) ? "Connected..." : "Not Connected...");

	cout << endl << endl;
	cout << "\t----- Using Simple Comparison -----\n";
	cout << "\tmyGraph is " << (isConnectedSimple(myGraph) ? "Connected..." : "Not Connected...");
	cout << "\tyourGraph is " << (isConnectedSimple(yourGraph) ? "Connected..." : "Not Connected...");


	cout << endl  << endl;
}