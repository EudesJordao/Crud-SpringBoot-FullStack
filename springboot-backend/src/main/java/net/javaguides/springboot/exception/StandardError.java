package net.javaguides.springboot.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StandardError implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long timestamp;
    private Integer status;
    private String error;


}
