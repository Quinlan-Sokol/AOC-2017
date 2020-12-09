/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author QDS
 */
public class Day23 {
    public static void main(String args[])
    {
        part2();
    }
    public static void part2()
    {
        int b = 109300;
        int c = 126300;
        int f = 1;
        int h = 0;
        
        for(int d = 2; d < b; d++)
        {
            for(int e = 2; e < b; e++)
            {
                if(d * e == b){ //composite check, or non-prime check
                    f = 0;
                }
                if(f == 0){
                    h++;
                    
                }
            }
        }
    }
    public static void part1()
    {
        String[] list = {"set b 93" ,
"set c b" ,
"jnz a 2" ,
"jnz 1 5" ,
"mul b 100" ,
"sub b -100000" ,
"set c b" ,
"sub c -17000" ,
"set f 1" ,
"set d 2" ,
"set e 2" ,
"set g d" ,
"mul g e" ,
"sub g b" ,
"jnz g 2" ,
"set f 0" ,
"sub e -1" ,
"set g e" ,
"sub g b" ,
"jnz g -8" ,
"sub d -1" ,
"set g d" ,
"sub g b" ,
"jnz g -13" ,
"jnz f 2" ,
"sub h -1" ,
"set g b" ,
"sub g c" ,
"jnz g 2" ,
"jnz 1 3" ,
"sub b -17" ,
"jnz 1 -23"};
        
        Map<String, Integer> registers = new HashMap();
        registers.put("a", 1);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
        registers.put("e", 0);
        registers.put("f", 0);
        registers.put("g", 0);
        registers.put("h", 0);

        int count = 0;

        ArrayList<String> command = new ArrayList();
        ArrayList<String> reg = new ArrayList();
        ArrayList<String> value = new ArrayList();
        for(String str : list)
        {
            String[] split = str.split(" ");
            command.add(split[0]);
            reg.add(split[1]);
            value.add(split[2]);
        }

        for(int k = 0; k < list.length; k++)
        {
            switch (command.get(k)) {

                case "set":
                    if(registers.containsKey(value.get(k))){
                        registers.replace(reg.get(k), registers.get(value.get(k)));
                    }
                    else{
                        registers.replace(reg.get(k), Integer.parseInt(value.get(k)));
                    }
                    break;
                case "sub":
                    if(registers.containsKey(value.get(k))){
                        registers.replace(reg.get(k), registers.get(reg.get(k)) - registers.get(value.get(k)));
                    }
                    else{
                        registers.replace(reg.get(k), registers.get(reg.get(k)) - Integer.parseInt(value.get(k)));
                    }
                    break;
                case "mul":
                    //count += 1;
                    if(registers.containsKey(value.get(k))){
                        registers.replace(reg.get(k), registers.get(reg.get(k)) * registers.get(value.get(k)));
                    }
                    else{
                        registers.replace(reg.get(k), registers.get(reg.get(k)) * Integer.parseInt(value.get(k)));
                    }
                    break;
                case "jnz":
                    if(registers.containsKey(reg.get(k))){
                        if(registers.get(reg.get(k)) != 0){
                            if(registers.containsKey(value.get(k))){
                                k += registers.get(value.get(k)) - 1;
                            }else{
                                k += Integer.parseInt(value.get(k)) - 1;
                            }
                        }
                    }else{
                        if(Integer.parseInt(reg.get(k)) != 0){
                            if(registers.containsKey(value.get(k))){
                                k += registers.get(value.get(k)) - 1;
                            }else{
                                k += Integer.parseInt(value.get(k)) - 1;
                            }
                        }
                    }
                    break;
            }
            //System.out.println(k);
        }
        System.out.println(registers.get("h"));
    }
}
