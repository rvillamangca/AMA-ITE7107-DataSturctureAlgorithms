/* Graph Implementation in C++ by Ramon Villamangca */

#include "graph.h"

Graph::Graph(int maxSz, int grType) {
	maxSize = maxSz;
    vert = new vertex[maxSize];
    graphSize = 0;
    graphType = grType;
    marked = new vertex[maxSize];
        for (int i = 0; i < maxSize; i++) {
            marked[i] = 0;
        }
    adjencyArray = new int*[maxSize];
        for (int i = 0; i < maxSize; i++) {
            adjencyArray[i] = new int[maxSize];
        }
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjencyArray[i][j] = 0;
            }
        }
}

int Graph::vertIndex(vertex V) {
    vertex *ptr;
    vertex *end = vert + graphSize;
    ptr = find(vert, end, V);
    if (ptr != end) return ptr - vert;
    return -1;
}

void Graph::addVertex(vertex V) {
	if (graphSize >= maxSize) {
        cout << "Maximum Graph size exceeded";
        return;
    }
    vert[graphSize] = V;
    graphSize++;
}

void Graph::addVertices(int count, vertex* V) {
    for (int i = 0; i < count; i++) {
    addVertex(V[i]);
    }
}

void Graph::addEdge(vertex V1, vertex V2, int weight) {
    int index1 = vertIndex(V1);
    int index2 = vertIndex(V2);
    if (index1 == -1 || index2 == -1) {
        cout << "At least one of the vertex is NOT found in the Graph";
        return;
    }
    adjencyArray[index1][index2] = weight;
    if (graphType == UNDIRECTED) adjencyArray[index2][index1] = weight;
}

int Graph::size(){
	return graphSize;
}

vertex Graph::getVertex(int index) {
	return vert[index];
}

void Graph::printVertices() {
    for(int i = 0; i < graphSize; i++) cout << vert[i] << " ";
}

void Graph::mark(vertex V) {
	if (isVisited(V)) return;
	if (vertIndex(V) == -1) {
        cout << "Vertex is NOT found in the Graph";
        return;
    }
	int i = 0;
	while(marked[i] != 0 && i <= graphSize) {
		i++;
	}
	if (i == graphSize) {
		cout << "No more vertex to visit";
		return;
	}
	marked[i] = V;
}

int Graph::markedSize() {
    int i = 0;
    while (marked[i] != 0) {
        i++;
    }
    return i;
}

bool Graph::isVisited(vertex V) {
    for (int i = 0; i < graphSize; i++) {
		if (marked[i] == V) return true;
	}
	return false;
}

void Graph::unVisitAll() {                  // clears the visited vertices
    for (int i = 0; i < graphSize; i++) {
        marked[i] = 0;
    }
}

vertex Graph::lastVisited() {
    int i = 0;
    do {
        i++;
    } while (marked[i] != 0);
    return marked[i-1];
}

void Graph::printVisited() {
	for(int i = 0; i < graphSize; i++) {
		if (marked[i] == 0) continue;
		cout << marked[i] << " ";
	}
}

bool Graph::hasSuccessor(vertex V) {
    int index = vertIndex(V);
    for (int i = 0; i < graphSize; i++) {
        if (adjencyArray[index][i] != 0) return true;
    }
    return false;
}

void Graph::dfs(vertex V, void (*visitFunc)(Graph G)) {     // depth-first search implementation
	if (isVisited(V)) return;
	mark(V);
    visitFunc(*this);
	if (hasSuccessor(V)) {
		for(int i = 0; i < graphSize; i++) {
			if ((adjencyArray[vertIndex(V)][i] > 0)) dfs(vert[i], visitFunc);
		}
	}	
}

void Graph::bfs(vertex V, void (*visitFunc)(Graph G)) { // breadth-first search implementation
	mark(V);
    visitFunc(*this);
    bfsHelper(V, visitFunc);
}
void Graph::bfsHelper(vertex V, void (*visitFunc)(Graph G)) {
    if (hasSuccessor(V)) {
        for(int i = 0; i < graphSize; i++) {
            if (adjencyArray[vertIndex(V)][i] > 0) {
                if (isVisited(vert[i])) continue;       // disable this line for cyclic graph
                mark(vert[i]);
                visitFunc(*this);
            }
        }
        for(int i = 0; i < graphSize; i++) {            
            if (adjencyArray[vertIndex(V)][i] > 0) bfsHelper(vert[i], visitFunc);
        }
    }
}

void Graph::reverseBfs(vertex V, void (*visitFunc)(Graph G)) { // breadth-first search implementation
    mark(V);
    visitFunc(*this);
    bfsHelper(V, visitFunc);
}
void Graph::reverseBfsHelper(vertex V, void (*visitFunc)(Graph G)) {
    if (hasSuccessor(V)) {
        for(int i = 0; i < graphSize; i++) {
            if (adjencyArray[i][vertIndex(V)] > 0) {
                if (isVisited(vert[i])) continue;       
                mark(vert[i]);
                visitFunc(*this);
            }
        }
        for(int i = 0; i < graphSize; i++) {            
            if (adjencyArray[i][vertIndex(V)] > 0) bfsHelper(vert[i], visitFunc);
        }
    }
}


int Graph::inDegree(vertex V) {
    int index = vertIndex(V);
    int inDeg = 0;
    if (index == -1) return 0;
    for (int i = 0; i < graphSize; i++) {
        inDeg += adjencyArray[i][index];
    }
    return inDeg;
}


int Graph::outDegree(vertex V) {
    int index = vertIndex(V);
    int outDeg = 0;
    if (index == -1) return 0;
    for (int i = 0; i < graphSize; i++) {
        outDeg += adjencyArray[index][i];
    }
    return outDeg;
}


int Graph::totDegree(vertex V) {
    return inDegree(V) + outDegree(V);
}

