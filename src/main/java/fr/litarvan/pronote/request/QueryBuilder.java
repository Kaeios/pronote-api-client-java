package fr.litarvan.pronote.request;

import fr.litarvan.pronote.data.Data;

import java.lang.reflect.Field;

public class QueryBuilder {

    private final StringBuilder sb = new StringBuilder("{");

    public QueryBuilder() {
    }

    public QueryBuilder function(String function, String... params) {
        sb.append(function).append("(");

        for (int i = 0; i < params.length; i++) {
            sb.append(params[i]);
            if (i % 2 == 0)
                sb.append(": ");
            else if (i < (params.length - 1))
                sb.append(",");
        }

        sb.append("){");

        return this;
    }

    public QueryBuilder value(String value) {
        sb.append(value).append("{");
        return this;
    }

    public String elements(String... elements) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i != elements.length - 1)
                sb.append(",");
        }

        return sb.toString();
    }

    public QueryBuilder elements(Class<?> clazz) {

        String[] elements = buildString(clazz);

        String toAdd = elements(elements);
        sb.append(toAdd);
        return this;
    }

    private String[] buildString(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        String[] elements = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {

            Field field = fields[i];
            String toAdd = "";

            if (Data.class.isAssignableFrom(field.getType())) {

                toAdd = "{" + elements(buildString(field.getType())) + "}";
            }

            if (field.getType().isArray() && Data.class.isAssignableFrom(field.getType().getComponentType())) {

                toAdd = "{" + elements(buildString(field.getType().getComponentType())) + "}";
            }

            if (field.getType().isArray() && field.getType().getComponentType().isArray() && Data.class.isAssignableFrom(field.getType().getComponentType().getComponentType())) {

                toAdd = "{" + elements(buildString(field.getType().getComponentType().getComponentType())) + "}";
            }

            elements[i] = field.getName() + toAdd;
        }

        return elements;
    }

    public String build() {

        return sb.toString() + "}}";
    }

}
