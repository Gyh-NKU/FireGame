package roles;

import items.HighMedicine;
import items.Item;
import items.LowMedicine;
import weapons.Weapon;
import weapons.axe.IconAxe;
import weapons.axe.SliverAxe;

public class Hktr extends Role{
    public Hktr() {
        super("海克托尔侯爵", 48, 15, 6,
                8, 5, 0,
                6, 8, new Item[]{new HighMedicine(),
                        new LowMedicine()}, new Weapon[]{new SliverAxe(),new IconAxe()});
    }
}
