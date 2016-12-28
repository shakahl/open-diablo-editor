package uk.me.karlsen.ode.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.me.karlsen.ode.stores.BaseItemStore;
import uk.me.karlsen.ode.types.BaseItem;

public class BaseItemsPanel extends JPanel {
	
	private BaseItemStore bis;
	
	public BaseItemsPanel(BaseItemStore bis){
		this.bis = bis;
		
		GridLayout layout = new GridLayout(0,2);
		this.setLayout(layout);
		
		String[] baseItemNames = bis.getItemNames();
		String[] comboBoxStrings = new String[baseItemNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(baseItemNames, 0, comboBoxStrings, 1, baseItemNames.length);
		JComboBox<String> itemComboBox = new JComboBox<String>(comboBoxStrings);
		itemComboBox.setSelectedIndex(0);
		JLabel itemCBLabel = new JLabel("Item selected:");
		this.add(itemCBLabel);
		this.add(itemComboBox);
		
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameField = new JTextField();
		this.add(nameLabel);
		this.add(nameField);
		
		JLabel namePointerLabel = new JLabel("Name pointer:");
		JTextField namePointerField = new JTextField();
		this.add(namePointerLabel);
		this.add(namePointerField);
		
		JLabel magicalNameLabel = new JLabel("Magical name:");
		JTextField magicalNameField = new JTextField();
		this.add(magicalNameLabel);
		this.add(magicalNameField);
		
		JLabel magicalNamePointerLabel = new JLabel("Magical name pointer:");
		JTextField magicalNamePointerField = new JTextField();
		this.add(magicalNamePointerLabel);
		this.add(magicalNamePointerField);
		
		JLabel activationTriggerLabel = new JLabel("Activation trigger:");
		String[] activationTriggerBoxStrings = {};
		JComboBox<String> activationTriggerBox = new JComboBox<String>(activationTriggerBoxStrings);
		this.add(activationTriggerLabel);
		this.add(activationTriggerBox);
		
		JLabel itemTypeLabel = new JLabel("Item type:");
		String[] itemTypeStrings = {};
		JComboBox<String> itemTypeBox = new JComboBox<String>(itemTypeStrings);
		this.add(itemTypeLabel);
		this.add(itemTypeBox);
		
		JLabel equipLocationLabel = new JLabel("Equip location:");
		String[] equipLocationStrings = {};
		JComboBox<String> equipLocationBox = new JComboBox<String>(equipLocationStrings);
		this.add(equipLocationLabel);
		this.add(equipLocationBox);
		
		JLabel graphicValueLabel = new JLabel("Graphic value:");
		String[] graphicValueStrings = {};
		JComboBox<String> graphicValueBox = new JComboBox<String>(graphicValueStrings);
		this.add(graphicValueLabel);
		this.add(graphicValueBox);
		
		JLabel itemCodeLabel = new JLabel("Item code:");
		String[] itemCodeStrings = {};
		JComboBox<String> itemCodeBox = new JComboBox<String>(itemCodeStrings);
		this.add(itemCodeLabel);
		this.add(itemCodeBox);
		
		JLabel uniqueItemCodeLabel = new JLabel("Unique item code:");
		String[] uniqueItemCodeStrings = {};
		JComboBox<String> uniqueItemCodeBox = new JComboBox<String>(uniqueItemCodeStrings);
		this.add(uniqueItemCodeLabel);
		this.add(uniqueItemCodeBox);
		
		JLabel qualityLevelLabel = new JLabel("Quality level:");
		JTextField qualityLevelField = new JTextField();
		this.add(qualityLevelLabel);
		this.add(qualityLevelField);
		
		JLabel durabilityLabel = new JLabel("Durability:");
		JTextField durabilityField = new JTextField();
		this.add(durabilityLabel);
		this.add(durabilityField);
		
		JLabel minAttackDamageLabel = new JLabel("Min. attack damage:");
		JTextField minAttackDamageField = new JTextField();
		this.add(minAttackDamageLabel);
		this.add(minAttackDamageField);
		
		JLabel maxAttackDamageLabel = new JLabel("Max. attack damage:");
		JTextField maxAttackDamageField = new JTextField();
		this.add(maxAttackDamageLabel);
		this.add(maxAttackDamageField);
		
		JLabel minAcLabel = new JLabel("Min. AC:");
		JTextField minAcField = new JTextField();
		this.add(minAcLabel);
		this.add(minAcField);
		
		JLabel maxAcLabel = new JLabel("Max. AC");
		JTextField maxAcField = new JTextField();
		this.add(maxAcLabel);
		this.add(maxAcField);
		
		JLabel requiredStrLabel = new JLabel("Required strength:");
		JTextField requiredStrField = new JTextField();
		this.add(requiredStrLabel);
		this.add(requiredStrField);
		
		JLabel requiredMagLabel = new JLabel("Required magic:");
		JTextField requiredMagField = new JTextField();
		this.add(requiredMagLabel);
		this.add(requiredMagField);
		
		JLabel requiredDexLabel = new JLabel("Required dexterity:");
		JTextField requiredDexField = new JTextField();
		this.add(requiredDexLabel);
		this.add(requiredDexField);
		
		JLabel requiredVitLabel = new JLabel("Required vitality:");
		JTextField requiredVitField = new JTextField();
		this.add(requiredVitLabel);
		this.add(requiredVitField);
		
		JLabel specialEffectsLabel = new JLabel("Special effects:");
		JTextField specialEffectsField = new JTextField();
		this.add(specialEffectsLabel);
		this.add(specialEffectsField);
		
		JLabel magicCodeLabel = new JLabel("Magic code:");
		String[] magicCodeStrings = {};
		JComboBox<String> magicCodeBox = new JComboBox<String>(magicCodeStrings);
		this.add(magicCodeLabel);
		this.add(magicCodeBox);
		
		JLabel spellNumberLabel = new JLabel("Spell number:");
		String[] spellNumberStrings = {};
		JComboBox<String> spellNumberBox = new JComboBox<String>(spellNumberStrings);
		this.add(spellNumberLabel);
		this.add(spellNumberBox);
		
		JLabel useCountLabel = new JLabel("Use count:");
		String[] useCountStrings = {};
		JComboBox<String> useCountBox = new JComboBox<String>(useCountStrings);
		this.add(useCountLabel);
		this.add(useCountBox);
		
		JLabel priceOneLabel = new JLabel("Price one:");
		JTextField priceOneField = new JTextField();
		this.add(priceOneLabel);
		this.add(priceOneField);
		
		JLabel priceTwoLabel = new JLabel("Price two:");
		JTextField priceTwoField = new JTextField();
		this.add(priceTwoLabel);
		this.add(priceTwoField);
		
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
		
		JButton saveButton = new JButton("Store changes");
		this.add(saveButton);
		
		ActionListener saveClick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				String itemName = (String) itemComboBox.getSelectedItem();
				if(itemName.equals("None selected")){
					//do nothing
				} else {
					BaseItem bi = bis.getItemByName(itemName);

					//bi.setName(nameField.getText());
					bi.setNamePointer(Long.parseLong(namePointerField.getText()));
					//magicalNameField.setText();
					bi.setMagicalNamePointer(Long.parseLong(magicalNamePointerField.getText()));
					//activationTriggerBox
					//itemTypeBox
					//equipLocationBox
					//graphicValueBox
					//itemCodeBox
					//uniqueItemCodeBox
					bi.setQualityLevel(Long.parseLong(qualityLevelField.getText()));
					bi.setDurability(Long.parseLong(durabilityField.getText()));
					bi.setMinAttackDamage(Long.parseLong(minAttackDamageField.getText()));
					bi.setMaxAttackDamage(Long.parseLong(maxAttackDamageField.getText()));
					bi.setMinAc(Long.parseLong(minAcField.getText()));
					bi.setMaxAc(Long.parseLong(maxAcField.getText()));
					bi.setRequiredStr(Integer.parseInt(requiredStrField.getText()));
					bi.setRequiredDex(Integer.parseInt(requiredDexField.getText()));
					bi.setRequiredMag(Integer.parseInt(requiredMagField.getText()));
					bi.setRequiredVit(Integer.parseInt(requiredVitField.getText()));
					bi.setSpecialEffects(Long.parseLong(specialEffectsField.getText()));
					//magicCodeBox
					//spellNumberBox
					//useCountBox
					bi.setPriceOne(Long.parseLong(priceOneField.getText()));
					bi.setPriceTwo(Long.parseLong(priceTwoField.getText()));
				}
			}
		};
		saveButton.addActionListener(saveClick);
	}
}
