package playerMeta;



/***
 * This enumeration contains the metadata for all the cypher system character descriptors:
 * keyName , skillArray, abilityArray, mightMod, speedMod, and intellectMod.
 * These descriptors have been slightly adapted from the original rule book for easier player usability.
 ***/
public enum Descriptor {

    APPEALING(
            "appealing",
            new Skill[]{
                    new Skill("pleasant social interactions",true, false,false),
                    new Skill("resisting any kind of persuasion",true,false,false)
            },
            new Abilities[]{},
            0,0,1
    ),
    BENEFICENT(
            "beneficent",
            new Skill[]{
                    new Skill("pleasant social interactions",true, false,false),
                    new Skill("gaining trust",true,false,false),
                    new Skill("putting other people at ease",true,false, false),
                    new Skill("being alone", false, false, true)
            },
            new Abilities[]{
                    new Abilities("Generous","description", 0,
                    "Allies who have spent the last day with you add +1 to their recovery rolls."),
                    new Abilities("Altruistic","any",1,
                            "If you’re standing next to a creature that takes damage, you can intercede " +
                                    "and take 1 point of that damage yourself"),
                    new Abilities("Helpful","description",0,
                            "Whenever you help another character, that character gains the benefit as if you" +
                                    " were trained even if you are not trained or specialized in the attempted task.")
            },
            0,0,0
    ),
    BRASH("brash",
            new Skill[]{
                    new Skill("initiative",true, false, false),
                    new Skill("overcoming fear",true, false,false),
            },
            new Abilities[]{},
            0,2,0 ),
    CALM("calm",
            new Skill[]{
                    new Skill(), new Skill(), new Skill(), new Skill(),
                    new Skill("All physical attacks",false,false,true),
                    new Skill("Climb",false,false,true),
                    new Skill("Running",false,false,true),
                    new Skill("Jumping",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Trivia","description", 0,
                            "You can come up with a random fact pertinent to the current situation when " +
                                    "you wish it. This is always a matter of fact, not conjecture or supposition, " +
                                    "and must be something you could have logically read or seen in the past. " +
                                    "You can do this one time, although the ability is " +
                                    "renewed each time you make a recovery roll.")
            },
            0,0,2
    ),
    CHAOTIC("chaotic",
            new Skill[]{
                    new Skill("Mental Defence",true,false,false),
                    new Skill("Might Defense",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Chaotic sleeper","description",0,
                        "Once after each ten-hour recovery roll, if you don’t like the first result, you can " +
                            "re-roll a die roll of your choice. If you do, and regardless of the outcome," +
                            " the GM presents you with a GM intrusion.")
            },
            0,4,0 ),
    CHARMING(" charming",
            new Skill[]{
                    new Skill("pleasant social interaction",true,false,false),
                    new Skill("influence the minds of others",true,false,false),
                    new Skill("studying or retaining facts",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Contact","description",0,"You have a friend in high places.")
            },
            0,0,2 ),
    CLEVER("clever",
            new Skill[]{
                    new Skill("trickery",true,false,false),
                    new Skill("resist mental effects", true, false,false),
                    new Skill(" identifying/assessing",true,false,false),
                    new Skill("retaining trivial knowledge", false, false, true)
            },
            new Abilities[]{},
            0,0,2 ),
    CLUMSY("clumsy",
            new Skill[]{
                    new Skill("pleasant social interactions",true,false,false),
                    new Skill("breaking things",true,false,false),
                    new Skill("balance, grace, or hand-to-eye",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Dumb Luck","description",0,
                            "The GM can introduce a GM intrusion on you, based on your clumsiness," +
                                    " without awarding you any XP (as if you had rolled a 1 on a d20 roll)." +
                                    " However, if this happens, 50% of the time," +
                                    " your clumsiness works to your advantage.")
            },
            2,-2,0 ),
    CRAVEN("craven",
            new Skill[]{
                    new Skill("Stealth",true,false,false),
                    new Skill("Running",true,false,false),
                    new Skill("Escape Danger",true,false,false),
                    new Skill("Initiative",false,false,true),
                    new Skill("Fighting Solo",false,false,true),

            },
            new Abilities[]{},
            0,2,0 ),
    CREATIVE("creative",
            new Skill[]{
                    new Skill("Story Telling",true,false,false),
                    new Skill("Artistic",true,false,false),
                    new Skill("Puzzle-solving",true,false,false),
                    new Skill("Learning something new",true,false,false),
                    new Skill("Pleasant social interaction",false,false,true),
            },
            new Abilities[]{},
            0,0,2 ),
    CRUEL("cruel",
            new Skill[]{
                    new Skill("Influencing people experiencing physical or emotional pain",true,false,false),
                    new Skill("Sensing motives, feelings, or disposition of others",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Torture","description",0,
                            "You can choose to maim or deliver painful injuries " +
                                    "to draw out your foe’s suffering. Whenever you inflict damage," +
                                    " you can choose to inflict 2 fewer points of damage " +
                                    "to make your next action against that foe easier by on step.")
            },
            0,0,2 ),
    DISHONORABLE("dishonorable",
            new Skill[]{
                    new Skill("Deception",true,false,false),
                    new Skill("Stealth",true,false,false),
                    new Skill("Intimidation",true,false,false),
                    new Skill("Pleasant social interaction",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Just Desserts","description",0,
                            "When the GM gives another player an experience point to award to someone for" +
                                    " a GM intrusion, that player cannot give it to you.")
            },
            0,4,0 ),
    DOOMED("doomed",
            new Skill[]{
                    new Skill("Perception",true,false,false),
                    new Skill("Speed defense",true,false,false),
                    new Skill("Intellect defense",true,false,false),
            },
            new Abilities[]{
                    new Abilities("Damned","description",0,
                            "Every other time the GM uses GM intrusion on your character, you cannot refuse it" +
                                    " and do not get an XP for it (you still get an XP to award to another player)." +
                                    " This is because you are doomed.")
            },
            0,2,0 ),
    EMPATHIC("empathic",
            new Skill[]{
                    new Skill("Sensing motives, feelings, or disposition of others",true,false,false),
                    new Skill("Social interaction",true,false,false),
                    new Skill("Intellect defense",false,false,true),
            },
            new Abilities[]{},
            0,0,4 ),
    EXILED("exiled",
            new Skill[]{
                    new Skill("Sneaking",true,false,false),
                    new Skill("Wilderness Survival",true,false,false),
                    new Skill("Social interaction",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Loner","description",0,
                            "You gain no benefit when you get help with a task from another character" +
                                    " who is trained or specialized in that task.")
            },
            2,0,0 ),
    FAST("fast",
            new Skill[]{
                    new Skill("Running",true,false,false),
                    new Skill("Social interaction",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Quick Movement","description",0,
                            "You can move a short distance and still take another action in the same round," +
                                    " or you can move a long distance as your action without" +
                                    " needing to make any kind of roll.")
            },
            0,2,0 ),
    FOOLISH("foolish",
            new Skill[]{
                    new Skill("Intellect defense",false,false,true),
                    new Skill("Sensing deceptions, illusions, or traps",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Care Free","description",0,
                            "You succeed more on luck than anything. Every time you roll for a task," +
                                    " roll twice and take the higher result."),
                    new Abilities("Soft in the Head","description",0,
                            "Any time you spend points from your Intellect Pool, " +
                                    "it costs you 1 more point than usual."),
            },
            0,0,-4 ),
    GRACEFUL("graceful",
            new Skill[]{
                    new Skill("Balance",true,false,false),
                    new Skill("Physical performing arts",true,false,false),
                    new Skill("Speed defense",true,false,false),
            },
            new Abilities[]{},
            0,2,0 ),
    GUARDED("guarded",
            new Skill[]{
                    new Skill("Intellect defense",true,false,false),
                    new Skill("Discerning the truth",true,false,false),
                    new Skill("Deception/Persuasion",false,false,true),
            },
            new Abilities[]{},
            0,0,2 ),
    HARDY("hardy",
            new Skill[]{
                    new Skill("Might defense",true,false,false),
                    new Skill("Initiative",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Fast Healer","description",0,
                            "You halve the time it takes to make a recovery roll (minimum one action)"),
                    new Abilities("Almost Unstoppable","description",0,
                            "You don’t suffer the effects of being impaired until you become debilitated," +
                                    " and you never suffer the effects of being debilitated." +
                                    " You still die if all your stat Pools are 0."),
                    new Abilities("Ponderous","description",0,
                            "When you apply Effort when making a Speed roll, " +
                                    "you must spend 1 extra point from your Speed Pool."),
            },
            4,0,0 ),
    HIDEOUS("hideous",
            new Skill[]{
                    new Skill("Disguise",true,false,false),
                    new Skill("Deception/Persuasion",false,false,true),
            },
            new Abilities[]{
                    new Abilities("Face of Fear","description",0,
                            "Any time a NPC sees your real face they will fear you as if you where a monster"),
            },
            2,2,2 ),
    HONORABLE("honorable",
            new Skill[]{
                    new Skill("Pleasant social interactions",true,false,false),
                    new Skill("Discerning the motives",true,false,false),
            },
            new Abilities[]{},
            2,0,0 ),
    IMPULSIVE("impulsive",
            new Skill[]{
                    new Skill("Initiative",true,false,false),
                    new Skill("Speed defense",true,false,false),
                    new Skill("Self-control",false,false,true),
            },
            new Abilities[]{},
            0,2,0 ),
    INQUISITIVE("appealing",
            new Skill[]{
                    new Skill("Learning something new",true,false,false),
                    new Skill("geography/history",true,false,false),
                    new Skill("Perceiving danger",false,false,true),
                    new Skill("Initiative",false,false,true)
            },
            new Abilities[]{},
            0,0,4 ),
    INTELLIGENT("intelligent",
            new Skill[]{
                    new Skill("Remembering",true,false,false),
            },
            new Abilities[]{}
            ,0,0,5 ),
    INTUITIVE("intuitive",
            new Skill[]{
                    new Skill("Perception",true,false,false)
            },
            new Abilities[]{
                    new Abilities("Always has a Plan","description",0,
                            "You can act immediately, even if it’s not your turn. Afterward, " +
                                    "on your next regular turn, any action you take is hindered." +
                                    " You can do this one time, although the ability is" +
                                    " renewed each time you make a recovery roll.")
            },
            0,0,2 ),
    JOVIAL("jovial",
            new Skill[]{
                    new Skill("Pleasant social interaction",true,false,false),
                    new Skill("Solving puzzles/riddles",true,false,false),
                    new Skill("Detecting falsehoods",false,false,true)
            },
            new Abilities[]{},
            0,0,2 ),
    KIND("kind",
            new Skill[]{
                    new Skill("Pleasant social interaction",true,false,false),
                    new Skill("Discerning the dispositions",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Always has a Plan","description",0,
                            "You gain the aid of a stranger by using a recovery roll" +
                                    " (without gaining its healing benefit), " +
                                    "and the GM determines the nature of the aid you gain.")
            },
            0,0,2 ),
    LEARNED("learned",
            new Skill[]{
                    new Skill("Knowledge of the world",true,false,false),
                    new Skill("Charm/persuasion/etiquette",false,false,true)
            },
            new Abilities[]{},
            0,0,2 ),
    LUCKY("lucky",
            new Skill[]{},
            new Abilities[]{
                    new Abilities("Luck Pool","description",0,
                            "You have one additional Pool called Luck that begins with 3 points. When spending" +
                                    " points from any other Pool, you can take points from your Luck Pool instead." +
                                    "When you recover points to any other Pool, your Luck Pool is also refreshed " +
                                    "by the same number of points "),
                    new Abilities("Lucky Dice","description",0,
                            "When you use 1 XP to re-roll a d20 for any roll that affects only you," +
                                    " add 3 to the re-roll.")
            },
            0,0,0 ),
    MAD("mad",
            new Skill[]{
                    new Skill("Intimidation",true,false,false),
                    new Skill("Intellect defense",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Fits of Insight","description",0,
                            "Whenever such knowledge is appropriate, the GM feeds you information although" +
                                    " there is no clear explanation as to how you could know such a thing." +
                                    " This is up to the GM’s discretion, but it should happen as often" +
                                    " as once each session."),
                    new Abilities("Erratic Behavior","description",0,
                            "You are prone to acting erratically or irrationally." +
                                    " When you are in the presence of a major discovery or subjected to great stress," +
                                    " the GM can introduce a GM intrusion that directs your next action" +
                                    " without awarding XP. You can still pay 1 XP to refuse the intrusion. " +
                                    "The GM’s influence is the manifestation of your madness and thus is always " +
                                    "something you would not likely do otherwise, but it is not directly, obviously" +
                                    " harmful to you unless there are extenuating circumstances.")
            },
            0,0,4 ),
    MECHANICAL("mechanical",
            new Skill[]{
                    new Skill("Identifying machines",true,false,false),
                    new Skill("Using/Repairing/Crafting machines",true,false,false),
            },
            new Abilities[]{},
            0,0,2 ),
    MYSTERIOUS("mysterious",
            new Skill[]{
                    new Skill("Stealth",true,false,false),
                    new Skill("Resisting interrogation",true,false,false),
                    new Skill("Gaining peoples trust",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Confounding","description",0,
                            "You pull talents and abilities seemingly out of nowhere. " +
                                    "You can attempt one task in which you have no training as if you were trained," +
                                    " attempt a task that you are trained in as if specialized, or gain a free level" +
                                    " of Effort with a task that you are specialized in." +
                                    " This ability refreshes every time you make a recovery roll"),
            },
            0,0,0 ),
    MYSTICAL("mystical",
            new Skill[]{
                    new Skill("Understanding the supernatural",true,false,false),
                    new Skill("Charm/persuasion/etiquette",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Sense Magic","description",0,
                            "You can sense whether the supernatural is active in situations where " +
                                    "its presence is not obvious. You must study an object or location closely" +
                                    " for a minute to get a feel for whether a mystical touch is at work."),
                    new Abilities("Spell","Intellect",1,
                            "You preform wild magic(whatever that mean in the context of your game).")
            },
            0,0,2 ),
    NAIVE("naive",
            new Skill[]{
                    new Skill("Perception",true,false,false),
                    new Skill("determining motive",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Sense Magic","description",0,
                            "You can sense whether the supernatural is active in situations where " +
                                    "its presence is not obvious. You must study an object or location closely" +
                                    " for a minute to get a feel for whether a mystical touch is at work."),
                    new Abilities("Spell","Intellect",1,
                            "You can preform wild magic.")
            },
            0,0,0 ),
    PERCEPTIVE("perceptive",
            new Skill[]{
                    new Skill("Perception",true,true,false),
                    new Skill("Intimidation",true,false,false),
                    new Skill("Positive social interactions",false,false,true)
            },
            new Abilities[]{},
            0,0,2 ),
    RESILIENT("resilient",
            new Skill[]{
                    new Skill("Might defense",true,false,false),
                    new Skill("Intellect defense",true,false,false),
                    new Skill("moving/bending/breaking things",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Recover","description",0,
                            "You can make an extra recovery roll each day. This roll is just one action."),
            },
            2,0,2 ),
    RISKY("risk taking",
            new Skill[]{
                    new Skill("Actions involving chance",true,false,false),
                    new Skill("Sneaking",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Pressing Your Luck","description",0,
                            "You can choose to automatically succeed on one task without rolling, " +
                                    "as long as the task’s difficulty is no higher than 6. When you do so" +
                                    " you also trigger a GM intrusion as if you had rolled a 1. " +
                                    "You can do this one time, although the ability renews each time" +
                                    " you make a ten-hour recovery roll.")
            },
            0,4,0 ),
    RUGGED("rugged",
            new Skill[]{
                    new Skill("Athletics",true,false,false),
                    new Skill("Handling animals",true,false,false),
                    new Skill("Identifying or using plants",true,false,false),
                    new Skill("Charm/persuasion/etiquette/deception",false,false,true)
            },
            new Abilities[]{},
            0,0,0 ),
    SHARPEYED("sharp-eyed",
            new Skill[]{
                    new Skill("Initiative",true,false,false),
                    new Skill("Perception",true,false,false),
            },
            new Abilities[]{
                    new Abilities("Find the Flaw","description",0,
                            "If an opponent has a straightforward weakness, the GM will tell you what it is.")
            },
            0, 0, 0 ),
    SKEPTICAL("appealing",
            new Skill[]{
                    new Skill("Identifying",true,false,false),
                    new Skill("Seeing through tricks, illusions, lies",true,false,false),
            },
            new Abilities[]{},
            0, 0, 2 ),
    STEALTHY("stealthy",
            new Skill[]{
                    new Skill("Stealth",true,false,false),
                    new Skill("Deception",true,false,false),
                    new Skill("Disguise",true,false,false),
            },
            new Abilities[]{},
            0,2,0 ),
    STRONG("strong",
            new Skill[]{
                    new Skill("Breaking inanimate objects",true,false,false),
                    new Skill("Jumping",true,false,false),
                    new Skill("Improvised Weapons",true,false,false),
            },
            new Abilities[]{},
            4,0,0 ),
    STRONGWILLED("strong willed",
            new Skill[]{
                    new Skill("Intellect Defence",true,false,false),
                    new Skill("Concentration",true,false,false),
                    new Skill("Puzzle solving/Memorizing things",false,false,true)
            },
            new Abilities[]{},
            0,0,4 ),
    SWIFT("swift",
            new Skill[]{
                    new Skill("Initiative",true,false,false),
                    new Skill("Running",true,false,false),
                    new Skill("Balance",false,false,true)
            },
            new Abilities[]{},
            0,4,0 ),
    TONGUETIED("tongue-tied",
            new Skill[]{
                    new Skill("Perception",true,false,false),
                    new Skill("Initiative",true,false,false),
                    new Skill("Social interaction",false,false,true),
                    new Skill("Relaying information",false,false,true)
            },
            new Abilities[]{},
            2,2,0 ),
    TOUGH("tough",
            new Skill[]{
                    new Skill("Might defense",true,false,false)
            },
            new Abilities[]{
                    new Abilities("Bloodthirsty","description",0,
                            "natural +1 to armor"),
                    new Abilities("Fast Recovery","description",0,
                            "Add 1 to the points you regain when you make a recovery roll.")
            },
            0,0,0 ),
    VICIOUS("vicious",
            new Skill[]{
                    new Skill("Tracking creatures",true,false,false)
            },
            new Abilities[]{
                    new Abilities("Bloodthirsty","description",0,
                            "Once you begin fighting, you see only red. You inflict 2 additional points of damage with any attack."),
                    new Abilities("Berserk","description",0,
                            "Once you begin fighting, it’s hard for you to stop. In fact," +
                                    " it’s a difficulty 2 Intellect task to do so, even if your foe surrenders" +
                                    " or you’ve run out of foes. If the latter occurs and you fail to stop, " +
                                    "you attack the nearest ally within short range.")
            },
            0,0,0 ),
    VIRTUOUS("virtuous",
            new Skill[]{
                    new Skill("Sense Motive",true,false,false),
                    new Skill("Intellect defense",true,false,false)
            },
            new Abilities[]{},
            2,0,0 ),
    WEIRD("weird",
            new Skill[]{
                    new Skill("Supernatural knowledge",true,false,false),
                    new Skill("Pleasant social interaction",false,false,true)
            },
            new Abilities[]{
                    new Abilities("Distinctive Physical Quirk","description",0,
                            "You have a unique physical aspect that is, well, bizarre. "),
                    new Abilities("A Sense for the Weird","description",0,
                            "Sometimes (GM’s discretion) weird things relating to the supernatural or" +
                                    " its effects on the world seem to call out to you. You can sense them from afar," +
                                    " and if you get within long range of such a thing, you can sense whether " +
                                    "it is overtly dangerous or not.")
            },
            0,0,2 );

    public static Descriptor keyNameof(String key) {
        for(Descriptor playerDes : Descriptor.values()){
            if (playerDes.keyName.equals(key)){
                return(playerDes);
            }
        }
        return null;
    }

    public final String keyName;
    public final Skill[] skillsArray;
    public final Abilities[] abilityArray;
    public int mightMod;
    public int speedMod;
    public int intellectMod;

    Descriptor(String keyName, Skill[] skills, Abilities[] abilities, int might, int speed, int intellect) {
        this.keyName = keyName ;
        this.skillsArray = skills;
        this.abilityArray = abilities;
        int mightMod = might;
        int speedMod = speed;
        int intellectMod = intellect;
    }


}
