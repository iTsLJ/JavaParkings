/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class BancoDados {

    //atributo que indica o banco que será utilizado:
    private static String banco = "estacionamento";

    //atributo para setar o usuário do banco:
    private static String usuario = "root";

    //atributo para setar a senha do usuário definido pelo atributo anterior:
    private static String senha = "root";

    //atributo que especifica o endereço do servidor do banco.
    //se for um servidor remoto, o localhost deve ser substituído pelo
    //endereço IP do servidor do banco
    private static String url = "jdbc:mysql://localhost:3306/estacionamento";

    //atributo que garante uma única conexão com o banco
    //padrão de projeto Singleton:
    private static BancoDados instancia = null;

    //atributo que realiza a conexão com o banco:
    private static Connection conexao = null;

    //construtor vazio e privado da Classe BancoDados
    //para nao permitir a instancia de multiplos objetos
    //faz parte do padrão Singleton
    private BancoDados() {

    }

    //método público que permitirá o uso de uma única instância da 
    //conexão com o banco. Se ainda não houver uma instância ativa,
    //este método a cria e retorna para quem "está chamando"
    //Também faz parte do padrão singleton
    public static BancoDados getInstancia() {

        if (instancia == null) {
            //se não houver uma instância ativa, bora criar!
            instancia = new BancoDados();
            //aproveitar e conectar logo ao banco!
            conectar();
        }
        //se já houver uma instância ativa, bora enviar ela!
        return instancia;
    }

    //método para realizar a conexão
    private static void conectar() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão OK!");
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, "Erro ao conectar ao banco de dados", ex);
        }
    }

    //método público para "pegar" a conexão ativa!
    //através deste método é que conseguiremos incluir, consultar ou alterar
    //dados em nosso banco de dados!
    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conectar(); // Reabre a conexão se ela estiver fechada
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, "Erro ao verificar conexão", ex);
        }
        return conexao;
    }

    //método público para desconectar o SGBD após o uso!
    public void desconectar() {

        try {
            conexao.close();
            System.out.println("Conexão Encerrada!");
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
