package com.devsuperior.dsList.repositories;

import com.devsuperior.dsList.Entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<GameList, Long> {
}
