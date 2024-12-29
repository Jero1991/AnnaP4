package ub.edu.view;

import javafx.scene.control.Button;

public class EscenaMenuAccessos  extends Escena{


    private Button codiAcces;
    private Button ruleta;
    private Button triviaJoc;


    public void start() throws Exception{
        //TODO
    }


    public void onCodiAcces() throws Exception{

        controller.getSessionMemory().setMembershipStrategy("CodiAccesSrategy");
        refreshMembershipStrategy();
        codiAcces.setDisable(false);
        ruleta.setDisable(true);
        triviaJoc.setDisable(true);

        Escena escena = EscenaFactory.INSTANCE.creaEscena("InvitacioCodi-view", "Invitacio" );
        EscenaInvitacioCodi escenaInvitacio = (EscenaInvitacioCodi) escena;
        escenaInvitacio.setController(controller);
        escenaInvitacio.start();
    }

    private void refreshMembershipStrategy() {
        String tipusStrategy = controller.getSessionMemory().getTipusStrategy();
        System.out.println("Tipus Strategy: " + tipusStrategy);
        try {
            controller.setMembershipStrategy(tipusStrategy);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onRuleta() throws Exception{
        Escena escena = EscenaFactory.INSTANCE.creaEscena("Ruleta-view", "Ruleta" );
        EscenaRuleta escenaRuleta = (EscenaRuleta) escena;
        escenaRuleta.setController(controller);
        escenaRuleta.start();

    }

    public void onTriviaJoc() throws Exception{
        Escena escena = EscenaFactory.INSTANCE.creaEscena("TriviaJoc-view", "Trivia Joc" );
        EscenaTriviaJoc escenaTrivia = (EscenaTriviaJoc) escena;
        escenaTrivia.setController(controller);
        escenaTrivia.start();
    }




}
