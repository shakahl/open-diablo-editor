package uk.me.karlsen.ode_gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.me.karlsen.ode.Character;

import uk.me.karlsen.ode.BaseMonster;
import uk.me.karlsen.ode.CharacterStore;

public class CharacterPanel extends JPanel {
	
	private final CharacterStore characterStore;

	public CharacterPanel(CharacterStore characterStore){
		super();
		this.characterStore = characterStore;
		
		GridLayout layout = new GridLayout(0,2);
		this.setLayout(layout);
		
		String[] charNames = characterStore.getCharacterNames();
		String[] comboBoxStrings = new String[charNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(charNames, 0, comboBoxStrings, 1, charNames.length);
		JComboBox<String> charComboBox = new JComboBox<String>(comboBoxStrings);
		charComboBox.setSelectedIndex(0);
		JLabel characterCBLabel = new JLabel("Character selected:");
		this.add(characterCBLabel);
		this.add(charComboBox);
		
		JLabel classNameLabel = new JLabel("Class name:");
		JTextField classNameField = new JTextField();
		this.add(classNameLabel);
		this.add(classNameField);
		
		JLabel initStrengthLabel = new JLabel("Init strength:");
		JTextField initStrengthField = new JTextField();
		this.add(initStrengthLabel);
		this.add(initStrengthField);
		
		JLabel maxStrengthLabel = new JLabel("Max strength:");
		JTextField maxStrengthField = new JTextField();
		this.add(maxStrengthLabel);
		this.add(maxStrengthField);
		
		JLabel initMagicLabel = new JLabel("Init magic:");
		JTextField initMagicField = new JTextField();
		this.add(initMagicLabel);
		this.add(initMagicField);
		
		JLabel maxMagicLabel = new JLabel("Max magic:");
		JTextField maxMagicField = new JTextField();
		this.add(maxMagicLabel);
		this.add(maxMagicField);
		
		JLabel initDexterityLabel = new JLabel("Init dexterity:");
		JTextField initDexterityField = new JTextField();
		this.add(initDexterityLabel);
		this.add(initDexterityField);
		
		JLabel maxDexterityLabel = new JLabel("Max dexterity:");
		JTextField maxDexterityField = new JTextField();
		this.add(maxDexterityLabel);
		this.add(maxDexterityField);
		
		JLabel initVitalityLabel = new JLabel("Init vitality:");
		JTextField initVitalityField = new JTextField();
		this.add(initVitalityLabel);
		this.add(initVitalityField);
		
		JLabel maxVitalityLabel = new JLabel("Max vitality:");
		JTextField maxVitalityField = new JTextField();
		this.add(maxVitalityLabel);
		this.add(maxVitalityField);
		
		JLabel blockingBonusLabel = new JLabel("Blocking bonus:");
		JTextField blockingBonusField = new JTextField();
		this.add(blockingBonusLabel);
		this.add(blockingBonusField);
		
		JLabel dungeonIdleFramesetLabel = new JLabel("Dungeon idle frameset:");
		JTextField dungeonIdleFramesetField = new JTextField();
		this.add(dungeonIdleFramesetLabel);
		this.add(dungeonIdleFramesetField);
		
		JLabel attackingFramesetLabel = new JLabel("Attacking frameset:");
		JTextField attackingFramesetField = new JTextField();
		this.add(attackingFramesetLabel);
		this.add(attackingFramesetField);
		
		JLabel dungeonWalkFramesetLabel = new JLabel("Dungeon walk frameset:");
		JTextField dungeonWalkFramesetField = new JTextField();
		this.add(dungeonWalkFramesetLabel);
		this.add(dungeonWalkFramesetField);
		
		JLabel blockSpeedLabel = new JLabel("Block speed (1/20 secs):");
		JTextField blockSpeedField = new JTextField();
		this.add(blockSpeedLabel);
		this.add(blockSpeedField);
		
		JLabel deathFramesetLabel = new JLabel("Death frameset:");
		JTextField deathFramesetField = new JTextField();
		this.add(deathFramesetLabel);
		this.add(deathFramesetField);
		
		JLabel castingFramesetLabel = new JLabel("Casting frameset:");
		JTextField castingFramesetField = new JTextField();
		this.add(castingFramesetLabel);
		this.add(castingFramesetField);
		
		JLabel hitRecoverySpeedLabel = new JLabel("Hit recovery speed:");
		JTextField hitRecoverySpeedField = new JTextField();
		this.add(hitRecoverySpeedLabel);
		this.add(hitRecoverySpeedField);
		
		JLabel townIdleFramesetLabel = new JLabel("Town idle frameset:");
		JTextField townIdleFramesetField = new JTextField();
		this.add(townIdleFramesetLabel);
		this.add(townIdleFramesetField);
		
		JLabel townWalkFramesetLabel = new JLabel("Town walk frameset:");
		JTextField townWalkFramesetField = new JTextField();
		this.add(townWalkFramesetLabel);
		this.add(townWalkFramesetField);
		
		JLabel oneHandedAttackSpeedLabel = new JLabel("1H attack speed:");
		JTextField oneHandedAttackSpeedField = new JTextField();
		this.add(oneHandedAttackSpeedLabel);
		this.add(oneHandedAttackSpeedField);
		
		JLabel castingSpeedLabel = new JLabel("Casting speed (1/20 secs):");
		JTextField castingSpeedField = new JTextField();
		this.add(castingSpeedLabel);
		this.add(castingSpeedField);
		
		ActionListener charListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				String charName = (String) charComboBox.getSelectedItem();
		        if(charName.equals("None selected")){
		        	//do nothing
		        } else {
		        	Character character = characterStore.getCharacterByName(charName);
		        	
		        	//monsterEnabledField.setText(String.valueOf(baseMonster.getEnabled()));
		        }
			}	
		};
		charComboBox.addActionListener(charListener);
	}
}
