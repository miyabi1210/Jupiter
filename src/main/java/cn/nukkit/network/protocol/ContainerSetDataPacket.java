package cn.nukkit.network.protocol;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class ContainerSetDataPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.CONTAINER_SET_DATA_PACKET;

    public static final int PROPERTY_FURNACE_TICK_COUNT = 0;
    public static final int PROPERTY_FURNACE_LIT_TIME = 1;
    public static final int PROPERTY_FURNACE_LIT_DURATION = 2;
    //TODO: check property 3
    public static final int PROPERTY_FURNACE_FUEL_AUX = 4;

    public static final int PROPERTY_BREWING_STAND_BREW_TIME = 0;
    public static final int PROPERTY_BREWING_STAND_FUEL_AMOUNT = 1;
    public static final int PROPERTY_BREWING_STAND_FUEL_TOTAL = 2;

    public int windowId;
    public int property;
    public int value;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.windowId);
        this.putVarInt(this.property);
        this.putVarInt(this.value);
    }
}
