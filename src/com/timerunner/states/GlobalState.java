package com.timerunner.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

import com.timerunner.Game;

public abstract class GlobalState extends BasicGameState
{
	protected StateBasedGame game;
	public static int pauseId = 0;
	private static Image screen;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException 
	{
		game = arg1;
		GlobalState.screen = new Image(Game.WIDTH, Game.HEIGHT);
	}
	
	/**
	 * Une touche clavier est-elle appuyée ?
	 * >> Seconde manière de détecter l'appui d'une touche
	 */
	public void keyPressed(int key, char c) 
	{
		switch (key) 
		{
			// Touche Echap : met en pause
			case Input.KEY_ESCAPE :
				getGraphics().copyArea(GlobalState.screen, 0, 0);
				pauseState(this.getID(), PauseMenuState.ID, new FadeOutTransition(new Color (0.2f, 0.2f, 0.2f, 0.5f)), new FadeInTransition(new Color (0.2f, 0.2f, 0.2f, 0.5f)));
				//game.enterState(PauseMenuState.ID);
			break;
			// Touche F3, active/desactive le debug
			case Input.KEY_F3 :
				Game.DEBUG = !Game.DEBUG;
				Game.container.setShowFPS(Game.DEBUG);
			break;
		}
	}
 
	/**
	 * Touche clavier relachée
	 */
	public void keyReleased(int key, char c) 
	{
	}
	
	@Override
	public abstract int getID();
	
	/**
     * Pause a particular game state with the transitions provided
     *
     * @param pauseId the id of the state to pause
     * @param id      The ID of the state to enter
     * @param leave   The transition to use when leaving the current state
     * @param enter   The transition to use when entering the new state
     */
    public void pauseState(int pauseId, int id, Transition leave, Transition enter) 
    {
    	GlobalState.pauseId = pauseId;
        game.enterState(id, leave, enter);
    }

    public void resumeState(Transition leave, Transition enter) 
    {
    	game.enterState(GlobalState.pauseId, leave, enter);
    }
    
    public static void setScreen(final Image pScreen)
    {
    	GlobalState.screen = pScreen;
    }
    
    public static Image getScreen()
    {
    	return GlobalState.screen;
    }

	public abstract Graphics getGraphics();
}