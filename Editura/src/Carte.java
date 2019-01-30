import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Carte {
	private String numeAutor, titlu, anulAparitiei, nrPag, pret, perLiv = "24h(curier rapid)/ 3 zile(posta romana)",
			picPath;
	private ArrayList<String> recenzii = new ArrayList<String>();

	public Carte(String numeAutor, String titlu, String anulAparitiei, String nrPag, String pret, String picPath) {
		super();
		this.numeAutor = numeAutor;
		this.titlu = titlu;
		this.anulAparitiei = anulAparitiei;
		this.nrPag = nrPag;
		this.pret = pret;
		this.picPath = picPath;
	}

	public void setRecenzii(String recenzie) {
		recenzii.add(recenzie);
	}

	public String getPret() {
		return pret;
	}

	public String getPerLiv() {
		return perLiv;
	}

	@Override
	public String toString() {
		return "Titlu:   " + titlu + "     Autor: " + numeAutor + "       Pret: " + pret + "\n";
	}

	public String getNumeAutor() {
		return numeAutor;
	}

	public String getTitlu() {
		return titlu;
	}

	public String getAnulAparitiei() {
		return anulAparitiei;
	}

	public String getNrPag() {
		return nrPag;
	}

	public String getPicPath() {
		return picPath;
	}

	public void salveazaRecenzii(Carte c) {
		File file = new File("txt\\" + c.getTitlu() + ".txt");
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferFileWriter = new BufferedWriter(fileWriter);
			for (String r : recenzii)
				fileWriter.append(r + "\n");
			bufferFileWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("An I/O Error Occurred");

		}

	}
}
