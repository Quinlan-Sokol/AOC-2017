package adventofcode;

import java.awt.Point;

public class Day3 {
    
    public static void main(String args[]) {
        Point pos = new Point(5000, 5000);
        int direction = 0; //0=right  1=up  2=left  3=down
        int distance = 1;
        int counter = 0;
        int[][] grid = new int[10000][10000];
        grid[pos.x][pos.y] = 1;
        loop:
        while(true){
            for(int i = 0; i < distance; i++){
                switch(direction){
                    case 0:
                        pos.x += 1;
                        break;
                    case 1:
                        pos.y -= 1;
                        break;
                    case 2:
                        pos.x -= 1;
                        break;
                    case 3:
                        pos.y += 1;
                        break;
                }
                
                int value = 0;
                value += grid[pos.x+1][pos.y];
                value += grid[pos.x+1][pos.y+1];
                value += grid[pos.x+1][pos.y-1];
                value += grid[pos.x][pos.y-1];
                value += grid[pos.x][pos.y+1];
                value += grid[pos.x-1][pos.y];
                value += grid[pos.x-1][pos.y+1];
                value += grid[pos.x-1][pos.y-1];
                grid[pos.x][pos.y] = value;

                if(value > 361527){
                    System.out.println(value);
                    break loop;
                }
            }
            
            counter++;
            if(counter == 2){
                counter = 0;
                distance++;
            }
            direction++;
            if(direction > 3){
                direction = 0;
            }
        }
    }
    
}
