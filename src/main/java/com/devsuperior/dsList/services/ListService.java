package com.devsuperior.dsList.services;

import com.devsuperior.dsList.DTO.GameListDTO;
import com.devsuperior.dsList.Entities.GameList;
import com.devsuperior.dsList.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ListService {
    @Autowired
    private ListRepository listRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAllLists(){
        List<GameList> result = listRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
