package pilha;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PilhaJunitTest {
	
	private static Pilha pilha;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		pilha = new Pilha();
		pilha = new Pilha(new FakePilhaDAO()); //usando o Mock
		System.out.println("Executou o @BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		pilha = null;
		System.out.println("Executou o @AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		Livro livro1 = new Livro("A Fortaleza");
		Livro livro2 = new Livro("A Emboscada");
		Livro livro3 = new Livro("O Palhaço");
		Livro livro4 = new Livro("A Lua");
		Livro livro5 = new Livro("O Sol");
		
		pilha.push(livro1);
		pilha.push(livro2);
		pilha.push(livro3);
		pilha.push(livro4);
		pilha.push(livro5);
		
		System.out.println("Executou o @Before");

	}

	@After
	public void tearDown() throws Exception {
		int tamanho = pilha.count();
		while (tamanho > 0) {
			pilha.pop();
			tamanho--;
		}
		System.out.println("Executou o @After");
	}

	@Test(timeout = 1)
	public void testNaoAdicionaLivroAlemDoLimite() {
		try {
			pilha.push(new Livro("O Lua"));
			fail();		
		} catch (ArrayStoreException e) {
			assertTrue(true);
		}
		System.out.println("Executou o testNaoAdicionaLivroAlemDoLimite");
	}
	
	@Test(expected = ArrayStoreException.class)
	public void testNaoAdicionaLivroAlemDoLimiteException() {
		pilha.push(new Livro("O Lua"));
	
		System.out.println("Executou o testNaoAdicionaLivroAlemDoLimite");
	}
	
	@Test
	public void testNaoAdicionaLivroForaDoPadraoNome() {
		pilha.pop();

		pilha.push(new Livro("Não Vale"));
		Livro livro = pilha.pop();

				
		assertEquals("A Lua", livro.getTitulo());

		System.out.println("Executou o testNaoAdicionaLivroForaDoPadraoNome");
	}

}
