package com.example.system_mangment.Service;

import com.example.system_mangment.Model.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentsService {
    ArrayList<Students>students=new ArrayList<>();

    public void add(Students student){
        students.add(student);
    }
    public ArrayList get(){
        return students;
    }

    public boolean update(int id,Students student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }}
        return false;
    }

    public boolean delete(int id){
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                return true;
            }

        }

        return false;
    }

    public ArrayList byGrade(int grade){
        ArrayList<Students> grades=new ArrayList<>();
        for(Students student:students){
            if (student.getGrade()==grade){
                grades.add(student);
            }
        }
        return grades;
    }


    public ArrayList passList(){
        ArrayList<Students> pass=new ArrayList<>();
        for(Students student:students){
            if (student.getGPA()>60){
                pass.add(student);
            }
        }
        return pass;
    }

    public ArrayList NotPassList(){
        ArrayList<Students> field=new ArrayList<>();
        for(Students student:students){
            if (student.getGPA()<60){
                field.add(student);
            }
        }
        return field;
    }


    public ArrayList byStstu(String statue){
        ArrayList<Students>status=new ArrayList<>();
        for(Students student:students){
            if (student.getStatus().equalsIgnoreCase(statue)){
                status.add(student);
            }
        }
        return status;
    }

    public Students byID(int id){
        for(Students student:students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }






}
