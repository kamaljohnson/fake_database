package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //the main function of the program
        Scanner scan = new Scanner(System.in);
        String text = new String();
        String currentUsername = "global";
        String currntRootDirectory = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company";
        boolean loop = true;
        String tempUsername = "";
        File dir;
        String path;
        while (loop)
        {
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
                    dir = new File(path);

                    if(dir.mkdir())
                    {
                        System.out.println("user added.");
                        currentUsername = tempUsername;
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
                    break;
                case "add_attribute":
                    break;
                default:
                    System.out.println("syntax error");
            }
        }
    }

}
