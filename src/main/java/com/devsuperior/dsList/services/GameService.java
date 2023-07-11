package com.devsuperior.dsList.services;

import com.devsuperior.dsList.DTO.GameMinDTO;
import com.devsuperior.dsList.Entities.Game;
import com.devsuperior.dsList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //OU @Component
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
