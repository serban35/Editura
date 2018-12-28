import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Client {
	private String nume;
	private String prenume;
	private String adresaPostala;
	private String adresaEmail;
	private String username;
	private String parola;
	private String nrTel;
	private int cod;

	public Client(String nume, String prenume, String adresaPostala, String adresaEmail, String username, String parola,
			String nrTel) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.adresaPostala = adresaPostala;
		this.adresaEmail = adresaEmail;
		this.username = username;
		this.parola = parola;
		this.nrTel = nrTel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nrTel == null) ? 0 : nrTel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (nrTel == null) {
			if (other.nrTel != null)
				return false;
		} else if (!nrTel.equals(other.nrTel))
			return false;
		return true;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return cod + " nume=" + nume + ", prenume=" + prenume + ", adresaPostala=" + adresaPostala + ", adresaEmail="
				+ adresaEmail + ", username=" + username + ", parola=" + parola + ", nrTel=" + nrTel;
	}

	public void salveazaListaClienti(Client c) {

		File file = new File("C:\\Users\\serba\\git\\repository\\Editura\\Editura\\src\\clienti.txt");
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
