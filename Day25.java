/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.ArrayList;


/**
 *
 * @author QDS
 */
public class Day25 {
    public static void main(String args[])
    {
        String state = "A";
        ArrayList<Double> tape = new ArrayList();
        double cursor = 0;
        int c = 0;
        
        for(int i = 0; i < 12134527; i++)
        {
            switch(state){
                case "A":
                    if(tape.contains(cursor)){ //value is 1
                        tape.remove(cursor);
                        cursor -= 1;
                        state = "C";
                    }
                    else{ //value is 0
                        tape.add(cursor);
                        cursor += 1;
                        state = "B";
                    }
                    break;
                case "B":
                    if(tape.contains(cursor)){ //value is 1
                        cursor += 1;
                        state = "C";
                    }
                    else{ //value is 0
                        tape.add(cursor);
                        cursor -= 1;
                        state = "A";
                    }
                    break;
                case "C":
                    if(tape.contains(cursor)){ //value is 1
                        tape.remove(cursor);
                        cursor -= 1;
                        state = "D";
                    }
                    else{ //value is 0
                        tape.add(cursor);
                        cursor += 1;
                        state = "A";
                    }
                    break;
                case "D":
                    if(tape.contains(cursor)){ //value is 1
                        cursor -= 1;
                        state = "C";
                    }
                    else{ //value is 0
                        tape.add(cursor);
                        cursor -= 1;
                        state = "E";
                    }
                    break;
                case "E":
                    if(tape.contains(cursor)){ //value is 1
                        cursor += 1;
                        state = "A";
                    }
                    else{ //value is 0
                        tape.add(cursor);
                        cursor += 1;
                        state = "F";
                    }
                    break;
                case "F":
                    if(tape.contains(cursor)){ //value is 1
                        cursor += 1;
                        state = "E";
                    }
                    else{ //value is 0
                        tape.add(cursor);
                        cursor += 1;
                        state = "A";
                    }
                    break;
            }
        }
        System.out.println(tape.size());
    }
}
