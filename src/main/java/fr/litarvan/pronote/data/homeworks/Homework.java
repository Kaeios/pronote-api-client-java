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
package fr.litarvan.pronote.data.homeworks;

import com.google.gson.annotations.SerializedName;
import fr.litarvan.pronote.data.FileUpload;

public class Homework {

    private String description;
    private String htmlDescription;
    private String subject;
    private long givenAt;
    private long to;
    private boolean done;
    private String color;
    private FileUpload[] files;

    public String getDescription() {
        return description;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public String getSubject()
    {
        return subject;
    }

    public long getGivenAt()
    {
        return givenAt;
    }

    public long getTo()
    {
        return to;
    }

    public boolean isDone()
    {
        return done;
    }

    public String getColor() {
        return color;
    }

    public FileUpload[] getFiles()
	{
		return files;
	}

}
