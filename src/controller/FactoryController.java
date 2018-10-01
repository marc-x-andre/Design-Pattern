package controller;

import model.*;
import model.Component;
import model.building.Factory;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

public class FactoryController {

    public static Subject<Shipment> sendingDispatcher = new Subject<>();
    public static Subject<Boolean> isInProduction = new Subject<>();

    private ArrayList<ISimulatedObject> simulatedObjects = new ArrayList<>();

    public FactoryController() {
        changeConfiguration("src/ressources/configuration.xml");
        sendingDispatcher.emit(new Shipment(11, null, Component.METAL));
    }

    public ArrayList<ISimulatedObject> getSimulatedObjects() {
        return simulatedObjects;
    }

    public boolean changeConfiguration(String configurationPath) {
        try{
            simulatedObjects = ConfigurationReader.createSimulationByConfiguration(configurationPath);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void resetWithNewValues(ArrayList<ISimulatedObject> simulatedObjects) {
        // TODO reset the controller
    }


}
