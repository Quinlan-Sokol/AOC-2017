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
import javafx.geometry.Point3D;

/**
 *
 * @author QDS
 */
public class Day20 {
    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner s = new Scanner(new File("src/input20.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        ArrayList<Point3D> pos = new ArrayList(); 
        ArrayList<Point3D> vel = new ArrayList(); 
        ArrayList<Point3D> acc = new ArrayList(); 
        
        for(String str : list){
            String[] parts = str.split(">,");
            
            String[] p1 = parts[0].replace("p=<", "").trim().split(",");
            String[] p2 = parts[1].replace("v=<", "").trim().split(",");
            String[] p3 = parts[2].replace("a=<", "").replace(">", "").trim().split(",");
            
            pos.add(new Point3D(Integer.parseInt(p1[0]), Integer.parseInt(p1[1]), Integer.parseInt(p1[2])));
            vel.add(new Point3D(Integer.parseInt(p2[0]), Integer.parseInt(p2[1]), Integer.parseInt(p2[2])));
            acc.add(new Point3D(Integer.parseInt(p3[0]), Integer.parseInt(p3[1]), Integer.parseInt(p3[2])));
        }
        
        while(true)
        {
            for(int i = 0; i < pos.size(); i++)
            {
                vel.set(i, vel.get(i).add(acc.get(i))); //CHANGING VELOCITY
                pos.set(i, pos.get(i).add(vel.get(i))); //CHANGING POSITION
            }
            
            //GETTING RID OF COLLISIONS
            for(int i = 0; i < pos.size(); i++){
                for(int j = 0; j < pos.size(); j++){
                    if(pos.get(i).equals(pos.get(j)) && i != j)
                    {
                        Point3D remove = pos.get(i);
                        for(int k = 0; k < pos.size(); k++)
                        {
                            if(pos.get(k).equals(remove)){
                                while(pos.contains(remove)){
                                    pos.remove(k);
                                    vel.remove(k);
                                    acc.remove(k);
                                }
                            }
                        }
                    }
                }
            }
            
            ArrayList<Double> dis = new ArrayList();
            for(int i = 0; i < pos.size(); i++)
            {
                double x = pos.get(i).getX();
                double y = pos.get(i).getY();
                double z = pos.get(i).getZ();
                dis.add(Math.abs(x) + Math.abs(y) + Math.abs(z));
            } 
            
            System.out.println(pos.size());
        }
    }
    public static int getMin(ArrayList<Double> inputArray){ 
    double minValue = inputArray.get(0); 
    int c = 0;
    for(int i=1;i<inputArray.size();i++){ 
      if(inputArray.get(i) < minValue){ 
        minValue = inputArray.get(i);
        c = i;
      } 
    } 
    return c; 
  } 
}
