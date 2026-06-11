import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class Demo extends JPanel {

    final int maxCol = 15;
    final int maxRow = 10;
    final int nodeSize = 65;
    final int screenWidth = nodeSize * maxCol;
    final int screenHeight = nodeSize * maxRow;

    Node[][] node = new Node[maxCol][maxRow];
    Node startNode, goalNode, currentNode;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> checkedList = new ArrayList<>();
    boolean goalReached = false;
    int step = 0;

    // Tracks what mode the user is in: "START", "GOAL", or "WALL"
    String currentMode = "WALL";

    public Demo() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));
        this.addKeyListener(new KeyHandler(this));
        this.setFocusable(true);

        // Create all nodes - pass 'this' so each node knows the Demo
        int col = 0;
        int row = 0;
        while (col < maxCol && row < maxRow) {
            node[col][row] = new Node(col, row, this);
            this.add(node[col][row]);
            col++;
            if (col == maxCol) {
                col = 0;
                row++;
            }
        }
    }

    // Called by mode buttons in Main.java
    public void setMode(String mode) {
        currentMode = mode;
    }

    // Recalculate costs on all nodes (called after start/goal changes)
    public void recalcCosts() {
        if (startNode == null || goalNode == null) return;
        int col = 0, row = 0;
        while (col < maxCol && row < maxRow) {
            getCost(node[col][row]);
            col++;
            if (col == maxCol) { col = 0; row++; }
        }
    }

    private void getCost(Node node) {
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        node.fCost = node.gCost + node.hCost;

        if (node != startNode && node != goalNode && !node.solid) {
            node.setText("<html>F:" + node.fCost + "<br>G:" + node.gCost + "</html>");
        }
    }

    // Full reset - clears everything back to blank grid
    public void resetAll() {
        goalReached = false;
        step = 0;
        startNode = null;
        goalNode = null;
        currentNode = null;
        openList.clear();
        checkedList.clear();

        for (int c = 0; c < maxCol; c++) {
            for (int r = 0; r < maxRow; r++) {
                node[c][r].reset();
            }
        }
    }

    public void autoSearch() {
        // Safety check - need both start and goal to search
        if (startNode == null || goalNode == null) {
            System.out.println("Please set a Start and Goal first!");
            return;
        }

        // Reset search state but KEEP walls, start, goal
        goalReached = false;
        openList.clear();
        checkedList.clear();
        currentNode = startNode;

        // Reset only the search colors (not walls/start/goal)
        for (int c = 0; c < maxCol; c++) {
            for (int r = 0; r < maxRow; r++) {
                Node n = node[c][r];
                if (!n.start && !n.goal && !n.solid) {
                    n.setBackground(Color.white);
                    n.open = false;
                    n.checked = false;
                    n.parent = null;
                }
            }
        }
        recalcCosts();

        while (goalReached == false && openList.size() > 0) {
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            if (row - 1 >= 0) openNode(node[col][row - 1]);
            if (col - 1 >= 0) openNode(node[col - 1][row]);
            if (row + 1 < maxRow) openNode(node[col][row + 1]);
            if (col + 1 < maxCol) openNode(node[col + 1][row]);

            // No path found
           // No path found - surrounded by walls or blocked!
            if (openList.size() == 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "No path found!\nThe Start node is completely blocked by walls.",
                    "Path Blocked",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            int bestNodeIndex = 0;
            int bestNodefCost = 999;

            for (int i = 0; i < openList.size(); i++) {
                if (openList.get(i).fCost < bestNodefCost) {
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                } else if (openList.get(i).fCost == bestNodefCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;
                    }
                }
            }

            currentNode = openList.get(bestNodeIndex);
            if (currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
        }
        // If loop ended but goal was never reached
if (goalReached == false) {
    JOptionPane.showMessageDialog(
        this,
        " No path found!\nThe Goal is unreachable — blocked by walls.",
        "Path Blocked",
        JOptionPane.ERROR_MESSAGE
    );
}
    }

    private void openNode(Node node) {
        if (!node.open && !node.checked && !node.solid) {
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }

    private void trackThePath() {
        Node current = goalNode;
        while (current != startNode) {
            current = current.parent;
            if (current != startNode) {
                current.setAsPath();
            }
        }
    }
}