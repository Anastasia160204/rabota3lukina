package org.example;

//в ячейке массива лежит что-то не то
public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i,int j,String value){
        super("В массиве под номерами [" + (i+1)+ "]["+ (j+1) +"] лежит некое \"" + value + "\", что в свою очередь не является целым числом.");
    }
}
