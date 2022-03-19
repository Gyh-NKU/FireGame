public class Battle {
    Role attacker;
    Role defencer;

    public Battle(Role attacker, Role defencer) {
        this.attacker = attacker;
        this.defencer = defencer;
    }

    void start() {
        int defSpeed = Math.max(defencer.speed - Math.max(defencer.curWeapon.weight - defencer.physique, 0), 0);
        int attSpeed = Math.max(attacker.speed - Math.max(attacker.curWeapon.weight - attacker.physique, 0), 0);
        int combo = 1;
        if (attSpeed - defSpeed > 4) {
            combo = 2;
        }
        if(combo == 1){
            attacker.attact(defencer);
            defencer.attact(attacker);
        }
        if(combo == 2){
            attacker.attact(defencer);
            defencer.attact(attacker);
            attacker.attact(defencer);
        }
    }


}
