package br.com.fiap.view.microRede;

import br.com.fiap.dao.MicroredeDAO;

import java.sql.Connection;
import java.util.Scanner;

public class DeletarMicrorede {
    private MicroredeDAO microredeDAO;
    private Scanner scanner;

    public DeletarMicrorede(Connection connection) {
        this.microredeDAO = new MicroredeDAO(connection);
        this.scanner = new Scanner(System.in);
    }

    public void deletar() {
        System.out.println("ID da Microrede a deletar:");
        int id = scanner.nextInt();
        microredeDAO.deleteMicrorede(id);

    }
}
