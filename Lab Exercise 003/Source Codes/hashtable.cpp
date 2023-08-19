/* Hash Table implementation in C++ by Ramon Villamangca */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

int sumChar(string str) {
	int sum = 0;
	for (int i = 0; i < str.size(); i++) {
		if ((int) str[i] < 97) sum += (int) str[i] - 64;
		else sum += (int) str[i] - 96;
	}
	return sum;
}

class hashTable {
	private:
		static const int initSize = 10;
		vector<string> hTable;
		int hashFun(string key) {
			return sumChar(key) % initSize;
		}
	public:
		hashTable() {
			for (int i = 0; i < initSize; i++) {
				hTable.push_back("");
			}
		}
		int size() {
			return hTable.size();
		}
		void add(string key) {
			hTable[hashFun(key)] = key;
		}
		int find(string key) {
			int index = hashFun(key);
			if (hTable[index] == key) return index;
			else return -1;
		}
		void del(string key){
			int index = hashFun(key);
			if (hTable[index] == key) hTable[hashFun(key)] = "";			
		}
		void displayTable() {
			cout << endl;
			cout << "-------------------------------------" << endl;
			cout << " Index    Key Name   CharSum    Hash" << endl;
			cout << "-------  ----------  --------  ------" << endl << endl;
			for (int i = 0; i < hTable.size(); i++) {
				cout << "   " << i;
				if (hTable[i] == "") {
					cout << endl;
					continue;
				}
				cout << "       " << hTable[i] << "    \t" << sumChar(hTable[i]) 
				     << "    \t  " << i << endl;
			}
			cout << endl << "-------------------------------------" << endl;
		}	
};

int main(int argc, char** argv) {
	
	hashTable Names;
	
	Names.add("George");
	Names.add("Amy");
	Names.add("Alan");
	Names.add("Sandy");
	
	Names.displayTable();
	cout << endl;
	
	return 0;
}
