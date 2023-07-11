package com.devsuperior.dsList.repositories;

import com.devsuperior.dsList.Entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
