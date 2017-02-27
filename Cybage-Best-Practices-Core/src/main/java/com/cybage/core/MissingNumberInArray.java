package com.cybage.core;
public class MissingNumberInArray
{
    //Method to calculate sum of 'n' numbers
 
    static int sumOfNnumbers(int n)
    {
        int sum = (n * (n+1))/ 2;
 
        return sum;
    }
 
    //Method to calculate sum of all elements of array
 
    static int sumOfElements(int[] array)
    {
        int sum = 0;
 
        for (int i = 0; i < array.length; i++)
        {
            sum = sum + array[i];
        }
 
        return sum;
    }
 
    public static void main(String[] args)
    {
        int n = 12;
 
        int[] a = {1, 9, 5, 3, 4, 8, 6, 2, 10, 12, 7};
 
        //Step 1
 
        int sumOfNnumbers = sumOfNnumbers(n);
 
        //Step 2
 
        int sumOfElements = sumOfElements(a);
 
        //Step 3
 
        int missingNumber = sumOfNnumbers - sumOfElements;
 
        System.out.println("Missing Number is = "+missingNumber);
    }
}