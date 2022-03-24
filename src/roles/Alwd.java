package roles;

import items.HighMedicine;
import items.Item;
import items.LowMedicine;
import weapons.sword.CriticalSword;
import weapons.sword.IconSword;
import weapons.sword.SliverSword;

public class Alwd extends Role{
    public Alwd() {
        super("国王艾利乌德", 38, 8, 5,
                12, 3, 0,
                6, 4, new Item[]{new HighMedicine(),
                        new LowMedicine()}, new Weapon[]{new SliverSword(),new CriticalSword()});
    }
}
