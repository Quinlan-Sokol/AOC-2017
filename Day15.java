/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

/**
 *
 * @author QDS
 */
public class Day15 {
    public static void main(String args[])
    {
        part2();
    }
    static long getBit(long num, long k) {
        return (num >> k) & 1;
    }
    public static void part1(){
        long a = 591;
        long b = 393;
        int count = 0;
        for(int i = 0; i < 40000000 ;i++){
            a = (a * 16807) % 2147483647;
            b = (b * 48271) % 2147483647;
            
            
            String binA = "";
            String binB = "";
            for(int k = 15; k > -1; k--){
                binA += Long.toString(getBit(a, k));
                binB += Long.toString(getBit(b, k));
            }
            if(binA.equals(binB)){
                count++;
            }
            System.out.println(i);
        }
        System.out.println("");
        System.out.println("");
        System.out.println(count);
    }
    public static void part2(){
        long a = 591;
        long b = 393;
        int count = 0;
        for(int i = 0; i < 5000000 ;i++){
            do{
                a = (a * 16807) % 2147483647;
            }while(a % 4 != 0);
            do{
                b = (b * 48271) % 2147483647;
            }while(b % 8 != 0);         
            
            String binA = "";
            String binB = "";
            for(int k = 15; k > -1; k--){
                binA += Long.toString(getBit(a, k));
                binB += Long.toString(getBit(b, k));
            }
            if(binA.equals(binB)){
                count++;
            }
            System.out.println(i);
        }
        System.out.println("");
        System.out.println("");
        System.out.println(count);
    }
}
