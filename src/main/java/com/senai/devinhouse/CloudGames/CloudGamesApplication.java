package com.senai.devinhouse.CloudGames;

import com.senai.devinhouse.CloudGames.service.PlataformaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CloudGamesApplication implements CommandLineRunner {

	private final PlataformaService plataformaService;
	private boolean system = true;

	public CloudGamesApplication(PlataformaService plataformaService) {
		this.plataformaService = plataformaService;
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

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					plataformaService.inicial(scanner);
					break;

				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}
