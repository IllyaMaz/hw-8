package com.company;

import java.util.Objects;

public class MyEntry<T,E> {
    int hashCode;
    T key;
    MyEntry<T,E> next;
    E value;
    MyEntry(int hashCode, T key, MyEntry<T,E> next, E value){
        this.hashCode=hashCode;
        this.key=key;
        this.next=next;
        this.value=value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){return true;}
        if (o == null || getClass() != o.getClass()){return  false;}
        MyEntry<T,E> myEntry = (MyEntry<T,E>) o;
        return this.key==((MyEntry<?, ?>) o).key;
    }

    @Override
    public int hashCode(){
        return Objects.hash(key);
    }

    @Override
    public String toString(){
        return "{key = "+key+" value = "+value+"}";
    }

}
