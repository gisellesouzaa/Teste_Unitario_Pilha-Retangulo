package retangulo;

public class Retangulo {
	private int base;
	private int altura;
	private int area;
	
	
	public Retangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}

	public int calcularArea() {
		area = base * altura;
		return area;
	}

}
