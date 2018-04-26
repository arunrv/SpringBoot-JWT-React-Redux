package com.qp.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// If table name matches with class name then we don't need @Table annotation
//@Table(name = "book")
@Data 
@NoArgsConstructor  // Entity must have a no argument constructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden=true)
    private Long id;

    @ApiModelProperty(notes = "Name of the Book", required = true, allowEmptyValue=false)
    @Size(min = 2, max = 255)
    private String name;

    @ApiModelProperty(notes = "Author of the book", required = true, allowEmptyValue=false)
    @Size(min = 3, max = 255)
    private String author;
}