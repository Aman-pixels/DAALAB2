import java.util.*;

public class nqueen
{
    static int N;
    static int[][] board;
    static int solutionCount = 0;

    static boolean isSafe(int row, int col)
    {
        for(int i = 0; i < col; i++)
        {
            if(board[row][i] == 1)
            {
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
        }

        for(int i = row, j = col; i < N && j >= 0; i++, j--)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
        }

        return true;
    }

    static void solve(int col)
    {
        if(col == N)
        {
            solutionCount++;

            System.out.println("Solution " + solutionCount + ":");

            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    System.out.print(board[i][j] + " ");
                }

                System.out.println();
            }

            System.out.println();

            return;
        }

        for(int i = 0; i < N; i++)
        {
            if(isSafe(i, col))
            {
                board[i][col] = 1;

                solve(col + 1);

                board[i][col] = 0;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        N = sc.nextInt();

        board = new int[N][N];

        solve(0);

        if(solutionCount == 0)
        {
            System.out.println("No solution exists");
        }
    }
}