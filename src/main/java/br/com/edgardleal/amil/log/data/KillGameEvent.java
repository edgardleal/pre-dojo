package br.com.edgardleal.amil.log.data;

import java.io.Serializable;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class KillGameEvent extends GameLogEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Player victim;
	private Player killer;
	private Weapon weapon;

	public Player getVictim() {
		return victim;
	}

	public KillGameEvent setVictim(Player victim) {
		this.victim = victim;
		return this;
	}

	public Player getKiller() {
		return killer;
	}

	public KillGameEvent setKiller(Player killer) {
		this.killer = killer;
		return this;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public KillGameEvent setWeapon(Weapon weapon) {
		this.weapon = weapon;
		return this;
	}

}
