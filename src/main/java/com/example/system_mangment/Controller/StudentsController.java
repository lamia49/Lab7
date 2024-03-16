package com.example.system_mangment.Controller;

import com.example.system_mangment.Model.Students;
import com.example.system_mangment.Service.StudentsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {
    StudentsService studentsService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Students student , Errors error){
        if(error.hasErrors()){
            String massege=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        studentsService.add(student);
        return ResponseEntity.status(200).body("added");
    }

    @GetMapping("/get")

    public ResponseEntity get(){
        return  ResponseEntity.status(200).body(studentsService.get());
    }

    @PutMapping("/update/{id}")

    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid Students student ,Errors error){
        if(error.hasErrors()){
            String massge= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massge);
        }
        boolean isFound=studentsService.update(id,student);
        if(isFound) {
            return ResponseEntity.status(200).body("Updeated");
        } return ResponseEntity.status(400).body("not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isFound=studentsService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("Not Found");
    }
    @GetMapping("by_Grade/{grade}")
    public ResponseEntity byGrade(@PathVariable int grade){
        return  ResponseEntity.status(200).body(studentsService.byGrade(grade));
    }
    @GetMapping("/PassList")
    public ResponseEntity PassList(){
        return  ResponseEntity.status(200).body(studentsService.passList());
    }
    @GetMapping("/Not_PassList")
    public ResponseEntity NotPassList(){
        return  ResponseEntity.status(200).body(studentsService.NotPassList());
    }

    @GetMapping("by_status/{status}")
    public ResponseEntity byStatus(@PathVariable String status){
        return  ResponseEntity.status(200).body(studentsService.byStstu(status));
    }

    @GetMapping("by_Id/{id}")
    public ResponseEntity byID(@PathVariable int id){
        if(studentsService.byID(id)==null){
            return ResponseEntity.status(400).body("Not found");
        }

        return ResponseEntity.status(200).body(studentsService.byID(id));
    }



}
