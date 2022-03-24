import items.Item;
import roles.*;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean allDead(Role[] players){
        boolean allDead = true;
        for (Role role : players) {
            if (!role.isdead()) {
                allDead = false;
            }
        }
        return allDead;
    }
    public static void main(String[] args) throws InterruptedException {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        Role[] players = new Role[]{new Lin(), new Alwd(),new Hktr()};
        Role[] enemys = new Role[]{new Warrior("山贼"), new Mercenary("佣兵"),
                new Lancer("枪兵")};
        while (true) {
            int toAct = rd.nextInt(players.length);
            while (players[toAct].isdead()) {
                toAct = rd.nextInt(players.length);
            }
            System.out.println("到" + players[toAct].name +
                    "的回合了，请输入你的指令：1为攻击 2为使用物品");
            String cmd = sc.next();
            if (Objects.equals(cmd, "1")) {
                System.out.println("请选择要使用的武器：");
                for (int i = 0; i < players[toAct].weapons.length; i++) {
                    System.out.printf("%d. %-8s \t攻击：%-6s 命中：%6s  必杀：%6s \n",
                            i + 1,
                            players[toAct].weapons[i].name,
                            players[toAct].weapons[i].attack,
                            players[toAct].weapons[i].skill,
                            players[toAct].weapons[i].critical);
                }
                int toSel = sc.nextInt();
                players[toAct].changeWeapon(toSel - 1);
                System.out.println("请选择要攻击的敌人：");

                for (int i = 0; i < enemys.length; i++) {
                    Role role = enemys[i];
                    System.out.printf("%d. %-8s \t血量：%-6s 攻击力：%6s  防御力：%6s \n",
                            i + 1, role.name, role.curLife + "/" +
                                    role.maxLife, role.force,
                            role.physicalDefence);
                }

                int toattact = sc.nextInt();
                Battle battle = new Battle(players[toAct], enemys[toattact - 1]);
                battle.start();
            }
//            System.out.println("一次战斗完成！\n");
            if (Objects.equals(cmd, "2")) {
                System.out.println("请选择你要使用的物品：");
                for (int i = 0; i < players[toAct].items.length; i++) {
                    System.out.print(i + ":" + players[toAct].items[i].name);
                    System.out.println("");
                }
                int pos = sc.nextInt();
                players[toAct].useItem(pos);
            }
            if(allDead(players)){
                System.out.println("玩家全部失败！");
                System.out.println("游戏结束");
                break;
            }
            if(allDead(enemys)){
                System.out.println("敌人全部失败！");
                System.out.println("游戏结束！");
                break;
            }
            System.out.println("--------------------------");
            toAct = rd.nextInt(enemys.length);
            int toAttack = rd.nextInt(players.length);
            while (players[toAttack].isdead()) {
                toAttack = rd.nextInt(players.length);
            }
            while (enemys[toAct].isdead()) {
                toAct = rd.nextInt(enemys.length);
            }
            System.out.println("到" + enemys[toAct].name + "的回合了，"
                    + enemys[toAct].name + "选择攻击"
                    + players[rd.nextInt(players.length)].name);
            Battle battle = new Battle(enemys[toAct], players[toAttack]);
            battle.start();
            System.out.println("---------------------------");
            if(allDead(players)){
                System.out.println("玩家全部失败！");
                System.out.println("游戏结束");
                break;
            }
            if(allDead(enemys)){
                System.out.println("敌人全部失败！");
                System.out.println("游戏结束！");
                break;
            }
        }
    }
}
