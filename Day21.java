/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author QDS
 */
public class Day21 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input21.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        String[][] grid = new String[3][3];grid[0][0] = ".";grid[0][1] = "#";grid[0][2] = ".";grid[1][0] = ".";grid[1][1] = ".";grid[1][2] = "#";grid[2][0] = "#";grid[2][1] = "#";grid[2][2] = "#";
        //System.out.println(Arrays.deepToString(grid).replace("], ", "]\n").replace(", ", "").replace("[", "").replace("]", ""));
        
        for(int k = 0; k < 2; k++){
            int splitSize = grid.length % 2 == 0 ? 2 : 3;
            String[][] newGrid = new String[grid.length + (grid.length / splitSize)][grid.length + (grid.length / splitSize)];
            for(int i = 0; i < grid.length; i+=splitSize){
                for(int j = 0; j < grid.length; j+=splitSize){
                    loop:
                    for(String rule : list){
                        String[][] arr = new String[splitSize][splitSize];
                        for(int i2 = i; i2 < i + splitSize; i2++){
                            for(int j2 = j; j2 < j + splitSize; j2++){
                                arr[i2%splitSize][j2%splitSize] = grid[i2][j2];
                            }
                        }
                        int counter = 0;
                        while(true){
                            if(Arrays.deepToString(arr).replace("], ", "/").replace(", ", "").replace("[", "").replace("]", "").equals(rule.split(" => ")[0])){
                                //add the pattern to the grid
                                for(int i2 = i; i2 <= i + splitSize; i2++){
                                    for(int j2 = j; j2 <= j + splitSize; j2++){
                                        newGrid[i2][j2] = Character.toString(rule.split(" => ")[1].split("/")[j2%rule.split(" => ")[1].split("/").length].charAt(i2%rule.split(" => ")[1].split("/").length));
                                    }
                                }
                                break loop;
                            }
                            else if(counter == 3){
                                arr = flip(arr);
                            }
                            else{
                                arr = rotate(arr);
                            }
                            counter++;
                            if(counter == 8)  break;
                        }
                    }
                    System.out.println(Arrays.deepToString(newGrid).replace("], ", "]\n").replace(", ", "").replace("[", "").replace("]", ""));
                    System.out.println();
                }
            }
            grid = newGrid;
            //System.out.println(Arrays.deepToString(grid).replace("], ", "]\n").replace(", ", "").replace("[", "").replace("]", ""));
            System.out.println();
        }
        
    }
    public static String[][] rotate(String[][] arr){
        String[][] newArray = new String[arr.length][arr.length];
        for(int i=0; i<arr[0].length; i++){
            for(int j=arr.length-1; j>=0; j--){
                newArray[i][arr.length-1-j] = arr[j][i];
            }
        }
        return newArray;
    }
    public static String[][] flip(String[][] arr){
        String[][] newArray = new String[arr.length][arr.length];
        for(String[] str : arr){
            Collections.reverse(Arrays.asList(arr));
        }
        return arr;
    }
}
