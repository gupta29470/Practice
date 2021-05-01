package javaapplication1;

/**
 *
 * @author Aakash
 */
import java.util.*;

public class Graph_Intro {

    static int v = 5;
    static int matrix[][];

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge_AdjancencyList(adj, 0, 1);
        addEdge_AdjancencyList(adj, 0, 2);
        addEdge_AdjancencyList(adj, 1, 2);
        addEdge_AdjancencyList(adj, 1, 3);
        addEdge_AdjancencyList(adj, 1, 4);
        addEdge_AdjancencyList(adj, 2, 3);
        addEdge_AdjancencyList(adj, 3, 4);
        print_AdjanencyList(adj);

        matrix = new int[v][v];
        addEdge_AdjancencyMatrix(matrix, 0, 0);
        addEdge_AdjancencyMatrix(matrix, 0, 1);
        addEdge_AdjancencyMatrix(matrix, 0, 2);
        addEdge_AdjancencyMatrix(matrix, 1, 2);
        addEdge_AdjancencyMatrix(matrix, 1, 3);
        addEdge_AdjancencyMatrix(matrix, 1, 4);
        addEdge_AdjancencyMatrix(matrix, 2, 3);
        addEdge_AdjancencyMatrix(matrix, 3, 4);
        print_AdjancencyyMatrix(matrix);

    }

    static void addEdge_AdjancencyList(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        // For undirected 
        adj.get(u).add(v);
        adj.get(v).add(u);

        // For directed
        //adj.get(u).add(v);
    }

    static void addEdge_AdjancencyMatrix(int matrix[][], int u, int v) {
        // For undirected 
        matrix[u][v] = 1;
        matrix[v][u] = 1;
        // For directed
        //matrix[u][v]=1;
    }

    static void print_AdjanencyList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjancency of vertex:" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" ---> " + adj.get(i).get(j));
            }
            System.out.println("");

        }
        System.out.println("");

    }

    static void print_AdjancencyyMatrix(int matrix[][]) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");

        }
        for (int i = 0; i < v; i++) {
            System.out.println("Adjancency of Matrix:" + i);
            System.out.print("head");
            for (int j = 0; j < v; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print("-->" + j);
                }
            }
            System.out.println("");
        }

    }
}
