public enum Moves {
    
    FLAMETHROWER("flamethrower", 95, 100, PokeType.FIRE, AttackCategory.SPECIAL, Target.REGULAR, 0),
    LEAF_BLADE("leaf blade", 90, 100, PokeType.GRASS, AttackCategory.PHYSICAL, Target.REGULAR, 0),
    SPLASH("splash", 0, 100, PokeType.WATER, AttackCategory.SPECIAL, Target.REGULAR, 0),
    GROWL("growl", 0, PokeType.WATER, AttackCategory.SPECIAL, Target.REGULAR, 100, Increment.FELL, StatusChange.ATTACK),
    WATER_GUN("water gun", 40, 100,PokeType.WATER, AttackCategory.SPECIAL, Target.REGULAR, 0),
    FLAME_WHEEL("flame wheel", 60, 100, PokeType.FIRE, AttackCategory.PHYSICAL, Target.REGULAR,
         10, Increment.NOTHING, StatusChange.INFLICT_BURN);

    private String battleText = "";
    private int attackPower = 0;
    private int attackAcc = 0;
    private PokeType attackType = PokeType.NO_TYPE;
    private AttackCategory attackCategory;
    private Target target = Target.NO_TARGET;
    private Target secondaryTarget = Target.NO_TARGET;
    private int successRate = 0;
    private Increment statLevel = Increment.NOTHING;
    private int turnsDelayed = 0;
    private StatusChange[] statusChanges = {};
    private int recoilDamage = 0;
    private int minDamage = 0;
    private int maxDamage = 0;

    private Moves (String battleText, int attackPower, int attackAcc, PokeType attackType, AttackCategory attackCategory, 
                    Target target, int successRate, Increment statLevel, StatusChange ...statusChanges) {
        // Used for ordinary moves (e.g. Scratch, Water Gun) or moves with chance for side effects (Sludge Bomb, Mud Slap, Thunderbolt) 
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackAcc = attackAcc;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
        this.successRate = successRate;
        this.statLevel = statLevel;
        this.statusChanges = statusChanges;
    }

    private Moves (String battleText, int attackPower, PokeType attackType, AttackCategory attackCategory, 
                    Target target, int successRate, Increment statLevel, StatusChange ...statusChanges) {
        // Used for moves whose side effects activate upon a hit (e.g. Dynamic Punch) or moves like Thunder Wave, Toxic
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
        this.successRate = successRate;
        this.statLevel = statLevel;
        this.statusChanges = statusChanges;
    }
    
    private Moves (String battleText, int attackPower, int attackAcc, PokeType attackType, AttackCategory attackCategory, 
                    Target target, int successRate, Increment statLevel, Target secondaryTarget, StatusChange ...statusChanges) {
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackPower = attackAcc;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
        this.successRate = successRate;
        this.statLevel = statLevel;
        this.secondaryTarget = secondaryTarget;
        this.statusChanges = statusChanges;
        // Used for moves whose side effects contains a separate target (e.g. Close Combat, Draco Meteor, Memento)
    }

    private Moves (String battleText, int attackPower, int attackAcc, PokeType attackType, AttackCategory attackCategory, 
                    Target target, int recoilDamage) {
        // Used for moves with a recoil (e.g. Wood Hammer, Flare Blitz, Brave Bird)
        this.battleText = battleText;
        this.attackPower = attackPower;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
        this.recoilDamage = recoilDamage;
    }

    private Moves (String battleText, int minDamage, int maxDamage, int attackAcc, PokeType attackType, 
                    AttackCategory attackCategory, Target target) {
        // Used for moves with varying amounts of damage (e.g. Magnitude, Rollout, Bulletseed)
        this.battleText = battleText;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.attackAcc = attackAcc;
        this.attackType = attackType;
        this.attackCategory = attackCategory;
        this.target = target;
    }

    private Moves (String battleText, int attackPower, int attackAcc, PokeType attackType, 
                    AttackCategory attackCategory, Target target, int turnsDelayed, StatusChange ...statusChanges) {
            this.battleText = battleText;
            this.attackPower = attackPower;
            this.attackAcc = attackAcc;
            this.attackType = attackType;
            this.attackCategory = attackCategory;
            this.target = target;
            this.turnsDelayed = turnsDelayed;
            this.statusChanges = statusChanges;
        }

    public String getBattleText() {
        return this.battleText;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getAttackAcc() {
        return this.attackAcc;
    }

    public PokeType getAttackType() {
        return this.attackType;
    }

    public AttackCategory getAttackCategory() {
        return this.attackCategory;
    }

    public Target getTarget() {
        return this.target;
    }

    public Target getSecondaryTarget() {
        return this.secondaryTarget;
    }

    public int getSuccessRate() {
        return this.successRate;
    }

    public Increment getStatLevel() {
        return this.statLevel;
    }

    public int getTurnsDelayed() {
        return this.turnsDelayed;
    }

    public StatusChange[] getStatusChanges() {
        return this.statusChanges;
    }

    public int getRecoilDamage() {
        return this.recoilDamage;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }
	
}