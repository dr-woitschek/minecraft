package drwoitschek.sack.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class SackRezepteLoader {

    public static ItemStack ding1;

    public void registerRecipies() {

        ItemStack item1 = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item1.getItemMeta();
        meta.setDisplayName("§6Stick1");
        item1.setItemMeta(meta);
        ding1 = item1;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("ding1"), item1);
        sr.shape(" B ", " S ", " S ");
        sr.setIngredient('B', Material.DIRT);
        sr.setIngredient('S', Material.DIAMOND_BLOCK);
        Bukkit.getServer().addRecipe(sr);
    }

}
