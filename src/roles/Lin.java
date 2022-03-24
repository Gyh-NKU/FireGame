package roles;

import items.HighMedicine;
import items.Item;
import items.LowMedicine;
import weapons.sword.CriticalSword;
import weapons.sword.IconSword;
import weapons.sword.SliverSword;

public class Lin extends Role{
    public Lin(){
        super("草原少女琳", 30, 5, 8,
                15, 2, 0,
                6, 4, new Item[]{new HighMedicine(),
                        new LowMedicine()}, new Weapon[]{new CriticalSword(), new SliverSword()});
    }
}
