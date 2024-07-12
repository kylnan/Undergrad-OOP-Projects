/**
 * Program to flip a coin randomly 100 times and calculate the ratio of both heads and tails appeared.
 * Author: Kyle Zyler Cayanan
 * E-mail Address: kcayanan@uci.edu
 * Last Changed: Septmeber 30, 2021.
 */
package com.example.Flip;
import java.lang.Math;

public class Flip {
    public static void main(String[] args){
        int flipNum = 1;                    //initialzing values
        int tailsCount = 0;
        int headsCount = 0;
        double headsPercent, tailsPercent;
        int coinFace = (int) (Math.random() * (1));
        while (flipNum <= 100){             //While loop flips the coin 100 times and randomly assigns heads or tails
            if (coinFace == 0){
                System.out.printf("Flip Number %d: Tails%n", flipNum);
                tailsCount++;
            }
            if (coinFace == 1){
                System.out.printf("FLip Number %d: Heads%n", flipNum);
                headsCount++;
            }
            flipNum++;
            coinFace = (int) (Math.random() * (2));
        }
        headsPercent = headsCount/100.0;    //calculating the ratios
        tailsPercent = tailsCount/100.0;

        System.out.printf("Heads: %.2f Tails: %.2f%n", headsPercent, tailsPercent);


    }
}
