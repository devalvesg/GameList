package com.devsuperior.dsList.repositories;

import com.devsuperior.dsList.Entities.Belonging;
import com.devsuperior.dsList.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BelongingRepository extends JpaRepository<Belonging, Long> {

    @Query(nativeQuery = true, value = """
            SELECT id
            FROM tb_game WHERE title = :title
            	""")
    Long searchId(String title);

    @Query(nativeQuery = true, value = """
            SELECT genre
            FROM tb_game WHERE title = :title
            	""")
    String searchList(String title);
}
