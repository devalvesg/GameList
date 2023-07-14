package com.devsuperior.dsList.services;

import com.devsuperior.dsList.DTO.GameDTO;
import com.devsuperior.dsList.DTO.GameListDTO;
import com.devsuperior.dsList.DTO.GameMinDTO;
import com.devsuperior.dsList.Entities.Game;
import com.devsuperior.dsList.Entities.GameList;
import com.devsuperior.dsList.projections.GameMinProjection;
import com.devsuperior.dsList.repositories.GameRepository;
import com.devsuperior.dsList.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service //OU @Component
public class GameService {
    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO resultado = new GameDTO(result);
        return resultado;
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }


}
