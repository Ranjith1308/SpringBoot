package com.kgisl.springboot.entity;

import org.springframework.data.annotation.Id;

public record Person (@Id Long id, String uname, String email){
    
}
