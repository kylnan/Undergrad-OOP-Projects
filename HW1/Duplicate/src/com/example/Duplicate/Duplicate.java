/**
 * Program display repeated integers in a given array
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: Septmeber 30, 2021.
 */

package com.example.Duplicate;
import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args){
        int n;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of your array: ");
        n = sc.nextInt();               //reading for array length

        int[] array = new int[n];       //creates an array of length n

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();    //reading array elements from user
        }

        for (int i = 0; i < array.length; i++) {
            array[array[i] % array.length] = array[array[i] % array.length] + array.length;
        }
        System.out.println("The duplicated elements are: ");
        for (int i = 0; i < array.length; i++) {
            if(array[i] >= array.length * 2) {
                System.out.print(i + " ");
            }
        }
    }
}
