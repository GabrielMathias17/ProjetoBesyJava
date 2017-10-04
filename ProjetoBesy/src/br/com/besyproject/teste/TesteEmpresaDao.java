package br.com.besyproject.teste;

import java.util.List;

import br.com.besyproject.dao.EmpresaDao;
import br.com.besyproject.model.Empresa;

public class TesteEmpresaDao {

	public static void main(String[] args) 
	{
		// Criando Empresa
		Empresa tEmpresaA = new Empresa(0, "Hydraulis", "Rua dos Teste maluco", 81182795, 84527294, "Serviços Hidraulicos");
		Empresa tEmpresaB = new Empresa(0, "Mecanics", "Avenida teste man", 548062370, 998057753, "Serviços em mecânica" );
		
		// Criando objeto de persistência
		EmpresaDao tDao = new EmpresaDao();
		
		// Incluir o Empresa
        System.out.println();
        System.out.println("Incluindo");
        Empresa tEmpresa2a = tDao.create(tEmpresaA);
        if (tEmpresa2a != null)
            System.out.println("OK...... : " + tEmpresa2a);
        else
            System.out.println("ERRO.... : " + tEmpresa2a);
        Empresa tEmpresa2b = tDao.create(tEmpresaB);
        if (tEmpresa2b != null)
            System.out.println("OK...... : " + tEmpresa2b);
        else
            System.out.println("ERRO.... : " + tEmpresa2b);

     // Recuperando o Empresa
        System.out.println();
        System.out.println("Recuperando");
        Empresa tEmpresa3a = tDao.recovery(tEmpresa2a.getId());
        if (tEmpresa3a != null)
            System.out.println("OK...... : " + tEmpresa3a);
        else
            System.out.println("ERRO.... : " + tEmpresa3a);
        Empresa tEmpresa3b = tDao.recovery(tEmpresa2b.getId());
        if (tEmpresa3b != null)
            System.out.println("OK...... : " + tEmpresa3b);
        else
            System.out.println("ERRO.... : " + tEmpresa3b);
        
     // Atualizando o Empresa
        System.out.println();
        System.out.println("Atualizando");
        tEmpresa2a.setNome(tEmpresa2a.getNome() + " Sentercio");
        tEmpresa2a.setEndereco("Avenida Teste");
        tEmpresa2a.setCnpj(5646464);
        Empresa tEmpresa4a = tDao.update(tEmpresa2a);
        if (tEmpresa4a != null)
            System.out.println("OK...... : " + tEmpresa4a);
        else
            System.out.println("ERRO.... : " + tEmpresa4a);

        tEmpresa2b.setNome(tEmpresa2b.getNome() + " Sundreco");
        tEmpresa2b.setEndereco("Avenida Teste 123");
        tEmpresa2b.setCnpj(9999999);
        Empresa tEmpresa4b = tDao.update(tEmpresa2b);
        if (tEmpresa4a != null)
            System.out.println("OK...... : " + tEmpresa4b);
        else
            System.out.println("ERRO.... : " + tEmpresa4b);
        
     // Recuperando o Empresa
        System.out.println();
        System.out.println("Recuperando");
        Empresa tEmpresa5a = tDao.recovery(tEmpresa2a.getId());
        if (tEmpresa5a != null)
            System.out.println("OK...... : " + tEmpresa5a);
        else
            System.out.println("ERRO.... : " + tEmpresa5a);
        Empresa tEmpresa5b = tDao.recovery(tEmpresa2b.getId());
        if (tEmpresa5b != null)
            System.out.println("OK...... : " + tEmpresa5b);
        else
            System.out.println("ERRO.... : " + tEmpresa5b);

        // Listar os Empresas
        List<Empresa> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Empresa tEmpresa : tLista)
        {
            System.out.println("OK...... : " + tEmpresa);
        }

        // Remover o Empresa
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tEmpresa2a.getId()))
            System.out.println("OK...... : " + tEmpresa2a);
        else
            System.out.println("ERRO.... : " + tEmpresa2a);
        if (tDao.delete(tEmpresa2b.getId()))
            System.out.println("OK...... : " + tEmpresa2b);
        else
            System.out.println("ERRO.... : " + tEmpresa2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tEmpresa2a.getId()))
            System.out.println("ERRO.... : " + tEmpresa2a);
        else
            System.out.println("OK...... : " + tEmpresa2a);
        if (tDao.delete(tEmpresa2b.getId()))
            System.out.println("ERRO.... : " + tEmpresa2b);
        else
            System.out.println("OK...... : " + tEmpresa2b);

	}

}
