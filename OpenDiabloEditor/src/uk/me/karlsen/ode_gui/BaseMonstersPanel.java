package uk.me.karlsen.ode_gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.me.karlsen.ode.BaseItem;
import uk.me.karlsen.ode.BaseMonster;
import uk.me.karlsen.ode.BaseMonsterStore;

public class BaseMonstersPanel extends JPanel {
	
	final BaseMonsterStore baseMonsterStore;
	
	public BaseMonstersPanel(BaseMonsterStore baseMonsterStore) {
		super();
		this.baseMonsterStore = baseMonsterStore;
		
		GridLayout layout = new GridLayout(0,2);
		this.setLayout(layout);
		
		String[] baseMonsterNames = baseMonsterStore.getMonsterNames();
		String[] comboBoxStrings = new String[baseMonsterNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(baseMonsterNames, 0, comboBoxStrings, 1, baseMonsterNames.length);
		JComboBox<String> monsterComboBox = new JComboBox<String>(comboBoxStrings);
		monsterComboBox.setSelectedIndex(0);
		JLabel monsterCBLabel = new JLabel("Monster selected:");
		this.add(monsterCBLabel);
		this.add(monsterComboBox);
		
		JLabel monsterNameLabel = new JLabel("Monster name:");
		JTextField monsterNameField = new JTextField();
		this.add(monsterNameLabel);
		this.add(monsterNameField);
		
		JLabel monsterEnabledLabel = new JLabel("Monster enabled:");
		JTextField monsterEnabledField = new JTextField();
		this.add(monsterEnabledLabel);
		this.add(monsterEnabledField);
		
		JLabel animationSizeLabel = new JLabel("Animation size:");
		JTextField animationSizeField = new JTextField();
		this.add(animationSizeLabel);
		this.add(animationSizeField);
		
		JLabel seedingSizeLabel = new JLabel("Seeding size:");
		JTextField seedingSizeField = new JTextField();
		this.add(seedingSizeLabel);
		this.add(seedingSizeField);
		
		JLabel animationFileLabel = new JLabel("Animation file:");
		JTextField animationFileField = new JTextField();
		this.add(animationFileLabel);
		this.add(animationFileField);
		
		JLabel animationPointerLabel = new JLabel("Animation pointer:");
		JTextField animationPointerField = new JTextField();
		this.add(animationPointerLabel);
		this.add(animationPointerField);
		
		JLabel secondAttackLabel = new JLabel("Second attack:");
		JTextField secondAttackField = new JTextField();
		this.add(secondAttackLabel);
		this.add(secondAttackField);
		
		JLabel soundFileLabel = new JLabel("Sound file:");
		JTextField soundFileField = new JTextField();
		this.add(soundFileLabel);
		this.add(soundFileField);
		
		JLabel soundPointerLabel = new JLabel("Sound pointer:");
		JTextField soundPointerField = new JTextField();
		this.add(soundPointerLabel);
		this.add(soundPointerField);
		
		JLabel secondAttackSoundLabel = new JLabel("Has second attack sound:");
		JTextField secondAttackSoundField = new JTextField();
		this.add(secondAttackSoundLabel);
		this.add(secondAttackSoundField);
		
		JLabel trnToModColorLabel = new JLabel("Uses TRN to mod color:");
		JTextField trnToModColorField = new JTextField();
		this.add(trnToModColorLabel);
		this.add(trnToModColorField);
		
		JLabel trnPointerLabel = new JLabel("TRN pointer:");
		JTextField trnPointerField = new JTextField();
		this.add(trnPointerLabel);
		this.add(trnPointerField);
		
		JLabel trnFileLabel = new JLabel("TRN file:");
		JTextField trnFileField = new JTextField();
		this.add(trnFileLabel);
		this.add(trnFileField);
		
		JLabel idleFramesetLabel = new JLabel("Idle frameset:");
		JTextField idleFramesetField = new JTextField();
		this.add(idleFramesetLabel);
		this.add(idleFramesetField);
		
		JLabel walkFramesetLabel = new JLabel("Walk frameset:");
		JTextField walkFramesetField = new JTextField();
		this.add(walkFramesetLabel);
		this.add(walkFramesetField);
		
		JLabel attackFramesetLabel = new JLabel("Attack frameset:");
		JTextField attackFramesetField = new JTextField();
		this.add(attackFramesetLabel);
		this.add(attackFramesetField);
		
		JLabel hitRecoveryFramesetLabel = new JLabel("Hit recovery frameset:");
		JTextField hitRecoveryFramesetField = new JTextField();
		this.add(hitRecoveryFramesetLabel);
		this.add(hitRecoveryFramesetField);
		
		JLabel deathFramesetLabel = new JLabel("Death frameset:");
		JTextField deathFramesetField = new JTextField();
		this.add(deathFramesetLabel);
		this.add(deathFramesetField);
		
		JLabel secondAttackFramsetLabel = new JLabel("Second attack framset:");
		JTextField secondAttackFramesetField = new JTextField();
		this.add(secondAttackFramsetLabel);
		this.add(secondAttackFramesetField);
		
		JLabel idlePlaybackSpeedLabel = new JLabel("Idle playback speed:");
		JTextField idlePlaybackSpeedField = new JTextField();
		this.add(idlePlaybackSpeedLabel);
		this.add(idlePlaybackSpeedField);
		
		JLabel walkPlaybackSpeedLabel = new JLabel("Walk playback speed:");
		JTextField walkPlaybackSpeedField = new JTextField();
		this.add(walkPlaybackSpeedLabel);
		this.add(walkPlaybackSpeedField);
		
		JLabel attackPlaybackSpeedLabel = new JLabel("Attack playback speed:");
		JTextField attackPlaybackSpeedField = new JTextField();
		this.add(attackPlaybackSpeedLabel);
		this.add(attackPlaybackSpeedField);
		
		JLabel hitRecoverySpeedLabel = new JLabel("Hit recovery speed:");
		JTextField hitRecoverySpeedField = new JTextField();
		this.add(hitRecoverySpeedLabel);
		this.add(hitRecoverySpeedField);
		
		JLabel deathPlaybackSpeedLabel = new JLabel("Death playback speed:");
		JTextField deathPlaybackSpeedField = new JTextField();
		this.add(deathPlaybackSpeedLabel);
		this.add(deathPlaybackSpeedField);
		
		JLabel secondAttackSpeedLabel = new JLabel("Second attack speed:");
		JTextField secondAttackSpeedField = new JTextField();
		this.add(secondAttackSpeedLabel);
		this.add(secondAttackSpeedField);
		
		JLabel namePointerLabel = new JLabel("Name pointer:");
		JTextField namePointerField = new JTextField();
		this.add(namePointerLabel);
		this.add(namePointerField);
		
		JLabel minDungeonLabel = new JLabel("Min. dungeon level:");
		JTextField minDungeonField = new JTextField();
		this.add(minDungeonLabel);
		this.add(minDungeonField);
		
		JLabel maxDungeonLabel = new JLabel("Max. dungeon level:");
		JTextField maxDungeonField = new JTextField();
		this.add(maxDungeonLabel);
		this.add(maxDungeonField);
		
		JLabel monsterItemLevelLabel = new JLabel("Monster item level:");
		JTextField monsterItemLevelField = new JTextField();
		this.add(monsterItemLevelLabel);
		this.add(monsterItemLevelField);
		
		JLabel minHitPointsLabel = new JLabel("Minimum hit points");
		JTextField minHitPointsField = new JTextField();
		this.add(minHitPointsLabel);
		this.add(minHitPointsField);
		
		JLabel attackType1Label = new JLabel("Attack type 1");
		JTextField attackType1Field = new JTextField();
		this.add(attackType1Label);
		this.add(attackType1Field);
		
		JLabel attackType2Label = new JLabel("Attack type 2");
		JTextField attackType2Field = new JTextField();
		this.add(attackType2Label);
		this.add(attackType2Field);
		
		JLabel attackType3Label = new JLabel("Attack type 3");
		JTextField attackType3Field = new JTextField();
		this.add(attackType3Label);
		this.add(attackType3Field);
		
		JLabel attackType4Label = new JLabel("Attack type 4");
		JTextField attackType4Field = new JTextField();
		this.add(attackType4Label);
		this.add(attackType4Field);
		
		JLabel attackType5Label = new JLabel("Attack type 5");
		JTextField attackType5Field = new JTextField();
		this.add(attackType5Label);
		this.add(attackType5Field);
		
		JLabel monsterIntelligenceLabel = new JLabel("Monster intelligence");
		JTextField monsterIntelligenceField = new JTextField();
		this.add(monsterIntelligenceLabel);
		this.add(monsterIntelligenceField);
		
		JLabel attackType7Label = new JLabel("Attack type 7");
		JTextField attackType7Field = new JTextField();
		this.add(attackType7Label);
		this.add(attackType7Field);
		
		JLabel attackType8Label = new JLabel("Attack type 8");
		JTextField attackType8Field = new JTextField();
		this.add(attackType8Label);
		this.add(attackType8Field);
		
		JLabel subTypeLabel = new JLabel("Sub-type label");
		JTextField subTypeField = new JTextField();
		this.add(subTypeLabel);
		this.add(subTypeField);
		
		JLabel monsterPriChanceToHitLabel = new JLabel("Primary attack % hit");
		JTextField monsterPriChanceToHitField = new JTextField();
		this.add(monsterPriChanceToHitLabel);
		this.add(monsterPriChanceToHitField);
		
		JLabel priToHitFrameLabel = new JLabel("Primary to hit frame");
		JTextField priToHitFrameField = new JTextField();
		this.add(priToHitFrameLabel);
		this.add(priToHitFrameField);
		
		JLabel priMinAttackDamageLabel = new JLabel("Primary min attack dmg");
		JTextField priMinAttackDamageField = new JTextField();
		this.add(priMinAttackDamageLabel);
		this.add(priMinAttackDamageField);
		
		JLabel priMaxAttackDamageLabel = new JLabel("Primary max attack dmg");
		JTextField priMaxAttackDamageField = new JTextField();
		this.add(priMaxAttackDamageLabel);
		this.add(priMaxAttackDamageField);
		
		JLabel secToHitChanceLabel = new JLabel("Sec attack % hit");
		JTextField secToHitChanceField = new JTextField();
		this.add(secToHitChanceLabel);
		this.add(secToHitChanceField);
		
		JLabel secToHitFrameLabel = new JLabel("Sec to hit frame");
		JTextField secToHitFrameField = new JTextField();
		this.add(secToHitFrameLabel);
		this.add(secToHitFrameField);
		
		JLabel secMinAttackDamageLabel = new JLabel("Sec min attack dmg");
		JTextField secMinAttackDamageField = new JTextField();
		this.add(secMinAttackDamageLabel);
		this.add(secMinAttackDamageField);
		
		JLabel secMaxAttackDamageLabel = new JLabel("Sec max attack dmg");
		JTextField secMaxAttackDamageField = new JTextField();
		this.add(secMaxAttackDamageLabel);
		this.add(secMaxAttackDamageField);
		
		JLabel monsterAcLabel = new JLabel("Monster AC");
		JTextField monsterAcField = new JTextField();
		this.add(monsterAcLabel);
		this.add(monsterAcField);
		
		JLabel monsterTypeLabel = new JLabel("Monster type");
		JTextField monsterTypeField = new JTextField();
		this.add(monsterTypeLabel);
		this.add(monsterTypeField);
		
		JLabel resistancesNormAndNightmareLabel = new JLabel("Resist norm + nightmare");
		JTextField resistancesNormAndNightmareField = new JTextField();
		this.add(resistancesNormAndNightmareLabel);
		this.add(resistancesNormAndNightmareField);
		
		JLabel resistancesHellLabel = new JLabel("Resist hell");
		JTextField resistancesHellField = new JTextField();
		this.add(resistancesHellLabel);
		this.add(resistancesHellField);
		
		JLabel itemDropSpecialsLabel = new JLabel("Item drop specials");
		JTextField itemDropSpecialsField = new JTextField();
		this.add(itemDropSpecialsLabel);
		this.add(itemDropSpecialsField);
		
		JLabel monsterSelectionOutline = new JLabel("Monster selection outline");
		JTextField monsterSelectionField = new JTextField();
		this.add(monsterSelectionOutline);
		this.add(monsterSelectionField);
		
		JLabel experiencePointsLabel = new JLabel("XP");
		JTextField experiencePointsField = new JTextField();
		this.add(experiencePointsLabel);
		this.add(experiencePointsField);
		
		ActionListener bmpcbl = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				String monsterName = (String) monsterComboBox.getSelectedItem();
		        if(monsterName.equals("None selected")){
		        	//do nothing
		        } else {
		        	BaseMonster baseMonster = baseMonsterStore.getMonsterByName(monsterName);
		        	monsterNameField.setText(baseMonster.getName());
		        	monsterEnabledField.setText(String.valueOf(baseMonster.getEnabled()));
		        	animationSizeField.setText(String.valueOf(baseMonster.getAnimationSize()));
		        	seedingSizeField.setText(String.valueOf(baseMonster.getSeedingSize()));
		        	animationFileField.setText(baseMonster.getAnimationFileName());
		        	animationPointerField.setText(String.valueOf(baseMonster.getAnimationFilePointer()));
		        	secondAttackField.setText(String.valueOf(baseMonster.getSecondAttackOnOrOff()));
		        	//soundFileField.setText("");
		        	soundPointerField.setText(String.valueOf(baseMonster.getSoundPointer()));
		        	secondAttackSoundField.setText(String.valueOf(baseMonster.getHasSecondAttackSound()));
		        	trnToModColorField.setText(String.valueOf(baseMonster.getUsesTrnToModColor()));
		        	trnPointerField.setText(String.valueOf(baseMonster.getTrnPointer()));
		        	//trnFileField.setText(String.valueOf(""));
		        	idleFramesetField.setText(String.valueOf(baseMonster.getIdleFrameset()));
		        	walkFramesetField.setText(String.valueOf(baseMonster.getWalkFrameset()));
		        	attackFramesetField.setText(String.valueOf(baseMonster.getAttackFrameset()));
		        	hitRecoveryFramesetField.setText(String.valueOf(baseMonster.getHitRecoveryFrameset()));
		        	deathFramesetField.setText(String.valueOf(baseMonster.getDeathFrameset()));
		        	secondAttackFramesetField.setText(String.valueOf(baseMonster.getSecondAttackFrameset()));
		        	idlePlaybackSpeedField.setText(String.valueOf(baseMonster.getIdlePlaybackSpeed()));
		        	walkPlaybackSpeedField.setText(String.valueOf(baseMonster.getWalkPlaybackSpeed()));
		        	attackPlaybackSpeedField.setText(String.valueOf(baseMonster.getAttackPlaybackSpeed()));
		        	hitRecoverySpeedField.setText(String.valueOf(baseMonster.getHitRecoverySpeed()));
		        	deathPlaybackSpeedField.setText(String.valueOf(baseMonster.getDeathPlaybackSpeed()));
		        	secondAttackSpeedField.setText(String.valueOf(baseMonster.getSecondAttackSpeed()));
		        	namePointerField.setText(String.valueOf(baseMonster.getNamePointer()));
		        	minDungeonField.setText(String.valueOf(baseMonster.getMinDungeonLevel()));
		        	maxDungeonField.setText(String.valueOf(baseMonster.getMaxDungeonLevel()));
		        	monsterItemLevelField.setText(String.valueOf(baseMonster.getMonsterItemLevel()));
		        	minHitPointsField.setText(String.valueOf(baseMonster.getMinHitPoints()));
		        	attackType1Field.setText(String.valueOf(baseMonster.getAttackType1()));
		        	attackType2Field.setText(String.valueOf(baseMonster.getAttackType2()));
		        	attackType3Field.setText(String.valueOf(baseMonster.getAttackType3()));
		        	attackType4Field.setText(String.valueOf(baseMonster.getAttackType4()));
		        	attackType5Field.setText(String.valueOf(baseMonster.getAttackType5()));
		        	monsterIntelligenceField.setText(String.valueOf(baseMonster.getMonsterIntelligence()));
		        	attackType7Field.setText(String.valueOf(baseMonster.getAttackType7()));
		        	attackType8Field.setText(String.valueOf(baseMonster.getAttackType8()));
		        	subTypeField.setText(String.valueOf(baseMonster.getSubType()));
		        	monsterPriChanceToHitField.setText(String.valueOf(0));
		        	priToHitFrameField.setText(String.valueOf(baseMonster.getPriToHitFrame()));
		        	priMinAttackDamageField.setText(String.valueOf(baseMonster.getPriMinAttackDamage()));
		        	priMaxAttackDamageField.setText(String.valueOf(baseMonster.getPriMaxAttackDamage()));
		        	secToHitChanceField.setText(String.valueOf(baseMonster.getSecToHitChance()));
		        	secToHitFrameField.setText(String.valueOf(baseMonster.getSecToHitFrame()));
		        	secMinAttackDamageField.setText(String.valueOf(baseMonster.getSecMinAttackDamage()));
		        	secMaxAttackDamageField.setText(String.valueOf(baseMonster.getSecMaxAttackDamage()));
		        	monsterAcField.setText(String.valueOf(baseMonster.getMonsterAc()));
		        	monsterTypeField.setText(String.valueOf(baseMonster.getMonsterType()));
		        	resistancesNormAndNightmareField.setText(String.valueOf(baseMonster.getResistancesNormAndNightmare()));
		        	resistancesHellField.setText(String.valueOf(baseMonster.getResistancesHell()));
		        	itemDropSpecialsField.setText(String.valueOf(baseMonster.getItemDropSpecials()));
		        	monsterSelectionField.setText(String.valueOf(baseMonster.getMonsterSelectionOutline()));
		        	experiencePointsField.setText(String.valueOf(baseMonster.getExperiencePoints()));
		        }
			}	
		};
		monsterComboBox.addActionListener(bmpcbl);
	}

}
