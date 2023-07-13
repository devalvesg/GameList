package com.devsuperior.dsList.controllers;

import com.devsuperior.dsList.DTO.GameDTO;
import com.devsuperior.dsList.DTO.GameListDTO;
import com.devsuperior.dsList.DTO.GameMinDTO;
import com.devsuperior.dsList.services.GameService;
import com.devsuperior.dsList.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping(value = "/lists")
public class ListsController {

    @Autowired
    private ListService listService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){

        return listService.findAllLists();
    }
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }
}
