package roles;

import items.HighMedicine;
import items.Item;
import items.LowMedicine;
import weapons.Weapon;
import weapons.sword.CriticalSword;
import weapons.sword.SliverSword;

public class Lin extends Role{
    public Lin(){
        super("草原少女琳", 32, 5, 18,
                15, 2, 0,
                6, 4, new Item[]{new HighMedicine(),
                        new LowMedicine()}, new Weapon[]{new CriticalSword(), new SliverSword()});
    }
}
