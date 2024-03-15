package com.example.system_mangment.Service;
import com.example.system_mangment.Model.Teachers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TechearService {
    ArrayList<Teachers>teachers=new ArrayList<>();
    public void add(Teachers teacher){
        teachers.add(teacher);
    }

    public ArrayList get(){
        return teachers;
    }

    public boolean update(int id,Teachers teacher){
        for (int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }}
        return false;
    }


    public boolean delete(int id){
        for(int i=0; i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList byCatogary(String catogary){
        ArrayList<Teachers>catogarys=new ArrayList<>();
        for(Teachers teacher:teachers){
            if (teacher.getCatogary().equalsIgnoreCase(catogary)){
               catogarys.add(teacher);
            }
        }
        return catogarys;
    }

    public boolean setOnLeave(int id){
        for (Teachers teachers1:teachers){
            if(teachers1.getId()==id){
                teachers1.setOnLeave(true);
                return true;
            }
        }
           return false;
    }
    public ArrayList byOnLeav(boolean onLeave){
        ArrayList<Teachers>onleave=new ArrayList<>();
        for(Teachers teacher:teachers){
            if (teacher.isOnLeave()){
                onleave.add(teacher);
            }
        }
        return onleave;
    }

    public Teachers byId(int id){
        for (Teachers teacher1:teachers){
            if(teacher1.getId()==id){
                return teacher1;
            }
        }
        return null;
    }
}
