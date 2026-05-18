import java.util.*;

class Edge
{
    int src, dest, weight;

    Edge(int s, int d, int w)
    {
        src = s;
        dest = d;
        weight = w;
    }
}

public class bellman
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];

        System.out.println("Enter source destination weight:");

        for(int i = 0; i < E; i++)
        {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(s, d, w);
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        for(int i = 1; i < V; i++)
        {
            for(int j = 0; j < E; j++)
            {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                {
                    dist[v] = dist[u] + w;
                }
            }
        }

        boolean negativeCycle = false;

        for(int j = 0; j < E; j++)
        {
            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;

            if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
            {
                negativeCycle = true;
                break;
            }
        }

        if(negativeCycle)
        {
            System.out.println("Graph contains negative weight cycle");
        }
        else
        {
            System.out.println("Shortest distances from source:");

            for(int i = 0; i < V; i++)
            {
                System.out.println("Vertex " + i + " : " + dist[i]);
            }
        }
    }
}