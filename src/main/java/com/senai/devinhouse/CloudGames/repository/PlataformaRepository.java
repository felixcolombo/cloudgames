package com.senai.devinhouse.CloudGames.repository;

import com.senai.devinhouse.CloudGames.model.Plataforma;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends CrudRepository<Plataforma, Long>,
        JpaSpecificationExecutor<Plataforma> {

}
