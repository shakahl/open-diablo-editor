package uk.me.karlsen.ode_gui;

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

import uk.me.karlsen.ode.BaseItemStore;
import uk.me.karlsen.ode.BaseMonsterStore;
import uk.me.karlsen.ode.CharacterStore;
import uk.me.karlsen.ode.ItemModifiersStore;
import uk.me.karlsen.ode.QuestStore;
import uk.me.karlsen.ode.ShrinesStore;
import uk.me.karlsen.ode.SpellsStore;
import uk.me.karlsen.ode.UniqueItemStore;
import uk.me.karlsen.ode.UniqueMonsterStore;

public class GUI {
	
	ItemModifiersStore modifierStore;
	BaseItemStore baseItemStore;
	QuestStore questStore;
	SpellsStore spellStore;
	ShrinesStore shrineStore;
	UniqueItemStore uniqueItemStore;
	CharacterStore characterStore;
	BaseMonsterStore baseMonsterStore;
	UniqueMonsterStore uniqueMonsterStore;

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
		
		JPanel baseItemsPanel = this.createBaseItemsPanel();
		JPanel baseMonstersPanel = this.createBaseMonstersPanel();
		JPanel characterPanel = this.createCharacterPanel();
		JPanel itemModifierPanel = this.createItemModifierPanel();
		JPanel questsPanel = this.createQuestsPanel();
		JPanel shrinesPanel = this.createShrinesPanel();
		JPanel spellsPanel = this.createSpellsPanel();
		JPanel uniqueItemsPanel = this.createUniqueItemsPanel();
		JPanel uniqueMonstersPanel = this.createUniqueMonstersPanel();
		
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
	
	private JPanel createUniqueMonstersPanel() {
		GridLayout layout = new GridLayout(32,2);
		JPanel uniqueMonstersPanel = new JPanel();
		uniqueMonstersPanel.setLayout(layout);
		
		return uniqueMonstersPanel;
	}

	private JPanel createUniqueItemsPanel() {
		GridLayout layout = new GridLayout(32,2);
		JPanel uniqueItemsPanel = new JPanel();
		uniqueItemsPanel.setLayout(layout);
		
		return uniqueItemsPanel;
	}

	private JPanel createSpellsPanel() {
		GridLayout layout = new GridLayout(32,2);
		JPanel spellsPanel = new JPanel();
		spellsPanel.setLayout(layout);
		
		return spellsPanel;
	}

	private JPanel createShrinesPanel() {
		GridLayout layout = new GridLayout(32,2);
		JPanel shrinesPanel = new JPanel();
		shrinesPanel.setLayout(layout);
		
		return shrinesPanel;
	}

	private JPanel createQuestsPanel() {
		GridLayout layout = new GridLayout(32,2);
		JPanel questsPanel = new JPanel();
		questsPanel.setLayout(layout);
		
		return questsPanel;
	}

	private JPanel createItemModifierPanel() {
		GridLayout layout = new GridLayout(32,2);
		JPanel itemModifierPanel = new JPanel();
		itemModifierPanel.setLayout(layout);
		
		return itemModifierPanel;
	}

	private JPanel createCharacterPanel() {
		GridLayout layout = new GridLayout(32,2);
		JPanel characterPanel = new JPanel();
		characterPanel.setLayout(layout);
		
		return characterPanel;
	}

	private JPanel createBaseMonstersPanel() {
		GridLayout layout = new GridLayout(32,2);
		JPanel baseMonstersPanel = new JPanel();
		baseMonstersPanel.setLayout(layout);
		
		String[] baseMonsterNames = baseMonsterStore.getMonsterNames();
		String[] comboBoxStrings = new String[baseMonsterNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(baseMonsterNames, 0, comboBoxStrings, 1, baseMonsterNames.length);
		JComboBox<String> monsterComboBox = new JComboBox<String>(comboBoxStrings);
		monsterComboBox.setSelectedIndex(0);
		BaseMonstersListener bmpcbl = new BaseMonstersListener(baseMonsterStore);
		monsterComboBox.addActionListener(bmpcbl);
		JLabel monsterCBLabel = new JLabel("Monster selected:");
		baseMonstersPanel.add(monsterCBLabel);
		baseMonstersPanel.add(monsterComboBox);
		
		JLabel monsterNameLabel = new JLabel("Monster name:");
		JTextField monsterNameField = new JTextField();
		baseMonstersPanel.add(monsterNameLabel);
		baseMonstersPanel.add(monsterNameField);
		
		JLabel monsterEnabledLabel = new JLabel("Monster enabled:");
		JTextField monsterEnabledField = new JTextField();
		baseMonstersPanel.add(monsterEnabledLabel);
		baseMonstersPanel.add(monsterEnabledField);
		
		JLabel animationSizeLabel = new JLabel("Animation size:");
		JTextField animationSizeField = new JTextField();
		baseMonstersPanel.add(animationSizeLabel);
		baseMonstersPanel.add(animationSizeField);
		
		JLabel seedingSizeLabel = new JLabel("Seeding size:");
		JTextField seedingSizeField = new JTextField();
		baseMonstersPanel.add(seedingSizeLabel);
		baseMonstersPanel.add(seedingSizeField);
		
		JLabel animationFileLabel = new JLabel("Animation file:");
		JTextField animationFileField = new JTextField();
		baseMonstersPanel.add(animationFileLabel);
		baseMonstersPanel.add(animationFileField);
		
		JLabel animationPointerLabel = new JLabel("Animation pointer:");
		JTextField animationPointerField = new JTextField();
		baseMonstersPanel.add(animationPointerLabel);
		baseMonstersPanel.add(animationPointerField);
		
		JLabel secondAttackLabel = new JLabel("Second attack:");
		JTextField secondAttackField = new JTextField();
		baseMonstersPanel.add(secondAttackLabel);
		baseMonstersPanel.add(secondAttackField);
		
		JLabel soundFileLabel = new JLabel("Sound file:");
		JTextField soundFileField = new JTextField();
		baseMonstersPanel.add(soundFileLabel);
		baseMonstersPanel.add(soundFileField);
		
		JLabel soundPointerLabel = new JLabel("Sound pointer:");
		JTextField soundPointerField = new JTextField();
		baseMonstersPanel.add(soundPointerLabel);
		baseMonstersPanel.add(soundPointerField);
		
		JLabel secondAttackSoundLabel = new JLabel("Has second attack sound:");
		JTextField secondAttackSoundField = new JTextField();
		baseMonstersPanel.add(secondAttackSoundLabel);
		baseMonstersPanel.add(secondAttackSoundField);
		
		JLabel trnToModColorLabel = new JLabel("Uses TRN to mod color:");
		JTextField trnToModColorField = new JTextField();
		baseMonstersPanel.add(trnToModColorLabel);
		baseMonstersPanel.add(trnToModColorField);
		
		JLabel trnPointerLabel = new JLabel("TRN pointer:");
		JTextField trnPointerField = new JTextField();
		baseMonstersPanel.add(trnPointerLabel);
		baseMonstersPanel.add(trnPointerField);
		
		JLabel trnFileLabel = new JLabel("TRN file:");
		JTextField trnFileField = new JTextField();
		baseMonstersPanel.add(trnFileLabel);
		baseMonstersPanel.add(trnFileField);
		
		JLabel idleFramesetLabel = new JLabel("Idle frameset:");
		JTextField idleFramesetField = new JTextField();
		baseMonstersPanel.add(idleFramesetLabel);
		baseMonstersPanel.add(idleFramesetField);
		
		JLabel walkFramesetLabel = new JLabel("Walk frameset:");
		JTextField walkFramesetField = new JTextField();
		baseMonstersPanel.add(walkFramesetLabel);
		baseMonstersPanel.add(walkFramesetField);
		
		JLabel attackFramesetLabel = new JLabel("Attack frameset:");
		JTextField attackFramesetField = new JTextField();
		baseMonstersPanel.add(attackFramesetLabel);
		baseMonstersPanel.add(attackFramesetField);
		
		JLabel hitRecoveryFramesetLabel = new JLabel("Hit recovery frameset:");
		JTextField hitRecoveryFramesetField = new JTextField();
		baseMonstersPanel.add(hitRecoveryFramesetLabel);
		baseMonstersPanel.add(hitRecoveryFramesetField);
		
		JLabel deathFramesetLabel = new JLabel("Death frameset:");
		JTextField deathFramesetField = new JTextField();
		baseMonstersPanel.add(deathFramesetLabel);
		baseMonstersPanel.add(deathFramesetField);
		
		JLabel secondAttackFramsetLabel = new JLabel("Second attack framset:");
		JTextField secondAttackFramesetField = new JTextField();
		baseMonstersPanel.add(secondAttackFramsetLabel);
		baseMonstersPanel.add(secondAttackFramesetField);
		
		JLabel idlePlaybackSpeedLabel = new JLabel("Idle playback speed:");
		JTextField idlePlaybackSpeedField = new JTextField();
		baseMonstersPanel.add(idlePlaybackSpeedLabel);
		baseMonstersPanel.add(idlePlaybackSpeedField);
		
		JLabel walkPlaybackSpeedLabel = new JLabel("Walk playback speed:");
		JTextField walkPlaybackSpeedField = new JTextField();
		baseMonstersPanel.add(walkPlaybackSpeedLabel);
		baseMonstersPanel.add(walkPlaybackSpeedField);
		
		JLabel attackPlaybackSpeedLabel = new JLabel("Attack playback speed:");
		JTextField attackPlaybackSpeedField = new JTextField();
		baseMonstersPanel.add(attackPlaybackSpeedLabel);
		baseMonstersPanel.add(attackPlaybackSpeedField);
		
		JLabel hitRecoverySpeedLabel = new JLabel("Hit recovery speed:");
		JTextField hitRecoverySpeedField = new JTextField();
		baseMonstersPanel.add(hitRecoverySpeedLabel);
		baseMonstersPanel.add(hitRecoverySpeedField);
		
		JLabel deathPlaybackSpeedLabel = new JLabel("Death playback speed:");
		JTextField deathPlaybackSpeedField = new JTextField();
		baseMonstersPanel.add(deathPlaybackSpeedLabel);
		baseMonstersPanel.add(deathPlaybackSpeedField);
		
		JLabel secondAttackSpeedLabel = new JLabel("Second attack speed:");
		JTextField secondAttackSpeedField = new JTextField();
		baseMonstersPanel.add(secondAttackSpeedLabel);
		baseMonstersPanel.add(secondAttackSpeedField);
		
		JLabel namePointerLabel = new JLabel("Name pointer:");
		JTextField namePointerField = new JTextField();
		baseMonstersPanel.add(namePointerLabel);
		baseMonstersPanel.add(namePointerField);
		
		JLabel minDungeonLabel = new JLabel("Min. dungeon level:");
		JTextField minDungeonField = new JTextField();
		baseMonstersPanel.add(minDungeonLabel);
		baseMonstersPanel.add(minDungeonField);
		
		JLabel maxDungeonLabel = new JLabel("Max. dungeon level:");
		JTextField maxDungeonField = new JTextField();
		baseMonstersPanel.add(maxDungeonLabel);
		baseMonstersPanel.add(maxDungeonField);
		
		JLabel monsterItemLevelLabel = new JLabel("Monster item level:");
		JTextField monsterItemLevelField = new JTextField();
		baseMonstersPanel.add(monsterItemLevelLabel);
		baseMonstersPanel.add(monsterItemLevelField);
		
		
		/*
		"| Monster item level: " + monsterItemLevel + "\n" +
		"| HPs: " + minHitPoints + "--" + maxHitPoints + "\n" +
		"| Attack type (byte 1): " + attackType1 + "\n" +
		"| Attack type (byte 2): " + attackType2 + "\n" +
		"| Attack type (byte 3): " + attackType3 + "\n" +
		"| Attack type (byte 4): " + attackType4 + "\n" +
		"| Attack type (byte 5): " + attackType5 + "\n" +
		"| Monster intelligence: " + monsterIntelligence + "\n" +
		"| Attack type (byte 7): " + attackType7 + "\n" +
		"| Attack type (byte 8): " + attackType8 + "\n" +
		"| Monster sub-type: " + subType + "\n" +
		"| Primary attack % hit: " + monsterPriChanceToHit + "\n" +
		"| Primary to-hit frame: " + priToHitFrame + "\n" +
		"| Primary damage: " + priMinAttackDamage + "--" + priMaxAttackDamage + "\n" +
		"| Sec. attack % hit: " + secToHitChance + "\n" +
		"| Sec. to-hit frame: " + secToHitFrame + "\n" +
		"| Secondary damage: " + secMinAttackDamage + "--" + secMaxAttackDamage + "\n" +
		"| Monster AC: " + monsterAc + "\n" +
		"| Monster type: " + monsterType + "\n" +
		"| Resistances (norm. and nightmare): " + resistancesNormAndNightmare + "\n" +
		"| Resistances (hell mode): " + resistancesHell + "\n" +
		"| Item drop specials: " + itemDropSpecials + "\n" +
		"| Monster selection outline: " + monsterSelectionOutline + "\n" +
		"| XP: " + experiencePoints + "\n" +
		*/
		return baseMonstersPanel;
	}
	
	private JPanel createBaseItemsPanel() {
		
		GridLayout layout = new GridLayout(32,2);
		JPanel baseItemsPanel = new JPanel();
		baseItemsPanel.setLayout(layout);
		
		String[] baseItemNames = baseItemStore.getItemNames();
		String[] comboBoxStrings = new String[baseItemNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(baseItemNames, 0, comboBoxStrings, 1, baseItemNames.length);
		JComboBox<String> itemComboBox = new JComboBox<String>(comboBoxStrings);
		itemComboBox.setSelectedIndex(0);
		BaseItemsListener bipcbl = new BaseItemsListener(baseItemStore);
		itemComboBox.addActionListener(bipcbl);
		JLabel itemCBLabel = new JLabel("Item selected:");
		baseItemsPanel.add(itemCBLabel);
		baseItemsPanel.add(itemComboBox);
		
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameField = new JTextField();
		baseItemsPanel.add(nameLabel);
		baseItemsPanel.add(nameField);
		
		JLabel namePointerLabel = new JLabel("Name pointer:");
		JTextField namePointerField = new JTextField();
		baseItemsPanel.add(namePointerLabel);
		baseItemsPanel.add(namePointerField);
		
		JLabel magicalNameLabel = new JLabel("Magical name:");
		JTextField magicalNameField = new JTextField();
		baseItemsPanel.add(magicalNameLabel);
		baseItemsPanel.add(magicalNameField);
		
		JLabel magicalNamePointerLabel = new JLabel("Magical name pointer:");
		JTextField magicalNamePointerField = new JTextField();
		baseItemsPanel.add(magicalNamePointerLabel);
		baseItemsPanel.add(magicalNamePointerField);
		
		JLabel activationTriggerLabel = new JLabel("Activation trigger:");
		String[] activationTriggerBoxStrings = {};
		JComboBox<String> activationTriggerBox = new JComboBox<String>(activationTriggerBoxStrings);
		baseItemsPanel.add(activationTriggerLabel);
		baseItemsPanel.add(activationTriggerBox);
		
		JLabel itemTypeLabel = new JLabel("Item type:");
		String[] itemTypeStrings = {};
		JComboBox<String> itemTypeBox = new JComboBox<String>(itemTypeStrings);
		baseItemsPanel.add(itemTypeLabel);
		baseItemsPanel.add(itemTypeBox);
		
		JLabel equipLocationLabel = new JLabel("Equip location:");
		String[] equipLocationStrings = {};
		JComboBox<String> equipLocationBox = new JComboBox<String>(equipLocationStrings);
		baseItemsPanel.add(equipLocationLabel);
		baseItemsPanel.add(equipLocationBox);
		
		JLabel graphicValueLabel = new JLabel("Graphic value:");
		String[] graphicValueStrings = {};
		JComboBox<String> graphicValueBox = new JComboBox<String>(graphicValueStrings);
		baseItemsPanel.add(graphicValueLabel);
		baseItemsPanel.add(graphicValueBox);
		
		JLabel itemCodeLabel = new JLabel("Item code:");
		String[] itemCodeStrings = {};
		JComboBox<String> itemCodeBox = new JComboBox<String>(itemCodeStrings);
		baseItemsPanel.add(itemCodeLabel);
		baseItemsPanel.add(itemCodeBox);
		
		JLabel uniqueItemCodeLabel = new JLabel("Unique item code:");
		String[] uniqueItemCodeStrings = {};
		JComboBox<String> uniqueItemCodeBox = new JComboBox<String>(uniqueItemCodeStrings);
		baseItemsPanel.add(uniqueItemCodeLabel);
		baseItemsPanel.add(uniqueItemCodeBox);
		
		JLabel qualityLevelLabel = new JLabel("Quality level:");
		JTextField qualityLevelField = new JTextField();
		baseItemsPanel.add(qualityLevelLabel);
		baseItemsPanel.add(qualityLevelField);
		
		JLabel durabilityLabel = new JLabel("Durability:");
		JTextField durabilityField = new JTextField();
		baseItemsPanel.add(durabilityLabel);
		baseItemsPanel.add(durabilityField);
		
		JLabel minAttackDamageLabel = new JLabel("Min. attack damage:");
		JTextField minAttackDamageField = new JTextField();
		baseItemsPanel.add(minAttackDamageLabel);
		baseItemsPanel.add(minAttackDamageField);
		
		JLabel maxAttackDamageLabel = new JLabel("Max. attack damage:");
		JTextField maxAttackDamageField = new JTextField();
		baseItemsPanel.add(maxAttackDamageLabel);
		baseItemsPanel.add(maxAttackDamageField);
		
		JLabel minAcLabel = new JLabel("Min. AC:");
		JTextField minAc = new JTextField();
		baseItemsPanel.add(minAcLabel);
		baseItemsPanel.add(minAc);
		
		JLabel maxAcLabel = new JLabel("Max. AC");
		JTextField maxAc = new JTextField();
		baseItemsPanel.add(maxAcLabel);
		baseItemsPanel.add(maxAc);
		
		JLabel requiredStrLabel = new JLabel("Required strength:");
		JTextField requiredStrField = new JTextField();
		baseItemsPanel.add(requiredStrLabel);
		baseItemsPanel.add(requiredStrField);
		
		JLabel requiredMagLabel = new JLabel("Required magic:");
		JTextField requiredMagField = new JTextField();
		baseItemsPanel.add(requiredMagLabel);
		baseItemsPanel.add(requiredMagField);
		
		JLabel requiredDexLabel = new JLabel("Required dexterity:");
		JTextField requiredDexField = new JTextField();
		baseItemsPanel.add(requiredDexLabel);
		baseItemsPanel.add(requiredDexField);
		
		JLabel requiredVitLabel = new JLabel("Required vitality:");
		JTextField requiredVitField = new JTextField();
		baseItemsPanel.add(requiredVitLabel);
		baseItemsPanel.add(requiredVitField);
		
		JLabel specialEffectsLabel = new JLabel("Special effects:");
		JTextField specialEffectsField = new JTextField();
		baseItemsPanel.add(specialEffectsLabel);
		baseItemsPanel.add(specialEffectsField);
		
		JLabel magicCodeLabel = new JLabel("Magic code:");
		String[] magicCodeStrings = {};
		JComboBox<String> magicCodeBox = new JComboBox<String>(magicCodeStrings);
		baseItemsPanel.add(magicCodeLabel);
		baseItemsPanel.add(magicCodeBox);
		
		JLabel spellNumberLabel = new JLabel("Spell number:");
		String[] spellNumberStrings = {};
		JComboBox<String> spellNumberBox = new JComboBox<String>(spellNumberStrings);
		baseItemsPanel.add(spellNumberLabel);
		baseItemsPanel.add(spellNumberBox);
		
		JLabel useCountLabel = new JLabel("Use count:");
		String[] useCountStrings = {};
		JComboBox<String> useCountBox = new JComboBox<String>(useCountStrings);
		baseItemsPanel.add(useCountLabel);
		baseItemsPanel.add(useCountBox);
		
		JLabel priceOneLabel = new JLabel("Price one:");
		JTextField priceOneField = new JTextField();
		baseItemsPanel.add(priceOneLabel);
		baseItemsPanel.add(priceOneField);
		
		JLabel priceTwoLabel = new JLabel("Price two:");
		JTextField priceTwoField = new JTextField();
		baseItemsPanel.add(priceTwoLabel);
		baseItemsPanel.add(priceTwoField);
		
		return baseItemsPanel;
	}
}
