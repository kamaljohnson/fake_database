package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;


public class MetaDataModule{

    public static boolean createMetaData(String username, String tablename, String[] tableAttributes)
    {

        String currntRootDirectory = "C:/Users/kamal/IdeaProjects/DBMS/src/com/company/all_users/" + username + "/" + tablename + ".metadata";

        try{
            String str;

            File file = new File(currntRootDirectory);
            file.createNewFile();
            FileWriter fw = new FileWriter(currntRootDirectory);
            fw.append(tablename + "#");

            for(String s : tableAttributes)
            {
                fw.append(s + "%");
            }
            fw.close();
        }
        catch (Exception e){
            System.out.print(e);
            return false;
        }
        return true;
    }
}
