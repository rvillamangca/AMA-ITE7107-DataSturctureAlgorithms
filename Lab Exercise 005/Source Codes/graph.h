/* Graph Implementation Header in C++ by Ramon Villamangca */

#ifndef GRAPH_H
#define GRAPH_H

#include <iostream>
#include <algorithm>

using namespace std;

enum {DIRECTED, UNDIRECTED};
typedef char vertex;

class Graph {
    private:
        vertex* vert;
        int** adjencyArray;
        int graphSize;
		int maxSize;
        int graphType;
        vertex* marked;
        int vertIndex(vertex V);
        void bfsHelper(vertex V, void (*visitFunc)(Graph G)); // helper function for BFS
        void reverseBfsHelper(vertex V, void (*visitFunc)(Graph G));
    public:
        Graph(int maxSize, int grType = DIRECTED);
		~Graph(){}
        void addVertex(vertex V);
        void addVertices(int count, vertex* V);
        void addEdge(vertex V1, vertex V2, int weight = 1);
		int size();
		vertex getVertex(int index);
        void printVertices();
        void mark(vertex V);
        int markedSize();
        bool isVisited(vertex V);
        void unVisitAll();                                  // clears the visited vertices
        vertex lastVisited();
		void printVisited();
        bool hasSuccessor(vertex V);
        void dfs(vertex V, void (*visitFunc)(Graph G));	 	// depth-first search implementation
        void bfs(vertex V, void (*visitFunc)(Graph G));	    // breadth-first search implementation
        void reverseBfs(vertex V, void (*visitFunc)(Graph G)); 
        int inDegree(vertex V);
        int outDegree(vertex V);
        int totDegree(vertex V);
};

#endif // GRAPH_H