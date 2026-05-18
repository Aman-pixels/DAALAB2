import java.util.*;

public class travel
{
    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    static void tsp(int current, int count, int cost)
    {
        if(count == N && graph[current][0] > 0)
        {
            minCost = Math.min(minCost, cost + graph[current][0]);
            return;
        }

        for(int i = 0; i < N; i++)
        {
            if(!visited[i] && graph[current][i] > 0)
            {
                if(cost + graph[current][i] < minCost)
                {
                    visited[i] = true;

                    tsp(i, count + 1, cost + graph[current][i]);

                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        N = sc.nextInt();

        graph = new int[N][N];

        System.out.println("Enter cost matrix:");

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                graph[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[N];

        visited[0] = true;

        tsp(0, 1, 0);

        System.out.println("Minimum delivery cost = " + minCost);
    }
}