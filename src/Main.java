public class Main {
    public static void main(String[] args) {
        Weapon iconSword = new Weapon("铁剑",5,5,0,
                85,WeaponType.SWORD);
        Weapon iconAxe = new Weapon("铁斧",10,8,0,
                65,WeaponType.AXE);
        Item pill = new Item("伤药",3,10);
        Role lin = new Role("琳",30,5,8,
                10,2,0,
                6,5,new Item[]{pill},new Weapon[]{iconSword});
        Role enemy = new Role("山贼",50,5,8,
                10,2,0,
                6,5,new Item[]{pill},new Weapon[]{iconAxe});
        Battle battle = new Battle(lin, enemy);
        while (lin.isdead() == enemy.isdead()){
            battle.start();
            System.out.println("一次战斗完成！\n");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}
