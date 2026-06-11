import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("A* Pathfinder");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        Demo demo = new Demo();

        // ── Control Panel (top bar) ──
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        controlPanel.setBackground(Color.DARK_GRAY);

        JLabel modeLabel = new JLabel("Mode: WALL");
        modeLabel.setForeground(Color.white);
        modeLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Mode buttons
        JButton btnStart = new JButton("📍 Set Start");
        JButton btnGoal  = new JButton("🎯 Set Goal");
        JButton btnWall  = new JButton("🧱 Set Wall");

        // Action buttons
        JButton btnFind  = new JButton("▶ Find Path");
        JButton btnReset = new JButton("🔄 Reset");

        // Style the buttons
        Color modeColor = new Color(70, 130, 180);
        for (JButton btn : new JButton[]{btnStart, btnGoal, btnWall}) {
            btn.setBackground(modeColor);
            btn.setForeground(Color.white);
            btn.setFocusPainted(false);
        }
        btnFind.setBackground(new Color(34, 139, 34));
        btnFind.setForeground(Color.white);
        btnFind.setFocusPainted(false);

        btnReset.setBackground(new Color(178, 34, 34));
        btnReset.setForeground(Color.white);
        btnReset.setFocusPainted(false);

        // Button actions
        btnStart.addActionListener(e -> {
            demo.setMode("START");
            modeLabel.setText("Mode: SET START");
        });
        btnGoal.addActionListener(e -> {
            demo.setMode("GOAL");
            modeLabel.setText("Mode: SET GOAL");
        });
        btnWall.addActionListener(e -> {
            demo.setMode("WALL");
            modeLabel.setText("Mode: SET WALL");
        });
        btnFind.addActionListener(e -> {
            demo.autoSearch();
            demo.requestFocusInWindow(); // keep ENTER working
        });
        btnReset.addActionListener(e -> {
            demo.resetAll();
            modeLabel.setText("Mode: WALL");
            demo.setMode("WALL");
            demo.requestFocusInWindow();
        });

        controlPanel.add(btnStart);
        controlPanel.add(btnGoal);
        controlPanel.add(btnWall);
        controlPanel.add(btnFind);
        controlPanel.add(btnReset);
        controlPanel.add(modeLabel);

        window.setLayout(new BorderLayout());
        window.add(controlPanel, BorderLayout.NORTH);
        window.add(demo, BorderLayout.CENTER);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        demo.requestFocusInWindow(); // so ENTER key works immediately
    }
}