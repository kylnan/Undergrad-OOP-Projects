/**
 * Program to count and display repeated integers in a given array
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: Septmeber 30, 2021.
 */
package com.example.MoreDuplicate;

import java.util.Scanner;

public class MoreDuplicate {
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

        for (int i = 0; i < n; i++) {
            array[array[i] % n] = array[array[i] % n] + n;

        }

        System.out.println("The duplicated elements are: ");
        for (int i = 0; i < n; i++) {
            if(array[i] >= n * 2) {
                System.out.println(i + " appear " + array[i % n] / n + " times");
            }
        }
    }
}
