package com.company;

import javax.sql.rowset.spi.SyncProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //the main function of the program

        Scanner scan = new Scanner(System.in);
        String text = new String();
        String currentUsername = "global";
        String currentTablename = "";
        String tableListPath = "";
        String currntRootDirectory = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company";
        boolean loop = true;
        String tempUsername = "";
        File dir;
        String path;
        String consolString = "/DBMS/";
        while (loop)
        {
            System.out.print(consolString + currentUsername + "/" + currentTablename + ">");
            text = scan.next();
            switch(text) {
                case "current_user":
                    //display all the public tables in the current username
                    System.out.println(currentUsername);
                    break;
                case "change_user":
                    System.out.print("enter user name : ");
                    tempUsername = scan.next();
                    path = currntRootDirectory + "/all_users/" + tempUsername;
                    dir = new File(path);
                    if (dir.exists())
                    {
                        System.out.print("enter password : ");
                        String password = scan.next();
                        if(ProtectionModule.check_userPassword(tempUsername, password))
                        {
                            currentUsername = tempUsername;
                            currentTablename = "";
                        }
                        else
                        {
                            System.out.println("password incorrect!!");
                        }
                    }
                    else
                        System.out.println("user " + tempUsername + " not found!!");
                    break;
                case "create_user":
                    String password;

                    System.out.print("enter user name : ");
                    tempUsername = scan.next();

                    System.out.print("create password : ");
                    password = scan.next();

                    System.out.print("conform password : ");
                    password = scan.next();

                    path = currntRootDirectory + "/all_users/" + tempUsername;
                    tableListPath = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + tempUsername + "/" + tempUsername + ".tableList";
                    dir = new File(path);
                    if(dir.mkdir())
                    {
                        System.out.println("user added.");
                        currentUsername = tempUsername;
                        try {
                            FileWriter f = new FileWriter(tableListPath);
                            f.close();
                        }
                        catch (Exception e)
                        {
                            System.out.print(e);
                        }
                    }
                    else
                    {
                        System.out.println("error occurred while creating user!!");
                    }
                    break;
                case "close":
                    loop = false;
                    break;
                case "create_table":
                    currentTablename = TableOperations.create_table(currentUsername);
                    break;
                case "display_table":
                    TableOperations.display(currentUsername, currentTablename);
                    break;
                case "select_table":
                    tableListPath = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + currentUsername + "/" + currentUsername + ".tableList";
                    try {
                        FileReader f = new FileReader(tableListPath);
                        BufferedReader br = new BufferedReader(f);

                        String s = br.readLine();

                        List<String> tableNames = Arrays.asList(s.split("#"));
                        for(String str : tableNames)
                        {
                            System.out.println(str.toUpperCase());
                        }
                        System.out.print("enter table : ");
                        String temp = scan.next();
                        if(tableNames.contains(temp))
                            currentTablename = temp;
                        else
                            System.out.println("table " +  temp + " not present in user " + currentUsername);
                        f.close();
                    }
                    catch (Exception e)
                    {
                        System.out.print(e);
                    }
                    break;
                case "add_data":
                    if(!currentTablename.equals(""))
                    {
                        TableOperations.add_data(currentUsername, currentTablename);
                    }
                    else
                    {
                        System.out.println("no table selected.(use select_table to select a table)");
                    }
                    break;
                case "help":
                    System.out.println("create_user - used to create user database");
                    System.out.println("change_user - used to change the current user to another existing user");
                    System.out.println("create_table - used to create a table");
                    System.out.println("select_table - used to select a table from the user base");
                    System.out.println("add_data - used to add data according to the attribute specified for the table");
                    System.out.println("display_table - used to display the current table");
                    System.out.println("close - used to close the DBMS sadly");
                    break;
                default:
                    System.out.println("syntax error");
            }
        }
    }

}
