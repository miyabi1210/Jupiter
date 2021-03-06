package cn.nukkit.entity.passive;

import java.util.concurrent.ThreadLocalRandom;

import cn.nukkit.Player;
import cn.nukkit.block.BlockWool;
import cn.nukkit.entity.data.ByteEntityData;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import cn.nukkit.item.ItemDye;
import cn.nukkit.item.ItemMuttonCooked;
import cn.nukkit.item.ItemMuttonRaw;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.utils.DyeColor;

/**
 * Author: BeYkeRYkt
 * Nukkit Project
 */
public class EntitySheep extends EntityAnimal {

    public static final int NETWORK_ID = 13;

    public boolean sheared = false;
    public int color = 0;

    public EntitySheep(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public float getWidth() {
        if (isBaby()) {
            return 0.45f;
        }
        return 0.9f;
    }

    @Override
    public float getHeight() {
        if (isBaby()) {
            return 0.65f;
        }
        return 1.3f;
    }

    @Override
    public float getEyeHeight() {
        if (isBaby()) {
            return 0.95f * 0.9f; // No have information
        }
        return 0.95f * getHeight();
    }

    @Override
    public String getName() {
        return this.getNameTag();
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    public void initEntity() {
        this.setMaxHealth(8);

        if (!this.namedTag.contains("Color")) {
            this.setColor(randomColor());
        } else {
            this.setColor(this.namedTag.getByte("Color"));
        }

        if (!this.namedTag.contains("Sheared")) {
            this.namedTag.putByte("Sheared", 0);
        } else {
            this.sheared = this.namedTag.getBoolean("Sheared");
        }

        this.setDataFlag(DATA_FLAGS, DATA_FLAG_SHEARED, this.sheared);
    }

    @Override
    public void saveNBT() {
        super.saveNBT();

        this.namedTag.putByte("Color", this.color);
        this.namedTag.putBoolean("Sheared", this.sheared);
    }

    @Override
    public boolean onInteract(Player player, Item item) {
        if (item.getId() == Item.DYE) {
            this.setColor(((ItemDye) item).getDyeColor().getDyedData());
            return true;
        }

        return item.getId() == Item.SHEARS && shear();
    }

    public boolean shear() {
        if (sheared) {
            return false;
        }

        this.sheared = true;
        this.setDataFlag(DATA_FLAGS, DATA_FLAG_SHEARED, true);

        this.level.dropItem(this, new ItemBlock(new BlockWool(this.getColor()), 0, this.level.rand.nextInt(2) + 1));
        return true;
    }

    @Override
    public Item[] getDrops() {
        if (!(this.sheared)) {
            if (this.isOnFire()) {
                return new Item[]{new ItemBlock(new BlockWool()), new ItemMuttonCooked(0, random.nextRange(1, 3))};
            } else {
                return new Item[]{new ItemBlock(new BlockWool()), new ItemMuttonRaw(0, random.nextRange(1, 3))};
            }
        } else {
            if (this.isOnFire()) {
                return new Item[]{new ItemMuttonCooked(0, random.nextRange(1, 3))};
            } else {
                return new Item[]{new ItemMuttonRaw(0, random.nextRange(1, 3))};
            }
        }
    }

    public void setColor(int color) {
        this.color = color;
        this.setDataProperty(new ByteEntityData(DATA_COLOUR, color));
    }

    public int getColor() {
        return namedTag.getByte("Color");
    }

    private int randomColor() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double rand = random.nextDouble(1, 100);

        if (rand <= 0.164) {
            return DyeColor.PINK.getDyedData();
        }

        if (rand <= 15) {
            return random.nextBoolean() ? DyeColor.BLACK.getDyedData() : random.nextBoolean() ? DyeColor.GRAY.getDyedData() : DyeColor.LIGHT_GRAY.getDyedData();
        }

        return DyeColor.WHITE.getDyedData();
    }
}