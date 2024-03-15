package com.example.system_mangment.Controller;

import com.example.system_mangment.Model.Teachers;
import com.example.system_mangment.Service.TechearService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacheController {
    TechearService techearService;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Teachers teacher , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        techearService.add(teacher);
        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(techearService.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id ,@RequestBody @Valid Teachers teachers ,Errors error){
        if(error.hasErrors()){
            String massege=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isFound= techearService.update(id,teachers);
        if(isFound){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("Not Found");
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id ){
        boolean isFound=techearService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("Not found");
    }

    @GetMapping("by_catogary/{catogary}")
    public ResponseEntity byStatus(@PathVariable String catogary){
        return  ResponseEntity.status(200).body(techearService.byCatogary(catogary));
    }


    @PutMapping("/set_onLeave/{id}")
    public ResponseEntity byOnLeave(@PathVariable int id){
        boolean OnLeave=techearService.setOnLeave(id);

        if(OnLeave){
            return ResponseEntity.status(200).body("done set");
        }
        return ResponseEntity.status(400).body("Not Found , cheack id and onLeave.");
    }
    @GetMapping("by_onLeave/{onLeave}")
    public ResponseEntity byStatus(@PathVariable boolean onLeave){
        return  ResponseEntity.status(200).body(techearService.byOnLeav(onLeave));
    }

    @GetMapping("by_Id/{id}")
    public ResponseEntity byID(@PathVariable int id){
        if(techearService.byId(id)==null){
            return ResponseEntity.status(400).body("Not found");
        }

        return ResponseEntity.status(200).body(techearService.byId(id));
    }



}
