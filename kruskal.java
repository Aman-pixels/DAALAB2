import java.util.*;

class Edge implements Comparable<Edge>
{
    int src, dest, weight;

    Edge(int s, int d, int w)
    {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge e)
    {
        return this.weight - e.weight;
    }
}

public class kruskal
{
    static int[] parent;

    static int find(int x)
    {
        if(parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y)
    {
        int px = find(x);
        int py = find(y);

        parent[px] = py;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        Edge[] edges = new Edge[e];

        System.out.println("Enter source destination weight:");

        for(int i = 0; i < e; i++)
        {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(s, d, w);
        }

        Arrays.sort(edges);

        parent = new int[v];

        for(int i = 0; i < v; i++)
        {
            parent[i] = i;
        }

        int totalCost = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        for(int i = 0; i < e; i++)
        {
            int u = edges[i].src;
            int d = edges[i].dest;
            int w = edges[i].weight;

            if(find(u) != find(d))
            {
                union(u, d);

                System.out.println(u + " - " + d + " : " + w);

                totalCost += w;
            }
        }

        System.out.println("Minimum Cost = " + totalCost);
    }
}