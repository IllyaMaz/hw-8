package com.company;

import java.util.Arrays;

public class MyStack<T>{
    Object[] objects = new Object[10];
    int point = 0;

    public void add(T value){
        if (point==objects.length-2){
            objects= Arrays.copyOf(objects,objects.length+5);
        }
        objects[point]=value;
        point++;
    }

    public void remove(int index){
        objects[index]=null;
        for (int i = index; i < objects.length-1; i++) {
            objects[i]=objects[i+1];
        }
        point--;
    }

    public void clear(){
        for (int i = 0; i < objects.length-1; i++) {
            objects[i]=null;
        }
    }

    public Object peek(){
        return objects[point-1];
    }

    public Object pop(){
        Object ret = objects[point-1];
        objects[point-1]=null;
        return ret;
    }


}
