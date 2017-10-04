package br.com.besyproject.teste;

import java.time.LocalDate;
import java.util.List;

import br.com.besyproject.dao.ClienteDao;
import br.com.besyproject.model.Cliente;

public class TesteClienteDao {

	public static void main(String[] args) {
		// Criando Cliente
		Cliente tClienteA = new Cliente(0, "Gabriel Mathias", LocalDate.of(2000, 2, 19), 81182795, 84523648521L, "Rua Julio Cocielo");
		Cliente tClienteB = new Cliente(0, "Mauro Miranda", LocalDate.of(1982, 5, 15), 548062370, 998057753L, "Rua Empecilio Prado");

		// Criando objeto de persistência
		ClienteDao tDao = new ClienteDao();

		// Incluir o Cliente
		System.out.println();
		System.out.println("Incluindo");
		Cliente tCliente2a = tDao.create(tClienteA);
		if (tCliente2a != null)
			System.out.println("OK...... : " + tCliente2a);
		else
			System.out.println("ERRO.... : " + tCliente2a);
		Cliente tCliente2b = tDao.create(tClienteB);
		if (tCliente2b != null)
			System.out.println("OK...... : " + tCliente2b);
		else
			System.out.println("ERRO.... : " + tCliente2b);

		// Recuperando o Cliente
		System.out.println();
		System.out.println("Recuperando");
		Cliente tCliente3a = tDao.recovery(tCliente2a.getId());
		if (tCliente3a != null)
			System.out.println("OK...... : " + tCliente3a);
		else
			System.out.println("ERRO.... : " + tCliente3a);
		Cliente tCliente3b = tDao.recovery(tCliente2b.getId());
		if (tCliente3b != null)
			System.out.println("OK...... : " + tCliente3b);
		else
			System.out.println("ERRO.... : " + tCliente3b);

		// Atualizando o Cliente
		System.out.println();
		System.out.println("Atualizando");
		tCliente2a.setNome(tCliente2a.getNome() + " do Nascimento");
		tCliente2a.setEndereco("Rua da Euvira Matamouros");
		tCliente2a.setCpf(84365215321L);
		Cliente tCliente4a = tDao.update(tCliente2a);
		if (tCliente4a != null)
			System.out.println("OK...... : " + tCliente4a);
		else
			System.out.println("ERRO.... : " + tCliente4a);

		tCliente2b.setNome(tCliente2b.getNome() + " Pistolo");
		tCliente2b.setEndereco("Avenida do Paulo Goulart");
		tCliente2b.setCpf(12345678912L);
		Cliente tCliente4b = tDao.update(tCliente2b);
		if (tCliente4a != null)
			System.out.println("OK...... : " + tCliente4b);
		else
			System.out.println("ERRO.... : " + tCliente4b);

		// Recuperando o Cliente
		System.out.println();
		System.out.println("Recuperando");
		Cliente tCliente5a = tDao.recovery(tCliente2a.getId());
		if (tCliente5a != null)
			System.out.println("OK...... : " + tCliente5a);
		else
			System.out.println("ERRO.... : " + tCliente5a);
		Cliente tCliente5b = tDao.recovery(tCliente2b.getId());
		if (tCliente5b != null)
			System.out.println("OK...... : " + tCliente5b);
		else
			System.out.println("ERRO.... : " + tCliente5b);

		// Listar os Clientes
		List<Cliente> tLista = tDao.search();
		System.out.println();
		System.out.println("Pesquisando");
		for (Cliente tCliente : tLista) {
			System.out.println("OK...... : " + tCliente);
		}

		// Remover o Cliente
		System.out.println();
		System.out.println("Removendo");
		if (tDao.delete(tCliente2a.getId()))
			System.out.println("OK...... : " + tCliente2a);
		else
			System.out.println("ERRO.... : " + tCliente2a);
		if (tDao.delete(tCliente2b.getId()))
			System.out.println("OK...... : " + tCliente2b);
		else
			System.out.println("ERRO.... : " + tCliente2b);

		// Verificando se removeu
		System.out.println();
		System.out.println("Verificando a remoção");
		if (tDao.delete(tCliente2a.getId()))
			System.out.println("ERRO.... : " + tCliente2a);
		else
			System.out.println("OK...... : " + tCliente2a);
		if (tDao.delete(tCliente2b.getId()))
			System.out.println("ERRO.... : " + tCliente2b);
		else
			System.out.println("OK...... : " + tCliente2b);

	}

}
