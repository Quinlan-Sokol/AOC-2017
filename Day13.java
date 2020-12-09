/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author QDS
 */
public class Day13 {
    public static void main(String args[])
    {
        String[] list = {"0: 3",
"1: 2",
"2: 6",
"4: 4",
"6: 4",
"8: 8",
"10: 9",
"12: 8",
"14: 5",
"16: 6",
"18: 8",
"20: 6",
"22: 12",
"24: 6",
"26: 12",
"28: 8",
"30: 8",
"32: 10",
"34: 12",
"36: 12",
"38: 8",
"40: 12",
"42: 12",
"44: 14",
"46: 12",
"48: 14",
"50: 12",
"52: 12",
"54: 12",
"56: 10",
"58: 14",
"60: 14",
"62: 14",
"64: 14",
"66: 17",
"68: 14",
"72: 14",
"76: 14",
"80: 14",
"82: 14",
"88: 18",
"92: 14",
"98: 18"};
        /*
        HashMap<Integer, Integer> layers = new HashMap<>();
        for (String line : lines) {
            String[] split = line.split(":");
            layers.put(Integer.valueOf(split[0]), Integer.valueOf(split[1].trim()));
        }
        int delay = 0;
        boolean ableToPass = false;
        while(!ableToPass) {
            ableToPass = true;
            for (int depth = 0; depth < 100; depth++) {
                if (layers.containsKey(depth)) {
                    int range = layers.get(depth);
                    int step = (2 * range) - 2;
                    if ((depth+delay)  % step == 0) {
                        ableToPass = false;
                        delay++;
                        break;
                    }
                }
            }
        }
        System.out.println(delay);
        }
    }*/
        
        //3849742
        Layer[] layers = new Layer[99];//CHANGE FOR INPUT
        for(int i = 0; i < layers.length; i++){ 
            
            boolean hasItem = false;
            int index = 0;
            
            for(int j = 0; j < list.length; j++){
                if(Integer.parseInt(list[j].split(":")[0]) == i){
                    hasItem = true;
                    index = j;
                }
            }
            if(hasItem){
                layers[i] = new Layer(Integer.parseInt(list[index].split(":")[0]),Integer.parseInt(list[index].split(":")[1].trim()), false);
            }
            else{
                layers[i] = new Layer(i,0,true);
            }
        }
        boolean sev = false;
        int delayMax = 3849740;
        
        while(true){
            delayMax += 1;
            int delay = 0;
            while(delay < delayMax){
                for(int i = 0; i < layers.length; i++){
                    if(!layers[i].empty){
                        layers[i].move();
                    }
                }
                delay += 1;
            }
            sev = false;
            for(int i = 0; i < layers.length; i++)
            {
                if(!layers[i].empty){
                    if(layers[i].scannerPos == 0){
                        //sev += i * (layers[i].range + 1);
                        sev = true;
                    }
                }

                for(Layer l : layers){
                    if(!l.empty){
                        l.move();
                    }
                }
            }
            System.out.println(delayMax);
            if(!sev){
                break;
            }
            else{
                for(int i = 0; i < layers.length; i++){
                    layers[i].scannerPos = 0;
                }
                
            }
        }
        System.out.println(delayMax);
    }
}
    
class Layer
{
    int scannerPos = 0;
    int direction = 1;
    int depth; 
    int range;
    boolean empty;
    public Layer(int depth, int range, boolean empty)
    {
        this.depth = depth;
        this.range = range-1;
        this.empty = empty;
    }
    public void move(){
        if(scannerPos == 0){
            direction = 1;
        }
        else if(scannerPos == range){
            direction = -1;
        }
        scannerPos += direction;
    }
}
