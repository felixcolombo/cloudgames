package com.senai.devinhouse.CloudGames.service;

import com.senai.devinhouse.CloudGames.model.Jogo;
import com.senai.devinhouse.CloudGames.model.Plataforma;
import com.senai.devinhouse.CloudGames.repository.JogoRepository;
import com.senai.devinhouse.CloudGames.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class PlataformaService {

    private boolean system = true;

    @Autowired
    private PlataformaRepository plataformaRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação em Plataforma você deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Adicionar um Jogo a uma Plataforma");

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
                case 5:
                    adicionarJogo(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void adicionarJogo(Scanner scanner) {
        System.out.println("Informe o ID da Plataforma");

        Long idPlataforma = scanner.nextLong();

        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(idPlataforma);

        // early return
        if(plataformaOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }

        System.out.println("Informe o ID do Jogo");

        Long idJogo = scanner.nextLong();

        Optional<Jogo> jogoOptional = jogoRepository.findById(idJogo);

        // early return
        if(jogoOptional.isEmpty()) {
            System.out.println("O ID informado é inválido");
            return;
        }

        Plataforma plataforma = plataformaOptional.get();
        plataforma.adicionarJogo(jogoOptional.get());

        plataformaRepository.save(plataforma);
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o ID da Plataforma que deseja atualizar");

        Long id = scanner.nextLong();
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(id);

        // early return
        if(plataformaOptional.isEmpty()) {
            System.out.println("O ID informado é inválido");
            return;
        }

        System.out.println("Informe o Nome para atualizar");
        scanner.nextLine();
        String nome = scanner.nextLine();
        Plataforma plataforma = plataformaOptional.get();
        plataforma.setNome(nome);

        plataformaRepository.save(plataforma);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o ID da Plataforma para deletar");
        Long id = scanner.nextLong();

        plataformaRepository.deleteById(id);
    }

    private void visualizar() {
        Iterable<Plataforma> plataformas = plataformaRepository.findAll();
        plataformas.forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Informe o Nome da Plataforma");
        String nome = scanner.next();

        Plataforma plataforma = new Plataforma();
        plataforma.setNome(nome);

        plataformaRepository.save(plataforma);
    }

}
