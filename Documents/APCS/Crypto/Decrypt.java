import java.util.*;

public class Decrypt
{
    private static String k;
    private String[] encodedword;
    String dec;
    public static void main(String input)
    {
        Decrypt decoded = new Decrypt();
        k = "";
        Scanner reader = new Scanner(System.in);
        Converter tim = new Converter();
        while(k.length() != 8)
        {
            System.out.println("enter k(8 chars): ");
            k = reader.nextLine();
        }
        System.out.println("k stored.");
        System.out.println("Encrypted binary:");
        System.out.println(input);
        System.out.println("Decrypted binary:");
        String dec = decoded.decrypto(input, decoded.k);
        System.out.print(dec);
        String finals = tim.convert(dec);
        System.out.println("Decrypted ascii:");
        System.out.println(finals);
    }

    public String decrypto(String eight, String key)
    {
        String j = "";
        int y = 0;
        int i = 0;
        int p = 0;
        String[] f = new String[eight.length() / 8];
        String s = "";
        while(y < eight.length())
        {
            if((eight.substring(y, y + 1)).equals(" "))
            {
                y++;
                //j += " ";
                continue;
            }
            if(!(eight.substring(y, y + 1).equals(key.substring(i, i + 1))))
                j += "0";
            else
                j += "1";
            y++;
            i++;
            if(i >= 8)
            {
                i = 0; 
                //p(j);
                f[p] = j;
                s += (j + " ");
                p++;
                j = "";
            }
        }
        return s;
    }

    public void p(String s)
    {
        System.out.println(s);
    }
}
