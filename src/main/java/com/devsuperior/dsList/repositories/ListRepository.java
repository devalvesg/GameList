package com.devsuperior.dsList.repositories;

import com.devsuperior.dsList.Entities.Game;
import com.devsuperior.dsList.Entities.GameList;
import com.devsuperior.dsList.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListRepository extends JpaRepository<GameList, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

    @Query(nativeQuery = true, value = """
            SELECT name, id FROM tb_game_list WHERE id = :listId
            """)
    GameList searchIdByList(Long listId);

    @Query(nativeQuery = true, value = """
            SELECT MAX(position) FROM tb_belonging WHERE list_id = :listId
            """)
    Long searchMaxPosition(Long listId);
}
