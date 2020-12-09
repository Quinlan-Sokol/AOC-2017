/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.ArrayList;

/**
 *
 * @author QDS
 */
public class Day17 {
    public static void main(String args[])
    {
        int steps = 356;
        //int pos = 0;
        ArrayList<Integer> list = new ArrayList();
        list.add(0);
        int a = 0;
        for(int i = 1, pos = 0; i <= 50000000; i++){
            if((pos = ((pos + steps) % i) + 1) == 1) {
                a = i;
            }
            System.out.println(i);
        }
        System.out.println(a);
    }
}
