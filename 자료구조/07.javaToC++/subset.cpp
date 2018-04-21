#include<iostream>

using namespace std;

int main(void){
    int arr[] = {1,2,3,4,5,6};
    for(int i = 0; i < (1<<6); i++){
        for(int j = 0; j < 6; j++){
            if(i & (1<<j)){
                cout<<arr[j]<<" ";
            }
        }
        cout<<endl;
    }
}