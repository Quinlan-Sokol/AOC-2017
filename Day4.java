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
public class Day4 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input4.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        int count = 0;
        
        for(String line : list){
            boolean valid = true;
            ArrayList<String> arr = new ArrayList(){{addAll(Arrays.asList(line.split(" ")));}};
            ArrayList<String> arr2 = new ArrayList();
            for(String str : arr){//part 1
                arr2.add(sort(str));
                if(Collections.frequency(arr, str) > 1){
                    valid = false;
                }
            }
            for(String str : arr2){
                if(Collections.frequency(arr2, str) > 1){
                    valid = false;
                }
            }
            if(valid)   count++;
        }
        System.out.println(count);
    }
    public static String sort(String inputString){ 
        char tempArray[] = inputString.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    } 
}
