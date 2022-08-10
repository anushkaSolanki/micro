package com.example.moviecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CatalogItem {
    private String name;
    private String desc;
    private int rating;
    
}
