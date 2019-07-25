package br.com.helpets.helpetsapi.model;

import lombok.Data;

@Data
public class AuthToken {

    private String token;
    private String username;
}
