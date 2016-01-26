package com.freedan.world;
public class World {
	private Landscape[][] planet;
	private String worldSeed;

	public static void main(String args[]) {
		World newWorld = new World(15);
		newWorld.showWorld();
		System.out.println(newWorld.getWorldSeed());
		System.out.println(newWorld.getWorldSeed().length());
		newWorld.compressSeed();
		System.out.println(newWorld.getWorldSeed());
		System.out.println(newWorld.getWorldSeed().length());
		WorldDisplay newDisplay = new WorldDisplay(15, 20, "Earth", newWorld);
		// World otherWorld = new World(15);
		// otherWorld.buildFromSeed("FMWPWWIWWWFPPWWWWWWWWWWWWIPWWWIMWWWWWWWIIWWWWIIDWMMWWIFWWWWWIFDIWWWWIIDWDWWFFIIIWWFDMPWDIWFFFIWIIDDDPPIIFFWWPPPIFDWWFFIPFWWWWDWFFWWWWWWFWWWDDDPFPWWWWFWWWWIDPPIPDWWWFFWIIDMMIIWDPWFFPPWDDWPPWWWPDDFFWWWWWWWFWFPWDDFFWWWWWWWFFFWWF");
		// otherWorld.showWorld();
	}

	public World(int size) {

		planet = new Landscape[size][size];
		worldSeed = "";
		LandscapeBuilder(size);
		while (!isFull()) {
			int randomizerRow = (int) (Math.random() * size);
			int randomizerCol = (int) (Math.random() * size);
			TerrainSpread(randomizerRow, randomizerCol, 0, 2,
					getLandscapeType());

		}
		getSeed();

	}

	/**
	 * Creates a world of blank Landscape tiles.
	 */
	public void LandscapeBuilder(int worldLength) {
		for (int i = 0; i < worldLength; i++) {
			for (int j = 0; j < worldLength; j++) {
				planet[i][j] = new Landscape();
			}
		}

	}

	/**
	 * Recursively spreads a terrain of type 'type' over the World stopping when
	 * MaxSize is reached or no blank tiles remain.
	 */
	public void TerrainSpread(int row, int col, int size, int maxSize,
			String type) {
		{
			if (row >= planet.length) {
				row = 0;
			} else if (col >= planet[0].length) {
				col = 0;
			} else if (row < 0) {
				row = planet.length - 1;
			} else if (col < 0) {
				col = planet[0].length - 1;
			}
		}

		if (size >= maxSize || !planet[row][col].getType().equals("")) {

		} else {

			planet[row][col] = new Landscape(type);
			TerrainSpread(row + 1, col, size + 1, maxSize, type);
			TerrainSpread(row - 1, col, size + 1, maxSize, type);
			TerrainSpread(row, col + 1, size + 1, maxSize, type);
			TerrainSpread(row, col - 1, size + 1, maxSize, type);
		}
	}

	/**
	 * Returns true when a World is fully populated with Landscape tiles.
	 * 
	 * @return
	 */
	public boolean isFull() {
		for (int i = 0; i < planet.length; i++) {
			for (int j = 0; j < planet[0].length; j++) {
				if (planet[i][j].getType().equals(""))
					return false;
			}
		}
		return true;
	}

	/**
	 * Returns a randomly assigned landscape type, with water being three times
	 * more likely to be selected.
	 * 
	 * @return
	 */
	public String getLandscapeType() {
		int random = (int) (Math.random() * 8);
		if (random == 0 || random == 6 | random == 7) {
			return "Water";
		} else if (random == 1) {
			return "Ice";
		} else if (random == 2) {
			return "Plains";
		} else if (random == 3) {
			return "Des";
		} else if (random == 4) {
			return "Forest";
		} else {
			return "Mount";
		}
	}

	/**
	 * Displays the world using character values for Landscape tiles
	 */
	public void showWorld() {
		for (int i = 0; i < planet.length; i++) {
			for (int j = 0; j < planet[0].length; j++) {
				System.out.print(planet[i][j].getType().charAt(0) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Makes the worldSeed String of a World object into it's seed value.
	 */

	public void getSeed() {
		for (int i = 0; i < planet.length; i++) {
			for (int j = 0; j < planet[0].length; j++) {
				worldSeed += planet[i][j].getType().charAt(0);
			}
		}

	}

	/**
	 * Rebuilds a world from an inputed seed. Replaces current world with the
	 * one from the seed.
	 */
	public void buildFromSeed(String seed) {
		int counter = 0;
		for (int i = 0; i < planet.length; i++) {
			for (int j = 0; j < planet[0].length; j++) {
				char type = seed.charAt(counter);
				if (type >= '0' && type <= '9') {
					char next = seed.charAt(counter + 1);
					for (int k = 0; k < '0' - type; k++) {
						if (next == 'W') {
							planet[i][j] = new Landscape("Water");
						} else if (next == 'I') {
							planet[i][j] = new Landscape("Ice");
						} else if (next == 'P') {
							planet[i][j] = new Landscape("Plains");
						} else if (next == 'D') {
							planet[i][j] = new Landscape("Des");
						} else if (next == 'F') {
							planet[i][j] = new Landscape("Forest");
						} else if (next == 'M') {
							planet[i][j] = new Landscape("Mount");
						}
					}
					counter += 2;
				} else {
					if (type == 'W') {
						planet[i][j] = new Landscape("Water");
					} else if (type == 'I') {
						planet[i][j] = new Landscape("Ice");
					} else if (type == 'P') {
						planet[i][j] = new Landscape("Plains");
					} else if (type == 'D') {
						planet[i][j] = new Landscape("Des");
					} else if (type == 'F') {
						planet[i][j] = new Landscape("Forest");
					} else if (type == 'M') {
						planet[i][j] = new Landscape("Mount");
					}
					counter++;
				}
			}
		}
	}

	/**
	 * Returns world seed of a World.
	 */
	public String getWorldSeed() {
		return worldSeed;
	}

	/**
	 * Makes a seed shorter through compression
	 */
	public void compressSeed() {
		String newSeed = "";
		int count = 0;
		int index = 0;
		char storeChar = '0';
		while (worldSeed.length() > 0) {
			index = 0;
			count = 1;

			storeChar = worldSeed.charAt(0);

			while (worldSeed.substring(index).length() > 1
					&& worldSeed.charAt(index) == worldSeed.charAt(index + 1)) {
				count++;
				index++;
			}
			if (count > 1)
				newSeed += count;
			newSeed += worldSeed.charAt(index) + "";
			worldSeed = worldSeed.substring(count);
		}

		worldSeed = newSeed;

	}

	public Landscape getLandInfo(int row, int col) {
		return planet[row][col];
	}

}
