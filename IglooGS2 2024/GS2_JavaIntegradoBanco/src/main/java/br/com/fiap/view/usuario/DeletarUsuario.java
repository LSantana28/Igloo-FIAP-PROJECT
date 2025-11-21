package br.com.fiap.view.usuario;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.util.Scanner;

public class DeletarUsuario {

    private UsuarioDAO usuarioDAO;
    private Connection connection;

    public DeletarUsuario(Connection connection){
        this.connection = connection;
    }

    public void deletar() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o ID do usuário que deseja excluir: ");
        int id = scanner.nextInt();


        Usuario usuario = new Usuario(id, "", "");  // Não importa nome e endereço aqui


        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);


        usuarioDAO.deleteUsuario(usuario);
    }
}
