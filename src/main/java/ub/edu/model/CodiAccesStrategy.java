package ub.edu.model;

import ub.edu.model.cataleg.GrupInteres;

public class CodiAccesStrategy implements MembershipStrategy {

    @Override
    public boolean becomeMember(PerfilPersona follower, GrupInteres grup) {
        if (follower.hasCodiAcces(grup.getCodiAcces())){
            follower.addGrupInteresMembership(grup);
            follower.addPunts(150);
            return true;
        } else {
            return false;
        }
    }
}
