package com.senai.devinhouse.CloudGames.repository;

import com.senai.devinhouse.CloudGames.model.Usuario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>,
        JpaSpecificationExecutor<Usuario> {
}