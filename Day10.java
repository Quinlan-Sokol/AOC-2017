/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author QDS
 */
public class Day10 {
    public static void main(String args[])
    {
        ArrayList<Integer> list = new ArrayList(){{for(int i = 0; i < 256; i++)add(i);}};
        ArrayList<Integer> lengths = new ArrayList();
        String bytes = "212,254,178,237,2,0,1,54,167,92,117,125,255,61,159,164";
        for(char c : bytes.toCharArray()){
            lengths.add((int)c);
        }
        lengths.addAll(Arrays.asList(17, 31, 73, 47, 23));
        int pos = 0;
        int skip = 0;
        
        for(int i = 0; i < 64; i++){
            for(int length : lengths){
                for(int k = 0; k < Math.floorDiv(length, 2); k++){
                    Collections.swap(list, (pos + k) % list.size(), (pos + length - 1 - k) % list.size());
                }
                pos += length + skip;
                skip++;
            }
        }
        
        int X = 0;
        String result = "";
        for(int i = 0; i < 16; i++){
            int num = 0;
            for(int j = X; j < X + 16; j++){
                num ^= list.get(j);
            }
            if(Integer.toHexString(num).length() == 1)
                result += "0" + Integer.toHexString(num);
            else
                result += Integer.toHexString(num);
            
            X += 16;
        }
        System.out.println(result);
    }
}