#include<stdio.h>
#include<stdlib.h>
#include"BinaryTree.h"

BTreeNode *MakeBTreeNode(void){
    BTreeNode *nd = (BTreeNode *)malloc(sizeof(BTreeNode));
    nd->left = NULL;
    nd->right = NULL;
    return nd;
}
BTData GetData(BTreeNode *bt){
    return bt->data;
}
void SetData(BTreeNode *bt, BTData data){
    bt->data = data;
}

BTreeNode *GetLeftSubTree(BTreeNode *bt){
    return bt->left;
}
BTreeNode *GetRightSubTree(BTreeNode *bt){
    return bt->right;
}

//메모리 누수가 가능한 코드 서브트리에 다른 노드들이 있으면 메모리 누수
void MakeLeftSubTree(BTreeNode *main, BTreeNode *sub){
    if(main->left != NULL) free(main->left);
    main->left = sub;
}
//메모리 누수가 가능한 코드 서브트리에 다른 노드들이 있으면 메모리 누수
void MakeRightSubTree(BTreeNode *main, BTreeNode *sub){
    if(main->right != NULL) free(main->right);
    main->right = sub;
}

void PreoderTraverse(BTreeNode *bt, VisitFuncPtr action){
    if(bt == NULL){
        return;
    }
    action(bt->data);
    PreoderTraverse(bt->left, action);
    PreoderTraverse(bt->right, action);
}
void InoderTraverse(BTreeNode *bt, VisitFuncPtr action){
    if(bt == NULL){
        return;
    }
    InoderTraverse(bt->left, action);
    action(bt->data);
    InoderTraverse(bt->right, action);
}
void PostoderTraverse(BTreeNode *bt, VisitFuncPtr action){
    if(bt == NULL){
        return;
    }
    PostoderTraverse(bt->left, action);
    PostoderTraverse(bt->right, action);
    action(bt->data);
}

void DeleteTree(BTreeNode *bt){
    if(bt == NULL){
        return;
    }
    DeleteTree(bt->left);
    DeleteTree(bt->right);

    free(bt);
}