package com.senai.devinhouse.CloudGames.repository;

import com.senai.devinhouse.CloudGames.model.Usuario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>,
        JpaSpecificationExecutor<Usuario> {

    @Query(value = "select * from usuario where nome like %:nome% order by nome", nativeQuery = true)
    List<Usuario> findByName(String nome);

    List<Usuario> findByEmail(String email);
}
