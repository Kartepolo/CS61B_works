package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;

import java.awt.Color;
import java.util.Map;
import java.util.List;

public class Clorus extends Creature {
	    /** red color. */
	    private int r;
	    /** green color. */
	    private int g;
	    /** blue color. */
	    private int b;
	    
	    public Clorus(double e) {
	        super("clorus");
	        r = 34;
	        g = 0;
	        b = 231;
	        energy = e;
	    }

	    public Clorus() {
	        this(1);
	    }

	    public Color color() {
	        return color(r, g, b);
	    }

	    public void attack(Creature c) {
	    	this.energy+=c.energy();
	    }

	    public void move() {
	    	this.energy-=0.03;
	    }

	    public void stay() {
	    	this.energy-=0.01;
	    }

	    public Clorus replicate() {
	    	Clorus nc = new Clorus(this.energy/2.0);
	    	this.energy = this.energy*0.5;
	        return nc;
	    }


	    public Action chooseAction(Map<Direction, Occupant> neighbors) {
	    	List<Direction> emptyn = getNeighborsOfType(neighbors,"empty");
	    	if (emptyn.isEmpty()){
	    		return new Action(Action.ActionType.STAY);
	    	}else{
	    		List<Direction> plips = getNeighborsOfType(neighbors,"plip");
	    		if(!plips.isEmpty()){
	    			return new Action(Action.ActionType.ATTACK, HugLifeUtils.randomEntry(plips));
	    		}else if (this.energy>=1.0){
	    			return new Action(Action.ActionType.REPLICATE, HugLifeUtils.randomEntry(emptyn));
	    		}else{
	    			return new Action(Action.ActionType.MOVE, HugLifeUtils.randomEntry(emptyn));
	    		}
	    	}
	    }
	}	    
