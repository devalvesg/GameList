package com.devsuperior.dsList.DTO;

import com.devsuperior.dsList.Entities.GameList;
import org.springframework.beans.BeanUtils;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(){

    }

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
