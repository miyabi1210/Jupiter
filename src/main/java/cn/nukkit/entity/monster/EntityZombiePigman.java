package cn.nukkit.entity.monster;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemNuggetGold;
import cn.nukkit.item.ItemRottenFlesh;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.AddEntityPacket;

public class EntityZombiePigman extends EntityMonster {
    public static final int NETWORK_ID = 36;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public EntityZombiePigman(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
    @Override
    protected void initEntity() {
        super.initEntity();
    }
    
    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public float getLength() {
        return 0.6f;
    }

    @Override
    public float getHeight() {
        return 1.8f;
    }

    @Override
    public String getName() {
        return "ZombiePigman";
    }

    @Override
    public void spawnTo(Player player) {
        AddEntityPacket pk = new AddEntityPacket();
        pk.type = this.getNetworkId();
        pk.entityUniqueId = this.getId();
        pk.entityRuntimeId = this.getId();
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.speedX = (float) this.motionX;
        pk.speedY = (float) this.motionY;
        pk.speedZ = (float) this.motionZ;
        pk.metadata = this.dataProperties;
        player.dataPacket(pk);

        super.spawnTo(player);
    }

    @Override
    public Item[] getDrops() {
        return new Item[]{new ItemRottenFlesh(0, random.nextRange(0, 1)), new ItemNuggetGold(0, random.nextRange(0, 1))};
    }
}
