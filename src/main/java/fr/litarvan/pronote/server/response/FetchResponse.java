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
package fr.litarvan.pronote.server.response;

import fr.litarvan.pronote.data.homeworks.Homework;
import fr.litarvan.pronote.data.informations.Info;
import fr.litarvan.pronote.data.marks.Marks;

public class FetchResponse extends Response
{
    private String studentClass;
    private String name;
    private String avatar;

    private String[][] menu;

    private Marks[] marks;
    private Homework[] homeworks;

    private Info[] infos;

    public FetchResponse()
    {
    }

	public FetchResponse(String studentClass, String name, String avatar, String[][] menu, Marks[] marks, Homework[] homeworks, Info[] infos)
	{
		this.studentClass = studentClass;
		this.name = name;
		this.avatar = avatar;
		this.menu = menu;
		this.marks = marks;
		this.homeworks = homeworks;
		this.infos = infos;
	}

	public String getStudentClass()
    {
        return studentClass;
    }

    public String getName()
    {
        return name;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public String[][] getMenu()
    {
        return menu;
    }

	public Marks[] getMarks()
	{
		return marks;
	}

	public Homework[] getHomeworks()
    {
        return homeworks;
    }

	public Info[] getInfos()
	{
		return infos;
	}
}
