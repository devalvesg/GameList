package com.devsuperior.dsList.controllers;

import com.devsuperior.dsList.DTO.GameDTO;
import com.devsuperior.dsList.DTO.GameListDTO;
import com.devsuperior.dsList.DTO.GameMinDTO;
import com.devsuperior.dsList.DTO.ReplacementDTO;
import com.devsuperior.dsList.services.GameService;
import com.devsuperior.dsList.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        listService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
