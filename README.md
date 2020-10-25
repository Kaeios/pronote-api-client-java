# Pronote API Java client

Un client pour [l'API Pronote](https://github.com/Litarvan/pronote-api) en Java

## Import

## Utilisation

```java
PronoteAPI api = new PronoteAPI("http://127.0.0.1:21727/");
// ou PronoteAPI api = new PronoteAPI();
// si vous utilisez le port par défaut

try {

    api.login(new LoginRequest("username", "password", "pronote url", "cas");
    Requester requester = api.getRequester();

    Timetable timetable = requester.fetchTimeTable("2020-10-12");

} catch (RequestException | IOException e) {

    ... // Mauvais identifiants
    // ou erreur lors de la récupération des données

}

```