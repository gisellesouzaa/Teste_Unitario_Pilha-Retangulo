package pilha;

public class PilhaDAO implements IPilhaDAO {
	
	@Override
	public void save(Pilha p) {
		//Método para salvar no banco de dados
		System.out.println("Eu salvo no banco de dados");
	}

}
