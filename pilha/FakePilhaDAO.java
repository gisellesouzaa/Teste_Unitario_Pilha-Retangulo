package pilha;

public class FakePilhaDAO implements IPilhaDAO {
	
	//� uma classe Mock
	@Override
	public void save(Pilha p) {
		System.out.println("Sou uma pilha falsa");
		System.out.println("N�o falo com o banco de dados");
	}

}
