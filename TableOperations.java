package com.company;

import java.io.File;
import java.util.Scanner;

public class TableOperations {

    static String path = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/";;
    public static void create_table(String username) {
        Scanner scan = new Scanner(System.in);
        path += username;
        String tableName = "";
        String[] tableAttributes;
        System.out.print("Table name : ");
        tableName = scan.next();
        System.out.print("Attributes : ");
        tableAttributes = scan.next().split(" ");

        if(!MetaDataModule.createMetaData(username, tableName, tableAttributes))
            System.out.println("error occurred while creating metadata");
    }
}
