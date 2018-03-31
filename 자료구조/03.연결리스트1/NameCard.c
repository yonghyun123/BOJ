#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include"NameCard.h"

NameCard * MakeNameCard(char *name, char *phone){
    NameCard *nc = (NameCard *)malloc(sizeof(NameCard));
    strcpy(nc->name,name);
    strcpy(nc->phone,phone);
    return nc;
}
// NameCard 구조체 변수 정보 출력
void ShowNameCardInfo(NameCard *pcard){
    printf("이름은%s\n", pcard->name);
    printf("번호는%s\n", pcard->phone);
}
// 이름이 같으면 0, 다르면 0이 아닌값 반환
int NameCompare(NameCard *pcard, char *name){
    if(strcmp(pcard->name,name)) return 0;
    else return -1;
}
// 전화번호 정보를 변경
void ChangePhoneNum(NameCard *pcard, char *phone){

}
