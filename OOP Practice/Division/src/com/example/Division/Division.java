/**
 * Program to divide two numbers and output as a float and an int, does not allow divide by zero.
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: Septmeber 30, 2021.
 */
package com.example.Division;
import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        double num1, num2, result;                                      //declaring variables
        int intResult;

        Scanner scannerObject = new Scanner(System.in);                 //creating an object to scan for input

        while(true){
            System.out.println("Enter two numbers for operation");

            num1 = scannerObject.nextDouble();                          //scans for double values for computation
            num2 = scannerObject.nextDouble();
            if (num2 == 0) {                                            //if divisor is zero then exit the program
                System.out.println("ERROR! Divisor cannot be zero");
                break;
            }
            result = num1 / num2;
            if ((result - (int)result) >= 0.5) {                        //determining ceiling function or floor function
                intResult = (int) (result + 1);
            }
            else {
                intResult = (int) (result);                             //typecasting to an int for output
            }
            System.out.printf("Result is: %.2f and round to int %d%n", result, intResult);
        }
        System.out.println("Program End");
    }


}

