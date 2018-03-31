// 과제 2. Doubly-Linked List 구현
// 아래 주석 속에 학번, 이름을 적어주세요.
//
// 학번: 60112334
// 이름: 김용현
//
//
#include <stdio.h>
#include <stdlib.h>

// Traverse 함수에서 사용할 리스트 순회 방향.
#define FORWARD     0
#define BACKWARD    1

// 리스트 노드
typedef struct t_node {
  int val;
  struct t_node* prev;
  struct t_node* next;
} Node;

// 리스트: 헤드 노드를 갖는 형태로 구현.
typedef struct t_list {
  Node* head;
} List;

// 빈 리스트 생성: head노드의 초기화를 잘 보세요.
List* Create() {
  List* list = (List*) malloc(sizeof(List));
  list->head = (Node*) malloc(sizeof(Node));
  list->head->prev = list->head;
  list->head->next = list->head;
  return list;
}

// 다음은 방문자 패턴을 활용한 리스트 순회 코드입니다. 참고 하세요.
// Traverse함수에서 사용할 handler함수를 위한 함수 포인터 타입 정의
typedef void (*NodeHandler)(Node* );

// 방문자 함수: 리스트를 주어진 방향대로 순회하면서 각 노드에 주어진 handler 함수를 실행.
// 리스트를 순회하는 방법을 잘 보세요.
void Traverse(int direction, List* list, NodeHandler handler) {
  Node* p = (direction == FORWARD) ? list->head->next : list->head->prev;
  Node* next;
  while(p != list->head) {
    next = (direction == FORWARD) ? p->next : p->prev;
    handler(p);
    p = next;
  }
}

// Traverse 함수에서 사용하는 handler의 예
void _print_node(Node* node) {
  if (node != NULL) {
    printf("%d -> ", node->val);
  }
}

// List를 next포인터를 따라 순회하면서 노드의 값 프린트
void Print(List* list) {
  printf("FORWARD: ");
  Traverse(FORWARD, list, _print_node);
  printf("\n");
}

// List를 prev포인터를 따라 순회하면서 노드의 값 프린트
void PrintRev(List* list) {
  printf("BACKWARD: ");
  Traverse(BACKWARD, list, _print_node);
  printf("\n");
}

// 리스트에서 주어진 val 값과 같은 첫 번째 노드를 반환
// 만약 node가 NULL이면 리스트의 처음부터 검색
// 만약 node가 NULL이 아니면 주어진 node 다음 노드부터 리스트 검색
Node* Find(List* list, Node* node, int val) {
  // TODO: 여기에 코드를 작성하세요
  Node *findNode = list->head->next;

  // 만약 node가 NULL이면 리스트의 처음부터 검색
  if(node == NULL){
    while(findNode != list->head){

      if(findNode->val==val){
        return findNode;
      }
      findNode = findNode->next;
    }
    return NULL;
  }
  else{// 만약 node가 NULL이 아니면 주어진 node 다음 노드부터 리스트 검색
    for( ; findNode != node->next; findNode = findNode->next);

    while(findNode != list->head){

      if(findNode->val==val){
        return findNode;
      }
      findNode = findNode->next;
    }
    return NULL;
  }
}

// 주어진 node 앞에 새로운 node를 추가
Node* AddBefore(Node* node, int val) {
  // TODO: 여기에 코드를 작성하세요.
  Node* newNode = (Node *)malloc(sizeof(Node));
  newNode->val = val;

  newNode->next = node;
  newNode->prev = node->prev;

  node->prev->next = newNode;
  node->prev = newNode;
  return newNode;


}

// 주어진 node 뒤에 새로운 node를 추가
Node* AddAfter(Node* node, int val) {
  // TODO: 여기에 코드를 작성하세요.
  Node* newNode = (Node *)malloc(sizeof(Node));
  newNode->val = val;
  newNode->prev = node;
  newNode->next = node->next;

  node->next->prev = newNode;
  node->next = newNode;


  return newNode;
}

// List의 맨 앞에 새로운 node 추가
Node* AddHead(List* list, int val) {
  // TODO: 여기에 코드를 작성하세요.
  Node* node = (Node *)malloc(sizeof(Node));
  node->val = val;
  node->prev = list->head;
  node->next = list->head->next;

  list->head->next->prev = node;
  list->head->next = node;
  



  return node;

}

// List의 맨 뒤에 새로운 node추가
Node* AddTail(List* list, int val) {
  // TODO: 여기에 코드를 작성하세요.
  Node* node = (Node *)malloc(sizeof(Node));
  node->val = val;
  node->next = list->head;
  node->prev = list->head->prev;

  list->head->prev->next = node;
  list->head->prev = node;
  return node;
}

// 주어진 Node 삭제
void Remove(Node* node) {
  // TODO: 여기에 코드를 작성하세요.
  node->prev->next = node->next;
  node->next->prev = node->prev;
  free(node);
}

// 리스트의 맨 앞 노드 삭제
void RemoveHead(List* list) {
  // TODO: 여기에 코드를 작성하세요.
  list->head->next->next->prev = list->head;
  list->head->next = list->head->next->next;

}

// 리스트의 맨 뒤 노드 삭제
void RemoveTail(List* list) {
  // TODO: 여기에 코드를 작성하세요.
  list->head->prev->prev->next = list->head;
  list->head->prev = list->head->prev->prev;

}

// 주어진 리스트의 모든 노드 삭제
void RemoveAll(List* list) {
  // TODO: 여기에 코드를 작성하세요.
  Node *tempNode = list->head->next;

  //list를 차례로 순회하면서 리스트의 맨 앞 노드를 삭제하고 메모리 해제
  while(tempNode != list->head){
    free(tempNode);
    RemoveHead(list);
    tempNode = tempNode->next;
  }
}

void Free(List* list) {
  RemoveAll(list);
  free(list->head);
  free(list);
}

int main() {
  // Main 함수는 가능하면 수정하지 마세요.
  // 다음과 같은 결과가 나타나야 합니다.
  //
  // FORWARD:
  // BACKWARD:
  // FORWARD: 10 ->
  // BACKWARD: 10 ->
  // FORWARD: 10 -> 50 ->
  // BACKWARD: 50 -> 10 ->
  // FORWARD: 5 -> 10 -> 30 -> 45 -> 50 -> 60 -> 70 ->
  // BACKWARD: 70 -> 60 -> 50 -> 45 -> 30 -> 10 -> 5 ->
  // FORWARD: 5 -> 30 -> 45 -> 50 -> 60 -> 70 ->
  // BACKWARD: 70 -> 60 -> 50 -> 45 -> 30 -> 5 ->
  // FORWARD: 30 -> 45 -> 50 -> 70 -> 45 ->
  // BACKWARD: 45 -> 70 -> 50 -> 45 -> 30 ->
  // FOUND 45
  // FOUND 45
  // FORWARD: 45 -> 50 -> 70 ->
  // BACKWARD: 70 -> 50 -> 45 ->
  // FORWARD:
  // BACKWARD:

  List* list = Create();
  Print(list);
  PrintRev(list);

  Node* n1 = AddHead(list, 10);
  Print(list);
  PrintRev(list);
  Node* n2 = AddTail(list, 50);
  Print(list);
  PrintRev(list);
  Node* n3 = AddBefore(n2, 30);
  Node* n4 = AddAfter(n2, 60);
  Node* n5 = AddHead(list, 5);
  AddTail(list, 70);
  AddAfter(n3, 45);
  Print(list);
  PrintRev(list);

  Remove(n1);
  Print(list);
  PrintRev(list);

  Remove(n4);
  Remove(n5);
  AddTail(list, 45);
  Print(list);
  PrintRev(list);
  n1 = NULL;
  do {
    n1 = Find(list, n1, 45);
    if (n1) {
      printf("FOUND 45\n");
    }
  } while(n1);

  RemoveHead(list);
  RemoveTail(list);

  Print(list);
  PrintRev(list);

  RemoveAll(list);
  Print(list);
  PrintRev(list);

  Free(list);
  return 0;
}
