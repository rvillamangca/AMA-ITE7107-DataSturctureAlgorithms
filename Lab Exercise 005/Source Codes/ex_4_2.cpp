/* Graph Demo for Exercise 4-2 in C++ by Ramon Villamangca */

#include "graph.h"

void doNothing(Graph G) {}

void printVisited(Graph G) {
	cout << G.lastVisited() << " ";
}

void topNum(Graph G, vertex V) {
	G.bfs(V, printVisited);
}

void topOrderAll(Graph G) {
	for (int i = 0; i < G.size(); i++) {
		G.bfs(G.getVertex(i), doNothing);
	}
	G.printVisited();
}

int main(int argc, char** argv) {

	cout << endl;
	
	Graph myGraph(5);
	
	vertex Vs[] = {'A', 'B', 'C', 'D', 'E'};
	
	myGraph.addVertices(5, Vs);
	
	//myGraph.addEdge('A','B'); 						// disconnect vertex 'B'
	myGraph.addEdge('A','C'); myGraph.addEdge('A','D');
	myGraph.addEdge('C','E'); myGraph.addEdge('D','E');


	cout << "  Calling topNum after disconnecting vertex 'B':\t";
	topNum(myGraph, 'A');

	cout << "\n\n  Calling topOrdellAll function:\t\t\t";
	myGraph.unVisitAll();
	topOrderAll(myGraph);
	
	cout << endl  << endl;
}