/*
 * To change this license header,choose License Headers in Project Properties.
 * To change this template file,choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.ArrayList;

/**
 *
 * @author QDS
 */
public class Day7 {
    public static void main(String args[])
    {
        String[] temp = {"pbga (66)",
"xhth (57)",
"ebii (61)",
"havc (66)",
"ktlj (57)",
"fwft (72)->ktlj,cntj,xhth",
"qoyq (66)",
"padx (45)->pbga,havc,qoyq",
"tknk (41)->ugml,padx,fwft",
"jptl (61)",
"ugml (68)->gyxo,ebii,jptl",
"gyxo (61)",
"cntj (57)"};
                
        ArrayList<String> names = new ArrayList();
        ArrayList<String> tempPrograms = new ArrayList();
        ArrayList<String> weights = new ArrayList();
        
        for(int i = 0; i < temp.length; i++)
        {
            if(temp[i].contains("->"))
            {
                names.add(temp[i].split("->")[0].split(" ")[0]);
                weights.add(temp[i].split("->")[0].split(" ")[1].replace("(","").replace(")",""));
                tempPrograms.add(temp[i].split("->")[1]);
            }
            else{
                names.add(temp[i].split(" ")[0]);
                weights.add(temp[i].split(" ")[1].replace("(","").replace(")",""));
            }
        }
        //SPLITTING UP PROGRAMS
        ArrayList<String> programs = new ArrayList();
        for(int i = 0; i < tempPrograms.size(); i++)
        {
            String[] split = tempPrograms.get(i).split(",");
            
            for(int k = 0; k < split.length; k++){
                programs.add(split[k]);
            }
        }
        
        ArrayList<String> common = new ArrayList<String>(names);
        common.retainAll(programs);
        for(int i = 0; i < names.size(); i++)
        {
            if(!common.contains(names.get(i)))
            {
                System.out.println(names.get(i));
            }
        }
    }
}
