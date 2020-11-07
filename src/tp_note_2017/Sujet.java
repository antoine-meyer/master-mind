package tp_note_2017;

public interface Sujet {
	/**
	 * 
	 */
	public void enregistrerObservateur(Observateur o);
	/**
	 * 
	 */
	public void supprimerObservateur(Observateur o);
	/**
	 * 
	 */
	public void notifierObservateurs();
}
