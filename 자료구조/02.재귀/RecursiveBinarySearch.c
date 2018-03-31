#include<stdio.h>

int BSearchRecur(int arr[], int first, int last, int target){
    int mid;

    if(last < first){
        return -1;
    }
    mid = (first + last)/2;
    if(arr[mid] > target){
        return BSearchRecur(arr, first, mid-1, target);
    } else if(arr[mid] == target){
        return mid;
    } else {
        return BSearchRecur(arr, mid+1, last, target);
    }
}

int main(void){
    int arr[] = {1,3,5,7,9};
    int idx;
    //c에서 배열 길이구할때, 외워둘 필요있어
    idx = BSearchRecur(arr, 0, sizeof(arr)/sizeof(int) - 1, 7);
    if(idx == -1){
        printf("탐색 실패");
    } else {
        printf("타겟 인덱스 저장 : %d\n", idx);
    }
}