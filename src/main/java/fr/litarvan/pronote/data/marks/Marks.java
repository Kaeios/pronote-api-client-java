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
package fr.litarvan.pronote.data.marks;

import fr.litarvan.pronote.data.Data;

public class Marks implements Data
{

	private MarksSubject[] subjects;
	private MarksAverages averages;

	public Marks()
	{
	}

	public Marks(MarksSubject[] subjects, MarksAverages averages)
	{
		this.subjects = subjects;
		this.averages = averages;
	}

	public MarksSubject[] getMarksSubjects()
	{
		return subjects;
	}

	public MarksAverages getAverages()
	{
		return averages;
	}

}