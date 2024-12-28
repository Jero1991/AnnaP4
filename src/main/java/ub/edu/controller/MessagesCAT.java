package ub.edu.controller;

import ub.edu.model.exceptions.*;

import java.lang.reflect.Method;

// TO DO moure a controller + crear classes per exceptions
public enum MessagesCAT {

    // Exception messages
    PersonaNotFoundException("Correu inexistent"),
    PersonaExistsException("Persona ja existent en el Sistema"),
    WrongPasswordException("Contrasenya incorrecta"),
    FormatIncorrecteException("Correu en format incorrecte"),
    NotAvailableMoviesException("No hi ha pel·lícules disponibles"),
    NotAvailableMovieException("Pel·lícula no disponible en el sistema"),
    NotSecurePasswordException("Contrasenya no prou segura"),
    NotAvailableShowsException("No hi ha sèries disponibles"),
    NotAvailableShowException("Aquesta sèrie no està disponible en el sistema"),
    ShowWithoutSeasonException("Aquesta sèrie no té aquesta temporada"),
    ShowWithoutSeasonsException("Aquesta sèrie no té temporades"),
    DuplicateSeasonException("Aquesta temporada ja existeix"),
    DuplicateEpisodeException("Aquest episodi ja existeix"),
    NotAvailableGroupsException("No hi ha grups disponibles"),
    NotAvailableGroupException("El grup no existeix"),
    SeasonNotFoundException("Aquesta sèrie no té aquesta temporada"),
    FollowingException("Ja eres follower del grup"),
    MemberExistsException("Membre ja existent en el grup"),
    PreguntaNotFound("Pregunta no trobada"),

    MemberNotFoundException("Membre no trobat"),
    DuplicateGrupInteresException("Grup ja existent en el Sistema"),

    // Success messages
    SuccessfulFindPersona("Persona ja existent en el Sistema"),
    SuccessfulRegistreValid("Registre vàlid"),
    SuccessfulLogin("Login correcte"),
    SuccessfulSecurePassword("Contrasenya segura"),
    SuccessfulFormatEmail("Correu en format correcte"),
    SuccessfulFindGrup("Grup trobat"),
    SuccessfulAddPreguntaQuiz("Pregunta afegida correctament"),
    SuccessfulAddFollowerGrup("Follower afegit correctament"),
    SuccessfulAddMemberGrup("Membre afegit correctament"),
    SuccessfulAddedWatchedHistory("Contingut afegit correctament a la Watched History"),
    RespostaCorrecta("Resposta correcta"),
    RespostaIncorrecta("Resposta incorrecta");



    private final String message;

    MessagesCAT(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String translate(Exception e) {
        // Depending on the type of the Exception we will return the corresponding message
        String exceptionName = e.getClass().getSimpleName();  // Obté el nom de la classe de l'excepció
        return valueOf(exceptionName).getMessage();
    }
    /*if (e instanceof PersonaNotFoundException) {
            return ClientNotFound.getMessage();
        } else if (e instanceof NotAvailableMoviesException) {
            return NotAvailableMovies.getMessage();
        } else if (e instanceof NotAvailableShowsException) {
            return NotAvailableShows.getMessage();
        } else {
            return "An error occurred";
        }
    }*/
}
