package com.senai.devinhouse.CloudGames.repository;

import com.senai.devinhouse.CloudGames.model.Jogo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RelatorioRepository extends PagingAndSortingRepository<Jogo, Long>,
        JpaSpecificationExecutor<Jogo> {

}
