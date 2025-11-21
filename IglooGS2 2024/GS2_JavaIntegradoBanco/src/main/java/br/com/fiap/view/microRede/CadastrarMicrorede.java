package br.com.fiap.view.microRede;

import br.com.fiap.dao.MicroredeDAO;
import br.com.fiap.model.MicroRede;

import java.sql.Connection;
import java.util.Scanner;

public class CadastrarMicrorede {

    private MicroredeDAO microredeDAO;
    private Scanner scanner;

    public CadastrarMicrorede(Connection connection) {
        this.microredeDAO = new MicroredeDAO(connection);
        this.scanner = new Scanner(System.in);
    }

    public void cadastrar() {
        System.out.println("Nome da Microrede:");
        String nome = scanner.nextLine();
        System.out.println("Total produzido:");
        double totalProduzido = scanner.nextDouble();
        System.out.println("Total consumido:");
        double totalConsumido = scanner.nextDouble();
        System.out.println("Energia armazenada:");
        double energiaArmazenada = scanner.nextDouble();

        MicroRede microrede = new MicroRede(nome, totalProduzido, totalConsumido, energiaArmazenada);
        microredeDAO.saveMicrorede(microrede);

        System.out.println("Microrede cadastrada com sucesso!");
    }
}
