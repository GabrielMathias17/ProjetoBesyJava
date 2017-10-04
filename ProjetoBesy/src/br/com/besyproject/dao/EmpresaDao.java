package br.com.besyproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.besyproject.jdbc.Conexao;
import br.com.besyproject.model.Empresa;
import br.com.besyproject.util.ExceptionUtil;

public class EmpresaDao 
{
	private String comandoCreate = "INSERT INTO EMPRESA (ID, NOME, ENDERECO, CNPJ, TELEFONE, ESPECIALIDADE) VALUES (EMPRESA_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
	
	private String comandoRecovery = "SELECT ID, NOME, ENDERECO, CNPJ, TELEFONE, ESPECIALIDADE FROM EMPRESA WHERE ID = ?";
	
	private String comandoRecoveryByCnpj = "SELECT ID, NOME, ENDERECO, CNPJ, TELEFONE, ESPECIALIDADE FROM EMPRESA WHERE CNPJ = ?";
	
	private String comandoUpdate = "UPDATE EMPRESA SET NOME = ?, ENDERECO = ?, CNPJ = ?, TELEFONE = ?, ESPECIALIDADE = ? WHERE ID = ?";
	
	private String comandoDelete = "DELETE FROM EMPRESA WHERE ID = ?";
	
	private String comandoSearch = "SELECT ID, NOME, ENDERECO, CNPJ, TELEFONE, ESPECIALIDADE FROM EMPRESA";
	
	public Empresa create(Empresa pEmpresa)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pEmpresa.getNome());
            tComandoJdbc.setString(i++, pEmpresa.getEndereco());
            tComandoJdbc.setLong(i++, pEmpresa.getCnpj());
            tComandoJdbc.setLong(i++, pEmpresa.getTelefone());
            tComandoJdbc.setString(i++, pEmpresa.getEspecialidade());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Empresa tEmpresa = pEmpresa;

                // Recuperando o código gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave primária gerada no objeto
                pEmpresa.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEmpresa;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Empresa");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }
	
	public Empresa recovery(int pId)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoRecovery);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pId);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            if (tResultSet.next())
            {
                // Criando o objeto
                Empresa tEmpresa = recuperarEmpresa(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEmpresa;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Empresa");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }
	
	public Empresa recoveryByCnpj(long pCnpj)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoRecoveryByCnpj);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setLong(i++, pCnpj);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            if (tResultSet.next())
            {
                // Criando o objeto
                Empresa tEmpresa = recuperarEmpresa(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEmpresa;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Empresa");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }
	
	public Empresa update(Empresa pEmpresa)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pEmpresa.getNome());
            tComandoJdbc.setString(i++, pEmpresa.getEndereco());
            tComandoJdbc.setLong(i++, pEmpresa.getCnpj());
            tComandoJdbc.setLong(i++, pEmpresa.getTelefone());
            tComandoJdbc.setString(i++, pEmpresa.getEspecialidade());
            tComandoJdbc.setInt(i++, pEmpresa.getId());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Empresa tEmpresa = pEmpresa;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEmpresa;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Empresa");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public boolean delete(int pId)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoDelete);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pId);

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o indicativo de sucesso
                return true;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Empresa");
        }

        // Retorna falso indicando algum erro de processamento
        return false;
    }

    public List<Empresa> search()
    {
        List<Empresa> tLista = new ArrayList<>();

        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearch);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            while (tResultSet.next())
            {
                Empresa tEmpresa = recuperarEmpresa(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tEmpresa);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Empresa");
        }

        // Retornando a lista de objetos
        return tLista;
    }

    private Empresa recuperarEmpresa(ResultSet tResultSet) throws SQLException
    {
        Empresa tEmpresa = new Empresa();

        // Recuperando os dados do resultSet
        tEmpresa.setId(tResultSet.getInt("ID"));
        tEmpresa.setNome(tResultSet.getString("NOME"));
        tEmpresa.setEndereco(tResultSet.getString("ENDERECO"));
        tEmpresa.setCnpj(tResultSet.getLong("CNPJ"));
        tEmpresa.setTelefone(tResultSet.getLong("TELEFONE"));
        tEmpresa.setEspecialidade(tResultSet.getString("ESPECIALIDADE"));
        return tEmpresa;
    }
	
	
}
