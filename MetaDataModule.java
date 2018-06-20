package com.company;

import java.io.*;
import java.util.*;


public class MetaDataModule{

    public static boolean createMetaData(String username, String tablename, String[] tableAttributes)
    {

        String metadataPath = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".metadata";
        String dataFilePate = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".datafile";
        try{
            String str;
            FileWriter mfw = new FileWriter(metadataPath, true);
            FileWriter dfw = new FileWriter(dataFilePate, true);

            for(String s : tableAttributes)
            {
                mfw.append(s + "%");
            }
            dfw.close();
            mfw.close();
        }
        catch (Exception e){
            System.out.print(e);
            return false;
        }
        return true;
    }
    public static List<String> getAttributes(String username, String tablename)
    {

        List<String> attributes = new ArrayList<>();
        String metadataPath = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".metadata";
        try {
            FileReader ar = new FileReader(metadataPath);
            BufferedReader bf = new BufferedReader(ar);
            String atb = bf.readLine();
            attributes = Arrays.asList(atb.split("%"));
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return attributes;
    }
}
