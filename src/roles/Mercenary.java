package roles;

import items.Item;
import items.LowMedicine;
import weapons.axe.IconAxe;
import weapons.sword.IconSword;

public class Mercenary extends Role{
    public Mercenary(String name) {
        super(name, 40, 4, 8,
                10, 3, 0,
                0, 5, new Item[]{new LowMedicine()}, new Weapon[]{new IconSword()});
    }
}
