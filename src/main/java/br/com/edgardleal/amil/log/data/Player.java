package br.com.edgardleal.amil.log.data;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class Player implements Comparable<Player> {
	private String name;

	public Player(String name){
		this.name = name;
	}
	
	/**
	 * Para ordenamento por nome
	 */
	@Override
	public int compareTo(Player o) {
		return name.compareTo(o.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Player))
			return false;
		return name.equals(((Player) obj).getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return name;
	}
	
	
}
