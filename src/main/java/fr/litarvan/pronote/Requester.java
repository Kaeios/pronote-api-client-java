package fr.litarvan.pronote;

import com.google.gson.JsonObject;
import fr.litarvan.pronote.data.absences.Absences;
import fr.litarvan.pronote.data.contents.Contents;
import fr.litarvan.pronote.data.evaluations.Evaluations;
import fr.litarvan.pronote.data.homeworks.Homeworks;
import fr.litarvan.pronote.data.informations.Infos;
import fr.litarvan.pronote.data.marks.Marks;
import fr.litarvan.pronote.data.menus.Menu;
import fr.litarvan.pronote.data.timetable.Timetable;
import fr.litarvan.pronote.request.Request;
import fr.litarvan.pronote.request.pronote.*;
import fr.litarvan.pronote.server.request.RequestException;

import java.io.IOException;

public class Requester {

    private final PronoteAPI pronoteAPI;

    private final Request<Absences> absencesRequest = new AbsencesRequest();
    private final Request<Evaluations> evaluationsRequest = new EvaluationsRequest();
    private final Request<Homeworks> homeWorkRequest = new HomeWorkRequest();
    private final Request<Infos> infosRequest = new InfosRequest();
    private final Request<Contents> lessonsContentsRequest = new LessonsContentsRequest();
    private final Request<Marks> marksRequest = new MarksRequest();
    private final Request<Menu> menuRequest = new MenuRequest();
    private final Request<Timetable> timeTableRequest = new TimeTableRequest();

    public Requester(PronoteAPI pronoteAPI) {
        this.pronoteAPI = pronoteAPI;
    }

    public Absences fetchAbsences(String period, String from) throws IOException, RequestException {
        return fetchRequest(absencesRequest, period, from);
    }

    public Absences fetchAbsences(String period, String from, String to) throws IOException, RequestException {
        return fetchRequest(absencesRequest, period, from, to);

    }

    public Evaluations fetchEvaluations(String period) throws IOException, RequestException {
        return fetchRequest(evaluationsRequest, period);
    }

    public Homeworks fetchHomeworks(String from) throws IOException, RequestException {
        return fetchRequest(homeWorkRequest, from);
    }

    public Homeworks fetchHomeworks(String from, String to) throws IOException, RequestException {
        return fetchRequest(homeWorkRequest, from, to);
    }

    public Infos fetchInfos() throws IOException, RequestException {
        return fetchRequest(infosRequest);
    }

    public Contents fetchContents(String from) throws IOException, RequestException {
        return fetchRequest(lessonsContentsRequest, from);
    }

    public Contents fetchContents(String from, String to) throws IOException, RequestException {
        return fetchRequest(lessonsContentsRequest, from, to);
    }

    public Marks fetchMarks(String period) throws IOException, RequestException {
        return fetchRequest(marksRequest, period);
    }

    public Menu fetchMenu(String from) throws IOException, RequestException {
        return fetchRequest(menuRequest, from);
    }

    public Menu fetchMenu(String from, String to) throws IOException, RequestException {
        return fetchRequest(menuRequest, from, to);
    }

    public Timetable fetchTimeTable(String from) throws IOException, RequestException {
        return fetchRequest(timeTableRequest, from);
    }

    public Timetable fetchTimeTable(String from, String to) throws IOException, RequestException {
        return fetchRequest(timeTableRequest, from, to);
    }

    private  <T> T fetchRequest(Request<T> request, String... parameters) throws IOException, RequestException {
        String query = request.buildQuery(parameters);
        JsonObject fetch = pronoteAPI.fetch(query);
        return request.buildObject(fetch, PronoteAPI.gson);
    }

}
