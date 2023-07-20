package com.devsuperior.dsList.controllers;

import com.devsuperior.dsList.DTO.GameDTO;
import com.devsuperior.dsList.DTO.GameListDTO;
import com.devsuperior.dsList.DTO.GameMinDTO;
import com.devsuperior.dsList.DTO.GameRequestDTO;
import com.devsuperior.dsList.Entities.Belonging;
import com.devsuperior.dsList.Entities.Game;
import com.devsuperior.dsList.projections.GameMinProjection;
import com.devsuperior.dsList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/games") @CrossOrigin("*")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable("id")Long id){
        return gameService.findById(id);
    }

    @PostMapping
    public void newGame(@RequestBody GameRequestDTO gameDTO){
        gameService.newGame(gameDTO);
        gameService.newGameBeloging(gameDTO.getTitle());
    }
}
