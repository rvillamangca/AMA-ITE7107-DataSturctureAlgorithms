/* Graph Demo for Exercise 3 in C++ by Ramon Villamangca */

#include "graph.h"

void printVisited(Graph G) {
	cout << G.lastVisited() << " ";
}

int main(int argc, char** argv) {
	
	Graph myGraph(5);
	
	vertex Vs[] = {'0', '1', '2', '3', '4'};
	
	myGraph.addVertices(5, Vs);
	
	
	myGraph.addEdge('0','2'); myGraph.addEdge('2','3'); myGraph.addEdge('3','1');
	myGraph.addEdge('3','4'); myGraph.addEdge('1','0');

	cout << endl;

	cout << "\tGraph DFS Ordering:\t\t\t";
	myGraph.dfs('0',printVisited);

	cout << "\n\n\tTotal Visited after DFS:\t\t" << myGraph.markedSize();
	myGraph.unVisitAll();
	cout << "\n\tTotal Visited after clearing Marked:\t" << myGraph.markedSize();
	
	cout << endl << endl;
}