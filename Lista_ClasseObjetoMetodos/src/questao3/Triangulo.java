package questao3;

public class Triangulo {
	//atributos
	double aX, bX, cX;
	double aY, bY, cY;
			
	//metodos
	//intepretar dados
	public double calcularAreaTrianguloX() {
		double pX = (aX + bX + cX) / 2;
		double areaX = Math.sqrt(pX * (pX-aX) * (pX-bX) * (pX-cX));
		return areaX;
	}

	public double calcularAreaTrianguloY() {
		double pY = (aY + bY + cY) / 2;
		double areaY = Math.sqrt(pY * (pY-aY) * (pY-bY) * (pY-cY));
		return areaY;
	}
	
	public String maiorArea(double areaX, double areaY) {
		if (areaX > areaY) {
			return "O triângulo X possui a MAIOR ÁREA!";
		}else if (areaY > areaX) {
			return "O triângulo Y possui a MAIOR ÁREA!";
		}else {
			return "A área de AMBOS os triângulos possuem valores iguais!";
		}	
	}
}