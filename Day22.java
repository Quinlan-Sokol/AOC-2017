/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author QDS
 */
public class Day22 {
    public static void main(String args[]){
        String[] map = {"#.#...###.#.##.#....##.##",
"..####.#.######....#....#",
"###..###.#.###.##.##..#.#",
"...##.....##.###.##.###..",
"....#...##.##..#....###..",
"##.#..###.#.###......####",
"#.#.###...###..#.#.#.#.#.",
"###...##..##..#..##......",
"##.#.####.#..###....#.###",
".....#..###....######..##",
".##.#.###....#..#####..#.",
"########...##.##....##..#",
".#.###.##.#..#..#.#..##..",
".#.##.##....##....##.#.#.",
"..#.#.##.#..##..##.#..#.#",
".####..#..#.###..#..#..#.",
"#.#.##......##..#.....###",
"...####...#.#.##.....####",
"#..##..##..#.####.#.#..#.",
"#...###.##..###..#..#....",
"#..#....##.##.....###..##",
"#..##...#...##...####..#.",
"#.###..#.#####.#..#..###.",
"###.#...#.##..#..#...##.#",
".#...#..#.#.#.##.####...."};
        Map<String, Integer> visited = new HashMap(); // 0 = clean  1 = infected
        int count = 0;
        int direction = 0; //0 = up  1 = right  2 = down  3 = left
        Point pos = new Point(0,0);
        
        int X = -(map.length-1) / 2;
        int Y = (map.length-1) / 2;
        for(String str : map){
            for(char c : str.toCharArray()){
                if(c == '#'){
                    visited.put(new Point(X, Y).toString(), 1);
                }
                X++;
            }
            Y--;
            X = -(map.length-1) / 2;
        }
        
        for(int k = 0; k < 10000; k++){
            if(!visited.containsKey(pos.toString())){
                visited.put(pos.toString(), 0);
            }
            
            if(visited.get(pos.toString()) == 0){//clean
                direction++;
                if(direction > 3)   direction = 0;
                visited.put(pos.toString(), 1);
                count++;
            }else{//infected
                direction--;
                if(direction < 0)   direction = 3;
                visited.put(pos.toString(), 0);
            }
            
            switch(direction){
                case 0:
                    pos.translate(0, 1);
                    break;
                case 1:
                    pos.translate(1, 0);
                    break;
                case 2:
                    pos.translate(0, -1);
                    break;
                case 3:
                    pos.translate(-1, 0);
                    break;
            }
        }
        System.out.println(count);
    }  
}

