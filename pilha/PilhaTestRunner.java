package pilha;


import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class PilhaTestRunner {

	public static void main(String[] args) {
		
		Result resultado = JUnitCore.runClasses(PilhaJunitTest.class);		
		System.out.println("Resultado dos testes: " + resultado.wasSuccessful());

		List<Failure> falha = resultado.getFailures();
		for (Failure failure: falha) {
			System.out.println(failure.getMessage());
		}
	}

}
