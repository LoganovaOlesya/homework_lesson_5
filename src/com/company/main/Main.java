package com.company.main;

import java.util.Random;

public class Main {

    public static int[] fullArray (int[] array, int arrayLength){

        Random rand = new Random();

        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(10);
        }
        return array;
    }

    public static void sortArray(int startIndex, int endIndex, int[] array){
        int originalStartIndex = startIndex;
        int originalEndIndex = endIndex;
        int pivot = startIndex - (startIndex-endIndex)/2;

        if (startIndex >= endIndex)
            return;

        while (startIndex < endIndex){
            while (startIndex < pivot && array[startIndex] <= array[pivot]){ //от левой части к центру
                startIndex++;
            }
            while (endIndex > pivot && array[pivot] <= array[endIndex]){ //от правой части к центру
                endIndex--;
            }

            //меняем найденные элементы местами
            if (startIndex < endIndex) {
                int temp = array[startIndex];
                array[startIndex] = array[endIndex];
                array[endIndex] = temp;

                if (startIndex == pivot) {
                    pivot = endIndex;
                } else if (endIndex == pivot) {
                    pivot = startIndex;
                }
            }
        }
        sortArray(originalStartIndex, pivot, array);
        sortArray(pivot+1, originalEndIndex, array);
    }


    public static void printArray(int[] array){

        for (int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] array = new int [10];
        int arrayLength = array.length;

        array = fullArray(array, arrayLength);

        sortArray(0, arrayLength-1, array);

        printArray(array);
    }
}
