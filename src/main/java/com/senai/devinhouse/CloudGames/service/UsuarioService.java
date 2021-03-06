package com.senai.devinhouse.CloudGames.service;

import com.senai.devinhouse.CloudGames.model.Usuario;
import com.senai.devinhouse.CloudGames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void inicial(Scanner scanner) {
        boolean system = true;
        while(system) {
            System.out.println("Qual ação em Usuário você deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Deletar");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Buscar por Nome");
            System.out.println("6 - Buscar por Email");

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
                    buscaPorNome(scanner);
                    break;
                case 6:
                    buscaPorEmail(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o ID do Usuário que deseja atualizar");

        Long id = scanner.nextLong();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        // early return
        if(usuarioOptional.isEmpty()) {
            System.out.println("O ID informado é inválido");
            return;
        }

        System.out.println("Informe o Nome para atualizar");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.println("Informe o Login para atualizar");
        String login = scanner.nextLine();

        System.out.println("Informe a Senha para atualizar");
        String senha = scanner.nextLine();

        System.out.println("Informe o Email para atualizar");
        String email = scanner.nextLine();

        System.out.println("Informe a Data de Nascimento para atualizar");
        String dataNascimento = scanner.nextLine();

        System.out.println("Informe o CPF para atualizar");
        String cpf= scanner.nextLine();

        System.out.println("Informe o RG para atualizar");
        String rg = scanner.nextLine();

        Usuario usuario = usuarioOptional.get();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setDataNascimento(LocalDate.parse(dataNascimento));
        usuario.setCpf(cpf);
        usuario.setRg(rg);

        usuarioRepository.save(usuario);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o id do Usuário para deletar");

        Long id = scanner.nextLong();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        // early return
        if(usuarioOptional.isEmpty()) {
            System.out.println("O ID informado é inválido");
            return;
        }

        usuarioRepository.deleteById(id);
    }

    public List<Usuario> visualizar(){
            return (List<Usuario>) usuarioRepository.findAll();
    }

    private void salvar(Scanner scanner) {
        System.out.println("Informe o Nome do Usuario");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.println("Informe o Login do Usuario");
        String login = scanner.nextLine();

        System.out.println("Informe a Senha do Usuario");
        String senha = scanner.nextLine();

        System.out.println("Informe o Email do Usuario");
        String email = scanner.nextLine();

        System.out.println("Informe a Data de Nascimento do Usuario");
        String dataNascimento = scanner.nextLine();

        System.out.println("Informe o CPF do Usuario");
        String cpf= scanner.nextLine();

        System.out.println("Informe o RG do Usuario");
        String rg = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setDataNascimento(LocalDate.parse(dataNascimento));
        usuario.setCpf(cpf);
        usuario.setRg(rg);

        usuarioRepository.save(usuario);
    }

    private void buscaPorNome(Scanner scanner) {
        System.out.println("Informe o Nome:");
        scanner.nextLine();
        String nome = scanner.nextLine();
        List<Usuario> usuarios = usuarioRepository.findByName(nome);
        if (usuarios.isEmpty()) {
            System.out.println("Não foram encontrados usuários!");
        }
        usuarios.forEach(System.out::println);
    }

    private void buscaPorEmail(Scanner scanner) {
        System.out.println("Informe o Email:");
        scanner.nextLine();
        String email = scanner.nextLine();
        List<Usuario> usuarios = usuarioRepository.findByEmail(email);
        if (usuarios.isEmpty()) {
            System.out.println("Não foram encontrados usuários!");
        }
        usuarios.forEach(System.out::println);
    }
}
