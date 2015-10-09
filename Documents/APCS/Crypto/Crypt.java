import java.util.*;

public class Crypt
{   
    private static String k;
    private String[] word;
    public static void main(String input)
    {
        Crypt encoded = new Crypt();
        k = "";
        Scanner reader = new Scanner(System.in);
        while(k.length() != 8)
        {
            System.out.print("enter k(8 chars): ");
            k =reader.nextLine();
        }
        System.out.println("k stored.");
        encoded.word = new String[input.length()];
        for (int a = 0; a < input.length(); a++) {
            byte[] b = new byte[1024];
            b = input.getBytes();
            encoded.word[a] = ("0" + Integer.toBinaryString(b[a]));
        }
        
        encoded.test(encoded.word);
        
        System.out.println("Here is the binary of your message:");
        encoded.printArray(encoded.word);

        for(int i = 0; i < encoded.word.length; i ++)
        {
            encoded.word[i] = encoded.crypto(encoded.word[i], encoded.k);
        }
        System.out.println("Here is the encoded binary of your message:");
        encoded.printArray(encoded.word);
    }

    public boolean check(String k)
    {
        if((k.length() != 8))
        {
            System.out.println("check k");
            return false;
        }
        for(int i = 0; i < k.length(); i++)
        {
            if(!((k.substring(i, i + 1) != "1") && (k.substring(i, i + 1) != "0")))
            {
                System.out.println("check k");
                return false;
            }
        }
        return true;
    }

    public String getK()
    {
        return k;
    }

    public void promptK()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("enter k");
        String notm = reader.nextLine();
        if(notm.equals("exit"))
            System.exit(0);
        else if(!check(notm))
            promptK();
        else
            k = notm;
    }

    public void printArray(String[] array)
    {
        for(int i = 0; i < array.length; i ++)
        {
            if(array[i] != null)
                System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public String crypto(String eight, String key)
    {
        String j = "";
        for(int i = 0; i < 8; i ++)
        {
            if(!(eight.substring(i, i + 1).equals(key.substring(i, i + 1))))
                j += "0";
            else
                j += "1";
        }
        return j;
    }
    
    public void test(String[] g)
    {
        for(int i = 0; i < g.length; i ++)
        {
            if(g[i].length() < 8)
            {
            g[i] = ("0" + g[i]);
            i--;
        }
        }
    }
}