import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Client {
	private String nume, prenume, adresaPostala, adresaEmail, username, parola, nrTel;

	public Client(String username, String parola, String adresaPostala, String adresaEmail, String nume, String prenume,
			String nrTel) {
		this.nume = nume;
		this.prenume = prenume;
		this.adresaPostala = adresaPostala;
		this.adresaEmail = adresaEmail;
		this.username = username;
		this.parola = parola;
		this.nrTel = nrTel;
	}

	@Override
	public String toString() {
		return nume + " " + prenume + " " + adresaPostala + " " + adresaEmail + " " + username + " " + parola + " "
				+ nrTel;
	}

	public String getUsername() {
		return username;
	}

	public String getParola() {
		return parola;
	}

	public void salveazaListaClienti(Client c) {

		File file = new File("txt\\clienti.txt");
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);
			fileWriter.append(c.toString() + "\n");
			bufferFileWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("An I/O Error Occurred");

		}

	}

}
