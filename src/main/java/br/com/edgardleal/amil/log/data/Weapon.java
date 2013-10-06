package br.com.edgardleal.amil.log.data;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class Weapon implements Comparable<Weapon> {
	private String name;
	private long damage;

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Weapon))
			return false;
		return name.equals(((Weapon) obj).getName());
	}

	public Weapon(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDamage() {
		return damage;
	}

	public void setDamage(long damage) {
		this.damage = damage;
	}

	/**
	 * Para ordenamento por nome
	 */
	@Override
	public int compareTo(Weapon o) {
		return name.compareTo(o.getName());
	}

}
