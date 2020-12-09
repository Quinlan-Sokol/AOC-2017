/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

/**
 *
 * @author QDS
 */
public class Day2 {
    
    public static void main(String args[]) {
        
        int[] row1 = {278,1689,250,1512,1792,1974,175,1639,235,1635,1690,1947,810,224,928,859};
        int[] row2 = {160,50,55,81,68,130,145,21,211,136,119,78,174,155,149,72};
        int[] row3 = {4284,	185,	4499,	273,	4750,	4620,	4779,	4669,	2333,	231,	416,	1603,	197,	922,	5149,	2993};
        int[] row4 = {120,	124,	104,	1015,	1467,	110,	299,	320,	1516,	137,	1473,	132,	1229,	1329,	1430,	392};
        int[] row5 = {257,	234,	3409,	2914,	2993,	3291,	368,	284,	259,	3445,	245,	1400,	3276,	339,	2207,	233};
        int[] row6 = {1259,	78,	811,	99,	2295,	1628,	3264,	2616,	116,	3069,	2622,	1696,	1457,	1532,	268,	82};
        int[] row7 = {868,	619,	139,	522,	168,	872,	176,	160,	1010,	200,	974,	1008,	1139,	552,	510,	1083};
        int[] row8 = {1982,	224,	3003,	234,	212,	1293,	1453,	3359,	326,	3627,	3276,	3347,	1438,	2910,	248,	2512};
        int[] row9 = {4964,	527,	5108,	4742,	4282,	4561,	4070,	3540,	196,	228,	3639,	4848,	152,	1174,	5005,	202};
        int[] row10 = {1381,	1480,	116,	435,	980,	1022,	155,	1452,	1372,	121,	128,	869,	1043,	826,	1398,	137};
        int[] row11 = {2067,	2153,	622,	1479,	2405,	1134,	2160,	1057,	819,	99,	106,	1628,	1538,	108,	112,	1732};
        int[] row12 = {4535,	2729,	4960,	241,	4372,	3960,	248,	267,	230,	5083,	827,	1843,	3488,	4762,	2294,	3932};
        int[] row13 = {3245,	190,	2249,	2812,	2620,	2743,	2209,	465,	139,	2757,	203,	2832,	2454,	177,	2799,	2278};
        int[] row14 = {1308,	797,	498,	791,	1312,	99,	1402,	1332,	521,	1354,	1339,	101,	367,	1333,	111,	92};
        int[] row15 = {149,	4140,	112,	3748,	148,	815,	4261,	138,	1422,	2670,	32,	334,	2029,	4750,	4472,	2010};
        int[] row16 = {114,	605,	94,	136,	96,	167,	553,	395,	164,	159,	284,	104,	530,	551,	544,	18};
        int total = 0;
        
        total += getDifference(row1);
        total += getDifference(row2);
        total += getDifference(row3);
        total += getDifference(row4);
        total += getDifference(row5);
        total += getDifference(row6);
        total += getDifference(row7);
        total += getDifference(row8);
        total += getDifference(row9);
        total += getDifference(row10);
        total += getDifference(row11);
        total += getDifference(row12);
        total += getDifference(row13);
        total += getDifference(row14);
        total += getDifference(row15);
        total += getDifference(row16);
        
        System.out.println(total);
        
    }
    public static int getDifference(int[] row)
    {
        int num1;
        int num2;
        
        for(int i = 0; i < row.length; i++)
        {
            for(int j = 0; j < row.length; j++)
            {
                num1 = row[i];
                num2 = row[j];
                
                if(num1 != num2){
                    if(num1 % num2 == 0){
                        return num1 / num2;
                    }
                }
            }
        }
        return 0;
    }
}
