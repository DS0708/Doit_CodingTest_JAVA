package Graph.플로이드워셜;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P062_11403 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[][] graph = new int[n][n];

    //input
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<n; j++){
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    //Floyd-warshall
    for(int k=0; k<n; k++){
      for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          if (graph[i][k] + graph[k][j] == 2)
            graph[i][j] = 1;
        }
      }
    }

    //output
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        bw.write(graph[i][j]+" ");
      }
      bw.write('\n');
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
