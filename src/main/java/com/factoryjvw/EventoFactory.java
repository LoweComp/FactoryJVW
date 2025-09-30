package com.factoryjvw;

public class EventoFactory {

    public static IEvento criarEvento(String tipoEvento) {
        Class classe = null;
        Object objeto = null;

        try {
            String nomeClasse = "com.factoryjvw.Evento" + tipoEvento;
            classe = Class.forName(nomeClasse);

            objeto = classe.getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Tipo de Evento inexistente: " + tipoEvento);

        } catch (Exception ex) {
            throw new IllegalArgumentException("Erro ao criar evento: " + ex.getMessage());
        }

        if (!(objeto instanceof IEvento)) {
            throw new IllegalArgumentException("Classe do evento não implementa IEvento.");
        }

        return (IEvento) objeto;
    }
}