package ub.edu.model;

import ub.edu.model.cataleg.GrupInteres;

public interface MembershipStrategy {

    boolean becomeMember(PerfilPersona follower, GrupInteres grup);
}
