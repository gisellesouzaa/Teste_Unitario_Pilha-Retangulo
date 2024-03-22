package pilha;
import java.util.ArrayList;

public class Pilha {
	int limite = 5;
	ArrayList<Livro> pilha = new ArrayList<Livro>();
//	PilhaDAO pilhaDAO = new PilhaDAO(); //Acoplamento entre classes
	IPilhaDAO pilhaDAO;
	
	public Pilha(IPilhaDAO pilhaDAO) {
		this.pilhaDAO = pilhaDAO;
	}
	
	public void push(Livro livro) {
		//Forçar demora na execução:
		/*
		int x = 10;
		while(x > 0) {
			try {
				Thread.sleep(200);
				x--;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		*/				
				
		if (pilha.size() >= limite) {
			throw new ArrayStoreException();
		}
		
		if (!livro.getTitulo().startsWith("A") && !livro.getTitulo().startsWith("O")) {
			return;
		}
		
		pilha.add(livro);
//		PilhaDAO.save();
		
	}
	
	public Livro pop() {
		Livro livro = pilha.get(pilha.size()-1);
		pilha.remove(pilha.size()-1);
		return livro;
	}
	
	public int count() {
		return pilha.size();
	}
}
