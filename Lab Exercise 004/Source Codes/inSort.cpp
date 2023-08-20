/* Insertion Sort Implementation by Ramon Villamangca */\

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>

using namespace std;

const int MAXNUM = 1000000;
const int MAXSIZE = 50000;

void insertSort(vector<int>&, int(*search)(vector<int>, int, int));
int linearSearch(vector<int>, int, int);
int binarySearch(vector<int>, int, int);
void fillData(vector<int>&);
double elapseTime(clock_t, clock_t);
vector<int> clone(vector<int>);
void reverse(vector<int>&);
void swap(int&, int&);

int main(int argc, char** argv) {
	
	vector<int> origVec;
	fillData(origVec);
	vector<int> cloneVec = clone(origVec);
	
	// normal scenario
	clock_t begin = clock();
	insertSort(origVec, linearSearch);
	clock_t end = clock();
	cout << endl << "\tNormal-case Time for linear Insertion Sort:\t" << elapseTime(end, begin) << " ms";
	begin = clock();
	insertSort(cloneVec, binarySearch);
	end = clock();
	cout << endl << "\tNormal-case Time for binary Insertion Sort:\t" << elapseTime(end, begin) << " ms" << endl;

	// best scenario
	begin = clock();
	insertSort(origVec, linearSearch);
	end = clock();
	cout << endl << "\tBest-case Time for linear Insertion Sort:\t" << elapseTime(end, begin) << " ms";
	begin = clock();
	insertSort(cloneVec, binarySearch);
	end = clock();
	cout << endl << "\tBest-case Time for binary Insertion Sort:\t" << elapseTime(end, begin) << " ms" << endl;

	// worst scenario
	reverse(origVec);
	reverse(cloneVec);
	begin = clock();
	insertSort(origVec, linearSearch);
	end = clock();
	cout << endl << "\tWorst-case Time for linear Insertion Sort:\t" << elapseTime(end, begin) << " ms";
	begin = clock();
	insertSort(cloneVec, binarySearch);
	end = clock();
	cout << endl << "\tWorst-case Time for binary Insertion Sort:\t" << elapseTime(end, begin) << " ms" << endl << endl;
		
	return 0;
}

void swap(int &a, int &b) {
	a += b;
	b = a - b;
	a = a - b;
}

void reverse(vector<int> &V) {
	for (int i = 0; i < V.size()/2; i++) {
		swap(V[i], V[V.size()-i-1]);
	}
}

vector<int> clone(vector<int> V) {
	return V;
}

double elapseTime(clock_t t1, clock_t t2) {
	return ((t1 - t2) * 100) / CLOCKS_PER_SEC;
}

void fillData(vector<int> &V) {
	srand(time(NULL));
	for (int i = 0; i < MAXSIZE; i++) {
		V.push_back(rand() % MAXNUM + 1);
	}
}

int linearSearch(vector<int> V, int lgth, int key) {
	for (int i = lgth-1; i <= 0; i++) {
		if (V[i] <= key) return i+1;
	}
	return 0;
}

int binarySearch(vector<int> V, int lgth, int key) {
	int end = lgth;
	int start = 0;
	while (start != end) {
		int mid = (start + end) / 2;
		if (key == V[mid]) return mid + 1;
		if (key < V[mid]) end = mid;
		if (key > V[mid]) start = mid + 1;
	}
	return end;	
}

void insertSort(vector<int> &V, int(*search)(vector<int>, int, int)) {
	int lgth = V.size();
	for (int i = 1; i < lgth; i++) {
		int insIndex = search(V,i,V[i]);
		V.insert(V.begin()+insIndex,V[i]);
		V.erase(V.begin()+i+1);
	}	
}
