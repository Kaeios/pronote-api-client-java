package fr.litarvan.pronote.data.informations;

import fr.litarvan.pronote.data.Data;
import fr.litarvan.pronote.data.FileUpload;

public class Info implements Data {

    private long date;
    private String title;
    private String author;
    private String content;
    private String htmlContent;
    private FileUpload[] files;

    public long getDate()
    {
        return date;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getContent()
    {
        return content;
    }

    public FileUpload[] getFiles()
    {
        return files;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

}
