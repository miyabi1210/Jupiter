package cn.nukkit.command.data;


public class CommandParameter {

    public static final String ARG_TYPE_STRING = "string";
    public static final String ARG_TYPE_STRING_ENUM = "stringenum";
    public static final String ARG_TYPE_BOOL = "bool";
    public static final String ARG_TYPE_TARGET = "target";
    public static final String ARG_TYPE_PLAYER = "target";
    public static final String ARG_TYPE_BLOCK_POS = "blockpos";
    public static final String ARG_TYPE_RAW_TEXT = "rawtext";
    public static final String ARG_TYPE_INT = "int";

    public static final String ENUM_TYPE_ITEM_LIST = "itemType";
    public static final String ENUM_TYPE_BLOCK_LIST = "blockType";
    public static final String ENUM_TYPE_COMMAND_LIST = "commandName";
    public static final String ENUM_TYPE_ENCHANTMENT_LIST = "enchantmentType";
    public static final String ENUM_TYPE_ENTITY_LIST = "entityType";
    public static final String ENUM_TYPE_EFFECT_LIST = "effectType";
    public static final String ENUM_TYPE_PARTICLE_LIST = "particleType";
    public static final String ENUM_TYPE_DIFFICULTY_LIST = "difficultyType";

    public static final String[] GAMERULE_LIST = new String[]{
            "sendcommandfeedback",
            "tntexplodes",
            "naturalregeneration",
            "showcoordinates",
            "pvp",
            "mobgriefing",
            "doweathercycle",
            "firedamage",
            "domobspawning",
            "drowingdamage",
            "falldamage",
            "domobloot",
            "dotiledrops",
            "dofiretick",
            "doentitydrops",
            "dodaylightcycle",
            "keepinventory",
            "commandblockoutput"
    };

    public static final String[] WEATHER_LIST = new String[]{
            "clear",
            "rain",
            "thunder"
    };

    public String name;
    public String type;
    public boolean optional;

    public String enum_type;
    public String[] enum_values;

    public CommandParameter(String name) {
        this(name, false);
    }

    public CommandParameter(String name, boolean optional) {
        this(name, ARG_TYPE_RAW_TEXT, optional);
    }

    public CommandParameter(String name, String type, boolean optional) {
        this.name = name;
        this.type = type;
        this.optional = optional;
    }

    public CommandParameter(String name, boolean optional, String enumType){
        this.name = name;
        this.type = ARG_TYPE_STRING_ENUM;
        this.optional = optional;
        this.enum_type = enumType;
    }

    public CommandParameter(String name, boolean optional, String[] enumValues){
        this.name = name;
        this.type = ARG_TYPE_STRING_ENUM;
        this.optional = optional;
        this.enum_values = enumValues;
    }

    public CommandParameter(String name, String enumType){
        this(name, false, enumType);
    }

    public CommandParameter(String name, String[] enumValues){
        this(name, false, enumValues);
    }

}
