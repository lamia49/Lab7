package com.example.system_mangment.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teachers {
//    @NotEmpty not working on my computer
@Min(value = 10000000, message = "id should be exactly 8 digits")
@Max(value = 99999999, message = "id should be exactly 8 digits")
    private int id;
    @NotNull(message = "name should't be empty")
    @Size(min = 3 , max = 10,message = "name min shoud be 3 and max 10 ")
    private String name;
    @NotNull(message = "catogary should't be empty")
    @Pattern(regexp ="^(teacher|manager|suprviser)$")
    private String catogary;
//    @NotEmpty not working on my computer
    @Min(value = 3000 ,message = "main salary is 3000")
    private int salary;
    @AssertFalse(message = " onLeave shoud be false")
    boolean onLeave;

}
