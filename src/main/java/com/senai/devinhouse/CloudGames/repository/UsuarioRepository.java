package com.senai.devinhouse.CloudGames.repository;

import com.senai.devinhouse.CloudGames.model.Usuario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>,
        JpaSpecificationExecutor<Usuario> {

    @Query(value = "select * from usuarios u where nome like '%:letras%'", nativeQuery = true)
    List<Usuario> findByNomeEndingWith(String letras);

    List<Usuario> findByEmail(String email);
}
