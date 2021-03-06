import java.util.ArrayList;

public class CosCumparaturi {

	private ArrayList<Carte> lista = new ArrayList<Carte>();
	private double pretTotal;

	public CosCumparaturi() {
	}

	void adaugaCarte(Carte carte) {
		this.lista.add(carte);
		pretTotal = pretTotal + Double.parseDouble(carte.getPret());
	}

	void detaliiCos() {
		for (int i = 0; i < this.lista.size(); i++) {
			Carte tmp = this.lista.get(i);
			tmp.toString();
		}
		// System.out.println("\n Pret Total:" + pretTotal + " RON");
	}

	public String getPretTotal() {
		return "\n Pret Total:" + pretTotal + " RON";
	}

	@Override
	public String toString() {
		return "Lista Carti \n" + lista;
	}

	public ArrayList<Carte> getLista() {
		return lista;
	}

}
