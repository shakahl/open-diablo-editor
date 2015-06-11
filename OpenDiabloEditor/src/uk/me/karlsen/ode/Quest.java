package uk.me.karlsen.ode;

public class Quest {

	String[] specialLevels = {
			"NA",
			"King Leoric's Tomb",
			"The Chamber of Bone",
			"Maze",
			"Dark Passage",
			"Unholy Altar"
	};

	String[] dungeonTypes = {
		"Tristram",  // 0
		"Cathedral", // 1
		"Catacombs", // 2
		"Caves",     // 3
		"Hell"       // 4
		             // -1 (0xFF) = "None"
	};

	String[] textEntries = {
		// ### [ NOTE ] ###
		//
		// Crude copy of the text strings contained within the game.
		//
		// TODO: Add a copy of the original text strings which include proper
		// punctuation, correct title casing and non-truncated words.
		//
		// ### [/ NOTE ] ###
		"Ahh The Story Of Our King Is It? The Tragic Fall Of Leoric Wa",
		"The Village Needs Your Help Good Master Some Months Ago King L",
		"As I Told You Good Master The King Was Entombed Three Levels B",
		"The Curse Of Our King Has Passed But I Fear That It Was Only Pa",
		"The Loss Of His Son Was Too Much For King Leoric_ I Did What I C",
		"I Don T Like To Think About How The King Died_ I Like To Remembe",
		"I Made Many Of The Weapons And Most Of The Armor That King Leori",
		"I Don T Care About That_ Listen No Skeleton Is Gonna Be My King",
		"The Dead Who Walk Among The Living Follow The Cursed King_ He Ho",
		"Look I M Running A Business Here_ I Don T Sell Information And",
		"The Warmth Of Life Has Entered My Tomb_ Prepare Yourself Mortal",
		"I See That This Strange Behavior Puzzles You As Well_ I Would Su",
		"Master I Have A Strange Experience To Relate_ I Know That You H",
		"Oh You Didn T Have To Bring Back My Sign But I Suppose That It",
		"My Goodness Demons Running About The Village At Night Pillagin",
		"Oh My Is That Where The Sign Went? My Grandmother And I Must Ha",
		"Demons Stole Ogden S Sign You Say? That Doesn T Sound Much Like",
		"You Know What I Think? Somebody Took That Sign And They Gonna W",
		"No Mortal Can Truly Understand The Mind Of The Demon_ Never L",
		"What Is He Saying I Took That? I Suppose That Griswold Is On H",
		"Hey You That One That Kill All You Get Me Magic Banner Or We",
		"You Kill Uglies Get Banner_ You Bring To Me Or Else___",
		"You Give Yes Good Go Now We Strong_ We Kill All With Big Mag",
		"This Does Not Bode Well For It Confirms My Darkest Fears_ While",
		"You Must Hurry And Rescue Albrecht From The Hands Of Lazarus_ Th",
		"Your Story Is Quite Grim My Friend_ Lazarus Will Surely Burn In",
		"Lazarus Was The Archbishop Who Led Many Of The Townspeople Into",
		"|",
		"|",
		"I Was Shocked When I Heard Of What The Townspeople Were Planning",
		"I Remember Lazarus As Being A Very Kind And Giving Man_ He Spoke",
		"I Was There When Lazarus Led Us Into The Labyrinth_ He Spoke Of",
		"They Stab Then Bite Then They Re All Around You_ Liar Liar T",
		"I Did Not Know This Lazarus Of Whom You Speak But I Do Sense A",
		"Yes The Righteous Lazarus Who Was Sooo Effective Against Those",
		"Abandon Your Foolish Quest_ All That Awaits You Is The Wrath Of",
		"|",
		"Hmm I Don T Know What I Can Really Tell You About This That Wil",
		"I Have Always Tried To Keep A Large Supply Of Foodstuffs And Dri",
		"I M Glad I Caught Up To You In Time Our Wells Have Become Brack",
		"Please You Must Hurry_ Every Hour That Passes Brings Us Closer",
		"What S That You Say The Mere Presence Of The Demons Had Caused",
		"My Grandmother Is Very Weak And Garda Says That We Cannot Drink",
		"Pepin Has Told You The Truth_ We Will Need Fresh Water Badly An",
		"You Drink Water?",
		"The People Of Tristram Will Die If You Cannot Restore Fresh Wate",
		"For Once I M With You_ My Business Runs Dry So To Speak If",
		"A Book That Speaks Of A Chamber Of Human Bones? Well A Chamber",
		"I Am Afraid That I Don T Know Anything About That Good Master_",
		"This Sounds Like A Very Dangerous Place_ If You Venture There P",
		"I Am Afraid That I Haven T Heard Anything About That_ Perhaps Ca",
		"I Know Nothing Of This Place But You May Try Asking Cain_ He Ta",
		"Okay So Listen_ There S This Chamber Of Wood See_ And His Wife",
		"You Will Become An Eternal Servant Of The Dark Lords Should You",
		"A Vast And Mysterious Treasure You Say? Maybe I Could Be Intere",
		"It Seems That The Archbishop Lazarus Goaded Many Of The Townsmen",
		"Yes Farnham Has Mumbled Something About A Hulking Brute Who Wie",
		"By The Light I Know Of This Vile Demon_ There Were Many That Bo",
		"When Farnham Said Something About A Butcher Killing People I Im",
		"I Saw What Farnham Calls The Butcher As It Swathed A Path Throug",
		"Big Big Cleaver Killing All My Friends_ Couldn T Stop Him Had",
		"The Butcher Is A Sadistic Creature That Delights In The Torture",
		"I Know More Than You D Think About That Grisly Fiend_ His Little",
		"Please Listen To Me_ The Archbishop Lazarus He Led Us Down Her",
		"|",
		"You Recite An Interesting Rhyme Written In A Style That Reminds",
		"I Never Much Cared For Poetry_ Occasionally I Had Cause To Hire",
		"This Does Seem Familiar Somehow_ I Seem To Recall Reading Somet",
		"If You Have Questions About Blindness You Should Talk To Pepin_",
		"I Am Afraid That I Have Neither Heard Nor Seen A Place That Matc",
		"Look Here___ That S Pretty Funny Huh? Get It? Blind Look Here",
		"This Is A Place Of Great Anguish And Terror And So Serves Its M",
		"Lets See Am I Selling You Something? No_ Are You Giving Me Mone",
		"You Claim To Have Spoken With Lachdanan? He Was A Great Hero Dur",
		"You Speak Of A Brave Warrior Long Dead I Ll Have No Such Talk O",
		"A Golden Elixir You Say_ I Have Never Concocted A Potion Of Tha",
		"I Ve Never Heard Of A Lachdanan Before_ I M Sorry But I Don T T",
		"If It Is Actually Lachdanan That You Have Met Then I Would Advi",
		"Lachdanan Is Dead_ Everybody Knows That And You Can T Fool Me",
		"You May Meet People Who Are Trapped Within The Labyrinth Such A",
		"Wait Let Me Guess_ Cain Was Swallowed Up In A Gigantic Fissure",
		"Please Don T Kill Me Just Hear Me Out_ I Was Once Captain Of K",
		"You Have Not Found The Golden Elixir_ I Fear That I Am Doomed Fo",
		"You Have Saved My Soul From Damnation And For That I Am In Your",
		"Griswold Speaks Of The Anvil Of Fury A Legendary Artifact Long",
		"Don T You Think That Griswold Would Be A Better Person To Ask Ab",
		"If You Had Been Looking For Information On The Pestle Of Curing",
		"Griswold S Father Used To Tell Some Of Us When We Were Growing U",
		"Greetings It S Always A Pleasure To See One Of My Best Customer",
		"Nothing Yet Eh? Well Keep Searching_ A Weapon Forged Upon The",
		"I Can Hardly Believe It This Is The Anvil Of Fury Good Work",
		"Griswold Can T Sell His Anvil_ What Will He Do Then? And I D Be",
		"There Are Many Artifacts Within The Labyrinth That Hold Powers B",
		"If You Were To Find This Artifact For Griswold It Could Put A S",
		"The Gateway Of Blood And The Halls Of Fire Are Landmarks Of Myst",
		"Every Child Hears The Story Of The Warrior Arkaine And His Mysti",
		"Hmm___ It Sounds Like Something I Should Remember But I Ve Been",
		"The Story Of The Magic Armor Called Valor Is Something I Often H",
		"The Armor Known As Valor Could Be What Tips The Scales In Your F",
		"Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz___",
		"Should You Find These Stones Of Blood Use Them Carefully_ Th",
		"You Intend To Find The Armor Known As Valor? No One Has Ever",
		"I Know Of Only One Legend That Speaks Of Such A Warrior As You D",
		"I Am Afraid That I Haven T Heard Anything About Such A Vicious W",
		"Cain Would Be Able To Tell You Much More About Something Like Th",
		"If You Are To Battle Such A Fierce Opponent May Light Be Your G",
		"Dark And Wicked Legends Surrounds The One Warlord Of Blood_ Be W",
		"Always You Gotta Talk About Blood? What About Flowers And Sunsh",
		"His Prowess With The Blade Is Awesome And He Has Lived For Thou",
		"I Haven T Ever Dealt With This Warlord You Speak Of But He Soun",
		"My Blade Sings For Your Blood Mortal And By My Dark Masters It",
		"Griswold Speaks Of The Heaven Stone That Was Destined For The En",
		"The Caravan Stopped Here To Take On Some Supplies For Their Jour",
		"I Don T Know What It Is That They Thought They Could See With Th",
		"Well A Caravan Of Some Very Important People Did Stop Here But",
		"Stay For A Moment I Have A Story You Might Find Interesting_ A",
		"I Am Still Waiting For You To Bring Me That Stone From The Heave",
		"Let Me See That Aye___ Aye It Is As I Believed_ Give Me A Mom",
		"I Used To Have A Nice Ring It Was A Really Expensive One With",
		"The Heaven Stone Is Very Powerful And Were It Any But Griswold",
		"If Anyone Can Make Something Out Of That Rock Griswold Can_ He",
		"The Witch Adria Seeks A Black Mushroom? I Know As Much About Bla",
		"Let Me Just Say This_ Both Garda And I Would Never Ever Serve B",
		"The Witch Told Me That You Were Searching For The Brain Of A Dem",
		"Excellent This Is Just What I Had In Mind_ I Was Able To Finish",
		"I Think Ogden Might Have Some Mushrooms In The Storage Cellar_ W",
		"If Adria Doesn T Have One Of These You Can Bet That S A Rare Th",
		"Ogden Mixes A Mean Black Mushroom But I Get Sick If I Drink Tha",
		"What Do We Have Here? Interesting It Looks Like A Book Of Reage",
		"It S A Big Black Mushroom That I Need_ Now Run Off And Get It F",
		"Yes This Will Be Perfect For A Brew That I Am Creating_ By The",
		"Why Have You Brought That Here? I Have No Need For A Demon S Bra",
		"What? Now You Bring Me That Elixir From The Healer? I Was Able T",
		"I Don T Have Any Mushrooms Of Any Size Or Color For Sale_ How Ab",
		"So The Legend Of The Map Is Real_ Even I Never Truly Believed A",
		"Our Time Is Running Short I Sense His Dark Power Building And O",
		"I Am Sure That You Tried Your Best But I Fear That Even Your St",
		"If The Witch Can T Help You And Suggests You See Cain What Make",
		"I Can T Make Much Of The Writing On This Map But Perhaps Adria",
		"The Best Person To Ask About That Sort Of Thing Would Be Our Sto",
		"I Have Never Seen A Map Of This Sort Before_ Where D You Get It?",
		"Listen Here Come Close_ I Don T Know If You Know What I Know B",
		"Oh I M Afraid This Does Not Bode Well At All_ This Map Of The S",
		"I Ve Been Looking For A Map But That Certainly Isn T It_ You Sh",
		"Pleeeease No Hurt_ No Kill_ Keep Alive And Next Time Good Bring",
		"Something For You I Am Making_ Again Not Kill Gharbad_ Live And",
		"Nothing Yet Almost Done_ Very Powerful Very Strong_ Live L",
		"This Too Good For You_ Very Powerful You Want You Take",
		"What? Why Are You Here? All These Interruptions Are Enough To M",
		"Arrrrgh Your Curiosity Will Be The Death Of You",
		"Hello My Friend_ Stay Awhile And Listen___",
		"While You Are Venturing Deeper Into The Labyrinth You May Find T",
		"I Know Of Many Myths And Legends That May Contain Answers To Que",
		"Griswold A Man Of Great Action And Great Courage_ I Bet He Nev",
		"Ogden Has Owned And Run The Rising Sun Inn And Tavern For Almost",
		"Poor Farnham_ He Is A Disquieting Reminder Of The Doomed Assembl",
		"The Witch Adria Is An Anomaly Here In Tristram_ She Arrived Sh",
		"The Story Of Wirt Is A Frightening And Tragic One_ He Was Taken",
		"Ah Pepin_ I Count Him As A True Friend Perhaps The Closest I",
		"Gillian Is A Fine Woman_ Much Adored For Her High Spirits And He",
		"Greetings Good Master_ Welcome To The Tavern Of The Rising Sun",
		"Many Adventurers Have Graced The Tables Of My Tavern And Ten Ti",
		"Griswold The Blacksmith Is Extremely Knowledgeable About Weapons",
		"Farnham Spends Far Too Much Time Here Drowning His Sorrows In C",
		"Adria Is Wise Beyond Her Years But I Must Admit She Frightens",
		"If You Want To Know More About The History Of Our Village The S",
		"Wirt Is A Rapscallion And A Little Scoundrel_ He Was Always Gett",
		"Pepin Is A Good Man And Certainly The Most Generous In The Vil",
		"Gillian My Barmaid? If It Were Not For Her Sense Of Duty To Her",
		"What Ails You My Friend?",
		"I Have Made A Very Interesting Discovery_ Unlike Us The Creatur",
		"Before It Was Taken Over By Well Whatever Lurks Below The Cat",
		"Griswold Knows As Much About The Art Of War As I Do About The Ar",
		"Cain Is A True Friend And A Wise Sage_ He Maintains A Vast Libra",
		"Even My Skills Have Been Unable To Fully Heal Farnham_ Oh I Hav",
		"While I Use Some Limited Forms Of Magic To Create The Potions An",
		"Poor Wirt_ I Did All That Was Possible For The Child But I Know",
		"I Really Don T Understand Why Ogden Stays Here In Tristram_ He S",
		"Ogden S Barmaid Is A Sweet Girl_ Her Grandmother Is Quite Ill A",
		"Good Day How May I Serve You?",
		"My Grandmother Had A Dream That You Would Come And Talk To Me_ S",
		"The Woman At The Edge Of Town Is A Witch She Seems Nice Enough",
		"Our Blacksmith Is A Point Of Pride To The People Of Tristram_ No",
		"Cain Has Been The Storyteller Of Tristram For As Long As I Can R",
		"Farnham Is A Drunkard Who Fills His Belly With Ale And Everyone",
		"Pepin Saved My Grandmother S Life And I Know That I Can Never R",
		"I Grew Up With Wirt S Mother Canace_ Although She Was Only Slig",
		"Ogden And His Wife Have Taken Me And My Grandmother Into Their H",
		"Well What Can I Do For Ya?",
		"If You Re Looking For A Good Weapon Let Me Show This To You_ Ta",
		"The Axe? Aye That S A Good Weapon Balanced Against Any Foe_ Lo",
		"Look At That Edge That Balance_ A Sword In The Right Hands And",
		"Your Weapons And Armor Will Show The Signs Of Your Struggles Aga",
		"While I Have To Practically Smuggle In The Metals And Tools I Ne",
		"Gillian Is A Nice Lass_ Shame That Her Gammer Is In Such Poor He",
		"Sometimes I Think That Cain Talks Too Much But I Guess That Is",
		"I Was With Farnham That Night That Lazarus Led Us Into Labyrinth",
		"A Good Man Who Puts The Needs Of Others Above His Own_ You Won T",
		"That Lad Is Going To Get Himself Into Serious Trouble___ Or I Gu",
		"The Innkeeper Has Little Business And No Real Way Of Turning A P",
		"Can T A Fella Drink In Peace?",
		"The Gal Who Brings The Drinks? Oh Yeah What A Pretty Lady_ So",
		"Why Don T That Old Crone Do Somethin For A Change_ Sure Sure",
		"Cain Isn T What He Says He Is_ Sure Sure He Talks A Good Story",
		"Griswold? Good Old Griswold_ I Love Him Like A Brother We Fough",
		"Hehehe I Like Pepin_ He Really Tries You Know_ Listen Here Yo",
		"Wirt Is A Kid With More Problems Than Even Me And I Know All Ab",
		"Ogden Is The Best Man In Town_ I Don T Think His Wife Likes Me M",
		"I Wanna Tell Ya Sumthin Cause I Know All About This Stuff_ It",
		"No One Ever Lis___ Listens To Me_ Somewhere I Ain T Too Sure",
		"I Know You Gots Your Own Ideas And I Know You Re Not Gonna Beli",
		"If I Was You___ And I Ain T___ But If I Was I D Sell All That S",
		"I Sense A Soul In Search Of Answers___",
		"Wisdom Is Earned Not Given_ If You Discover A Tome Of Knowledge",
		"The Greatest Power Is Often The Shortest Lived_ You May Find Anc",
		"Though The Heat Of The Sun Is Beyond Measure The Mere Flame Of",
		"The Sum Of Our Knowledge Is In The Sum Of Its People_ Should You",
		"To A Man Who Only Knows Iron There Is No Greater Magic Than Ste",
		"Corruption Has The Strength Of Deceit But Innocence Holds The P",
		"A Chest Opened In Darkness Holds No Greater Treasure Than When I",
		"The Higher You Place Your Faith In One Man The Farther It Has T",
		"The Hand The Heart And The Mind Can Perform Miracles When They",
		"There Is Much About The Future We Cannot See But When It Comes",
		"Earthen Walls And Thatched Canopy Do Not A Home Create_ The Innk",
		"Pssst___ Over Here___",
		"Not Everyone In Tristram Has A Use Or A Market For Everythin",
		"Don T Trust Everything The Drunk Says_ Too Many Ales Have Fogged",
		"In Case You Haven T Noticed I Don T Buy Anything From Tristram_",
		"I Guess I Owe The Blacksmith My Life What There Is Of It_ Sure",
		"If I Were A Few Years Older I Would Shower Her With Whatever Ri",
		"Cain Knows Too Much_ He Scares The Life Out Of Me Even More Th",
		"Farnham Now There Is A Man With Serious Problems And I Know A",
		"As Long As You Don T Need Anything Reattached Old Pepin Is As G",
		"Adria Truly Bothers Me_ Sure Cain Is Creepy In What He Can Tell",
		"Ogden Is A Fool For Staying Here_ I Could Get Him Out Of Town Fo",
		"Beyond The Hall Of Heroes Lies The Chamber Of Bone_ Eternal Deat",
		"___and So Locked Beyond The Gateway Of Blood And Past The Hall",
		"I Can See What You See Not_ Vision Milky Then Eyes Rot_ When You",
		"The Armories Of Hell Are Home To The Warlord Of Blood_ In His Wa",
		"Beyond The Hall Of Heroes Lies The Chamber Of Bone_ Eternal Deat",
		"___and So Locked Beyond The Gateway Of Blood And Past The Hall",
		"I Can See What You See Not_ Vision Milky Then Eyes Rot_ When You",
		"The Armories Of Hell Are Home To The Warlord Of Blood_ In His Wa",
		"Beyond The Hall Of Heroes Lies The Chamber Of Bone_ Eternal Deat",
		"___and So Locked Beyond The Gateway Of Blood And Past The Hall",
		"I Can See What You See Not_ Vision Milky Then Eyes Rot_ When You",
		"The Armories Of Hell Are Home To The Warlord Of Blood_ In His Wa",
		"|",
		"|",
		"Take Heed And Bear Witness To The Truths That Lie Herein For Th",
		"Take Heed And Bear Witness To The Truths That Lie Herein For Th_0",
		"Take Heed And Bear Witness To The Truths That Lie Herein For Th_1",
		"So It Came To Be That There Was A Great Revolution Within The Bu",
		"Many Demons Traveled To The Mortal Realm In Search Of The Three",
		"So It Came To Be That The Three Prime Evils Were Banished In Spi",
		"All Praises To Diablo Lord Of Terror And Survivor Of The Dark",
		"Glory And Approbation To Diablo Lord Of Terror And Leader Of T",
		"Hail And Sacrifice To Diablo Lord Of Terror And Destroyer Of S",
		"Thank Goodness You Ve Returned Much Has Changed Since You Lived"
	};

	private int dungeonLevelSingle;
	private int dungeonLevelMulti;
	private int dungeonType;
	private int questNumber;
	private int byteFourValue;
	private int specialLevel; //SP only
	private int zeroOne;
	private int zeroTwo;
	private long mpTriggerFlag;
	private long textEntryIDX;
	private byte[] questBytes;
	int slotNumber;

	public Quest(int indexValue, byte[] questBytes, ReaderWriter rw){
		this.slotNumber = indexValue;
		dungeonLevelSingle = rw.convertUnsignedByteToInt(questBytes[0]);
		dungeonLevelMulti = rw.convertUnsignedByteToInt(questBytes[1]);
		dungeonType = rw.convertUnsignedByteToInt(questBytes[2]);
		questNumber = rw.convertUnsignedByteToInt(questBytes[3]);
		byteFourValue = rw.convertUnsignedByteToInt(questBytes[4]);
		specialLevel = rw.convertUnsignedByteToInt(questBytes[5]); //SP only
		zeroOne = rw.convertUnsignedByteToInt(questBytes[6]);
		zeroTwo = rw.convertUnsignedByteToInt(questBytes[7]);
		mpTriggerFlag = rw.convertFourBytesToNumber(questBytes[8], questBytes[9], questBytes[10], questBytes[11]);
		textEntryIDX = rw.convertFourBytesToNumber(questBytes[12], questBytes[13], questBytes[14], questBytes[15]);
		this.questBytes = questBytes;
	}

	public void printQuest(){
		System.out.println("Slot number: " + slotNumber + " (hex: " + Integer.toHexString(slotNumber) + ")");
		System.out.println("Dungeon level single: " + dungeonLevelSingle);
		System.out.println("Dungeon level multi: " + dungeonLevelMulti);
		if(dungeonType >= 0 && dungeonType <= 4){
			System.out.println("Dungeon type: " + dungeonTypes[dungeonType]);
		}
		System.out.println("Quest number: " + questNumber);
		System.out.println("Unknown: " + byteFourValue);
		System.out.println("Special level: " + specialLevels[specialLevel]);
		System.out.println("Zero: " + zeroOne);
		System.out.println("Zero: " + zeroTwo);
		System.out.println("Multi player trigger flag: " + mpTriggerFlag);
		System.out.println("Text entry IDX: `" + textEntries[(int) textEntryIDX] + "`");
		System.out.println();
	}

	public byte[] getQuestAsBytes() {
		byte[] questAsBytes = new byte[16];
		questAsBytes[0] = (byte) dungeonLevelSingle;
		questAsBytes[1] = (byte) dungeonLevelMulti;
		questAsBytes[2] = (byte) dungeonType;
		questAsBytes[3] = (byte) questNumber;
		questAsBytes[4] = (byte) byteFourValue;
		questAsBytes[5] = (byte) specialLevel;
		questAsBytes[6] = (byte) zeroOne;
		questAsBytes[7] = (byte) zeroTwo;
		questAsBytes[8] = (byte) (mpTriggerFlag >>>  0);;
		questAsBytes[9] = (byte) (mpTriggerFlag >>>  8);;
		questAsBytes[10] = (byte) (mpTriggerFlag >>>  16);;
		questAsBytes[11] = (byte) (mpTriggerFlag >>>  24);;
		questAsBytes[12] = (byte) (textEntryIDX >>>  0);;
		questAsBytes[13] = (byte) (textEntryIDX >>>  8);;
		questAsBytes[14] = (byte) (textEntryIDX >>>  16);;
		questAsBytes[15] = (byte) (textEntryIDX >>>  24);;
		//System.out.println("ORIG: " + Arrays.toString(questBytes));
		//System.out.println("BACK: " + Arrays.toString(questAsBytes));
		//System.out.println();

		return questAsBytes;
	}

	public int getDungeonLevelSingle() {
		return dungeonLevelSingle;
	}

	public void setDungeonLevelSingle(int dungeonLevelSingle) {
		this.dungeonLevelSingle = dungeonLevelSingle;
	}

	public int getDungeonLevelMulti() {
		return dungeonLevelMulti;
	}

	public void setDungeonLevelMulti(int dungeonLevelMulti) {
		this.dungeonLevelMulti = dungeonLevelMulti;
	}

	public int getDungeonType() {
		return dungeonType;
	}

	public void setDungeonType(int dungeonType) {
		this.dungeonType = dungeonType;
	}

	public int getQuestNumber() {
		return questNumber;
	}

	public void setQuestNumber(int questNumber) {
		this.questNumber = questNumber;
	}

	public int getByteFourValue() {
		return byteFourValue;
	}

	public void setByteFourValue(int byteFourValue) {
		this.byteFourValue = byteFourValue;
	}

	public int getSpecialLevel() {
		return specialLevel;
	}

	public void setSpecialLevel(int specialLevel) {
		this.specialLevel = specialLevel;
	}

	public int getZeroOne() {
		return zeroOne;
	}

	public void setZeroOne(int zeroOne) {
		this.zeroOne = zeroOne;
	}

	public int getZeroTwo() {
		return zeroTwo;
	}

	public void setZeroTwo(int zeroTwo) {
		this.zeroTwo = zeroTwo;
	}

	public long getMpTriggerFlag() {
		return mpTriggerFlag;
	}

	public void setMpTriggerFlag(long mpTriggerFlag) {
		this.mpTriggerFlag = mpTriggerFlag;
	}

	public long getTextEntryIDX() {
		return textEntryIDX;
	}

	public void setTextEntryIDX(long textEntryIDX) {
		this.textEntryIDX = textEntryIDX;
	}

	public byte[] getQuestBytes() {
		return questBytes;
	}

	public void setQuestBytes(byte[] questBytes) {
		this.questBytes = questBytes;
	}
}
