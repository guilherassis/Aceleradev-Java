package br.com.centralerros.application.domain.entity;

import liquibase.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {

    private int id;
    private String name;
}
