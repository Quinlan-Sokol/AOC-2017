
import java.util.ArrayList;



public class Day6 {
    public static void main(String args[])
    {
        int[] blocks = {11,11,13,7,0,15,5,5,4,4,1,1,7,1,15,11}; 
        
        ArrayList<String> memory = new ArrayList();
        memory.add(setString(blocks));
        
        int maxNum;
        int maxIndex = 0;
        int count = 0;
        int cycles = 0;
        boolean d1 = true;
        boolean endLoop = false;

        while(!endLoop)
        {
            maxNum = 0;

            //FINDING HIGHEST NUMBER
            for(int i = 0; i < blocks.length; i++)
            {
                if(blocks[i] > maxNum){
                    maxNum = blocks[i];
                    maxIndex = i;
                }
            }

            //MOVING BLOCKS
            blocks[maxIndex] = 0;
            int index = maxIndex;
            for(int i = 0; i < maxNum; i++)
            {
                index += 1;
                if(index > 15){
                    index = 0;
                } 
                blocks[index] += 1;
            }
            
            count += 1;
            if(!d1){
                cycles += 1;
            }
            
            for(int i = 0; i < memory.size(); i++)
            {
                if(memory.get(i) == null ? setString(blocks) == null : memory.get(i).equals(setString(blocks)))
                {
                    if(!d1){
                        endLoop = true;
                    }
                    else{
                        d1 = false;
                        String temp = memory.get(i);
                        memory.clear();
                        memory.add(temp);
                        
                    }
                }
            }
            memory.add(setString(blocks));
        }
        System.out.println(cycles);
    }
    
    
    public static String setString(int[] array)
    {
        String result = "";
        for(int i = 0; i < array.length; i++){
            result += Integer.toString(array[i]);
        }
        return result;
    }
}
