package com.cybage.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

// A Java program to print topological sorting of a DAG

// This class represents a directed graph using adjacency
// list representation
class Graph
{
    private int Vertices;   // No. of vertices
    private LinkedList<Integer> adjecents[]; // Adjacency List
 
    //Constructor
    Graph(int vertices)
    {
        Vertices = vertices;
        adjecents = new LinkedList[vertices];
        for (int i=0; i<vertices; ++i)
            adjecents[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w) { adjecents[v].add(w); }
 
    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[],
                             Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adjecents[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
 
        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }
 
    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    void topologicalSort()
    {
        Stack stack = new Stack();
 
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[Vertices];
        for (int i = 0; i < Vertices; i++)
            visited[i] = false;
 
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < Vertices; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
 
        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
 
    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 2);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " + "sort of the given graph");
        g.topologicalSort();
    }
}
