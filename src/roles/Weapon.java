package roles;

public class Weapon {

    public String name;
    public Integer weight;
    public Integer attack;
    public Integer critical;
    public Integer skill;
    public WeaponType type;

    public Weapon(String name, Integer weight, Integer attack, Integer critical, Integer skill, WeaponType type){
        this.name = name;
        this.weight = weight;
        this.attack = attack;
        this.critical = critical;
        this.skill = skill;
        this.type = type;
    }

    public Integer bonus(Weapon another){
        if(type == WeaponType.SWORD && another.type == WeaponType.AXE){
            return 1;
        }
        if(type == WeaponType.AXE && another.type == WeaponType.LANCE){
            return 1;
        }
        if(type == WeaponType.LANCE && another.type == WeaponType.SWORD){
            return 1;
        }
        if(another.type == WeaponType.SWORD && type == WeaponType.AXE){
            return -1;
        }
        if(another.type == WeaponType.AXE && type == WeaponType.LANCE){
            return -1;
        }
        if(another.type == WeaponType.LANCE && type == WeaponType.SWORD){
            return -1;
        }
        return 0;
    }
}
