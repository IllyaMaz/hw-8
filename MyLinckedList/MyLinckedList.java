package com.company;

public class MyLinckedList<T> {
    MyNode<T> head=new MyNode<>(null,null,null);
    MyNode<T> tail=new MyNode<>(null,null,null);
    int point = 0;

    public void add(T value){
        MyNode<T> node = new MyNode<>(tail,null,value);
        tail.next=node;
        tail=node;
        if(head.next==null){
            head=node;
        }
        point++;
    }

    public void remove(int index){
        MyNode midle = serchByIndex(index);
        MyNode first = serchByIndex(index-1);
        MyNode last = serchByIndex(index+1);
        if(midle.next==null&&midle.prev==null){
            midle=null;
        }else if (midle.next==null){
            tail=tail.prev;
            tail.next=null;
        }else if (midle.prev.prev==null){
            head=head.next;
            head.prev=null;
        }else {
            first.next=last;
            last.prev=first;
        }
        point--;
        midle=null;
    }

    public void clear(){
        head=null;
        tail=null;
        point=0;
    }

    public int size(){
        return point;
    }

    public T get(int index){
        int count =0;
        MyNode myNode=head;
        while (myNode!=null){
            if (count==index){
                return (T) myNode.element;
            }
            count++;
            myNode=myNode.next;
        }
        return null;
    }

    MyNode serchByIndex(int index){

        int count = 0;
        MyNode f=head;
        while(f!=null){
            if(count==index){
                return f;
            }
            count++;
            f=f.next;
        }
        return null;
    }

    @Override
    public String toString(){
        String s = "";
        MyNode myNode = head;
        while (myNode!=null){
            s+=myNode.element+"\n";
            myNode=myNode.next;
        }
        return s;
    }
}
