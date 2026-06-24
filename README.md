# A* Pathfinder Visualizer 🗺️

A visual pathfinding application built with Java Swing that demonstrates
the A* search algorithm. Users can interactively set start/goal points,
draw walls, and watch the algorithm find the shortest path.

---

## 📸 How It Looks
[Start] → 🟠 explored nodes → 🟢 shortest path → [Goal]

---

## ✨ Features

- Set **Start** point by clicking any cell in Start mode
- Set **Goal** point by clicking any cell in Goal mode
- Draw **Walls** (blockades) by clicking cells in Wall mode
- Click a wall again to **remove** it
- Press **Find Path** button or **ENTER** key to start search
- Shows **error popup** if no path exists
- **Reset** button clears the entire grid

---

## 🚀 How to Run

### Requirements
- Java JDK 17 or higher → [Download here](https://adoptium.net)
- VS Code with [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

### Steps
1. Clone this repository:
```bash
   git clone https://github.com/manjish12/AStar.git
```
2. Open the folder in VS Code
3. Open `Main.java`
4. Click the ▶ Run button above the main method
5. or
6. Open terminal in vs-code or cmd
7. Compile Demo, Node, KeyHandler.java by running command      `javac Demo.java` for all the `.java file`in terminal
8. Then, run `Main.java` using command `java Main`

---

## 🎮 How to Use

| Step | Action |
|------|--------|
| 1 | Click **📍 Set Start** button, then click a cell on the grid |
| 2 | Click **🎯 Set Goal** button, then click a cell on the grid |
| 3 | Click **🧱 Set Wall** button, then click cells to draw walls |
| 4 | Press **▶ Find Path** or hit **ENTER** |
| 5 | Green cells show the shortest path! |
| 6 | Click **🔄 Reset** to start over |

---

## 🧠 How A* Works (Simple Explanation)

Each cell has 3 costs:

| Cost | Meaning |
|------|---------|
| **G Cost** | Distance from Start |
| **H Cost** | Estimated distance to Goal |
| **F Cost** | G + H (lower = better candidate) |

The algorithm always picks the cell with the **lowest F Cost** next,
guaranteeing the shortest path.

---

## 📁 Project Structure
astar-pathfinder/
|── src
|── Main.java        → Opens the window
│── Demo.java        → Grid logic + A* algorithm
│── Node.java        → Each cell/button on the grid
│── KeyHandler.java  → Handles ENTER key press
└── README.md

---

## 🛠️ Built With

- Java 17+
- Java Swing (GUI)
- A* Search Algorithm

---