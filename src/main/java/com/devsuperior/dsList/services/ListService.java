package com.devsuperior.dsList.services;

import com.devsuperior.dsList.DTO.GameListDTO;
import com.devsuperior.dsList.Entities.GameList;
import com.devsuperior.dsList.projections.GameMinProjection;
import com.devsuperior.dsList.repositories.GameRepository;
import com.devsuperior.dsList.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ListService {
    @Autowired
    private ListRepository listRepository;

    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAllLists(){
        List<GameList> result = listRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex <= destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex <= destinationIndex ? destinationIndex: sourceIndex;

        for(int i = min; i <= max; i++){
            listRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
