package fr.litarvan.pronote.request;

public class Replacement {

    private final String api;
    private final String server;

    public Replacement(String api, String server) {
        this.api = api;
        this.server = server;
    }

    public String toServer(String text) {
        return text.replace(api, server);
    }

    public String toApi(String text) {
        return text.replace(server, api);
    }

}
