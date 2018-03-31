#include<stdio.h>
#include"ArrayBaseStack.h"

int main(void){
    Stack st;
    StackInit(&st);
    
    SPush(&st, 1);
    SPush(&st, 2);
    SPush(&st, 3);
    SPush(&st, 4);
    SPush(&st, 5);

    while(!SIsEmpty(&st)){
        printf("%d ",SPop(&st));
    }

}