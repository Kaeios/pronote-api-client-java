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

public class Absence
{
	private long from;
	private long to;
	private boolean solved;
	private boolean justified;
	private String reason;

	public Absence()
	{
	}

	public Absence(long from, long to, boolean solved, boolean justified, String reason)
	{
		this.from = from;
		this.to = to;
		this.solved = solved;
		this.justified = justified;
		this.reason = reason;
	}

	public long getFrom()
	{
		return from;
	}

	public long getTo()
	{
		return to;
	}

	public boolean isSolved()
	{
		return solved;
	}

	public boolean isJustified()
	{
		return justified;
	}

	public String getReason()
	{
		return reason;
	}
}