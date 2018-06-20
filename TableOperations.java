package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TableOperations {

    public static String create_table(String username) {
        String path = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/";;
        Scanner scan = new Scanner(System.in);
        path += username;
        String tableName = "";
        List<String> tableAttributes = new ArrayList<>();
        System.out.print("Table name : ");
        tableName = scan.next();
        System.out.print("Attributes : ");
        tableAttributes = Arrays.asList(scan.next().split(","));
        System.out.println(tableAttributes);
        if(!MetaDataModule.createMetaData(username, tableName, tableAttributes)){
            System.out.println("error occurred while creating metadata");
            return "";
        }
        else {
            try {
                    FileWriter fw = new FileWriter(path  + "/" + username + ".tableList", true);
                    fw.append("#" + tableName);
                    fw.close();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
        }
        return tableName;
    }
    public static void add_data(String username, String tablename)
    {
        Scanner scan = new Scanner(System.in);
        List<String> attributes = MetaDataModule.getAttributes(username, tablename);
        attributes.remove(" ");
        List<String> dataEntry = new ArrayList<>();

        for(String str : attributes)
        {
            System.out.print(str + " : ");
            String data = scan.next();
            dataEntry.add(data);
            dataEntry.add("|");
        }
        String dataFilePate = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".datafile";
        try {
            FileWriter dfw = new FileWriter(dataFilePate, true);
            dataEntry.remove(dataEntry.size()-1);
            dataEntry.add("%");
            String data = "";
            for(String d : dataEntry)
                data += d;
            dfw.append(data);
            dfw.close();
            System.out.println(data);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public static void display(String username, String tablename)
    {
        String metadataPath = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".metadata";
        String dataFilePate = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".datafile";

        try {
            FileReader mfw = new FileReader(metadataPath);
            BufferedReader mbf = new BufferedReader(mfw);
            FileReader dfw = new FileReader(dataFilePate);
            BufferedReader dbf = new BufferedReader(dfw);

            String attributeString = mbf.readLine();
            String dataString = dbf.readLine();
            List<String> attributs = Arrays.asList(attributeString.split("%"));
            List<String> datarow = Arrays.asList(dataString.split("%"));
            for(String s : attributs)
                System.out.print(s + " ");
            System.out.println();
            for(String d : datarow)
                System.out.println(d);
            mfw.close();
            dfw.close();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
