import java.util.*;

public class boyersearch
{
    static final int SIZE = 256;

    static void badCharacter(String pattern, int[] badChar)
    {
        for(int i = 0; i < SIZE; i++)
        {
            badChar[i] = -1;
        }

        for(int i = 0; i < pattern.length(); i++)
        {
            badChar[(int)pattern.charAt(i)] = i;
        }
    }

    static void search(String text, String pattern)
    {
        int m = pattern.length();
        int n = text.length();

        int[] badChar = new int[SIZE];

        badCharacter(pattern, badChar);

        int shift = 0;

        boolean found = false;

        while(shift <= (n - m))
        {
            int j = m - 1;

            while(j >= 0 && pattern.charAt(j) == text.charAt(shift + j))
            {
                j--;
            }

            if(j < 0)
            {
                System.out.println("Pattern found at position: " + shift);
                found = true;

                if(shift + m < n)
                {
                    shift += m - badChar[text.charAt(shift + m)];
                }
                else
                {
                    shift += 1;
                }
            }
            else
            {
                shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
            }
        }

        if(!found)
        {
            System.out.println("Pattern not found");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = sc.nextLine();

        search(text, pattern);
    }
}