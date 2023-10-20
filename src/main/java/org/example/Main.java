package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "103", "107", "109"},
                {"100", "4", "131", "137"},
                {"139", "149", "22", "157"},
                {"163", "167", "173", "179"}
        };

        try {
            System.out.println("Сумма чисел матрицы: " + method(array));
        }
        catch (MyArraySizeException | MyArrayDataException | MyHappyException e){
            e.printStackTrace();
        }
    }

    public static int method(String[][] array) throws MyArraySizeException, MyArrayDataException, MyHappyException {

        if(array.length != 4){
            throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4){
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        int number;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j,array[i][j]);
                }

                try{
                    if(luckyNumber(number)){
                        throw new MyHappyException(i,j,array[i][j]);
                    }
                }
                catch (MyHappyException ee){
                    ee.printStackTrace();
                }

            }
        }
        return sum;
    }

    public static boolean luckyNumber(int number) {
        char[] value = String.valueOf(number).toCharArray();
        if(value.length != 6)
            return false;

        int ch1 = 0;
        int ch2 = 0;
        for (int i = 0; i < 6; i++) {

            if(i < 3){

                ch1 += Character.digit(value[i], 10);
            }
            else
                ch2 += Character.digit(value[i], 10);

        }
        return ch1 == ch2;
    }
}