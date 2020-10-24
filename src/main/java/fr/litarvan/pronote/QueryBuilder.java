package fr.litarvan.pronote;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.List;

public class QueryBuilder {

    private final StringBuilder sb = new StringBuilder("{");

    public QueryBuilder() { }

    public QueryBuilder function(String function, String... params) {
        sb.append(function).append("(");

        for (int i = 0; i < params.length; i++) {
            sb.append(params[i]);
            if(i % 2 == 0)
                sb.append(": ");
            else if (i < (params.length-1))
                sb.append(",");
        }

        sb.append("){");

        return this;
    }

    public QueryBuilder elements(String... elements) {
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if(i != elements.length-1)
                sb.append(",");
        }

        return this;
    }

    public QueryBuilder elements(Class<?> clazz) {
        String[] elements = new String[clazz.getDeclaredFields().length];

        for (int i = 0; i < clazz.getDeclaredFields().length; i++) {
            elements[i] = clazz.getDeclaredFields()[i].getName();
        }

        return elements(elements);
    }

    public String build() {

        return sb.toString() + "}}";
    }

}
