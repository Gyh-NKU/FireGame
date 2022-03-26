package roles;

import items.*;
import weapons.Weapon;
import weapons.lance.IconLance;


public class Lancer extends Role {
    public Lancer(String name){
        super(name, 50, 5, 8,
                10, 2, 0,
                6, 5, new Item[]{new LowMedicine()},
                new Weapon[]{new IconLance()});
    }

}
