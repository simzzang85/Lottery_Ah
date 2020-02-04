package com.simstudious.lottery_ah;

import java.util.Random;
import java.util.*;
import android.util.Log;

public class LotteryLib
{
    static int[] numbers = new int[6];
    static int[] spNumber = new int[1];
    static int[] rtnNumbers = new int[6];
    static Random random = new Random();
    public static int[] LotteryAh(String type)
    {
        for (int i = 0; i < 6; i++)
        {
            //initiate
            numbers[i] = 0;
        }
        //List<Lottery> lotteries = new List<Lottery>();
        int[] num = LotteryType(type);
        int[] order = new int[6];
        int normal = num[0]; //normal 5 numbers
        int special = num[1]; // special 1 number
        for (int i = 0; i < 6; i++)
        {
            int number = PickNum(type, normal);
            Log.v("PickNum","LotteryAh:::::"+ type+"::number::"+num[0]);
            numbers[i] = number;
            normal--;
        }

        int specialNumber = 0;//PickSpecialNum(special);
        spNumber[0] = specialNumber;
        Log.v("PickNum","LotteryAh:::::"+ type+"::number::"+spNumber[0]);
        //normal--;
        order = Ordering(numbers);
        //Log.v("PickNum","LotteryAh:::::"+ type+"::order::"+order);
        for (int i = 0; i < 6; i++)
        {
            if (i < 6)
            {
                rtnNumbers[i] = order[i];
            }
            else
            {
                rtnNumbers[i] = spNumber[0];
            }
        }
        return rtnNumbers;
    }
    //pick real lottery numbers
    public static int PickNum(String type, int number)
    {
        //Log.v("PickNum","TYPE:::::"+ type+"::number::"+number);
        int rtn_value = 0;
        int[] totNum = new int[number];
        totNum = PlaceNumToArry(type, number);
        rtn_value = totNum[PickOne(number)];
        return rtn_value;
    }
    //pick real lottery numbers
    public static int PickSpecialNum(int number)
    {
        int rtn_value = 0;
        int[] totNum = new int[number];
        totNum = PlaceSpecialNumToArry(number);
        rtn_value = totNum[PickOne(number)];
        return rtn_value;
    }
    //check already picked number and placing numbers without picked numbers
    public static int[] PlaceNumToArry(String type, int number)
    {
        Log.v("PlaceNumToArry","TYPE:::::"+ type+"::number::"+number);
        int[] rtnNum = new int[number];
        int checkCnt = 0;
        int totNumbers = 0;
        if (type == "pw")
        {
            totNumbers = 45;
        }

        //put number in array 1 to 69 except already picked numbers
        for (int i = 0; i < totNumbers; i++)
        {
            if (CheckNextCnt() == 0)
            {
                //input all number in array
                rtnNum[checkCnt] = i + 1;
                checkCnt++;
            }
            else
            {
                if (CheckPickedNumber(i + 1))
                {
                    rtnNum[checkCnt] = i + 1;
                    checkCnt++;
                }
            }
        }
        //Log.v("PlaceNumToArry222222","TYPE:::::::number::"+rtnNum[0]+"::"+rtnNum[1]+"::"+rtnNum[2]+"::"+rtnNum[3]+"::"+rtnNum[4]);
        rtnNum = ReSuffle(rtnNum);
        //Log.v("PlaceNumToArry333333","TYPE::::::number::"+rtnNum[0]+"::"+rtnNum[1]+"::"+rtnNum[2]+"::"+rtnNum[3]+"::"+rtnNum[4]);
        return rtnNum;
    }
    //check already picked number and placing numbers without picked numbers
    public static int[] PlaceSpecialNumToArry(int number)
    {
        int[] rtnNum = new int[number];
        int checkCnt = 0;
        //put number in array 1 to 69 except already picked numbers
        for (int i = 0; i < number; i++)
        {
            //input all number in array
            rtnNum[checkCnt] = i + 1;
            checkCnt++;
        }
        rtnNum = ReSuffle(rtnNum);
        return rtnNum;
    }
    public static int CheckNextCnt()
    {
        int count = 0;
        for (int i = 0; i < 6; i++)
        {
            if (numbers[i] == 0)
            {
                count++;
            }
        }
        count = 6 - count;
        return count;
    }
    public static Boolean CheckPickedNumber(int number)
    {
        Boolean flag = true;
        int cnt = 0;
        for (int i = 0; i < CheckNextCnt(); i++)
        {
            if (number == numbers[i])
            {
                cnt++;
            }
        }
        if (cnt > 0)
        {
            flag = false;
        }
        else
        {
            flag = true;
        }
        return flag;
    }
    public static void PlacingArry(int number, int order)
    {
        int placement = 6 - order;
        numbers[placement] = number;
    }
    public static int PickOne(int number)
    {
        int rtn_one = 0;
        rtn_one = random.nextInt( number);

        return rtn_one;
    }
    //return lottery types normal numbers and special number
    public static int[] LotteryType(String type)
    {
            /*int powerball = 69;
            int powerballSP = 26;
            int cashforlife = 60;
            int cashforlifeSP = 4;
            int megamil = 70;
            int megamilSP = 25;*/
        int[] rtnVal = new int[2];
        /*
        final Lottery lottery = new Lottery();
        List<Lottery> lotteryList = new ArrayList<Lottery>()
        {
                    new Lottery(){ lottery.type="pw", lottery.normal=69, lottery.special=26 },
                    new Lottery(){ lottery.type="mg", lottery.normal=70, lottery.special=25 },
                    new Lottery(){ lottery.type="cash", lottery.normal=60, lottery.special=4 }
        };

        rtnVal[0] = lotteryList.Find(x => x.type.Contains(type)).Normal;
        rtnVal[1] = lotteryList.Find(x => x.type.Contains(type)).Special;
        */
        //Log.v("LOTTERYLIB","TYPE:::::"+ type);
        if(type=="pw") {
            rtnVal[0] = 45;
            rtnVal[1] = 26;
        }else if(type=="mg"){
            rtnVal[0] = 70;
            rtnVal[1] = 25;
        }else{
            rtnVal[0] = 60;
            rtnVal[1] = 4;
        }


        return rtnVal;
    }

    public static int[] ReSuffle(int[] n)
    {
        for (int t = 0; t < n.length; t++)
        {
            int tmp = n[t];
            int r = random.nextInt( n.length);
            n[t] = n[r];
            n[r] = tmp;
        }
        return n;
    }
    public static int[] Ordering(int[] n)
    {
        //tmp = n.OrderBy(i => i).ToArray();
        Arrays.sort(n);
        return n;
    }
}
//class Lottery
//{
//    public String type { get; set; }
//    public int Normal { get; set; }
//    public int Special { get; set; }

//}
