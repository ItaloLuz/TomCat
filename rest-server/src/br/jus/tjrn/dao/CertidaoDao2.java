package br.jus.tjrn.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CertidaoDao2 {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://h-italia.intrajus.tjrn:5432/pje_floriano_h_20140307";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "BpMLSxQKH0n1VXTu";
    
    /*
    public static void main(String[] argv) {        
        try {
            ConsultarCertidao();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
    }    
    */
    
    public boolean ConsultarCertidao(String Modelo, String TipoPessoa, String Nome, String CPF) throws SQLException {
        boolean bEncontrou = false;
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
                
        /*
        String sql =    " select count(*) as Total " +
                        " from tb_processo proc " +
                        // join dados processo  
                        " inner join tb_processo_trf proc_trf on proc.id_processo = proc_trf.id_processo_trf " +
                        " inner join tb_processo_parte pp on pp.id_processo_trf = proc_trf.id_processo_trf " +
                        // join dados pessoa
                        " inner join tb_usuario_login ul on ul.id_usuario = pp.id_pessoa " +
                        " left join tb_pess_doc_identificacao pdoc on pdoc.id_pessoa = pp.id_pessoa and cd_tp_documento_identificacao = 'CPJ' " +
                        " left join tb_pessoa_nome_alternativo palt on palt.id_pessoa = pp.id_pessoa " +                        
                        " where 1=1 " +
                        " and proc.nr_processo ilike '%' " +
                        " and pp.in_participacao = 'P' " +
                        " and proc_trf.id_processo_trf not in ( select id_processo_trf from vs_situacao_processo_new where nm_tarefa ilike 'Arquivo definitivo' and id_tarefa = 52 ) " +
                        " and proc_trf.id_classe_judicial in (4, 241) " +
                        " and ( ul.ds_nome ilike '%TOMME EMPREENDIMENTOS (ALDRIM B DA SILVA EMPREENDIMENTOS ME)%' or nr_documento_identificacao = '02.558.157/0020-25' ) ";
        */        
 
        String selectSQL = "select 1 as t where 1=?";
        
        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, 1);

            ResultSet rs = preparedStatement.executeQuery();
            
            if ( rs.getRow() > 0 ){
                bEncontrou = true;
            }                
            
            /*
            while (rs.next()) {
                String t = rs.getString("t");
                System.out.println("teste : " + t);
            }
            */
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            if (preparedStatement != null) {
                preparedStatement.close();
            }
 
            if (dbConnection != null) {
                dbConnection.close();
            }            
        }
        return bEncontrou;
    }
    
    private static Connection getDBConnection() {
        
        Connection dbConnection = null;
 
        try {
                Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
        }
 
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection; 
    }
    
}