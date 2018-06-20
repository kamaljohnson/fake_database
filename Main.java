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
        while (loop)
        {
            text = scan.next();
            switch(text) {
                case "local_interface":
                    if(UserInterface.local(currentUsername));
                    else
                        System.out.println("user " + currentUsername + " not found");
                    break;
                case "client_interface":
                    if(UserInterface.client(currentUsername));
                    else
                        System.out.println("user " + currentUsername + " not found");
                    break;
                case "current_user":
                    //display all the public tables in the current username
                    System.out.println(currentUsername);
                    break;
                case "change_user":
                    System.out.print("enter user name : ");
                    currentUsername = scan.next();
                    break;
                case "create_user":
                    String password;
                    System.out.print("enter user name : ");
                    currentUsername = scan.next();
                    System.out.print("create password : ");
                    password = scan.next();
                    System.out.print("conform password : ");
                    password = scan.next();
                    String path = currntRootDirectory + "/all_users/" + currentUsername;
                    File dir = new File(path);
                    if(dir.mkdir())
                    {
                        System.out.println("user added.");
                    }
                    else
                    {
                        System.out.println("error occurred while creating user!!");
                    }
                    break;
                case "close":
                    loop = false;
                    break;
                default:
                    System.out.println("syntax error");
            }
        }
    }

}
