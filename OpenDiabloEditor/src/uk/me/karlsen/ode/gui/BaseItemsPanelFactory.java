package uk.me.karlsen.ode.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.me.karlsen.ode.stores.BaseItemStore;
import uk.me.karlsen.ode.types.BaseItem;

public class BaseItemsPanelFactory {
	
	private BaseItemStore bis;
	
	public BaseItemsPanelFactory(BaseItemStore bis){
		this.bis = bis;
	}

	public JPanel createBaseItemsPanel() {
		
		GridLayout layout = new GridLayout(0,2);
		JPanel baseItemsPanel = new JPanel();
		baseItemsPanel.setLayout(layout);
		
		String[] baseItemNames = bis.getItemNames();
		String[] comboBoxStrings = new String[baseItemNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(baseItemNames, 0, comboBoxStrings, 1, baseItemNames.length);
		JComboBox<String> itemComboBox = new JComboBox<String>(comboBoxStrings);
		itemComboBox.setSelectedIndex(0);
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
		JTextField minAcField = new JTextField();
		baseItemsPanel.add(minAcLabel);
		baseItemsPanel.add(minAcField);
		
		JLabel maxAcLabel = new JLabel("Max. AC");
		JTextField maxAcField = new JTextField();
		baseItemsPanel.add(maxAcLabel);
		baseItemsPanel.add(maxAcField);
		
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
		
		ActionListener bipcbl = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				String itemName = (String) itemComboBox.getSelectedItem();
		        if(itemName.equals("None selected")){
		        	//do nothing
		        } else {
		        	BaseItem bi = bis.getItemByName(itemName);
		        	nameField.setText(bi.getName());
		        	namePointerField.setText(String.valueOf(bi.getNamePointer()));
		        	//magicalNameField.setText();
		        	magicalNamePointerField.setText(String.valueOf(bi.getMagicalNamePointer()));
		        	//activationTriggerBox
		        	//itemTypeBox
		        	//equipLocationBox
		        	//graphicValueBox
		        	//itemCodeBox
		        	//uniqueItemCodeBox
		        	qualityLevelField.setText(String.valueOf(bi.getQualityLevel()));
		        	durabilityField.setText(String.valueOf(bi.getDurability()));
		        	minAttackDamageField.setText(String.valueOf(bi.getMinAttackDamage()));
		        	maxAttackDamageField.setText(String.valueOf(bi.getMaxAttackDamage()));
		        	minAcField.setText(String.valueOf(bi.getMinAc()));
		        	maxAcField.setText(String.valueOf(bi.getMaxAc()));
		        	requiredStrField.setText(String.valueOf(bi.getRequiredStr()));
		        	requiredDexField.setText(String.valueOf(bi.getRequiredDex()));
		        	requiredMagField.setText(String.valueOf(bi.getRequiredMag()));
		        	requiredVitField.setText(String.valueOf(bi.getRequiredVit()));
		        	specialEffectsField.setText(String.valueOf(bi.getSpecialEffects()));
		        	//magicCodeBox
		        	//spellNumberBox
		        	//useCountBox
		        	priceOneField.setText(String.valueOf(bi.getPriceOne()));
		        	priceTwoField.setText(String.valueOf(bi.getPriceTwo()));
		        }
			}	
		};
		itemComboBox.addActionListener(bipcbl);
		
		
		return baseItemsPanel;
	}
}
