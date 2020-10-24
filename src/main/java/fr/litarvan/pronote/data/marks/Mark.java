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

public class Mark implements Data {

    private String id;
    private String title;
    private float value;
    private float scale;
    private float average;
    private float coefficient;
    private float min;
    private float max;
    private long date;
    private boolean isAway;

    public String getId() {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public float getValue()
    {
        return value;
    }

    public float getScale() {
        return scale;
    }

    public float getCoefficient()
    {
        return coefficient;
    }

    public float getAverage()
    {
        return average;
    }

    public float getMin()
    {
        return min;
    }

    public float getMax()
    {
        return max;
    }

    public long getDate() {
        return date;
    }

    public boolean isAway()
    {
        return isAway;
    }

}
