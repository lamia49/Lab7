package com.example.system_mangment.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Classes {
    @NotNull(message = "name should't be empty")
    @Size(min = 3,max = 10,message = "name minmum 3 maximum 10")
    private String name;
    @Positive(message = "level must be greater then 0")
       @NotEmpty 
    @Max(value = 8,message = "maximum level is 8")
    private Integer level;
    @Positive(message = "houts must be greater then 0")
      @NotEmpty
    @Min(value = 1,message = "minmum hours is 1 ")
    @Max(value = 2,message = "maximum hours is 2")
    private Integer hours;
}
