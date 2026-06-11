import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Node extends JButton implements ActionListener {
    Node parent;
    int col;
    int row;
    int gCost;
    int hCost;
    int fCost;
    boolean start;
    boolean goal;
    boolean solid;
    boolean open;
    boolean checked;

    Demo demo; // reference to Demo so we know what mode is active

    public Node(int col, int row, Demo demo) {
        this.col = col;
        this.row = row;
        this.demo = demo;

        setBackground(Color.white);
        setForeground(Color.BLACK);
        addActionListener(this);
    }

    public void setAsStart() {
        setBackground(Color.blue);
        setForeground(Color.white);
        setText("Start");
        start = true;
    }

    public void setAsGoal() {
        setBackground(Color.red);
        setForeground(Color.BLACK);
        setText("Goal");
        goal = true;
    }

    public void setAsSolid() {
        setBackground(Color.black);
        setForeground(Color.black);
        setText("");
        solid = true;
    }

    public void setAsOpen() {
        open = true;
    }

    public void setAsChecked() {
        if (start == false && goal == false) {
            setBackground(Color.orange);
            setForeground(Color.black);
        }
        checked = true;
    }

    public void setAsPath() {
        setBackground(Color.green);
        setForeground(Color.black);
    }

    // Reset this node back to blank white
    public void reset() {
        setBackground(Color.white);
        setForeground(Color.black);
        setText("");
        start = false;
        goal = false;
        solid = false;
        open = false;
        checked = false;
        parent = null;
        gCost = 0;
        hCost = 0;
        fCost = 0;
    }

    // Now the click does different things depending on mode
    public void actionPerformed(ActionEvent e) {
        switch (demo.currentMode) {
            case "START":
                // Clear old start if exists
                if (demo.startNode != null) {
                    demo.startNode.reset();
                    demo.recalcCosts(); // recalculate after reset
                }
                reset();
                setAsStart();
                demo.startNode = this;
                demo.currentNode = this;
                demo.recalcCosts();
                break;

            case "GOAL":
                // Clear old goal if exists
                if (demo.goalNode != null) {
                    demo.goalNode.reset();
                }
                reset();
                setAsGoal();
                demo.goalNode = this;
                demo.recalcCosts();
                break;

            case "WALL":
                // Toggle wall on/off
                if (solid) {
                    reset(); // clicking a wall removes it
                } else if (!start && !goal) {
                    setAsSolid();
                }
                break;
        }
    }
}