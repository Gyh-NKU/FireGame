package weapons.sword;

import roles.Weapon;
import roles.WeaponType;

public class CriticalSword extends Weapon {
    public CriticalSword() {
        super("必杀剑", 7, 9, 30, 80, WeaponType.SWORD);
    }
}
