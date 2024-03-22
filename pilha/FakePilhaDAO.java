package pilha;

public class FakePilhaDAO implements IPilhaDAO {
	
	//É uma classe Mock
	@Override
	public void save(Pilha p) {
		System.out.println("Sou uma pilha falsa");
		System.out.println("Não falo com o banco de dados");
	}

}
