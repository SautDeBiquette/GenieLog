

import builders.HomeBuilder;
import builders.HostDirector;
import builders.WorkplaceBuilder;
import components.devices.*;
import components.hosts.Home;
import components.hosts.Room;
import components.hosts.Workplace;
import components.smartDevices.*;
import factories.*;
import interfaces.SmartDevice;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========================================");
        System.out.println("   DÉMO SMART HOME & SMART WORKPLACE    ");
        System.out.println("========================================\n");

        // ─────────────────────────────────────────
        // 1. DÉMO FACTORY — Création de SmartDevices
        // ─────────────────────────────────────────
        System.out.println("Création des appareils via DeviceFactory\n");

        DeviceFactory blindsFactory        = new Blinds();
        DeviceFactory thermometerFactory   = new Thermometer();
        DeviceFactory coffeeMachineFactory = new CoffeeMachine();
        DeviceFactory dishwasherFactory    = new Dishwasher();
        DeviceFactory doorFactory          = new Door();
        DeviceFactory vacuumFactory        = new VacuumCleaner();
        DeviceFactory washingFactory       = new WashingMachine();
        DeviceFactory foodDispenserFactory = new FoodDispenser();

        SmartDevice blinds          = blindsFactory.createSmartDevice();
        SmartDevice thermostat      = thermometerFactory.createSmartDevice();
        SmartDevice coffee          = coffeeMachineFactory.createSmartDevice();
        SmartDevice dishwasher      = dishwasherFactory.createSmartDevice();
        SmartDevice door            = doorFactory.createSmartDevice();
        SmartDevice vacuum          = vacuumFactory.createSmartDevice();
        SmartDevice washing         = washingFactory.createSmartDevice();
        SmartDevice foodDispenser   = foodDispenserFactory.createSmartDevice();

        ((SmartBlinds) blinds).setLabel("Volets salon");
        ((SmartBlinds) blinds).setSerialNumber("BL-001");

        ((SmartThermometer) thermostat).setLabel("Thermostat salon");
        ((SmartThermometer) thermostat).setSerialNumber("TH-9000");
        ((SmartThermometer) thermostat).setTemperature(11.8);

        ((SmartCoffeeMachine) coffee).setLabel("Cafew Carnaval (4x4 teinté)");
        ((SmartCoffeeMachine) coffee).setSerialNumber("CL4-P-TP");

        ((SmartDishwasher) dishwasher).setLabel("Lave-vaisselle cuisine");
        ((SmartDishwasher) dishwasher).setSerialNumber("DHWSHR-42069");

        ((SmartDoor) door).setLabel("La puerta");
        ((SmartDoor) door).setSerialNumber("PRT-879");

        ((SmartVacuumCleaner) vacuum).setLabel("daBigSuck");
        ((SmartVacuumCleaner) vacuum).setLabel("6767676767");

        ((SmartWashingMachine) washing).setLabel("Lavlavlav");
        ((SmartWashingMachine) washing).setSerialNumber("45-WM-666");

        ((SmartFoodDispenser) foodDispenser).setLabel("Gib food");
        ((SmartFoodDispenser) foodDispenser).setSerialNumber("C4TF00D");

        // Optionnel
        System.out.println("Interaction avec les appareils\n");

        blinds.turnOn();
        blinds.turnOff();

        thermostat.turnOn();
        System.out.println(thermostat.report());

        coffee.turnOn();
        System.out.println(coffee.report());
        coffee.turnOff();
        //

        System.out.println();

        System.out.println("Construction d'une Smart Home\n");

        Room salon   = new Room(List.of(blinds, thermostat, vacuum) , "Salon");
        Room cuisine = new Room(List.of(dishwasher, foodDispenser)  , "Cuisine");
        Room entree  = new Room(List.of(door)                       , "Entrée");

        HomeBuilder homeBuilder = new HomeBuilder();


        System.out.println("Construction d'un Smart Workplace\n");

        Room openSpace  = new Room(List.of(thermostat, blinds)      , "Open Space");
        Room salleCafe  = new Room(List.of(coffee, foodDispenser)   , "Salle café");
        Room local      = new Room(List.of(washing, dishwasher)     , "Local tech");

        WorkplaceBuilder workplaceBuilder = new WorkplaceBuilder();

        HostDirector director = new HostDirector(workplaceBuilder, homeBuilder);

        director.constructHome(
                "Villa Les Pins",
                "12 rue des Mimosas, Toulouse",
                List.of(salon, cuisine, entree)
        );

        director.constructWorkplace(
                "TechCorp HQ",
                "42 avenue Compans-Caffarelli, Toulouse",
                List.of(openSpace, salleCafe, local)
        );


        Home home = homeBuilder.getResult();
        System.out.println("Maison construite : " + home.getName()
                + " à " + home.getLocation());
        System.out.println("Pièces : " + home.getRooms().size() + "\n");

        Workplace workplace = workplaceBuilder.getResult();
        System.out.println("Lieu de travail construit : " + workplace.getName()
                + " à " + workplace.getLocation());
        System.out.println("Salles : " + workplace.getRooms().size() + "\n");


        // ETIENNE CACA GONELLA CODE ICI


        System.out.println("reports\n");

        for (SmartDevice device : salon.getRoomsDevices()) {
            System.out.println(device.report());
        }

        System.out.println();


        System.out.println("\n========================================");
        System.out.println("           FIN DE LA DÉMO               ");
        System.out.println("========================================");
    }
}