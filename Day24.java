/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author QDS
 */
public class Day24 {
    static int maxStrength = 0;
    static int maxLength = 0;
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input24.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        connect("0", list, 0, 0);
        System.out.println(maxStrength);
    }
    public static void connect(String port, ArrayList<String> list, int strength, int length){
        if(length >= maxLength && strength > maxStrength){
            maxStrength = strength;
            maxLength = length;
        }
        for(String str : list){
            boolean fits = false;
            int newStrength = strength;
            String newPort = "";
            ArrayList<String> newList = new ArrayList();newList.addAll(list);
            if(str.split("/")[0].equals(port)){
                newPort = str.split("/")[1];
                fits = true;
            }else if(str.split("/")[1].equals(port)){
                newPort = str.split("/")[0];
                fits = true;
            }
            
            if(fits){
                newStrength += Integer.parseInt(str.split("/")[0]) + Integer.parseInt(str.split("/")[1]);
                newList.remove(str);
                connect(newPort, newList, newStrength, length+1);
            }
        }
    }   
}
