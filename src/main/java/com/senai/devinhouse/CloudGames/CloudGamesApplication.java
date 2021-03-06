package com.senai.devinhouse.CloudGames;

import com.senai.devinhouse.CloudGames.service.JogoService;
import com.senai.devinhouse.CloudGames.service.PlataformaService;
import com.senai.devinhouse.CloudGames.service.RelatorioService;
import com.senai.devinhouse.CloudGames.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CloudGamesApplication implements CommandLineRunner {

	private final PlataformaService plataformaService;
	private final UsuarioService usuarioService;
	private final JogoService jogoService;
	private final RelatorioService relatorioService;
	private boolean system = true;

	public CloudGamesApplication(PlataformaService plataformaService,
								 UsuarioService usuarioService,
								 JogoService jogoService, RelatorioService relatorioService) {
		this.plataformaService = plataformaService;
		this.usuarioService = usuarioService;
		this.jogoService = jogoService;
		this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudGamesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system) {
			System.out.println("Qual a função que você deseja acessar");
			System.out.println("0 - Sair");
			System.out.println("1 - Plataforma");
			System.out.println("2 - Usuário");
			System.out.println("3 - Jogo");
			System.out.println("4 - Relatórios");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					plataformaService.inicial(scanner);
					break;
				case 2:
					usuarioService.inicial(scanner);
					break;
				case 3:
					jogoService.inicial(scanner);
					break;
				case 4:
					relatorioService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}
