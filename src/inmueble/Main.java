package inmueble;

public class Main {

	public static void main(String[] args) {
		int techo_un_agua = 1;
		int piso_madera = 2;
		Inmueble inmueble = new Inmueble(techo_un_agua,piso_madera);
		System.out.println(inmueble.getValor());
	}

}
