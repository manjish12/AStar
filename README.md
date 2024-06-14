Pathfinding Using A*.

The A* (A-star) algorithm is a popular pathfinding algorithm used in various applications such as robotics, video games, and route planning. It efficiently finds the shortest path between two points on a graph, taking into account both the cost of reaching each node and the estimated cost from the current node to the goal node.
This Pathfinding project is a Java application, designed to visualize pathfinding algorithms on a grid-based map. It allows users to set start and goal points, add obstacles, and visualize the process of finding the shortest path between the start and goal points using the A* algorithm.

Here,

gCost: Represents the cost of reaching the current node from the start node.

hCost: Estimates the cost of reaching the goal node from the current node.

fCost: Total estimated cost of reaching the goal through the current node (sum of gCost and hCost). It guides the A* algorithm in selecting the most promising nodes to explore next.

Components
1. Main Class (Main.java):
The entry point of the application.
Initializes the JFrame window and adds an instance of the Demo class to it.
   
2. Demo Class (Demo.java):
Extends JPanel and represents the main visualization panel.
Contains the grid of nodes, start and goal nodes, open and checked lists, and methods for pathfinding.
Initializes the grid, sets up start and goal nodes, adds obstacles, and calculates costs for nodes.
Provides methods for manual search and autosearch (running A* algorithm).
Implements synchronization to ensure thread safety when accessing shared data structures.
   
3. Node Class (Node.java):
Represents individual nodes on the grid.
Extends JButton and implements ActionListener.
Contains properties such as position, costs, and flags for start, goal, solid, open, and checked nodes.
Provides methods to set node properties and handle node clicks.

4. KeyHandler Class (KeyHandler.java):
Implements KeyListener to handle keyboard input.
Listens for the ENTER key press to trigger autosearch.

How it Runs:

To execute the program and visualize the pathfinding algorithm in action, you should run the "Main.java" class, as it serves as the entry point for the application. Once     executed, the program will display a graphical user interface (GUI) window containing the grid-based visualization panel. From there, you can interact with the program by    setting start and goal points, adding obstacles, and triggering the pathfinding algorithm automatically.

Initialization:
Upon running the application, a JFrame window is displayed with the grid-based visualization panel.
The grid is initialized with nodes, and start and goal nodes are set.
Obstacles are added to the grid.

Autosearch:
Users can trigger autosearch by pressing the ENTER key.
The autosearch algorithm (A*) runs continuously until the goal is reached or a maximum step limit is reached.
The process visualizes the pathfinding algorithm in action, updating the nodes as the algorithm progresses.

Path Visualization:
Once the goal is reached, the shortest path from the start to the goal is highlighted in green.
Users can observe the final path from the start to the goal, along with the nodes checked by the algorithm.

Conclusion
The Pathfinding Visualization project provides a visual representation of the A* algorithm for finding the shortest path in a grid-based environment. It allows users to interactively explore pathfinding concepts and observe the algorithm's behavior in real-time.
