package uk.me.karlsen.ode_gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class GUI {

	private void displayGUI(){
		
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar jMenuBar = new JMenuBar();
		jFrame.setJMenuBar(jMenuBar);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		JMenuItem closeItem = new JMenuItem("Close");
		fileMenu.add(closeItem);
		JMenuItem saveItem = new JMenuItem("Save");
		fileMenu.add(saveItem);
		JMenuItem saveAsItem = new JMenuItem("Save As...");
		fileMenu.add(saveAsItem);
		
		jMenuBar.add(fileMenu);
		
		JPanel baseItemsPanel = new JPanel();
		JPanel baseMonstersPanel = new JPanel();
		JPanel characterPanel = new JPanel();
		JPanel itemModifierPanel = new JPanel();
		JPanel questsPanel = new JPanel();
		JPanel shrinesPanel = new JPanel();
		JPanel spellsPanel = new JPanel();
		JPanel uniqueItemsPanel = new JPanel();
		JPanel uniqueMonstersPanel = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Base Items", baseItemsPanel);
		tabbedPane.addTab("Base Monsters", baseMonstersPanel);
		tabbedPane.addTab("Characters", characterPanel);
		tabbedPane.addTab("Prefixes and Suffixes", itemModifierPanel);
		tabbedPane.addTab("Quests", questsPanel);
		tabbedPane.addTab("Shrines", shrinesPanel);
		tabbedPane.addTab("Spells", spellsPanel);
		tabbedPane.addTab("Unique Items", uniqueItemsPanel);
		tabbedPane.addTab("Unique Monsters", uniqueMonstersPanel);
		jFrame.add(tabbedPane);
		
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	public static void main(String[] args){
		Runnable runnable = new Runnable() {
			public void run(){
				GUI gui = new GUI();
				gui.displayGUI();
			}
		};
		SwingUtilities.invokeLater(runnable);
	}
}
