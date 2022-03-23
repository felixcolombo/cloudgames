package com.senai.devinhouse.CloudGames.service;

import com.senai.devinhouse.CloudGames.model.Jogo;
import com.senai.devinhouse.CloudGames.repository.JogoRepository;
import com.senai.devinhouse.CloudGames.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {

    private boolean system = true;

    @Autowired
    private RelatorioRepository relatorioRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação em Jogo você deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar Jogos por Gênero");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscarJogosGenero(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscarJogosGenero(Scanner scanner) {
        System.out.println("Informe o Gênero:");
        String genero = scanner.next();
        List<Jogo> jogos = relatorioRepository.findByGenero(genero);
        jogos.forEach(System.out::println);
    }
}
