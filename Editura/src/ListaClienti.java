import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListaClienti {
	private ArrayList<Client> lista = new ArrayList<Client>();

	public ListaClienti() {
	}

	void adaugaClient(Client client) {
		this.lista.add(client);
	}

	void salveazaListaClienti() {

		File file = new File("C:\\Users\\serba\\eclipse-workspace\\Editura\\src\\clienti.txt");
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);
			for (Client c : lista) {
				fileWriter.append(c.toString() + "\n");
			}
			bufferFileWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("An I/O Error Occurred");

		}

	}

}
