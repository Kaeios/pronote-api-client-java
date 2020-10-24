package fr.litarvan.pronote.data.informations;

import fr.litarvan.pronote.data.Data;
import fr.litarvan.pronote.olddata.FileUpload;

public class Info implements Data {

    private long date;
    private String title;
    private String author;
    private String content;
    private String htmlContent;
    private FileUpload[] files;

    public Info() {
    }

    public Info(long date, String title, String author, String content, String htmlContent, FileUpload[] files)
    {
        this.date = date;
        this.title = title;
        this.author = author;
        this.content = content;
        this.htmlContent = htmlContent;
        this.files = files;
    }

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
