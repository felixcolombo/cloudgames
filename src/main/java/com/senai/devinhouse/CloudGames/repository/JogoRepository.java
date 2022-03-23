package com.senai.devinhouse.CloudGames.repository;

import com.senai.devinhouse.CloudGames.model.Jogo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends PagingAndSortingRepository<Jogo, Long>,
        JpaSpecificationExecutor<Jogo> {

    @Query(value = "select * from jogo where genero like %:genero% order by nome", nativeQuery = true)
    List<Jogo> findByGenero(String genero);

}
