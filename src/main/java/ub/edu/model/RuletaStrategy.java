package ub.edu.model;

import ub.edu.model.cataleg.GrupInteres;

import java.util.Random;

public class RuletaStrategy implements MembershipStrategy {

    private int numRuleta;

    @Override
    public boolean becomeMember(PerfilPersona follower, GrupInteres grup) {
        //3 opcions: continuar sent Follower, esdevenir membre o no ser res del grup

        //Generem un número aleatori entre 0 i 2
        Random rand = new Random();
        numRuleta = rand.nextInt(3);

        switch (numRuleta) {
            case 0: //Continuar sent follower
                return false;
            case 1: //Esdevenir membre
                follower.addGrupInteresMembership(grup);
                return true;
            case 2: //No ser res del grup
                follower.removeGrupInteresFollowed(grup);
                return false;
            default:
                return false;
        }
    }
}
