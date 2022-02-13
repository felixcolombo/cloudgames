package com.senai.devinhouse.CloudGames.service;

import com.senai.devinhouse.CloudGames.model.Jogo;
import com.senai.devinhouse.CloudGames.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class JogoService {

    private boolean system = true;

    @Autowired
    private JogoRepository jogoRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação em Jogo você deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Visualizar");

            int action = scanner.nextInt();

            switch (action) {
                case 1 :
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3 :
                    deletar(scanner);
                    break;
                case 4:
                    visualizar();
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o ID do Jogo que deseja atualizar");

        Long id = scanner.nextLong();
        Optional<Jogo> jogoOptional = jogoRepository.findById(id);

        // early return
        if(jogoOptional.isEmpty()) {
            System.out.println("O ID informado é inválido");
            return;
        }

        System.out.println("Informe o Nome para atualizar");
        scanner.nextLine();
        String nome = scanner.nextLine();
        Jogo jogo = jogoOptional.get();
        jogo.setNome(nome);

        jogoRepository.save(jogo);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o ID do Jogo para deletar");
        Long id = scanner.nextLong();

        jogoRepository.deleteById(id);
    }

    private void visualizar() {
        Iterable<Jogo> jogos = jogoRepository.findAll();
        jogos.forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Informe o Nome do Jogo");
        String nome = scanner.next();

        System.out.println("Informe a Data de Lançamento do Jogo");
        String dataLancamento = scanner.next();

        System.out.println("Informe a Capa do Jogo");
        String capa= scanner.next();

        System.out.println("Informe o Gênero do Jogo");
        String genero= scanner.next();

        Jogo jogo = new Jogo();
        jogo.setNome(nome);

        jogoRepository.save(jogo);
    }
}
