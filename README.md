# Pronote API Java client

Un client pour [l'API Pronote](https://github.com/Litarvan/pronote-api) en Java

## Import

## Utilisation

```java
PronoteAPI api = new PronoteAPI("http://127.0.0.1:21727/");

try {
    api.login(new LoginRequest("username", "password", "pronote url", "cas");
    Timetable timetable = Timetable.fetch(api, "2020-10-12");
} catch (RequestException e) {
    ... // Mauvais identifiants
}

```