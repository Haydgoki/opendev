package unnamed.game;

import java.net.MalformedURLException;

import gameframework.game.*;
import gameframework.gui.*;

public class UnnamedGame extends  GameDefaultImpl{
	
	
	public UnnamedGame(GameData data) {
		super(data);
		this.initLevels();
	}	
	/**
	 * Add all the levels on the game list
	 */
	public void initLevels() {
		this.data.addLevel(new TestLevel(data));
	}

	/**
	 * @param args not use here 
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		//TODO a specific configuration class
		GameConfiguration conf= new GameConfiguration();
		
		//T
		GameData data = new GameData(conf);
		
		Game game = new UnnamedGame(data);
		
		GameStatusBarElement<Integer> score = new GameStatusBarElement<Integer>("Score : ", data.getScore());
		
		GameStatusBarElement<Integer> life = new GameStatusBarElement<Integer>("Life : ", data.getLife());
			
		GameWindow window = new GameWindow("Baladeva", data.getCanvas(),conf, life, score);
			
		window.createGUI();
		game.start();
	}
}
	
	/*
	SCHEMA D'UNE IMPLEMENTATION :
	
	-On crée le game + game configuration
	
	-On ajoute les levels et tout autre element dans le game data
	
	-gameConfiguration.createUniverse(gameData), gameConfiguration.createCanvas()
	
	
	
	On crée la GameWindow( Nom , Canvas, gameData)
	On crée le GUI et on lance la fenêtre
	
	
	Game.start(Nouvelle classe de game)  <-- lancer les observer les objets en mouvement etc etc et laisser faire les boucles de dessin(  ), et de mouvement (),
	(LANCER BOUCLE)
	*/