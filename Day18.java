/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author QDS
 */
public class Day18 {
    public static void main(String args[])
    {
        /*String[] list = {"set a 1",
"add a 2",
"mul a a",
"mod a 5",
"snd a",
"set a 0",
"rcv a",
"jgz a -1",
"set a 1",
"jgz a -2"};*/
        
        String[] list = {"set i 31",
"set a 1",
"mul p 17",
"jgz p p",
"mul a 2",
"add i -1",
"jgz i -2",
"add a -1",
"set i 127",
"set p 464",
"mul p 8505",
"mod p a",
"mul p 129749",
"add p 12345",
"mod p a",
"set b p",
"mod b 10000",
"snd b",
"add i -1",
"jgz i -9",
"jgz a 3",
"rcv b",
"jgz b -1",
"set f 0",
"set i 126",
"rcv a",
"rcv b",
"set p a",
"mul p -1",
"add p b",
"jgz p 4",
"snd a",
"set a b",
"jgz 1 3",
"snd b",
"set f 1",
"add i -1",
"jgz i -11",
"snd a",
"jgz f -16",
"jgz a -19"};
        //String[] list = {"mul a b","snd a"};
        
        Map<String, Integer> registers = new HashMap();
        registers.put("a", 0);
        registers.put("b", 0);
        registers.put("f", 0);
        registers.put("i", 0);
        registers.put("p", 0);
        
        int lastSound = 0;
        boolean in = true;
        
        for(int k = 0; k < list.length; k++)
        {
            String[] split = list[k].split(" ");
            String str = split[0];
            String reg = split[1];
            String value = "";
            if(split.length > 2){
                value = split[2];
            }
            
            if(in)
                switch (str) {
                    
                    case "snd":
                        lastSound = registers.get(reg);
                        System.out.println(lastSound);
                        break;
                    case "set":
                        if(registers.containsKey(value)){
                            registers.replace(reg, registers.get(value));
                        }
                        else{
                            registers.replace(reg, Integer.parseInt(value));
                        }
                        break;
                    case "add":
                        if(registers.containsKey(value)){
                            registers.replace(reg, registers.get(reg) + registers.get(value));
                        }
                        else{
                            registers.replace(reg, registers.get(reg) + Integer.parseInt(value));
                        }
                        break;
                    case "mul":
                        if(registers.containsKey(value)){
                            registers.replace(reg, registers.get(reg) * registers.get(value));
                        }
                        else{
                            registers.replace(reg, registers.get(reg) * Integer.parseInt(value));
                        }
                        break;
                    case "mod":
                        int ans = 0;
                        
                        if(registers.containsKey(value)){
                            System.out.println(registers.get(value));
                            ans = registers.get(reg)%registers.get(value);
                            registers.replace(reg, ans);
                        }
                        else{
                            ans = registers.get(reg)%Integer.parseInt(value);
                            registers.replace(reg, ans);
                        }
                        
                        break;
                    case "rcv":
                        //System.out.println(lastSound);
                        if(lastSound > 0){
                            //System.out.println(lastSound);
                            in = false;
                        }
                        break;
                    case "jgz":
                        int x;
                        int y;
                        if(registers.containsKey(reg)){
                            x = registers.get(reg);
                        }else{
                            x = Integer.parseInt(reg);
                        }
                        if(registers.containsKey(value)){
                            y = registers.get(value);
                        }else{
                            y = Integer.parseInt(value);
                        }

                        if(x > 0){
                            k += y - 1;
                        }
                        break;
                }
            }
    }
}
