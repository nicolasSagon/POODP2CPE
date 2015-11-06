package model;





/**
 * @author francoise.perrin
  * Inspiration Jacques SARAYDARYAN, Adrien GUENARD*
 */
public class Pion extends AbstractPiece implements IPion {
	
	private boolean premierCoup;

	/**
	 * @param name
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Pion(String name,Couleur couleur_de_piece, Coord coord) {
		super(name,couleur_de_piece, coord);
		this.premierCoup = true;
	}

	/* (non-Javadoc)
	 * @see model.Pions#isMoveDiagOk(int, int)
	 */
	@Override
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		
		boolean ret = false;
		
		if (Couleur.NOIR.equals(this.getCouleur())) {
			if ((yFinal == this.getY()+1 && xFinal == this.getX()+1) 
					|| (yFinal == this.getY()+1 && xFinal == this.getX()-1)) {
				ret = true;
			}
		}
					
		if (Couleur.BLANC.equals(this.getCouleur())) {
			if ((yFinal == this.getY()-1 && xFinal == this.getX()+1) 
					|| (yFinal == this.getY()-1 && xFinal == this.getX()-1)) {
				ret = true;
			}
		}	
			
		return ret;
	}

	/* (non-Javadoc)
	 * @see model.AbstractPiece#move(int, int)
	 */
	@Override
	public boolean move(int x, int y){
		
		boolean ret = false;
		
		if(Coord.coordonnees_valides(x,y)){
			this.premierCoup = false;
			ret = super.move(x, y);
		}
		return ret;
	}
	
	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		System.out.println(this.getName() + " " + this.getMovementStrategy().getClass().getSimpleName());
		return this.getMovementStrategy().isMoveOk(this.getX(), this.getY(), xFinal, yFinal, this.premierCoup, this.getCouleur());
	}

	

}
