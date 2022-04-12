package com.company;

public class MyNode<T> {
    MyNode<T> next = null;
    MyNode<T> prev = null;
    T element;
    MyNode(MyNode prev,MyNode next,T element){
        this.next=next;
        this.prev=prev;
        this.element=element;
    }


}
