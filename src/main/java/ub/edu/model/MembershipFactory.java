package ub.edu.model;

import java.util.HashMap;

public enum MembershipFactory {
    INSTANCE;

    public static MembershipFactory getInstance() {
        return INSTANCE;
    }

    private final HashMap<String, MembershipStrategy> memberships = new HashMap<>();

    public MembershipStrategy createMembership(String membershipType) {
        MembershipStrategy membership = memberships.get(membershipType);

        if (membership != null) {
            return membership;
        } else {
            try {
                String name = MembershipStrategy.class.getPackage().getName();
                membership = (MembershipStrategy) Class.forName(name + "." + membershipType).getDeclaredConstructor().newInstance();
                memberships.put(membershipType, membership);
                return membership;
            } catch (Exception e) {
                System.out.println("El tipus de membership no existeix");
                return null;
            }
        }
    }
}
