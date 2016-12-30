package uk.me.karlsen.ode.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.me.karlsen.ode.stores.QuestStore;
import uk.me.karlsen.ode.types.Quest;

public class QuestsPanel extends JPanel {

	private QuestStore questStore;
	
	public QuestsPanel(QuestStore questStore)
	{
		super();
		this.questStore = questStore;
		
		GridLayout layout = new GridLayout(0,2);
		this.setLayout(layout);
		
		String[] questNames = questStore.getQuestNames();
		String[] comboBoxStrings = new String[questNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(questNames, 0, comboBoxStrings, 1, questNames.length);
		JComboBox<String> comboBox = new JComboBox<String>(comboBoxStrings);
		comboBox.setSelectedIndex(0);
		
		JLabel cbLabel = new JLabel("Quest selected:");
		this.add(cbLabel);
		this.add(comboBox);
		
		JLabel slotNumberLabel = new JLabel("Slot number:");
		JTextField slotNumberField = new JTextField();
		this.add(slotNumberLabel);
		this.add(slotNumberField);
		
		JLabel dungeonLevelSingleLabel = new JLabel("Dungeon level in SP:");
		JTextField dungeonLevelSingleField = new JTextField();
		this.add(dungeonLevelSingleLabel);
		this.add(dungeonLevelSingleField);
		
		JLabel dungeonLevelMultiLabel = new JLabel("Dungeon level in MP:");
		JTextField dungeonLevelMultiField = new JTextField();
		this.add(dungeonLevelMultiLabel);
		this.add(dungeonLevelMultiField);
		
		JLabel dungeonTypeLabel = new JLabel("Dungeon type:");
		JTextField dungeonTypeField = new JTextField();
		this.add(dungeonTypeLabel);
		this.add(dungeonTypeField);
		
		JLabel questNumberLabel = new JLabel("Quest number:");
		JTextField questNumberField = new JTextField();
		this.add(questNumberLabel);
		this.add(questNumberField);
		
		JLabel byteFourValueLabel = new JLabel("Byte four value:");
		JTextField byteFourValueField = new JTextField();
		this.add(byteFourValueLabel);
		this.add(byteFourValueField);
		
		JLabel specialLevelLabel = new JLabel("Special level?");
		JTextField specialLevelField = new JTextField();
		this.add(specialLevelLabel);
		this.add(specialLevelField);
		
		JLabel zeroOneLabel = new JLabel("Zero one:");
		JTextField zeroOneField = new JTextField();
		this.add(zeroOneLabel);
		this.add(zeroOneField);
		
		JLabel zeroTwoLabel = new JLabel("Zero two:");
		JTextField zeroTwoField = new JTextField();
		this.add(zeroTwoLabel);
		this.add(zeroTwoField);
		
		JLabel mpTriggerFlagLabel = new JLabel("MP trigger flag:");
		JTextField mpTriggerFlagField = new JTextField();
		this.add(mpTriggerFlagLabel);
		this.add(mpTriggerFlagField);
		
		JLabel textEntryIndexLabel = new JLabel("Text entry index:");
		JTextField textEntryIndexField = new JTextField();
		this.add(textEntryIndexLabel);
		this.add(textEntryIndexField);
		
		ActionListener questListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String questName = (String) comboBox.getSelectedItem();
				if(questName.equals("None selected")){
					slotNumberField.setText("");
					dungeonLevelSingleField.setText("");
					dungeonLevelMultiField.setText("");
					dungeonTypeField.setText("");
					questNumberField.setText("");
					byteFourValueField.setText("");
					specialLevelField.setText("");
					zeroOneField.setText("");
					zeroTwoField.setText("");
					mpTriggerFlagField.setText("");
					textEntryIndexField.setText("");
				} else {
					Quest quest = questStore.getQuestByName(questName);
					slotNumberField.setText(questName);
					dungeonLevelSingleField.setText(String.valueOf(quest.getDungeonLevelSingle()));
					dungeonLevelMultiField.setText(String.valueOf(quest.getDungeonLevelMulti()));
					dungeonTypeField.setText(String.valueOf(quest.getDungeonType()));
					questNumberField.setText(String.valueOf(quest.getQuestNumber()));
					byteFourValueField.setText(String.valueOf(quest.getByteFourValue()));
					specialLevelField.setText(String.valueOf(quest.getSpecialLevel()));
					zeroOneField.setText(String.valueOf(quest.getZeroOne()));
					zeroTwoField.setText(String.valueOf(quest.getZeroTwo()));
					mpTriggerFlagField.setText(String.valueOf(quest.getMpTriggerFlag()));
					textEntryIndexField.setText(String.valueOf(quest.getTextEntryIDX()));
				}
			}
			
		};
		comboBox.addActionListener(questListener);
		
		JButton saveButton = new JButton("Store changes");
		this.add(saveButton);
		
		ActionListener saveClick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String questName = (String) comboBox.getSelectedItem();
				if(questName.equals("None selected")){
					//do nothing
				} else {
					Quest quest = questStore.getQuestByName(questName);
					//TODO -- set quest name
					quest.setQuestNumber(Integer.parseInt(slotNumberField.getText()));
					quest.setDungeonLevelSingle(Integer.parseInt(dungeonLevelSingleField.getText()));
					quest.setDungeonLevelMulti(Integer.parseInt(dungeonLevelMultiField.getText()));
					quest.setDungeonType(Integer.parseInt(dungeonTypeField.getText()));
					quest.setQuestNumber(Integer.parseInt(questNumberField.getText()));
					quest.setByteFourValue(Integer.parseInt(byteFourValueField.getText()));
					quest.setSpecialLevel(Integer.parseInt(specialLevelField.getText()));
					quest.setZeroOne(Integer.parseInt(zeroOneField.getText()));
					quest.setZeroTwo(Integer.parseInt(zeroTwoField.getText()));
					quest.setMpTriggerFlag(Long.parseLong(mpTriggerFlagField.getText()));
					quest.setTextEntryIDX(Long.parseLong(textEntryIndexField.getText()));
				}
			}
		};
		saveButton.addActionListener(saveClick);
	}
}
