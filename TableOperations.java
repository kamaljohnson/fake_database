package com.company;

import java.io.File;
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
        String[] tableAttributes;
        System.out.print("Table name : ");
        tableName = scan.next();
        System.out.print("Attributes : ");
        tableAttributes = scan.next().split(" ");

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
        }

    }

}
