package com.javacore.steve.db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBase {

    private Object tableBlock = new Object();

    Map<String, Table> tables;
    //DB.query("SELECT id, firstName, lastName FROM criminals WHERE id=0")

    public List<Record> select(){
        System.out.println("Starting fetching records...");
        synchronized (tableBlock) {
            try {
                Thread.sleep(500);
                System.out.println("Finishing fetching records...");
            } catch (InterruptedException e) {
            }
        }
        return null;

    }

    public void delete(){

    }

    public void update(){
        System.out.println("Starting updating database...");
        synchronized (tableBlock) {
            try {
                Thread.sleep(10000);
                System.out.println("Finishing updating database...");
            } catch (InterruptedException e) {
            }
        }
    }

    public void insert(Record record, Table table) {
        System.out.println("Inserting...");

    }

    public static List<String[]> readDataFile(String fileName) {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader;
        List<String[]> result = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                result.add(line.split(" "));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
