package com.example.system_mangment.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Students {
       @NotEmpty
    @Min(value = 10000000, message = "id should be exactly 8 digits")
    @Max(value = 99999999, message = "id should be exactly 8 digits")
    private  Integer id;
    @NotNull(message = "name should't be empty")
    @Size(min = 3,max = 10,message = "name minmum 3 maximum 10")
    private String name;
      @NotEmpty
    @Max(value = 100,message = "maxiumm GPA is 100")
    private Integer GPA;
      @NotEmpty
    @Min(value = 1,message = "Minmum Grade is 1")
    @Max(value = 8,message = "Maximum Grade is 8")
    private  Integer grade;
    @Pattern(regexp ="^(graduet|student)$")
    private String status;
}
