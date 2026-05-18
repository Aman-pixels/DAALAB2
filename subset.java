import java.util.*;

public class subset
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int sum = sc.nextInt();

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 0; i <= n; i++)
        {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= sum; j++)
            {
                if(arr[i - 1] > j)
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        if(dp[n][sum])
        {
            System.out.println("Subset with given sum exists");
        }
        else
        {
            System.out.println("Subset with given sum does not exist");
        }
    }
}