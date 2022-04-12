package com.company;

import java.util.Arrays;

public class MyArrayList<T> {
    Object[] a = new Object[10];
    int point = 0;

    public void add(T value){
        if(a.length-1==point){
            a = Arrays.copyOf(a,a.length+5);
        }
        a[point++] = value;
    }

   public void remove(int index){
        a[index]=null;
        point--;
       for (int i = index; i < a.length-1; i++) {
           a[i] = a[i + 1];
       }
   }

   public void clear(){
       for (int i = 0; i < a.length; i++) {
           a[i] = null;
           point--;
       }
   }

   public int size(){
        return point;
   }

   public Object get(int index){
        return  a[index];
   }

@Override
    public String toString(){
        String s ="";
    for (int i = 0; i < a.length; i++) {
        s += a[i] + "\n";
    }
        return s;
}

}
