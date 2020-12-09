/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author QDS
 */
public class Day14 {
    public static void main(String args[]){
        String input = "ljoxqyyw";
        int[][] grid = new int[128][128];
        int count = 0;
        int groups = 0;
        
        for(int i = 0; i < 128; i++){
            String key = input + "-" + Integer.toString(i);
            String binary = new BigInteger(knotHash(key), 16).toString(2);
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(binary.length() - 1 - j) == '1') {
                    count++;
                }
                grid[j][i] = binary.charAt(binary.length() - 1 - j) == '1' ? 1 : 0;
            }
        }
        
        for(int i = 0; i < 128; i++){
            for(int j = 0; j < 128; j++){
                if(grid[i][j] == 1){
                    groups++;
                    removeRegion(grid, i, j);
                }
            }
        }
        System.out.println(groups);
    }
    public static void removeRegion(int[][] grid, int x, int y){
        grid[x][y] = 0;
        if(x+1 < 128)
            if(grid[x+1][y] == 1) removeRegion(grid, x+1, y);
        if(x-1 >= 0)
            if(grid[x-1][y] == 1) removeRegion(grid, x-1, y);
        if(y+1 < 128)
            if(grid[x][y+1] == 1) removeRegion(grid, x, y+1);
        if(y-1 >= 0)
            if(grid[x][y-1] == 1) removeRegion(grid, x, y-1);
    }
    public static String knotHash(String bytes){
        ArrayList<Integer> list = new ArrayList(){{for(int i = 0; i < 256; i++)add(i);}};
        ArrayList<Integer> lengths = new ArrayList();
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
        return result;
    }
}
