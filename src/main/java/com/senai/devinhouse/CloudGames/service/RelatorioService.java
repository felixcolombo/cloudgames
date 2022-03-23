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

    @Autowired
    private RelatorioRepository relatorioRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public void inicial(Scanner scanner) {
        boolean system = true;
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
        scanner.nextLine();
        String genero = scanner.nextLine();
        List<Jogo> jogos = jogoRepository.findByGenero(genero);
        if (jogos.isEmpty()) {
            System.out.println("Não foram encontrados jogos!");
        }
        jogos.forEach(System.out::println);
    }
}
