/* Graph Demo for Exercise 4-1 in C++ by Ramon Villamangca */

#include "graph.h"

void printVisited(Graph G) {
	cout << G.lastVisited() << " ";
}

void topNum(Graph G, vertex V) {
	G.bfs(V, printVisited);
}

void ex_4_1 (int size, vertex* Vs) {
	Graph G(size);
	G.addVertices(5, Vs);	
	G.addEdge('A','B'); 
	G.addEdge('A','C'); G.addEdge('A','D');
	G.addEdge('C','E'); G.addEdge('D','E');
	topNum(G, 'A');
}

int main(int argc, char** argv) {

	cout << endl;
	
	vertex Vs[] = {'A', 'B', 'C', 'D', 'E'};

	cout << "       ---------" << endl;
	cout << "       1 2 3 4 5" << endl;
	cout << "       ---------" << endl;
	int i = 1;
	do {
		cout << "   " << i << " | ";
		ex_4_1(5, Vs);
		cout << endl;
		i++;
	} while (next_permutation(Vs+1, Vs+4));
	cout << "       ---------" << endl;

	cout << endl;
}