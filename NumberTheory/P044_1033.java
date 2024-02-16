package NumberTheory;

import java.util.ArrayList;
import java.util.Scanner;

public class P044_1033 {
    static ArrayList<Node>[] A;
    static long lcm; //최소 공배수
    static boolean visited[];
    static long D[];
    public static void main(String[] args) {
        //init
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        for(int i=0; i<N; i++) A[i] = new ArrayList<>();

        // 그래프 만들기, 최소 공배수 구하기
        for (int i=0; i<N-1; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            A[a].add(new Node(b,p,q));
            A[b].add(new Node(a,q,p));
            lcm *= p*q/gcd(p,q);
        }

        //시작점 최소 공배수로 초기화 하기
        D[0] = lcm;
        // 시작점으로 부터 DFS 실행
        DFS(0);

        //거리들의 최대 공약수 구하기
        long mgcd = D[0];
        for (int i=1; i<D.length; i++){
            mgcd = gcd(mgcd,D[i]); //a,b,c 의 최대공약수는 gcd(a,b)와 c의 최대 공약수
        }

        //결과 출력
        for(int i=0; i<N; i++) System.out.print(D[i]/mgcd+" ");
    }

    public static void DFS(int node){
        visited[node] = true;
        for (int i=0; i<A[node].size(); i++){
            Node current = A[node].get(i);
            int next = current.getB();
            if (visited[next]==false) {
                D[next] = D[node] * current.q / current.p; // a : b = p : q 일떄 b*p = a*q ->  b = a * q / p
                DFS(next);
            }
        }
    }

    public static long gcd(long n1,long n2){
        if (n2 ==0 ) return n1;
        else return gcd(n2,n1%n2);
    }
}

class Node{
    int b;
    int p;
    int q;

    public Node(int b,int p, int q){
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB(){
        return this.b;
    }

    public int getP(){
        return this.p;
    }

    public int getQ(){
        return this.q;
    }
}
