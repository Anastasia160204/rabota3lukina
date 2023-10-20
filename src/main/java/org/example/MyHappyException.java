package org.example;


public class MyHappyException extends RuntimeException{
    public MyHappyException(int i,int j,String value){
        super("В массиве под индексами [" + (i+1) + "]["+ (j+1) +"] лежит \"" + value + "\", что в свою очередь является  счастливым числом.");
    }
}
