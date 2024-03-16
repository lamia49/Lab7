package com.example.system_mangment.Controller;

import com.example.system_mangment.Model.Classes;
import com.example.system_mangment.Service.ClassesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/class")
public class ClassesController {
    ClassesService classesService;


   @PostMapping("/add")
   public ResponseEntity add(@RequestBody @Valid Classes class1 , Errors error){
       if(error.hasErrors()){
           String massege= error.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(massege);
       }
       classesService.add(class1);
       return ResponseEntity.status(200).body("added");
   }
    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(classesService.get());
    }

    @PutMapping("/update/{name}")
    public ResponseEntity update(@PathVariable String name ,@RequestBody @Valid Classes classe ,Errors error){
        if(error.hasErrors()){
            String massege=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isFound=classesService.update(name,classe);
        if(isFound){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("Not Found");
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity delete(@PathVariable String name){
        boolean isFound=classesService.delete(name);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("Not Found");
    }


    @GetMapping("by_name/{name}")
public ResponseEntity byName(@PathVariable String name){
       if(classesService.serch_byName(name)==null){
           return ResponseEntity.status(400).body("Not Found");
       }
       return  ResponseEntity.status(200).body(classesService.serch_byName(name));
    }

    @GetMapping("by_level/{level}")
public ResponseEntity byLevel(@PathVariable int level){
       return ResponseEntity.status(200).body(classesService.serch_byLevel(level));
    }
    @GetMapping("by_hours/{hours}")
    public ResponseEntity byHours(@PathVariable int hours){
        return ResponseEntity.status(200).body(classesService.serch_hours(hours));
    }
}
