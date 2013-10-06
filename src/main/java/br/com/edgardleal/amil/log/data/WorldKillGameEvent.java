package br.com.edgardleal.amil.log.data;

import java.io.Serializable;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class WorldKillGameEvent extends GameLogEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Player victim;
	private Weapon weapon;

	public Player getVictim() {
		return victim;
	}

	public WorldKillGameEvent setVictim(Player victim) {
		this.victim = victim;
		return this;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public WorldKillGameEvent setWeapon(Weapon weapon) {
		this.weapon = weapon;
		return this;
	}

}
