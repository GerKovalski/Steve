package com.javacore.steve.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Table {

    private String tableName;
    private List<String> columns;
    private List<Record> records;

    {
        records = new ArrayList<>();
    }

    public void insert(Record record) {
        records.add(record);
    }

    //Query SELECT id, firstName, lastName
    public void select(String query){}
    //-------------------------
    //ID     firstName lastName
    //-------------------------
    //1      Ivan      Ivanov
    //2      Petr      Petrov
    //Select печатает 100мс в это время идет индикатор загрузки

    public List<String> selectField(String fieldName) {
        int index = columns.indexOf(fieldName);
        Iterator iterator = records.iterator();
        List<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Record r = (Record)iterator.next();
            result.add(r.values.get(index));
        }
        return result;
    }

    public Table(String tableName, List<String> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public List<String> getColumns() {

        return columns;
    }
}
