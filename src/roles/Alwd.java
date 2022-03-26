package roles;

import items.HighMedicine;
import items.Item;
import items.LowMedicine;
import weapons.Weapon;
import weapons.sword.CriticalSword;
import weapons.sword.SliverSword;

public class Alwd extends Role{
    public Alwd() {
        super("国王艾利乌德", 38, 8, 10,
                12, 3, 0,
                6, 4, new Item[]{new HighMedicine(),
                        new LowMedicine()}, new Weapon[]{new SliverSword(),new CriticalSword()});
    }
}
