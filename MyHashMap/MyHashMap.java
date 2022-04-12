package com.company;

import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<T,E> {
        MyEntry<T,E>[] buckets = new MyEntry[10];
        MyEntry<T,E>[] buckets1 = new MyEntry[10];
        int breakpoint=0;
        int point = 0;
        int point1 = 0;

        public void put(T key,E value){
                int hash = Objects.hash(key);
                if (hash > 0){

                        if (point == 0){
                                buckets[point]=new MyEntry<T,E>(hash,key,null,value);
                                point++;
                        }else {
                                for (int i = 0; i < point; i++) {
                                        if (buckets[i].key.equals(key)){
                                                buckets[i].key=key;
                                                buckets[i].value=value;
                                                breakpoint=1;
                                        }

                                }
                                if (breakpoint==0) {
                                        buckets[point] = new MyEntry<>(hash, key, null, value);
                                        buckets[point - 1].next = buckets[point];
                                        point++;
                                }
                                breakpoint=0;
                        }
                } else {

                        if (point1 == 0){
                                buckets1[point1]=new MyEntry<>(hash,key,null,value);
                                point1++;
                        } else {
                                for (int i = 0; i < point; i++) {
                                        if (buckets1[i].key.equals(key)){
                                                buckets1[i].key=key;
                                                buckets1[i].value=value;
                                                breakpoint=1;
                                        }

                                }
                                if (breakpoint == 0) {
                                        buckets1[point1] = new MyEntry<>(hash, key, null, value);
                                        buckets1[point1 - 1].next = buckets1[point1];
                                        point1++;
                                }
                                breakpoint=0;
                        }
                }
        }

        public void remove(T key){
                int hash = key.hashCode();
                if (hash>0){
                        if (buckets[0].key.equals(key)) {
                                buckets[0]=null;
                                point--;
                        } else {
                                for (int i = 1; i < point; i++) {
                                        if (buckets[i].key.equals(key)){
                                                buckets[i]=null;
                                                buckets[i-1].next=buckets[i+1];
                                                point--;
                                        }
                                }
                        }
                } else {
                        if (buckets1[0].key.equals(key)){
                                buckets1[0]=null;
                                point1--;
                        } else {
                                for (int i = 1; i < point1; i++) {
                                        if (buckets1[i].key.equals(key)){
                                                buckets1[i]=null;
                                                buckets1[i-1].next=buckets1[i+1];
                                                point1--;
                                        }
                                }
                        }
                }
        }

        public void clear(){

                for (int i = 0; i < point; i++) {
                        buckets[i]=null;
                }
                point=0;
                for (int i = 0; i < point1; i++) {
                        buckets1[i]=null;
                }
                point1=0;
        }

        public int size(){
                return point+point1;
        }

        public E get(T key){
                int hash = Objects.hash(key);
                if (hash>0){
                        for (int i = 0; i < point; i++) {
                                if (buckets[i].key.equals(key)){
                                        return buckets[i].value;
                                }
                        }
                } else {
                        for (int i = 0; i < point1; i++) {
                                if (buckets1[i].key.equals(key)){
                                        return buckets1[i].value;
                                }
                        }
                }
                return null;
        }

      



}
