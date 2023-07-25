package com.devsuperior.dsList.services;

import com.devsuperior.dsList.DTO.GameDTO;
import com.devsuperior.dsList.DTO.GameMinDTO;
import com.devsuperior.dsList.DTO.GameRequestDTO;
import com.devsuperior.dsList.DTO.UpdateDTO;
import com.devsuperior.dsList.Entities.Belonging;
import com.devsuperior.dsList.Entities.Game;
import com.devsuperior.dsList.Entities.GameList;
import com.devsuperior.dsList.projections.GameMinProjection;
import com.devsuperior.dsList.repositories.BelongingRepository;
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
    @Autowired
    private ListRepository listRepository;
    @Autowired
    private BelongingRepository belongingRepository;

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

    @Transactional
    public Game findIdByGame(Long id){
        Game result = gameRepository.findById(id).get();
        return result;
    }

    @Transactional
    public GameList findIdByList(Long listId){
       return listRepository.searchIdByList(listId);
    }

    @Transactional
    public void newGame(GameRequestDTO gameDTO){
        Game game = new Game(gameDTO);
        gameRepository.save(game);
    }

    @Transactional
    public void newGameBeloging(String title) {
        Long id = belongingRepository.searchId(title);
        String list = belongingRepository.searchList(title);


        Integer listId = null;
        if (list.contains("RPG")) {
            listId = 1;
        } else {
            listId = 2;
        }

        //PEGA O ID DO ULTIMO JOGO PASSADO PARA O BANCO DE DADOS
        Game game = findIdByGame(id);
        //PEGA O ID DA LISTA DO ULTIMO JOGO
        GameList gameList = findIdByList(Long.valueOf(listId));
        //PEGA A ULTIMA POSIÇÃO DE ACORDO COM O TIPO DA LISTA
        Long position = listRepository.searchMaxPosition(Long.valueOf(listId));

        //INSTANCIA UM NOVO BELOGING PASSANDO A ULTIMA POSIÇÃO DA TABELA + 1, O ID DO JOGO E O ID DA LISTA
        Belonging belonging = new Belonging(position + 1, game, gameList);

        //SALVA O NOVO BELOGING NO BD
        belongingRepository.save(belonging);

    }

    @Transactional
    public void deleteById(Long id) {
        //PEGA O ID DA LISTA DO JOGO DELETADO
        Long listId = belongingRepository.searchIdList(id);

        //DELETA NA TABELA BELOGING
        belongingRepository.deleteById(id, listId);
        //DELETA O JOGO DA LISTA DE JOGOS
        gameRepository.deleteById(id);
    }
    @Transactional
    public void updateScore(Double score, Long id) {
        Optional<Game> gameToUpdate = gameRepository.findById(id);
        Game updateGame = gameToUpdate.get();
        updateGame.setScore(score);
        gameRepository.save(updateGame);
    }
}
