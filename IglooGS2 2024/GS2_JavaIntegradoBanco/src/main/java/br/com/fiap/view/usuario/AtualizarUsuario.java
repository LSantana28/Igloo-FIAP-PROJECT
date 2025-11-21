package br.com.fiap.view.usuario;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.util.Scanner;

public class AtualizarUsuario {
    private UsuarioDAO usuarioDAO;
    private Connection connection;

    public AtualizarUsuario(Connection connection){
        this.connection = connection;
    }

    public void atualizar(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do usuário que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        System.out.print("Digite o novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o novo endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite o novo consumo mensal: ");
        int consumoMensal = scanner.nextInt();

        System.out.print("Digite a nova produção mensal: ");
        int producaoMensal = scanner.nextInt();


        Usuario usuario = new Usuario(id, nome, endereco, consumoMensal, producaoMensal);


        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);


        usuarioDAO.updateUsuario(usuario);
    }
}
