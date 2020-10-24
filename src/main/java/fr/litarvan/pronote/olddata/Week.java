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
package fr.litarvan.pronote.olddata;

import fr.litarvan.pronote.data.timetable.Lesson;

public class Week
{
    private long time;
    private Lesson[] content;

    public Week()
    {
    }

    public Week(long time, Lesson[] content)
    {
        this.time = time;
        this.content = content;
    }

    public long getTime()
    {
        return time;
    }

    public Lesson[] getContent()
    {
        return content;
    }
}
