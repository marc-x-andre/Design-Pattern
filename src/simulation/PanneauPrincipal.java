package simulation;

import controller.FactoryController;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;

	private FactoryController factoryController;

	public PanneauPrincipal(FactoryController factoryController) {
	    this.factoryController = factoryController;
    }

	@Override
	public void paint(Graphics g) {
	    super.paint(g);
        this.factoryController.getSimulatedObjects().forEach( ob -> {
            try {
                ob.nextTurn();
                ob.draw(g);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
	}

}