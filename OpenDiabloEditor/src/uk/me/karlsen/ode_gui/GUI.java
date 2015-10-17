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
import uk.me.karlsen.ode.ItemEffect;
import uk.me.karlsen.ode.ItemModifiersStore;
import uk.me.karlsen.ode.QuestStore;
import uk.me.karlsen.ode.ShrinesStore;
import uk.me.karlsen.ode.SpellsStore;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.UniqueItem;
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
		
		BaseItemsPanelFactory bipf = new BaseItemsPanelFactory(baseItemStore);
		JPanel baseItemsPanel = bipf.createBaseItemsPanel();
		JPanel baseMonstersPanel = new BaseMonstersPanel(baseMonsterStore); //this.createBaseMonstersPanel();
		JPanel characterPanel = new CharacterPanel(characterStore);
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
		GridLayout layout = new GridLayout(0,2);
		JPanel uniqueMonstersPanel = new JPanel();
		uniqueMonstersPanel.setLayout(layout);
		
		String[] uMonsterNames = uniqueMonsterStore.getMonsterNames();
		String[] comboBoxStrings = new String[uMonsterNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(uMonsterNames, 0, comboBoxStrings, 1, uMonsterNames.length);
		JComboBox<String> comboBox = new JComboBox<String>(comboBoxStrings);
		comboBox.setSelectedIndex(0);
		UniqueMonstersListener uniqueMonstersListener = new UniqueMonstersListener(uniqueMonsterStore);
		comboBox.addActionListener(uniqueMonstersListener);
		JLabel cbLabel = new JLabel("Unique monster selected:");
		uniqueMonstersPanel.add(cbLabel);
		uniqueMonstersPanel.add(comboBox);
		
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameField = new JTextField();
		uniqueMonstersPanel.add(nameLabel);
		uniqueMonstersPanel.add(nameField);
		
		JLabel monsterTypeLabel = new JLabel("Monster type:");
		JTextField monsterTypeField = new JTextField();
		uniqueMonstersPanel.add(monsterTypeLabel);
		uniqueMonstersPanel.add(monsterTypeField);
		
		JLabel namePointerLabel = new JLabel("Name pointer:");
		JTextField namePointerField = new JTextField();
		uniqueMonstersPanel.add(namePointerLabel);
		uniqueMonstersPanel.add(namePointerField);
		
		JLabel trnPointerLabel = new JLabel("TRN pointer:");
		JTextField trnPointerField = new JTextField();
		uniqueMonstersPanel.add(trnPointerLabel);
		uniqueMonstersPanel.add(trnPointerField);
		
		JLabel dungeonLevelLabel = new JLabel("Dungeon level:");
		JTextField dungeonLevelField = new JTextField();
		uniqueMonstersPanel.add(dungeonLevelLabel);
		uniqueMonstersPanel.add(dungeonLevelField);
		
		JLabel hitPointsLabel = new JLabel("Hit points:");
		JTextField hitPointsField = new JTextField();
		uniqueMonstersPanel.add(hitPointsLabel);
		uniqueMonstersPanel.add(hitPointsField);
		
		JLabel monsterAILabel = new JLabel("Monster AI:");
		JTextField monsterAIField = new JTextField();
		uniqueMonstersPanel.add(monsterAILabel);
		uniqueMonstersPanel.add(monsterAIField);
		
		JLabel intelligenceFactorLabel = new JLabel("Intelligence factor:");
		JTextField intelligenceFactorField = new JTextField();
		uniqueMonstersPanel.add(intelligenceFactorLabel);
		uniqueMonstersPanel.add(intelligenceFactorField);
		
		JLabel minAttackDmgLabel = new JLabel("Min attack dmg:");
		JTextField minAttackDmgField = new JTextField();
		uniqueMonstersPanel.add(minAttackDmgLabel);
		uniqueMonstersPanel.add(minAttackDmgField);
		
		JLabel maxAttackDmgLabel = new JLabel("Max attack dmg:");
		JTextField maxAttackDmgField = new JTextField();
		uniqueMonstersPanel.add(maxAttackDmgLabel);
		uniqueMonstersPanel.add(maxAttackDmgField);
		
		JLabel resistancesLabel = new JLabel("Resistances:");
		JTextField resistancesField = new JTextField();
		uniqueMonstersPanel.add(resistancesLabel);
		uniqueMonstersPanel.add(resistancesField);
		
		JLabel packTriggerLabel = new JLabel("Pack trigger:");
		JTextField packTriggerField = new JTextField();
		uniqueMonstersPanel.add(packTriggerLabel);
		uniqueMonstersPanel.add(packTriggerField);
		
		JLabel packSpecialsLabel = new JLabel("Pack specials:");
		JTextField packSpecialsField = new JTextField();
		uniqueMonstersPanel.add(packSpecialsLabel);
		uniqueMonstersPanel.add(packSpecialsField);
		
		JLabel specialSoundWavLabel = new JLabel("Special sound WAV:");
		JTextField specialSoundWavField = new JTextField();
		uniqueMonstersPanel.add(specialSoundWavLabel);
		uniqueMonstersPanel.add(specialSoundWavField);
		
		return uniqueMonstersPanel;
	}

	private JPanel createUniqueItemsPanel() {
		GridLayout layout = new GridLayout(0,2);
		JPanel uniqueItemsPanel = new JPanel();
		uniqueItemsPanel.setLayout(layout);
		
		String[] uItemNames = uniqueItemStore.getItemNames();
		String[] comboBoxStrings = new String[uItemNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(uItemNames, 0, comboBoxStrings, 1, uItemNames.length);
		JComboBox<String> comboBox = new JComboBox<String>(comboBoxStrings);
		comboBox.setSelectedIndex(0);
		UniqueItemsListener uniqueItemsListener = new UniqueItemsListener(uniqueItemStore);
		comboBox.addActionListener(uniqueItemsListener);
		JLabel cbLabel = new JLabel("Unique item selected:");
		uniqueItemsPanel.add(cbLabel);
		uniqueItemsPanel.add(comboBox);
		
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameField = new JTextField();
		uniqueItemsPanel.add(nameLabel);
		uniqueItemsPanel.add(nameField);
		
		JLabel namePointerLabel = new JLabel("Name pointer:");
		JTextField namePointerField = new JTextField();
		uniqueItemsPanel.add(namePointerLabel);
		uniqueItemsPanel.add(namePointerField);
		
		JLabel itemTypeLabel = new JLabel("Item type:");
		JTextField itemTypeField = new JTextField();
		uniqueItemsPanel.add(itemTypeLabel);
		uniqueItemsPanel.add(itemTypeField);
		
		JLabel qualityLevelLabel = new JLabel("Quality level:");
		JTextField qualityLevelField = new JTextField();
		uniqueItemsPanel.add(qualityLevelLabel);
		uniqueItemsPanel.add(qualityLevelField);
		
		JLabel numberOfEffectsLabel = new JLabel("Number of effects:");
		JTextField numberOfEffectsField = new JTextField();
		uniqueItemsPanel.add(numberOfEffectsLabel);
		uniqueItemsPanel.add(numberOfEffectsField);
		
		JLabel effect1NumberLabel = new JLabel("Effect number:");
		JTextField effect1NumberField = new JTextField();
		uniqueItemsPanel.add(effect1NumberLabel);
		uniqueItemsPanel.add(effect1NumberField);
		
		JLabel effect1NameLabel = new JLabel("Effect:");
		JTextField effect1NameField = new JTextField();
		uniqueItemsPanel.add(effect1NameLabel);
		uniqueItemsPanel.add(effect1NameField);
		
		JLabel effect1MinValueLabel = new JLabel("Min value:");
		JTextField effect1MinValueField = new JTextField();
		uniqueItemsPanel.add(effect1MinValueLabel);
		uniqueItemsPanel.add(effect1MinValueField);
		
		JLabel effect1MaxValueLabel = new JLabel("Max value");
		JTextField effect1MaxValueField = new JTextField();
		uniqueItemsPanel.add(effect1MaxValueLabel);
		uniqueItemsPanel.add(effect1MaxValueField);
		
		JLabel effect2NumberLabel = new JLabel("Effect number:");
		JTextField effect2NumberField = new JTextField();
		uniqueItemsPanel.add(effect2NumberLabel);
		uniqueItemsPanel.add(effect2NumberField);
		
		JLabel effect2NameLabel = new JLabel("Effect:");
		JTextField effect2NameField = new JTextField();
		uniqueItemsPanel.add(effect2NameLabel);
		uniqueItemsPanel.add(effect2NameField);
		
		JLabel effect2MinValueLabel = new JLabel("Min value:");
		JTextField effect2MinValueField = new JTextField();
		uniqueItemsPanel.add(effect2MinValueLabel);
		uniqueItemsPanel.add(effect2MinValueField);
		
		JLabel effect2MaxValueLabel = new JLabel("Max value");
		JTextField effect2MaxValueField = new JTextField();
		uniqueItemsPanel.add(effect2MaxValueLabel);
		uniqueItemsPanel.add(effect2MaxValueField);
		
		JLabel effect3NumberLabel = new JLabel("Effect number:");
		JTextField effect3NumberField = new JTextField();
		uniqueItemsPanel.add(effect3NumberLabel);
		uniqueItemsPanel.add(effect3NumberField);
		
		JLabel effect3NameLabel = new JLabel("Effect:");
		JTextField effect3NameField = new JTextField();
		uniqueItemsPanel.add(effect3NameLabel);
		uniqueItemsPanel.add(effect3NameField);
		
		JLabel effect3MinValueLabel = new JLabel("Min value:");
		JTextField effect3MinValueField = new JTextField();
		uniqueItemsPanel.add(effect3MinValueLabel);
		uniqueItemsPanel.add(effect3MinValueField);
		
		JLabel effect3MaxValueLabel = new JLabel("Max value");
		JTextField effect3MaxValueField = new JTextField();
		uniqueItemsPanel.add(effect3MaxValueLabel);
		uniqueItemsPanel.add(effect3MaxValueField);
		
		JLabel effect4NumberLabel = new JLabel("Effect number:");
		JTextField effect4NumberField = new JTextField();
		uniqueItemsPanel.add(effect4NumberLabel);
		uniqueItemsPanel.add(effect4NumberField);
		
		JLabel effect4NameLabel = new JLabel("Effect:");
		JTextField effect4NameField = new JTextField();
		uniqueItemsPanel.add(effect4NameLabel);
		uniqueItemsPanel.add(effect4NameField);
		
		JLabel effect4MinValueLabel = new JLabel("Min value:");
		JTextField effect4MinValueField = new JTextField();
		uniqueItemsPanel.add(effect4MinValueLabel);
		uniqueItemsPanel.add(effect4MinValueField);
		
		JLabel effect4MaxValueLabel = new JLabel("Max value");
		JTextField effect4MaxValueField = new JTextField();
		uniqueItemsPanel.add(effect4MaxValueLabel);
		uniqueItemsPanel.add(effect4MaxValueField);
		
		JLabel effect5NumberLabel = new JLabel("Effect number:");
		JTextField effect5NumberField = new JTextField();
		uniqueItemsPanel.add(effect5NumberLabel);
		uniqueItemsPanel.add(effect5NumberField);
		
		JLabel effect5NameLabel = new JLabel("Effect:");
		JTextField effect5NameField = new JTextField();
		uniqueItemsPanel.add(effect5NameLabel);
		uniqueItemsPanel.add(effect5NameField);
		
		JLabel effect5MinValueLabel = new JLabel("Min value:");
		JTextField effect5MinValueField = new JTextField();
		uniqueItemsPanel.add(effect5MinValueLabel);
		uniqueItemsPanel.add(effect5MinValueField);
		
		JLabel effect5MaxValueLabel = new JLabel("Max value");
		JTextField effect5MaxValueField = new JTextField();
		uniqueItemsPanel.add(effect5MaxValueLabel);
		uniqueItemsPanel.add(effect5MaxValueField);
		
		JLabel effect6NumberLabel = new JLabel("Effect number:");
		JTextField effect6NumberField = new JTextField();
		uniqueItemsPanel.add(effect6NumberLabel);
		uniqueItemsPanel.add(effect6NumberField);
		
		JLabel effect6NameLabel = new JLabel("Effect:");
		JTextField effect6NameField = new JTextField();
		uniqueItemsPanel.add(effect6NameLabel);
		uniqueItemsPanel.add(effect6NameField);
		
		JLabel effect6MinValueLabel = new JLabel("Min value:");
		JTextField effect6MinValueField = new JTextField();
		uniqueItemsPanel.add(effect6MinValueLabel);
		uniqueItemsPanel.add(effect6MinValueField);
		
		JLabel effect6MaxValueLabel = new JLabel("Max value");
		JTextField effect6MaxValueField = new JTextField();
		uniqueItemsPanel.add(effect6MaxValueLabel);
		uniqueItemsPanel.add(effect6MaxValueField);
		
		JLabel effect7NumberLabel = new JLabel("Effect number:");
		JTextField effect7NumberField = new JTextField();
		uniqueItemsPanel.add(effect7NumberLabel);
		uniqueItemsPanel.add(effect7NumberField);
		
		JLabel effect7NameLabel = new JLabel("Effect:");
		JTextField effect7NameField = new JTextField();
		uniqueItemsPanel.add(effect7NameLabel);
		uniqueItemsPanel.add(effect7NameField);
		
		JLabel effect7MinValueLabel = new JLabel("Min value:");
		JTextField effect7MinValueField = new JTextField();
		uniqueItemsPanel.add(effect7MinValueLabel);
		uniqueItemsPanel.add(effect7MinValueField);
		
		JLabel effect7MaxValueLabel = new JLabel("Max value");
		JTextField effect7MaxValueField = new JTextField();
		uniqueItemsPanel.add(effect7MaxValueLabel);
		uniqueItemsPanel.add(effect7MaxValueField);
	
		return uniqueItemsPanel;
	}

	private JPanel createSpellsPanel() {
		GridLayout layout = new GridLayout(0,2);
		JPanel spellsPanel = new JPanel();
		spellsPanel.setLayout(layout);
		
		String[] spellNames = spellStore.getSpellNames();
		String[] comboBoxStrings = new String[spellNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(spellNames, 0, comboBoxStrings, 1, spellNames.length);
		JComboBox<String> comboBox = new JComboBox<String>(comboBoxStrings);
		comboBox.setSelectedIndex(0);
		SpellsListener spellsListener = new SpellsListener(spellStore);
		comboBox.addActionListener(spellsListener);
		JLabel cbLabel = new JLabel("Spell selected:");
		spellsPanel.add(cbLabel);
		spellsPanel.add(comboBox);
		
		JLabel indexLabel = new JLabel("Index:");
		JTextField indexField = new JTextField();
		spellsPanel.add(indexLabel);
		spellsPanel.add(indexField);
		
		//String[] unmoddedSpellNames = TomeOfKnowledge.createSpellNamesArray();
		//unmoddedSpellNames[unmoddedSpellIndex]
		JLabel unmoddedSpellNameLabel = new JLabel("Unmodded spell name:");
		JTextField unmoddedSpellNameField = new JTextField();
		spellsPanel.add(unmoddedSpellNameLabel);
		spellsPanel.add(unmoddedSpellNameField);
		
		JLabel manaToCastLabel = new JLabel("Mana to cast:");
		JTextField manaToCastField = new JTextField();
		spellsPanel.add(manaToCastLabel);
		spellsPanel.add(manaToCastField);
		
		JLabel animationWhenCastingLabel = new JLabel("Animation when casting:");
		JTextField animationWhenCastingField = new JTextField();
		spellsPanel.add(animationWhenCastingLabel);
		spellsPanel.add(animationWhenCastingField);
		
		JLabel pointerToNameAsSpellLabel = new JLabel("Pointer to name as spell:");
		JTextField pointerToNameAsSpellField = new JTextField();
		spellsPanel.add(pointerToNameAsSpellLabel);
		spellsPanel.add(pointerToNameAsSpellField);
		
		JLabel nameAsSpellLabel = new JLabel("Name as spell:");
		JTextField nameAsSpellField = new JTextField();
		spellsPanel.add(nameAsSpellLabel);
		spellsPanel.add(nameAsSpellField);
		
		JLabel pointerToNameAsSkillLabel = new JLabel("Pointer to name as skill:");
		JTextField pointerToNameAsSkillField = new JTextField();
		spellsPanel.add(pointerToNameAsSkillLabel);
		spellsPanel.add(pointerToNameAsSkillField);
		
		JLabel nameAsSkillLabel = new JLabel("Name as skill:");
		JTextField nameAsSkillField = new JTextField();
		spellsPanel.add(nameAsSkillLabel);
		spellsPanel.add(nameAsSkillField);
		
		JLabel spellbookQualityLabel = new JLabel("Spellbook quality:");
		JTextField spellbookQualityField = new JTextField();
		spellsPanel.add(spellbookQualityLabel);
		spellsPanel.add(spellbookQualityField);
		
		JLabel staffQualityLabel = new JLabel("Staff quality:");
		JTextField staffQualityField = new JTextField();
		spellsPanel.add(staffQualityLabel);
		spellsPanel.add(staffQualityField);
		
		JLabel byteTwentyLabel = new JLabel("Byte twenty:");
		JTextField byteTwentyField = new JTextField();
		spellsPanel.add(byteTwentyLabel);
		spellsPanel.add(byteTwentyField);
		
		JLabel byteTwentyoneLabel = new JLabel("Byte twentyone:");
		JTextField byteTwentyoneField = new JTextField();
		spellsPanel.add(byteTwentyoneLabel);
		spellsPanel.add(byteTwentyoneField);
		
		JLabel byteTwentytwoLabel = new JLabel("Byte twentytwo:");
		JTextField byteTwentytwoField = new JTextField();
		spellsPanel.add(byteTwentytwoLabel);
		spellsPanel.add(byteTwentytwoField);
		
		JLabel byteTwentythreeLabel = new JLabel("Byte twentythree:");
		JTextField byteTwentythreeField = new JTextField();
		spellsPanel.add(byteTwentythreeLabel);
		spellsPanel.add(byteTwentythreeField);
		
		JLabel spellActiveInTownLabel = new JLabel("Active in town?");
		JTextField spellActiveInTownField = new JTextField();
		spellsPanel.add(spellActiveInTownLabel);
		spellsPanel.add(spellActiveInTownField);
		
		JLabel baseRequiredMagicLabel = new JLabel("Base req. magic:");
		JTextField baseRequiredMagicField = new JTextField();
		spellsPanel.add(baseRequiredMagicLabel);
		spellsPanel.add(baseRequiredMagicField);
		
		JLabel castingSoundLabel = new JLabel("Casting sound:");
		JTextField castingSoundField = new JTextField();
		spellsPanel.add(castingSoundLabel);
		spellsPanel.add(castingSoundField);
		
		JLabel spellEffect1Label = new JLabel("Spell effect 1:");
		JTextField spellEffect1Field = new JTextField();
		spellsPanel.add(spellEffect1Label);
		spellsPanel.add(spellEffect1Field);
		
		JLabel spellEffect2Label = new JLabel("Spell effect 2:");
		JTextField spellEffect2Field = new JTextField();
		spellsPanel.add(spellEffect2Label);
		spellsPanel.add(spellEffect2Field);
		
		JLabel spellEffect3Label = new JLabel("Spell effect 3:");
		JTextField spellEffect3Field = new JTextField();
		spellsPanel.add(spellEffect3Label);
		spellsPanel.add(spellEffect3Field);
		
		JLabel manaStepLabel = new JLabel("Mana step:");
		JTextField manaStepField = new JTextField();
		spellsPanel.add(manaStepLabel);
		spellsPanel.add(manaStepField);
		
		JLabel minCastingCostLabel = new JLabel("Min casting cost:");
		JTextField minCastingCostField = new JTextField();
		spellsPanel.add(minCastingCostLabel);
		spellsPanel.add(minCastingCostField);
		
		JLabel byteThirtyEightLabel = new JLabel("Byte thirtyeight:");
		JTextField byteThirtyEightField = new JTextField();
		spellsPanel.add(byteThirtyEightLabel);
		spellsPanel.add(byteThirtyEightField);
		
		JLabel byteThirtyNineLabel = new JLabel("Byte thirtynine:");
		JTextField byteThirtyNineField = new JTextField();
		spellsPanel.add(byteThirtyNineLabel);
		spellsPanel.add(byteThirtyNineField);
		
		JLabel minChargesLabel = new JLabel("Min charges label:");
		JTextField minChargesField = new JTextField();
		spellsPanel.add(minChargesLabel);
		spellsPanel.add(minChargesField);
		
		JLabel maxChargesLabel = new JLabel("Max charges label:");
		JTextField maxChargesField = new JTextField();
		spellsPanel.add(maxChargesLabel);
		spellsPanel.add(maxChargesField);
		
		JLabel bookCostLabel = new JLabel("Book cost:");
		JTextField bookCostField = new JTextField();
		spellsPanel.add(bookCostLabel);
		spellsPanel.add(bookCostField);
		
		JLabel staffCostMultiplierLabel = new JLabel("Staff cost multiplier:");
		JTextField staffCostMultiplierField = new JTextField();
		spellsPanel.add(staffCostMultiplierLabel);
		spellsPanel.add(staffCostMultiplierField);
		
		return spellsPanel;
	}

	private JPanel createShrinesPanel() {
		GridLayout layout = new GridLayout(0,2);
		JPanel shrinesPanel = new JPanel();
		shrinesPanel.setLayout(layout);
		
		String[] shrineNames = shrineStore.getShrineNames();
		String[] comboBoxStrings = new String[shrineNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(shrineNames, 0, comboBoxStrings, 1, shrineNames.length);
		JComboBox<String> comboBox = new JComboBox<String>(comboBoxStrings);
		comboBox.setSelectedIndex(0);
		ShrinesListener shrinesListener = new ShrinesListener(shrineStore);
		comboBox.addActionListener(shrinesListener);
		JLabel cbLabel = new JLabel("Quest selected:");
		shrinesPanel.add(cbLabel);
		shrinesPanel.add(comboBox);
		
		JLabel shrineIndexLabel = new JLabel("Shrine index:");
		JTextField shrineIndexField = new JTextField();
		shrinesPanel.add(shrineIndexLabel);
		shrinesPanel.add(shrineIndexField);
		
		JLabel shrineNameLabel = new JLabel("Shrine name:");
		JTextField shrineNameField = new JTextField();
		shrinesPanel.add(shrineNameLabel);
		shrinesPanel.add(shrineNameField);
		
		JLabel shrinePointerLabel = new JLabel("Shrine pointer:");
		JTextField shrinePointerField = new JTextField();
		shrinesPanel.add(shrinePointerLabel);
		shrinesPanel.add(shrinePointerField);
		
		JLabel minShrineLevelLabel = new JLabel("Min shrine level:");
		JTextField minShrineLevelField = new JTextField();
		shrinesPanel.add(minShrineLevelLabel);
		shrinesPanel.add(minShrineLevelField);
		
		JLabel maxShrineLevelLabel = new JLabel("Max shrine level:");
		JTextField maxShrineLevelField = new JTextField();
		shrinesPanel.add(maxShrineLevelLabel);
		shrinesPanel.add(maxShrineLevelField);
		
		JLabel gameTypesInWhichPresentLabel = new JLabel("Game types in which present:");
		JTextField gameTypesInWhichPresentField = new JTextField();
		shrinesPanel.add(gameTypesInWhichPresentLabel);
		shrinesPanel.add(gameTypesInWhichPresentField);
		
		return shrinesPanel;
	}

	private JPanel createQuestsPanel() {
		GridLayout layout = new GridLayout(0,2);
		JPanel questsPanel = new JPanel();
		questsPanel.setLayout(layout);
		
		String[] questNames = questStore.getQuestNames();
		String[] comboBoxStrings = new String[questNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(questNames, 0, comboBoxStrings, 1, questNames.length);
		JComboBox<String> comboBox = new JComboBox<String>(comboBoxStrings);
		comboBox.setSelectedIndex(0);
		QuestsListener questListener = new QuestsListener(questStore);
		comboBox.addActionListener(questListener);
		JLabel cbLabel = new JLabel("Quest selected:");
		questsPanel.add(cbLabel);
		questsPanel.add(comboBox);
		
		JLabel slotNumberLabel = new JLabel("Slot number:");
		JTextField slotNumberField = new JTextField();
		questsPanel.add(slotNumberLabel);
		questsPanel.add(slotNumberField);
		
		JLabel dungeonLevelSingleLabel = new JLabel("Dungeon level in SP:");
		JTextField dungeonLevelSingleField = new JTextField();
		questsPanel.add(dungeonLevelSingleLabel);
		questsPanel.add(dungeonLevelSingleField);
		
		JLabel dungeonLevelMultiLabel = new JLabel("Dungeon level in MP:");
		JTextField dungeonLevelMultiField = new JTextField();
		questsPanel.add(dungeonLevelMultiLabel);
		questsPanel.add(dungeonLevelMultiField);
		
		JLabel dungeonTypeLabel = new JLabel("Dungeon type:");
		JTextField dungeonTypeField = new JTextField();
		questsPanel.add(dungeonTypeLabel);
		questsPanel.add(dungeonTypeField);
		
		JLabel questNumberLabel = new JLabel("Quest number:");
		JTextField questNumberField = new JTextField();
		questsPanel.add(questNumberLabel);
		questsPanel.add(questNumberField);
		
		JLabel byteFourValueLabel = new JLabel("Byte four value:");
		JTextField byteFourValueField = new JTextField();
		questsPanel.add(byteFourValueLabel);
		questsPanel.add(byteFourValueField);
		
		JLabel specialLevelLabel = new JLabel("Special level?");
		JTextField specialLevelField = new JTextField();
		questsPanel.add(specialLevelLabel);
		questsPanel.add(specialLevelField);
		
		JLabel zeroOneLabel = new JLabel("Zero one:");
		JTextField zeroOneField = new JTextField();
		questsPanel.add(zeroOneLabel);
		questsPanel.add(zeroOneField);
		
		JLabel zeroTwoLabel = new JLabel("Zero two:");
		JTextField zeroTwoField = new JTextField();
		questsPanel.add(zeroTwoLabel);
		questsPanel.add(zeroTwoField);
		
		JLabel mpTriggerFlagLabel = new JLabel("MP trigger flag:");
		JTextField mpTriggerFlagField = new JTextField();
		questsPanel.add(mpTriggerFlagLabel);
		questsPanel.add(mpTriggerFlagField);
		
		JLabel textEntryIndexLabel = new JLabel("Text entry index:");
		JTextField textEntryIndexField = new JTextField();
		questsPanel.add(textEntryIndexLabel);
		questsPanel.add(textEntryIndexField);
		
		return questsPanel;
	}

	private JPanel createItemModifierPanel() {
		GridLayout layout = new GridLayout(0,2);
		JPanel itemModifierPanel = new JPanel();
		itemModifierPanel.setLayout(layout);
		
		String[] itemModNames = modifierStore.getModifierNames();
		String[] comboBoxStrings = new String[itemModNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(itemModNames, 0, comboBoxStrings, 1, itemModNames.length);
		JComboBox<String> modifierComboBox = new JComboBox<String>(comboBoxStrings);
		modifierComboBox.setSelectedIndex(0);
		ModifiersListener modifierListener = new ModifiersListener(modifierStore);
		modifierComboBox.addActionListener(modifierListener);
		JLabel modifierCBLabel = new JLabel("Item modifier selected:");
		itemModifierPanel.add(modifierCBLabel);
		itemModifierPanel.add(modifierComboBox);
		
		JLabel nameLabel = new JLabel("Modifier name:");
		JTextField nameField = new JTextField();
		itemModifierPanel.add(nameLabel);
		itemModifierPanel.add(nameField);
		
		JLabel namePointerLabel = new JLabel("Name pointer:");
		JTextField namePointerField = new JTextField();
		itemModifierPanel.add(namePointerLabel);
		itemModifierPanel.add(namePointerField);
		
		JLabel itemEffects1Label = new JLabel("Item effects 1:");
		JTextField itemEffects1Field = new JTextField();
		itemModifierPanel.add(itemEffects1Label);
		itemModifierPanel.add(itemEffects1Field);
		
		JLabel itemEffects2Label = new JLabel("Item effects 2:");
		JTextField itemEffects2Field = new JTextField();
		itemModifierPanel.add(itemEffects2Label);
		itemModifierPanel.add(itemEffects2Field);
		
		JLabel itemEffects3Label = new JLabel("Item effects 3:");
		JTextField itemEffects3Field = new JTextField();
		itemModifierPanel.add(itemEffects3Label);
		itemModifierPanel.add(itemEffects3Field);
		
		JLabel itemEffects4Label = new JLabel("Item effects 4:");
		JTextField itemEffects4Field = new JTextField();
		itemModifierPanel.add(itemEffects4Label);
		itemModifierPanel.add(itemEffects4Field);
		
		JLabel minimumEffectValueLabel = new JLabel("Minimum effect value:");
		JTextField minimumEffectValueField = new JTextField();
		itemModifierPanel.add(minimumEffectValueLabel);
		itemModifierPanel.add(minimumEffectValueField);
		
		JLabel maximumEffectValueLabel = new JLabel("Max effect value:");
		JTextField maximumEffectValueField = new JTextField();
		itemModifierPanel.add(maximumEffectValueLabel);
		itemModifierPanel.add(maximumEffectValueField);
		
		JLabel qualityLevelLabel = new JLabel("Quality level:");
		JTextField qualityLevelField = new JTextField();
		itemModifierPanel.add(qualityLevelLabel);
		itemModifierPanel.add(qualityLevelField);
		
		JLabel occurencePossibilitiesLabel = new JLabel("Occurence possibilities:");
		JTextField occurencePossibilitiesField = new JTextField();
		itemModifierPanel.add(occurencePossibilitiesLabel);
		itemModifierPanel.add(occurencePossibilitiesField);
		
		JLabel byteTwentyThreeLabel = new JLabel("Byte twentythree");
		JTextField byteTwentyThreeField = new JTextField();
		itemModifierPanel.add(byteTwentyThreeLabel);
		itemModifierPanel.add(byteTwentyThreeField);
		
		JLabel excludedComboIndicatorLabel = new JLabel("Excluded combo indicator:");
		JTextField excludedComboIndicatorField = new JTextField();
		itemModifierPanel.add(excludedComboIndicatorLabel);
		itemModifierPanel.add(excludedComboIndicatorField);
		
		JLabel cursedIndicatorLabel = new JLabel("Cursed indicator:");
		JTextField cursedIndicatorField = new JTextField();
		itemModifierPanel.add(cursedIndicatorLabel);
		itemModifierPanel.add(cursedIndicatorField);
		
		JLabel minGoldLabel = new JLabel("Min gold:");
		JTextField minGoldField = new JTextField();
		itemModifierPanel.add(minGoldLabel);
		itemModifierPanel.add(minGoldField);
		
		JLabel maxGoldLabel = new JLabel("Max gold:");
		JTextField maxGoldField = new JTextField();
		itemModifierPanel.add(maxGoldLabel);
		itemModifierPanel.add(maxGoldField);
		
		JLabel valueMultiplierLabel = new JLabel("Value multiplier:");
		JTextField valueMultiplierField = new JTextField();
		itemModifierPanel.add(valueMultiplierLabel);
		itemModifierPanel.add(valueMultiplierField);
		
		return itemModifierPanel;
	}
}
