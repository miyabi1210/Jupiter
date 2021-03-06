package cn.nukkit.network.protocol;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class ContainerOpenPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.CONTAINER_OPEN_PACKET;

    public int windowId;
    public int type;
    public int x;
    public int y;
    public int z;
    public long entityRuntimeId = -1;

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
        this.putByte((byte) this.type);
        this.putBlockVector3(this.x, this.y, this.z);
        this.putEntityUniqueId(this.entityRuntimeId);
    }
}
