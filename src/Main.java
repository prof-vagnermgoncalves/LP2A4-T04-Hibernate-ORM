import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;

import modelo.*;
import modelo.repositorio.*;

public class Main
{
	private static final DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final Locale locale = new Locale("pt", "BR");      
	private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	
	/**
	 * M�todo principal com exemplos de cria��o de dados. 
	 * @param args
	 */
	/*
	public static void main(String[] args)
	{	
		Pessoa p1 = new Pessoa("Maria dos Santos", "Av. Brasil, 1262", 1430001l, "(99) 99999-9999", 2500.55, 1);
		Pessoa p2 = new Pessoa("Jo�o dos Santos", "Av. Brasil, 1262", 1430001l, "(88) 88888-8888", 2300.25, 1);
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		System.out.println("\n********** Exemplo de Inser��o 1: **********\n");
		
		pessoaRepository.criarPessoa(p1);
		pessoaRepository.criarPessoa(p2);
		
		System.out.println("ID da Pessoa p1: " + p1.getIdPessoa());
		System.out.println("ID da Pessoa p2: " + p2.getIdPessoa());
		
		ContaComum cc1 = new ContaComum(1l, Calendar.getInstance(), null, 1, 123456, 5000.00);
				
		cc1.getPessoas().add(p1);
		cc1.getPessoas().add(p2);
		
		ContaComumRepository contaComumRepository = new ContaComumRepository();
		
		System.out.println("\n********** Exemplo de Inser��o 2: **********\n");
		
		contaComumRepository.criarContaComum(cc1);
		
		Movimento m1 = new Movimento(1, 1250.0, cc1); // Dep�sito de R$ 1.250,00
		
		System.out.println("\n********** Exemplo de Inser��o 3: **********\n");
		
		m1.registrarMovimento();
		
		Movimento m2 = new Movimento(2, 3500.0, cc1); // Saque de R$ 3.500,00
		
		System.out.println("\n********** Exemplo de Inser��o 4: **********\n");
		
		m2.registrarMovimento();
		
		Movimento m3 = new Movimento(2, 10500.0, cc1); // Saque de R$ 10.500,00 - Saldo n�o dispon�vel
		
		System.out.println("\n********** Tentativa de Inser��o sem sucesso: **********\n");
		
		m3.registrarMovimento();
		
		PersistenceConfig.closeEntityManager();
	}
	*/
	
	/**
	 * M�todo principal com exemplos de recupera��o de dados. 
	 * @param args
	 */
	/*
	public static void main(String[] args)
	{	
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		System.out.println("\n********** Exemplo de Recupera��o 1: **********\n");
		
		Set<Pessoa> pessoasCadastradas = pessoaRepository.recuperarPessoas();
		
		System.out.println("Todas as pessoas cadastradas no BD:");
		
		pessoasCadastradas.forEach(p ->
			System.out.println(p.getIdPessoa() + " - " + p.getNomePessoa()));
		
		System.out.println("\n********** Exemplo de Recupera��o 2: **********\n");
		
		System.out.println("Recuperando a pessoa com ID igual a 1 e exibindo suas informa��es:");
		
		Pessoa p1 = pessoaRepository.recuperarPessoaPorId(1);
		
		if(p1 != null)
		{
			System.out.println(p1.getIdPessoa() + " - " + p1.getNomePessoa());
			
			p1.getContas().forEach(c ->
				System.out.println(p1.getNomePessoa() + " possui a Conta #" + c.getNumeroConta()));
		}
		
		ContaComumRepository contaComumRepository = new ContaComumRepository();
		
		System.out.println("\n********** Exemplo de Recupera��o 3: **********\n");
		
		System.out.println("Recuperando a ContaComum com n�mero igual a 1 e exibindo suas informa��es:");
		
		ContaComum cc1 = contaComumRepository.recuperarContaComumPorNumeroConta(1l);
		
		if(cc1 != null)
		{
			System.out.println("Conta #" +
				cc1.getNumeroConta() + ", Saldo: " + currencyFormatter.format(cc1.getSaldoConta()));
			
			System.out.println("Titulares: ");
			
			cc1.getPessoas().forEach(p -> System.out.println("  " + p.getNomePessoa()));
		}
		
		MovimentoRepository movimentoRepository = new MovimentoRepository();
		
		System.out.println("\n********** Exemplo de Recupera��o 4: **********\n");
		
		System.out.println("Movimentos na Conta Comum #" + cc1.getNumeroConta());
		
		Set<Movimento> movimentosCc1 =
				movimentoRepository.recuperarMovimentosPorNumeroConta(cc1.getNumeroConta());
		
		movimentosCc1.forEach(m -> System.out.println("  " +
					dateFormatter.format(m.getDataHoraMovimento().getTime()) +
					(m.getTipoMovimento() == 1 ? " Dep�sito" : " Saque") +
					" no valor de " +
					currencyFormatter.format(m.getValorMovimento())
				));
		
		PersistenceConfig.closeEntityManager();
	}
	*/
	
	/**
	 * M�todo principal com exemplos de atualiza��o de dados. 
	 * @param args
	 */
	/*
	public static void main(String[] args)
	{	
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		System.out.println("\n********** Exemplo de Atualiza��o 1: ********** \n");
		
		System.out.println("Recuperando a pessoa com ID igual a 2 e exibindo suas informa��es:");
		
		Pessoa p1 = pessoaRepository.recuperarPessoaPorId(2);
		
		if(p1 != null)
		{	
			System.out.println("Dados atuais da Pessoa p1: ");
			System.out.println("  Id: " + p1.getIdPessoa());
			System.out.println("  Nome: " + p1.getNomePessoa());
			System.out.println("  Renda: " + currencyFormatter.format(p1.getRendaPessoa()));
			System.out.println("  Telefone: " + p1.getTelefonePessoa());
			System.out.println("  Endere�o: " + p1.getEnderecoPessoa() + ", CEP: " + p1.getCepPessoa());
			System.out.println("  Situa��o: " +
				(p1.getSituacaoPessoa() == 1 ? "Ativo" : "Inativo"));
			
			System.out.println("Atualizando a renda e o telefone da Pessoa p1:");

			p1.setRendaPessoa(2450.25);
			p1.setTelefonePessoa("(88) 7777-7777");
			
			// Atualiza��o no banco de dados
			pessoaRepository.atualizarPessoa(p1);
			
			// Atualiza p1 com os dados cadastrados no banco de dados
			pessoaRepository.recuperarPessoaPorId(p1.getIdPessoa());			
			
			System.out.println("Dados da Pessoa p1 p�s atualiza��o do banco: ");
			System.out.println("  Id: " + p1.getIdPessoa());
			System.out.println("  Nome: " + p1.getNomePessoa());
			System.out.println("  Renda: " + currencyFormatter.format(p1.getRendaPessoa()));
			System.out.println("  Telefone: " + p1.getTelefonePessoa());
			System.out.println("  Endere�o: " + p1.getEnderecoPessoa() + ", CEP: " + p1.getCepPessoa());
			System.out.println("  Situa��o: " +
				(p1.getSituacaoPessoa() == 1 ? "Ativo" : "Inativo"));
		}
		
		PersistenceConfig.closeEntityManager();
	}
	*/
	
	/**
	 * M�todo principal com exemplos de exclus�o de dados. 
	 * @param args
	 */
	
	public static void main(String[] args)
	{	
		ContaComumRepository contaComumRepository = new ContaComumRepository();
		
		ContaComum cc1 = contaComumRepository.recuperarContaComumPorNumeroConta(1l);
		
		System.out.println("\n********** Exemplo de Exclus�o 1: ********** \n");
		
		System.out.println("Excuindo a Conta Comum com ID igual a 1:");
		
		if(contaComumRepository.excluirContaComum(cc1))
		{
			System.out.println("Conta Comum #1 exclu�da com sucesso.");
		}
		
		PersistenceConfig.closeEntityManager();
	}
	
}