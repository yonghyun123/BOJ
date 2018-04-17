#include<iostream>
#include<string>

using namespace std;

int main(void){
    long N1,N2;
    int cnt = 0;
    int flag;
    cin>>N1>>N2;
    
    for(int i = N1; i <=N2; i++){
        flag = 0;
        std::string s = std::to_string(i);
        if(s[0] == '3' || s[0] == '4' || s[0] == '6' || s[0] == '7' || s[0] == '9') continue;
        
        for(int j = 0;  j < (s.length()+1)/2; j++){
            if(s[j] == '2' && s[s.length()-j-1] == '5'){
                continue;
            } else if(s[j] == '5' && s[s.length()-j-1] == '2'){
                continue;
            } else if(s[j] == '0' || s[j] == '1' || s[j] == '8'){
                if(s[j] != s[s.length()-j-1]){
                    flag = 1;
                    break;
                }
            } else {
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            cnt += 1;
        }
    }
    cout<<cnt<<endl;

}

