package com.javacore.steve.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Record {

    protected List<String> values;
    protected List<String> columns;

    public Record(Table table) {
        columns = table.getColumns();
        values = new ArrayList<>();
    }

    {
        values = new ArrayList<>();
    }

    public void setValues(String[] values) {
        this.values.clear();
        this.values = Arrays.asList(values);
    }

    public int getInt(String fieldName) throws FieldNotFoundException {
        int index = columns.indexOf(fieldName);
        if (index == -1) {
            throw new FieldNotFoundException("Field not found: " + fieldName);
        }
        return Integer.parseInt(values.get(index));
    }

    public boolean getBoolean(String fieldName) throws FieldNotFoundException {
        int index = columns.indexOf(fieldName);
        if (index == -1) {
            throw new FieldNotFoundException("Field not found: " + fieldName);
        }
        return Boolean.parseBoolean(values.get(index));
    }

    public class FieldNotFoundException extends Exception{
        public FieldNotFoundException(String message) {
            super(message);
        }
    }
}
