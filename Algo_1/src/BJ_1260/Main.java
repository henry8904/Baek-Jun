package BJ_1260;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int node[][];
	static boolean check[];
	static int N;
	
	public static void dfs(int V) {
		System.out.print(V);
		check[V] = true;
		for(int i = 0; i <= N; i++) {
			if(node[V][i] == 1 && check[i] == false) {
				System.out.print(" ");
				dfs(i);
			}
		}
	}
	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[V] = true;
		q.add(V);
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for(int i = 0; i <= N; i++) {
				if(node[temp][i] == 1 && check[i] == false) {
					q.add(i);
					check[i] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String firstLine[] = input.split(" ");
		int firstLineTemp[] = Arrays.asList(firstLine).stream().mapToInt(Integer::parseInt).toArray();
		N = firstLineTemp[0];
		
		int M = firstLineTemp[1];
		
		int V = firstLineTemp[2];
		
		node = new int[N+1][N+1];
		check = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			String inputTemp = sc.nextLine();
			String secondLine[] = inputTemp.split(" ");
			int secondLineTemp[] = Arrays.asList(secondLine).stream().mapToInt(Integer::parseInt).toArray();
			int x = secondLineTemp[0];
			
			int y = secondLineTemp[1];
			
			node[x][y] = 1;
			node[y][x] = 1;
		}
		for(int i = 0; i <= N; i++) {
			check[i] = false;
		}
		dfs(V);
		for(int i = 0; i <= N; i++) {
			check[i] = false;
		}
		System.out.println("");
		bfs(V);
		
	}
}
