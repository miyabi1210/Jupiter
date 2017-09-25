package cn.nukkit.network.protocol;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class EntityEventPacket extends DataPacket {
    public static final int NETWORK_ID = ProtocolInfo.ENTITY_EVENT_PACKET;


    public static final int HURT_ANIMATION = 2;
    public static final int DEATH_ANIMATION = 3;

    public static final int TAME_FAIL = 6;
    public static final int TAME_SUCCESS = 7;
    public static final int SHAKE_WET = 8;
    public static final int USE_ITEM = 9;
    public static final int EAT_GRASS_ANIMATION = 10;
    public static final int FISH_HOOK_BUBBLE = 11;
    public static final int FISH_HOOK_POSITION = 12;
    public static final int FISH_HOOK_HOOK = 13;
    public static final int FISH_HOOK_TEASE = 14;
    public static final int SQUID_INK_CLOUD = 15;

    public static final int AMBIENT_SOUND = 16;
    public static final int RESPAWN = 17;

    public static final int ENCHANT = 34;

    public static final int FEED = 57;

    public static final byte EAT_FOOD = 57;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public long eid;
    public int event;
    public int type;

    @Override
    public void decode() {
        this.eid = this.getVarLong();
        this.event = this.getByte();
        this.type = this.getByte();
    }

    @Override
    public void encode() {
        this.reset();
        this.putVarLong(this.eid);
        this.putByte((byte) this.event);
        this.putByte((byte) this.type);
    }
}