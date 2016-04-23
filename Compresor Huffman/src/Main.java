
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		String C = "-c";
		String D = "-d";

		Compresor_Descompresor accion = new Compresor_Descompresor();

		if (args.length == 0) {
			return;
		} else {

			String directorio = System.getProperty("user.dir");

			if (C.equalsIgnoreCase(args[0])) {

				if (args.length == 1) {
					System.out.println("Por favor especifique el archivo que desea comprimir");
					return;
				}

				if (args.length == 2) {
					accion.Comprime(directorio, args[1], args[1]);
				}

				if (args.length == 3) {
					accion.Comprime(directorio, args[1], args[2]);
				}

			} else if (D.equalsIgnoreCase(args[0])) {

				if (args.length == 1) {
					System.out.println("Por favor especifique el archivo que desea descomprimir");
					return;
				}

				if (args.length == 2) {
					accion.Descomprime(directorio, args[1], args[1]);
				}

				if (args.length == 3) {
					accion.Descomprime(directorio, args[1], args[2]);
				}
			}

		}
	}
}
