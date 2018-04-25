# README
*Xin Yang*
*NetID: xy213*

All main functions are in the hw4_x.java.

* Q1:
 - This program using the depth first search to determine if a edge weighted digraph has a cycle in it. If
there is no cycle, the program will output “No cycle!”, otherwise it will show “Cycle exists.”. In the
given dataset, there is cycle.

* Q2:
- This program will by default print the total weight of both Prim’s algorithm and Kruskal’s algorithm.
The implementation of Prim’s is based on the eager one.

* Q5:
- This program will print all the steps of both dfs and bfs, and the first number represents the counting
number of visited vertices, the last number is the current visited vertex.

* Q6:
- Running the Djikstra’s algorithm on the datasets from Q4(a) and Q4(b) will both throw an
IllegalArgumentException, as there are negative weights in both datasets. If I delete the negative
weight detection code, then this program will fall into a dead loop because the negative weight will
always decrease the total weights and to the nature of greedy algorithm, the program will keep
following the negative weight edge.

 - The default dataset is Q4(a), to change into Q4(b), change the "dataa" in hw4_6.java:
 "List<String> data = dataLoader.loadData("./dataa.txt");"
 into "datab".


+ References of basic tools code such as Queue, MinPQ... can be seen at the link below to ensure the accuracy of experiments:
  > https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/
