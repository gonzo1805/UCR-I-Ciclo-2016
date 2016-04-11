import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {

		Compresor_Descompresor accion = new Compresor_Descompresor();
		accion.Comprime();
		accion.Descomprime();

	}
}