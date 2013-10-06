/**
 * 
 */
package br.com.edgardleal.amil.log.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import br.com.edgardleal.amil.log.data.Player;
import br.com.edgardleal.amil.log.data.Round;
import br.com.edgardleal.amil.log.data.Weapon;

/**
 * @author Edgard Leal
 * 
 */
public class RandomLogGenerator {
	private final String[] players = new String[] { "<WORLD>", "Jhon", "Pedro",
			"Amanda", "Jessica" };

	private final String[] weapon = new String[] { "M16", "Faca",
			"Cácu Vrídrú", "Gilete de gay", "Prédrá" };
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	public RandomLogGenerator() {
		Arrays.sort(players);
	}

	public void generate(File file, long count) throws IOException {
		PrintWriter writer = new PrintWriter(file);
		Calendar calendar = Calendar.getInstance();
		long _count = 0;
		long id = Round.getNewId();
		writer.println(String.format("%s - New match %d has started",
				dateFormat.format(calendar.getTime()), id));
		for (_count = 0; _count < count; _count++) {
			calendar.add(Calendar.MINUTE, roundMinute());
			Player killer = new Player(randomKiller());
			Player victim = new Player(randomVictim(killer.getName()));
			Weapon weapon = new Weapon(randomWeapon());
			String line = String.format("%s - %s killed %s using %s",
					dateFormat.format(calendar.getTime()), killer.getName(),
					victim.getName(), weapon.getName());
			System.out.println(String.format("Escrevendo a linha: %s", line));
			writer.println(line);
			
		}

		calendar.add(Calendar.MINUTE, roundMinute());
		writer.println(String.format("%s - Match %d has ended",
				dateFormat.format(calendar.getTime()), id));
		writer.flush();
		writer.close();
	}

	private String randomWeapon() {
		return weapon[((int)( Math.random() * weapon.length))];
	}

	public String randomKiller() {
		return players[((int)( Math.random() * players.length))];
	}

	public String randomVictim(final String killer) {
		int i = 0;
		String result = null;
		while (result == null && ++i < 50) {
			result = randomKiller();
			if (result.equals(killer))
				result = null;
		}
		return result;
	}

	private int roundMinute() {
		return (int) (Math.random() * 120);
	}

	public void generate(String file, long count) throws IOException {
		generate(new File(file), count);
	}
	
	public static void main(String[] args) throws IOException {
		new RandomLogGenerator().generate("log100.log", 100);
	}
}
