package com.example.system_mangment.Service;

import com.example.system_mangment.Model.Classes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClassesService {

    ArrayList<Classes>classes=new ArrayList<>();

    public void add(Classes classes1){
        classes.add(classes1);
    }
    public ArrayList<Classes>get(){
        return classes;
    }

    public boolean update(String name, Classes classe){
        for (int i =0 ; i<classes.size();i++){
            if (classes.get(i).getName().equalsIgnoreCase(name)){
                classes.set(i,classe);
                return  true;
            }
        }
        return false;
    }

    public boolean delete(String name){
        for (int i =0 ; i<classes.size();i++){
            if (classes.get(i).getName().equalsIgnoreCase(name)){
                classes.remove(i);
                return true;
            }
        }
        return false;
    }

   public Classes serch_byName(String name){
        for (Classes classes1:classes){
            if(classes1.getName().equalsIgnoreCase(name)){
                return classes1;
            }
        }
        return null;
   }

   public ArrayList<Classes> serch_byLevel(int leval){
        ArrayList<Classes>leves=new ArrayList<>();
        for (Classes classes1:classes){
            if(classes1.getLevel()==leval){
                leves.add(classes1);
            }
        }
        return leves;
   }

    public ArrayList<Classes> serch_hours(int hour){
        ArrayList<Classes>hours=new ArrayList<>();
        for (Classes classes1:classes){
            if(classes1.getHours()==hour){
                hours.add(classes1);
            }
        }
        return hours;
    }





}
