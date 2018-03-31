#include<stdio.h>
#include<stdlib.h>

typedef struct _node{
    int data;
    struct _node *next;
} Node;

int main(void){
    Node *head = NULL;
    Node *tail = NULL;
    Node *cur = NULL;

    Node *newNode = NULL;

    int readData;

    while(1){
        scanf("%d", &readData);
        if(readData < 1) break;

        newNode = malloc(sizeof(Node));
        newNode->data = readData;
        newNode->next = NULL;

        /*
        뒤에 데이터 삽입
        if(head == NULL) head = newNode;
        else tail->next = newNode;

        tail = newNode;
        */

        // 앞에 삽입
        if(head == NULL) {
            head = newNode;
            tail = newNode;
        } else {
            newNode->next = head;
            head = newNode;
        }
        
    }
    printf("\n");

    //입력 데이터 출력과정

    printf("데이터 전체 출력\n");
    if(head == NULL) printf("저장된 수가 없습니다\n");
    else{
        cur = head;
        // printf("%d ",cur->data);
        while(cur != NULL){
            printf("%d ",cur->data);
            cur = cur->next;
        }

        // printf("%d ", cur->data); 코드를 이렇게하면 cur은 NULL
    }
    printf("\n\n");

    Node *delNode = head;
    Node *delNextNode = head->next;

    free(delNode);
    while(delNextNode != NULL){
        delNode = delNextNode;
        delNextNode = delNextNode->next;
        free(delNode);
    }
}