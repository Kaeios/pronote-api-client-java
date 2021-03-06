/*
 *  Copyright (c) 2017-2019 Adrien 'Litarvan' Navratil
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package fr.litarvan.pronote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.litarvan.pronote.server.request.LoginRequest;
import fr.litarvan.pronote.server.response.LoginResponse;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Pronote API</h2>
 *
 * You must have an <a href="https://github.com/Litarvan/pronote-api">API server</a> setup.
 * Then, use it like this :
 * <pre>
 *     PronoteAPI api = new PronoteAPI("http://127.0.0.1:21727/");
 *
 *     try {
 *         api.login(new LoginRequest("username", "password", "pronote url", "cas");
 *     } catch (RequestException e) {
 *         // ...
 *     }
 *
 *     FetchResponse response = api.fetch(new FetchResponse("username", "password", "pronote url", "cas");
 *     System.out.println(String.format("Welcome %s !", response.getName()));
 * </pre>
 *
 * The "cas" field is optional, it is necessary only if your Pronote server redirects you to a regional-specific
 * interface to login, then chose the right one (ex: "ac-lyon"), see the API server README.
 *
 * @author Adrien 'Litarvan' Navratil
 * @version 1.0.0
 * @since 1.0.0
 */
public class PronoteAPI {

    private static final String DEFAULT_URL = "http://127.0.0.1:21727/";
    public static final String VERSION = "2.0.0";
    public static final Gson gson = new GsonBuilder()
            .enableComplexMapKeySerialization()
            .disableHtmlEscaping()
            .serializeNulls()
            .create();

    private final String url;
    private final Requester requester;
    private String token;

    /**
     * @param url URL of the <a href="https://github.com/Litarvan/pronote-api">API server</a>
     */
    public PronoteAPI(String url) {
        this.url = url;
        this.requester = new Requester(this);
    }

    public PronoteAPI() {
        this.url = DEFAULT_URL;
        this.requester = new Requester(this);
    }

    /**
     * Login the user (does not fetch any data).
     * This request is optional, doing fetch without "login" will first do login
     *
     * @param request The request data
     *
     * @throws IOException If the HTTP connection or I/O failed
     * @throws RequestException If the "error" field is not empty, throw an exception with its content
     */
    public void login(LoginRequest request) throws IOException, RequestException {

        URL url = new URL(this.url + (this.url.endsWith("/") ? "" : "/") + "auth/login");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        try (DataOutputStream out = new DataOutputStream(connection.getOutputStream()))
        {
            out.write(gson.toJson(request).getBytes(StandardCharsets.UTF_8));
        }

        StringBuilder content = readResponse(connection);

        LoginResponse response = gson.fromJson(content.toString(), LoginResponse.class);
        if (response.getError() != null)
        {
            throw new RequestException(new Exception(response.getError()));
        }

        this.token = response.getToken();
    }

    /**
     * Fetch pronote data relative to the graphql query
     *
     * @param graphQlQuery The query
     *
     * @return Response of the query
     *
     * @throws IOException If the HTTP connection or I/O failed
     * @throws RequestException If the api isn't connected with pronote, by PronoteAPI#login call
     */
    public JsonObject fetch(String graphQlQuery) throws IOException, RequestException {

        if (token == null || token.isEmpty()) {
            throw new RequestException("login required before perform any fetch");
        }

        URL url = new URL(this.url + (this.url.endsWith("/") ? "" : "/") + "graphql");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoInput(true);
        connection.setDoOutput(true);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Token", token);

//        System.out.println("request : " + graphQlQuery);

        try (DataOutputStream out = new DataOutputStream(connection.getOutputStream()))
        {
            Map<String, String> request = new HashMap<>();

            request.put("query", graphQlQuery);
            out.write(gson.toJson(request).getBytes(StandardCharsets.UTF_8));
        }

        StringBuilder content = readResponse(connection);

//        System.out.println("response : " + content);

        return gson.fromJson(content.toString(), JsonObject.class).getAsJsonObject("data");
    }

    private StringBuilder readResponse(HttpURLConnection connection) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)))
        {
            String line;

            while ((line = in.readLine()) != null)
            {
                content.append(line).append(System.lineSeparator());
            }

        }

        connection.disconnect();
        return content;
    }

    public String getUrl()
    {
        return url;
    }

    public Requester getRequester() {
        return requester;
    }

}
