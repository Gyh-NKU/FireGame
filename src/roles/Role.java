package roles;

import items.Item;

import java.util.Random;

abstract public class Role {

    public String name;
    public Integer level;
    final Integer maxLevel = 20;
    public Integer maxLife;
    public Integer curLife;
    public Integer force;
    public Integer skill;
    public Integer speed;
    public Integer physicalDefence;
    public Integer magicDefence;
    public Integer luck;
    public Integer physique;
    public Item[] items;
    public Weapon[] weapons;
    public Weapon curWeapon;

    public Role(String name, Integer maxLife, Integer force, Integer skill,
                Integer speed, Integer physicalDefence, Integer magicDefence,
                Integer luck, Integer physique, Item[] items, Weapon[] weapons) {
        this.name = name;
        this.maxLife = maxLife;
        this.force = force;
        this.skill = skill;
        this.speed = speed;
        this.physicalDefence = physicalDefence;
        this.magicDefence = magicDefence;
        this.luck = luck;
        this.physique = physique;
        this.items = items;
        this.weapons = weapons;
        curWeapon = weapons[0];
        this.curLife = maxLife;
    }


    public boolean isdead() {
        return curLife <= 0;
    }

    /**
     * @param pos 物品的位置
     * @return 物品是否使用成功
     */
    public boolean useItem(Integer pos) {
        if (pos >= items.length) {
            System.out.println("使用失败！");
            return false;
        }
        items[pos].cnt--;
        int prelife = curLife;
        curLife = Math.min(curLife + items[pos].effect, maxLife);
        System.out.println("使用成功！" + name + "恢复了" + (curLife - prelife) + "点生命");
        return true;
    }

    public boolean changeWeapon(Integer pos) {
        if (pos >= items.length) {
            System.out.println("切换失败！");
            return false;
        }
        curWeapon = weapons[pos];
        return true;
    }

    public void attack(Role enemy) {
        System.out.println(name + " 对 " + enemy.name + " 发动攻击！");
        Random rd = new Random();
        int attForce = force + curWeapon.attack;
        int attSkill = skill * 2 + curWeapon.skill + luck / 2;

        int attCritical = Math.min(curWeapon.critical + skill / 2, 100);
        if (curWeapon.bonus(enemy.curWeapon) == 1) {
            attForce += 1;
            attSkill += 15;
        }
        if (curWeapon.bonus(enemy.curWeapon) == -1) {
            attForce -= 1;
            attSkill -= 15;
        }
        attSkill = Math.min(attSkill, 100);
        Integer defDefence = enemy.physicalDefence;
        Integer defMiss = enemy.speed * 2 + luck;
        Integer defMissCri = luck;


        int realDamage = attForce - defDefence;

        System.out.println("暴击率:" + attCritical + "命中率:" + attSkill);

        int missDig = rd.nextInt(101);
        int critDig = rd.nextInt(101);
        if (missDig > attSkill) {
            System.out.println("miss");
        } else {
            if (critDig < attCritical) {
                enemy.curLife -= 3 * realDamage;
                System.out.println("暴击伤害！");
                System.out.println("造成" + realDamage * 3 + "伤害");
            } else {
                enemy.curLife -= realDamage;
                System.out.println("造成" + realDamage + "伤害");
            }
        }

        System.out.println("目前" + name + "血量为： " + curLife + "/" + maxLife);
        System.out.println("目前" + enemy.name + "血量为： " + enemy.curLife + "/" + enemy.maxLife);
        System.out.println("");
        if(isdead()){
            System.out.println(name + "已被击败");
        }
        if (enemy.isdead()) {
            System.out.println(enemy.name + "已被击败！");
        }
    }


}

