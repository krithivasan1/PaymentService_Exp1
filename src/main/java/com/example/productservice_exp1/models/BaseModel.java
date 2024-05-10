package com.example.productservice_exp1.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import jakarta.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Date createdAt;
    public Date lastUpdatedAt;
    public boolean isDelete;
}
