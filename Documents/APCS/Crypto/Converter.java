import java.util.*;

public class Converter{
    public String convert(String binary)
    {
        String s2 = "";   
        char nextChar;
        String[] stringBytes = new String[((binary.length()) / 8) + 1];
        int p = 0;
        String temp = "";
        for(int i = 0; i < binary.length(); i ++)
        {
            if(!(binary.substring(i, i + 1).equals(" ")))
                temp += binary.substring(i, i + 1);
            else
            {
                stringBytes[p] = temp;
                p++;
                temp = "";
            }
        }
        //return stringBytes;
        for(int i = 0; i < stringBytes.length; i ++)
        {
            try{
                nextChar = (char)Integer.parseInt(stringBytes[i], 2);
                s2 += nextChar;
            }
            catch(Exception e){}        
        }
        System.out.println(s2);
        return s2;
    }

    public static void main(String args)
    {
        Converter tim = new Converter();
        tim.convert(args);
    }
}

