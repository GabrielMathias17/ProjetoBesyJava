package br.com.besyproject.teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.besyproject.dao.ClienteDao;
import br.com.besyproject.dao.EmpresaDao;
import br.com.besyproject.dao.ServicoDao;
import br.com.besyproject.model.Cliente;
import br.com.besyproject.model.Empresa;
import br.com.besyproject.model.Servico;

public class TesteServicoDao
{

    public static void main(String[] pArgs)
    {
        //
        // Pré Teste
        //
        // Criar um cliente
        Cliente tClienteA = new Cliente(0, "Maico Jéquisso", LocalDate.of(1932, 8, 7), 44554642L, 46656546542L, "Rua dos Momentos");
        Cliente tClienteB = new Cliente(0, "Paulo Guina", LocalDate.of(1987, 10, 20), 65464568L, 65464646458L, "Rua Pedro Paulo");

        // Criando o objeto de persistência
        ClienteDao tClienteDao = new ClienteDao();

        // Incluir o paciente
        System.out.println();
        System.out.println("Incluindo o paciente");
        Cliente tCliente2a = tClienteDao.create(tClienteA);
        if (tCliente2a != null)
            System.out.println("OK...... : " + tCliente2a);
        else
            System.out.println("ERRO.... : " + tCliente2a);
        Cliente tCliente2b = tClienteDao.create(tClienteB);
        if (tCliente2b != null)
            System.out.println("OK...... : " + tCliente2b);
        else
            System.out.println("ERRO.... : " + tCliente2b);

        // Criar um medico
        Empresa tEmpresaA = new Empresa(0, "Eletronics Corp", "Avenida Testator", 5834649748364L, 984527294L, "Serviços Eletrônicos");
        Empresa tEmpresaB = new Empresa(0, "Raimunds Delegacy", "Rua Piranga moço", 68456465254154L, 984527294L, "Combustivel");

        // Criando o objeto de persistência
        EmpresaDao tEmpresaDao = new EmpresaDao();

        // Incluir o medico
        System.out.println();
        System.out.println("Incluindo Empresa");
        Empresa tEmpresa2a = tEmpresaDao.create(tEmpresaA);
        if (tEmpresa2a != null)
            System.out.println("OK...... : " + tEmpresa2a);
        else
            System.out.println("ERRO.... : " + tEmpresa2a);
        Empresa tEmpresa2b = tEmpresaDao.create(tEmpresaB);
        if (tEmpresa2b != null)
            System.out.println("OK...... : " + tEmpresa2b);
        else
            System.out.println("ERRO.... : " + tEmpresa2b);

        //
        // Teste
        //
        // Criar uma consulta
        Servico tServicoA = new Servico(0, tEmpresa2a.getId(), tCliente2a.getId(), "Arrumar a Televisão", new BigDecimal("120.00"), LocalDate.of(2017, 10, 11));
        Servico tServicoB = new Servico(0, tEmpresa2b.getId(), tCliente2a.getId(), "Consertar o tanque do carro", new BigDecimal("250.00"), LocalDate.of(2017, 10, 15));

        // Criando o objeto de persistência
        ServicoDao tDao = new ServicoDao();

        // Incluir a consulta
        System.out.println();
        System.out.println("Incluindo Serviço");
        Servico tServico2a = tDao.create(tServicoA);
        if (tServico2a != null)
            System.out.println("OK...... : " + tServico2a);
        else
            System.out.println("ERRO.... : " + tServico2a);
        Servico tServico2b = tDao.create(tServicoB);
        if (tServico2b != null)
            System.out.println("OK...... : " + tServico2b);
        else
            System.out.println("ERRO.... : " + tServico2b);

        // Recuperando a consulta
        System.out.println();
        System.out.println("Recuperando");
        Servico tServico3a = tDao.recovery(tServico2a.getId());
        if (tServico3a != null)
            System.out.println("OK...... : " + tServico3a);
        else
            System.out.println("ERRO.... : " + tServico3a);
        Servico tServico3b = tDao.recovery(tServico2b.getId());
        if (tServico3b != null)
            System.out.println("OK...... : " + tServico3b);
        else
            System.out.println("ERRO.... : " + tServico3b);

        // Atualizando a consulta
        System.out.println();
        System.out.println("Atualizando");
        tServico2a.setDataServico(LocalDate.of(2017, 10, 5));
        tServico2a.setValor(new BigDecimal("100.00"));
        tServico2a.setDescricao("Consertar a geladeira");
        tServico2a.setIdCliente(tCliente2b.getId());
        tServico2a.setIdEmpresa(tEmpresa2b.getId());
        Servico tServico4a = tDao.update(tServico2a);
        if (tServico4a != null)
            System.out.println("OK...... : " + tServico4a);
        else
            System.out.println("ERRO.... : " + tServico4a);
        tServico2b.setDataServico(LocalDate.of(2017, 10, 25));
        tServico2b.setValor(new BigDecimal("800.00"));
        tServico2b.setDescricao("Trocar a estrutura de combustivel do carro");
        tServico2b.setIdCliente(tCliente2a.getId());
        tServico2b.setIdEmpresa(tEmpresa2a.getId());
        Servico tServico4b = tDao.update(tServico2b);
        if (tServico4a != null)
            System.out.println("OK...... : " + tServico4b);
        else
            System.out.println("ERRO.... : " + tServico4b);

        // Recuperando a consulta
        System.out.println();
        System.out.println("Recuperando");
        Servico tServico5a = tDao.recovery(tServico2a.getId());
        if (tServico5a != null)
            System.out.println("OK...... : " + tServico5a);
        else
            System.out.println("ERRO.... : " + tServico5a);
        Servico tServico5b = tDao.recovery(tServico2b.getId());
        if (tServico5b != null)
            System.out.println("OK...... : " + tServico5b);
        else
            System.out.println("ERRO.... : " + tServico5b);

        // Listar os consultas
        List<Servico> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Servico tServico : tLista)
        {
            System.out.println("OK...... : " + tServico);
        }

        // Remover a consulta
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tServico2a.getId()))
            System.out.println("OK...... : " + tServico2a);
        else
            System.out.println("ERRO.... : " + tServico2a);
        if (tDao.delete(tServico2b.getId()))
            System.out.println("OK...... : " + tServico2b);
        else
            System.out.println("ERRO.... : " + tServico2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tServico2a.getId()))
            System.out.println("ERRO.... : " + tServico2a);
        else
            System.out.println("OK...... : " + tServico2a);
        if (tDao.delete(tServico2b.getId()))
            System.out.println("ERRO.... : " + tServico2b);
        else
            System.out.println("OK...... : " + tServico2b);

        //
        // Pós teste
        //
        // Remover o paciente
        System.out.println();
        System.out.println("Removendo");
        if (tClienteDao.delete(tCliente2a.getId()))
            System.out.println("OK...... : " + tCliente2a);
        else
            System.out.println("ERRO.... : " + tCliente2a);
        if (tClienteDao.delete(tCliente2b.getId()))
            System.out.println("OK...... : " + tCliente2b);
        else
            System.out.println("ERRO.... : " + tCliente2b);

        // Remover o medico
        System.out.println();
        System.out.println("Removendo");
        if (tEmpresaDao.delete(tEmpresa2a.getId()))
            System.out.println("OK...... : " + tEmpresa2a);
        else
            System.out.println("ERRO.... : " + tEmpresa2a);
        if (tEmpresaDao.delete(tEmpresa2b.getId()))
            System.out.println("OK...... : " + tEmpresa2b);
        else
            System.out.println("ERRO.... : " + tEmpresa2b);

    }
}
