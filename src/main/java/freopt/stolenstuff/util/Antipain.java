package freopt.stolenstuff.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;


public class Antipain {
    public static ItemStack getItemStack (String mod, String item, int meta, int amount) {
        return new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(mod,item)),amount,meta);
    }

    public static ItemStack getItemStack (String mod, String item, int meta) {
        return new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(mod,item)),1,meta);
    }

    public static ItemStack getItemStack (String mod, String item, int meta, NBTTagCompound nbt) {
        return new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(mod,item)),1,meta,nbt);
    }

    public static void addOreDict (ItemStack item, String oreDictEntry) {
        if (!item.isEmpty()) {
            OreDictionary.registerOre(oreDictEntry,item);
        }
    }

    public static String getRegistryName (ItemStack item) {
        return item.getItem().getRegistryName().toString()+":"+item.getMetadata();
    }
}
