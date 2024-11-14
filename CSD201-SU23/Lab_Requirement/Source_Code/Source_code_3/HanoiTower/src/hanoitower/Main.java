/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hanoitower;

public class Main {
    static int k=1;   
    
    public static void HanoiTower(int n, char a, char b, char c) {
        if(n==1) {
            System.out.printf("%5d: %c -> %c\n",k++,a,b);
            return;
        }
        HanoiTower(n-1,a,c,b);
        HanoiTower(1,a,b,c); 
        HanoiTower(n-1,c,b,a); 
    }
  
    public static void main(String [] args) {
        int n; char a, b, c;
        n=3; a='A'; b='C'; c='B';
        HanoiTower(n,a,b,c);
    }
}
