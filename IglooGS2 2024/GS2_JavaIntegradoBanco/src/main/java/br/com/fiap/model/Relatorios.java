package br.com.fiap.model;

import br.com.fiap.dao.MicroredeDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.view.usuario.VisualizarUsuario;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Relatorios {

    private int id;
    private String nome;
    private String dataCriacao;
    private Connection connection;
    private UsuarioDAO usuarioDAO;
    private MicroredeDAO microredeDAO;

    public Relatorios(Connection connection) {
        this.connection = connection;
        this.usuarioDAO = new UsuarioDAO(connection);
        this.microredeDAO = new MicroredeDAO(connection);
    }

    public Relatorios(int id, String nome, String dataCriacao){
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public void relatorioConsumoPorUsuario() {
        // Instanciando a classe VisualizarUsuario
        VisualizarUsuario visualizarUsuario = new VisualizarUsuario(connection);

        visualizarUsuario.listarTodos();  // Exibe diretamente na tela
    }

    public void relatorioProducaoEConsumoPorMicrorede() {
        List<MicroRede> microredes = microredeDAO.listAll();
        System.out.println("Relatório de Produção e Consumo de Energia por Microrede:");
        for (MicroRede microrede : microredes) {
            System.out.println("Microrede: " + microrede.getNome());
            System.out.println("Produção Mensal: " + microrede.getTotalProduzido() + " kWh");
            System.out.println("Consumo Mensal: " + microrede.getTotalConsumido() + " kWh");
            System.out.println("-------------------------------------");
        }
    }

    public void relatorioEficienciaMicrorede() {
        List<MicroRede> microredes = microredeDAO.listAll();
        System.out.println("Relatório de Eficiência das Microredes (Produção vs Consumo):");
        for (MicroRede microrede : microredes) {
            double eficiencia = microrede.getTotalProduzido() / microrede.getTotalConsumido();
            System.out.println("Microrede: " + microrede.getNome());
            System.out.println("Eficiência: " + String.format("%.2f", eficiencia));
            System.out.println("-------------------------------------");
        }
    }

    public void relatorioEnergiaArmazenada() {
        List<MicroRede> microredes = microredeDAO.listAll();
        System.out.println("Relatório de Energia Armazenada por Microrede:");
        for (MicroRede microrede : microredes) {
            System.out.println("Microrede: " + microrede.getNome());
            System.out.println("Energia Armazenada: " + microrede.getEnergiaArmazenada() + " kWh");
            System.out.println("-------------------------------------");
        }
    }
}
