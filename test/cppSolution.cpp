#include <iostream>
using namespace std;

class cppSolution
{
public:
    string test() {
        return "hello world";
    }
};

int main() {
    cout << cppSolution().test() << endl;
}