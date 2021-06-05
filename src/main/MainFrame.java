package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Rectangle;

public class MainFrame extends JFrame {

	private static JPanel MainPanel;
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
	public MainFrame() {
		setResizable(false);
		setTitle("SAKSHI COMPUTERS AND COMMERCE ACADEMY\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 750);
		MainPanel = new JPanel();
		MainPanel.setBounds(new Rectangle(0, 0, 1366, 750));
		MainPanel.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		AddPanel(new MainPanel());
		
	}
	public static void AddPanel(JPanel p)
	{
		MainFrame.RemoveAllPanel();
		p.setBounds(new Rectangle(0, 0, 1366, 750));
		MainPanel.add(p);
	}
	public static void RemoveAllPanel()
	{
		MainPanel.removeAll();
		MainPanel.repaint();
		MainPanel.revalidate();
	}
	public static Rectangle Dimensions()
	{
		return MainPanel.getBounds();
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}