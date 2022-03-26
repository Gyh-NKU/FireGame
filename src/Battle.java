import roles.Role;

public class Battle {
    Role attacker;
    Role defencer;

    public Battle(Role attacker, Role defencer) {
        this.attacker = attacker;
        this.defencer = defencer;
    }

    void start() {
        int defSpeed = Math.max(defencer.speed -
                Math.max(defencer.curWeapon.weight - defencer.physique, 0), 0);
        int attSpeed = Math.max(attacker.speed -
                Math.max(attacker.curWeapon.weight - attacker.physique, 0), 0);
        int combo = 0;
        if (attSpeed - defSpeed > 4) {
            combo = 1;
        }
        if (defSpeed - attSpeed > 4) {
            combo = -1;
        }
        if (combo == 0) {
            attacker.attack(defencer);
            defencer.attack(attacker);
        }
        if (combo == 1) {
            attacker.attack(defencer);
            defencer.attack(attacker);
            attacker.attack(defencer);
        }
        if (combo == -1){
            attacker.attack(defencer);
            defencer.attack(attacker);
            defencer.attack(attacker);
        }
    }


}
