/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author QDS
 */
public class Day12 {
    static ArrayList<Integer> visited = new ArrayList();
    static Map<Integer, String[]> pipes = new HashMap();
    static ArrayList<Integer> programs = new ArrayList(){{for(int i = 0; i < 2000; i++){add(i);}}};
    static ArrayList<Integer> list = new ArrayList();
    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File("src/input12.txt"));
        
        while(s.hasNextLine()){
            String str = s.nextLine();
            pipes.put(Integer.parseInt(str.split(" <-> ")[0]), str.split(" <-> ")[1].split(", "));
        }
        s.close();
        int groups = 0;
        
        while(visited.size() < 2000){
            connect(programs.get(0));
            groups++;
            programs.removeAll(list);
            list.clear();
        }
        System.out.println(groups);
    }
    public static void connect(int ID){
        visited.add(ID);
        list.add(ID);
        for(String str : pipes.get(ID)){
            if(!visited.contains(Integer.parseInt(str))){
                connect(Integer.parseInt(str));
            }
        }
    }
}
