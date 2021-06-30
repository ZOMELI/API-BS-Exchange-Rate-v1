package com.zomeli.villanueva.desafiobcp.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

    private String user;
    private String token;


}
