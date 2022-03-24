package roles;

import items.Item;
import items.LowMedicine;
import weapons.axe.IconAxe;

public class Warrior extends Role{
    public Warrior(String name) {
        super(name, 50, 8, 4,
                5, 2, 0,
                3, 8, new Item[]{new LowMedicine()}, new Weapon[]{new IconAxe()});
    }
}
