package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;


public class MetaDataModule{

    public static boolean createMetaData(String username, String tablename, String[] tableAttributes)
    {

        String metadataPath = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".metadata";
        String dataFilePate = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".datafile";
        try{
            String str;
            FileWriter mfw = new FileWriter(metadataPath);
            FileWriter dfw = new FileWriter(dataFilePate);
            mfw.append(tablename + "#");

            for(String s : tableAttributes)
            {
                mfw.append(s + "%");
            }
            mfw.close();
        }
        catch (Exception e){
            System.out.print(e);
            return false;
        }
        return true;
    }
    public static String[] getAttributes(String username, String tablename)
    {
        String[] attributes = {};
        return attributes;
    }
}
