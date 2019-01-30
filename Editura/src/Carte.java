import java.util.ArrayList;

public class Carte {
	private String numeAutor, titlu, anulAparitiei, nrPag, pret, perLiv = "sunati pentru mai multe detalii", picPath;
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

}
