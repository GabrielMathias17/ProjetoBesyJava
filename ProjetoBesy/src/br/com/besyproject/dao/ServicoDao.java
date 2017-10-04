package br.com.besyproject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.besyproject.jdbc.Conexao;
import br.com.besyproject.model.Servico;
import br.com.besyproject.util.ExceptionUtil;

public class ServicoDao
{
	private String comandoCreate = "INSERT INTO SERVICO (ID, ID_EMPRESA, ID_CLIENTE, DESCRICAO, VALOR, DATA_SERVICO) VALUES (SERVICO_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

	private String comandoRecovery = "SELECT ID, ID_EMPRESA, ID_CLIENTE, DESCRICAO, VALOR, DATA_SERVICO FROM SERVICO WHERE ID = ?";

	private String comandoUpdate = "UPDATE SERVICO SET ID_EMPRESA = ?, ID_CLIENTE = ?, DESCRICAO = ?, VALOR = ?, DATA_SERVICO = ? WHERE ID = ?";

	private String comandoDelete = "DELETE FROM SERVICO WHERE ID = ?";

	private String comandoSearch = "SELECT ID, ID_EMPRESA, ID_CLIENTE, DESCRICAO, VALOR, DATA_SERVICO FROM Servico";

	public Servico create(Servico pServico)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pServico.getIdCliente());
            tComandoJdbc.setInt(i++, pServico.getIdEmpresa());
            tComandoJdbc.setString(i++, pServico.getDescricao());
            tComandoJdbc.setBigDecimal(i++, pServico.getValor());
            tComandoJdbc.setDate(i++, Date.valueOf(pServico.getDataServico()));

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Servico tServico = pServico;

                // Recuperando o código gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave primária gerada no objeto
                pServico.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tServico;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Servico");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

	public Servico recovery(int pId)
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
                Servico tServico = recuperarServico(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tServico;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Servico");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

	public Servico update(Servico pServico)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pServico.getIdEmpresa());
            tComandoJdbc.setInt(i++, pServico.getIdCliente());
            tComandoJdbc.setString(i++, pServico.getDescricao());
            tComandoJdbc.setBigDecimal(i++, pServico.getValor());
            tComandoJdbc.setDate(i++, Date.valueOf(pServico.getDataServico()));
            tComandoJdbc.setInt(i++, pServico.getId());


            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Servico tServico = pServico;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tServico;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Servico");
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
            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Servico");
        }

        // Retorna falso indicando algum erro de processamento
        return false;
    }

    public List<Servico> search()
    {
        List<Servico> tLista = new ArrayList<>();

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
                Servico tServico = recuperarServico(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tServico);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Servico");
        }

        // Retornando a lista de objetos
        return tLista;
    }

    private Servico recuperarServico(ResultSet tResultSet) throws SQLException
    {
        Servico tServico = new Servico();

        // Recuperando os dados do resultSet
        tServico.setId(tResultSet.getInt("ID"));
        tServico.setIdEmpresa(tResultSet.getInt("ID_EMPRESA"));
        tServico.setIdCliente(tResultSet.getInt("ID_CLIENTE"));
        tServico.setDescricao(tResultSet.getString("DESCRICAO"));
        tServico.setValor(tResultSet.getBigDecimal("VALOR"));
        tServico.setDataServico(tResultSet.getDate("DATA_SERVICO").toLocalDate());
        return tServico;
    }


}
