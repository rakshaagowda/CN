package CN_LAB;

import java.util.Arrays;
import java.util.Scanner;
public class BellmanFord {
    public static void BellmanFordAlgorith(int graph[][],int source){
        int n=graph.length;
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        for(int i=0;i<n-1;i++){
            for(int u=0;u<n;u++){
                for(int v=0;v<n;v++){
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                        dist[v]=dist[u]+graph[u][v];
                    }
                    }
                }
            }

            for(int u=0;u<n;u++){
                for(int v=0;v<n;v++){
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v])
                    {
                        System.out.println("Graph contains negative weight cycle");
                        return;
                    }
                }
            }

        System.out.println("Vertex Distance from Source");
        for(int i=0;i<n;i++){
            System.out.println(i+"\t\t"+dist[i]);
        }
     
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int graph[][] = new int[n][n];
        System.out.println("Enter the adjacency matrix (use 0 for no edge):");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=sc.nextInt();
            }
        }
        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();
        BellmanFordAlgorith(graph,source-1);
        sc.close();
    }
}