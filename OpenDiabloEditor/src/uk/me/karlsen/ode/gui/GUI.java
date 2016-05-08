package uk.me.karlsen.ode.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.BaseItemStore;
import uk.me.karlsen.ode.stores.BaseMonsterStore;
import uk.me.karlsen.ode.stores.CharacterStore;
import uk.me.karlsen.ode.stores.ItemModifiersStore;
import uk.me.karlsen.ode.stores.QuestStore;
import uk.me.karlsen.ode.stores.ShrinesStore;
import uk.me.karlsen.ode.stores.SpellsStore;
import uk.me.karlsen.ode.stores.UniqueItemStore;
import uk.me.karlsen.ode.stores.UniqueMonsterStore;
import uk.me.karlsen.ode.types.ItemEffect;
import uk.me.karlsen.ode.types.UniqueItem;

public class GUI {
	
	public GUI() {
		
	}
	
	private ItemModifiersStore modifierStore;
	private BaseItemStore baseItemStore;
	private QuestStore questStore;
	private SpellsStore spellStore;
	private ShrinesStore shrineStore;
	private UniqueItemStore uniqueItemStore;
	private CharacterStore characterStore;
	private BaseMonsterStore baseMonsterStore;
	private UniqueMonsterStore uniqueMonsterStore;

	public void setItemModifiersStore(ItemModifiersStore modifierStore){
		this.modifierStore = modifierStore;
	}
	
	public void setBaseItemStore(BaseItemStore baseItemStore) {
		this.baseItemStore = baseItemStore;
	}
	
	public void setQuestStore(QuestStore qs){
		this.questStore = qs; 
	}
	
	public void setSpellStore(SpellsStore ss){
		this.spellStore = ss;
	}
	
	public void setShrineStore(ShrinesStore ss){
		this.shrineStore = ss; 
	}
	
	public void setUniqueItemStore(UniqueItemStore uis){
		this.uniqueItemStore = uis;
	}
	
	public void setCharacterStore(CharacterStore cs){
		this.characterStore = cs;
	}
	
	public void setBaseMonsterStore(BaseMonsterStore bms){
		this.baseMonsterStore = bms;
	}
	
	public void setUniqueMonsterStore(UniqueMonsterStore ums){
		this.uniqueMonsterStore = ums;
	}
	
	public void displayGUI(){
		
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = new Dimension(600, 450);
		jFrame.setMinimumSize(d);
		
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
		
		JPanel baseItemsPanel = new BaseItemsPanel(baseItemStore);
		JPanel baseMonstersPanel = new BaseMonstersPanel(baseMonsterStore);
		JPanel characterPanel = new CharacterPanel(characterStore);
		JPanel itemModifierPanel = new ItemModifierPanel(modifierStore);
		JPanel questsPanel = new QuestsPanel(questStore);
		JPanel shrinesPanel = new ShrinesPanel(shrineStore);
		JPanel spellsPanel = new SpellsPanel(spellStore);
		JPanel uniqueItemsPanel = new UniqueItemsPanel(uniqueItemStore);
		JPanel uniqueMonstersPanel = new UniqueMonstersPanel(uniqueMonsterStore);
		
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
}
