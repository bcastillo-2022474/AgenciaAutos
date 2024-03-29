package com.joao.controller;

import com.joao.model.Motorcycle;

import java.util.ArrayList;

public class MotorcycleController extends ConveyanceController<Motorcycle>{
    private static MotorcycleController motorcycleController;

    /**
     * Constructor Singleton.<br/>
     * Esto con el fin de Que siempre se trabaje con la misma base de Datos.
     * Singleton es indispensable para esta implementación, ya que
     * no se puede implementar un ArrayList estático, puesto que el ArrayList es heredado
     * de una Clase Parametrizada/Genérica por lo cual no puede ser declarada como
     * estática.
     * */
    public static MotorcycleController getMotorcycleController() {
        if (motorcycleController == null) motorcycleController = new MotorcycleController();
        return motorcycleController;
    }

    /**
     * crea un Array de 2 dimensiones con todas las propiedades de los objetos
     * almacenados en {@link #conveyances} convertidos a String
     * */
    public static String[][] getFields() {
        ArrayList<Motorcycle> motos = getMotorcycleController().getConveyances();
        String[][] array = new String[motos.size()][5];
        int i = 0;
        for (Motorcycle moto : motos) {
            array[i][0] = String.valueOf(moto.getId());
            array[i][1] = String.valueOf(moto.getYear());
            array[i][2] = String.valueOf(moto.getTransportCapacity());
            array[i][3] = String.valueOf(moto.getModel());
            array[i][4] = String.valueOf(moto.getBrand());
            i++;
        }

        return array;
    }

    @Override
    public void validate(Motorcycle moto) throws Exception {
        validateYear(moto.getYear());
        validateTransportCapacity(moto.getTransportCapacity());
        validateBrand(moto.getBrand());
        validateModel(moto.getModel());
    }

    @Override
    public void validateYear(int year) throws Exception {
        if (year < 1930 || year > 2024) throw new Exception("a Motorcycle cant have been released before 1930 or after 2024");
    }

    @Override
    public void validateTransportCapacity(int transportCapacity) throws Exception {
        if (transportCapacity < 1 || transportCapacity > 5) throw new Exception("a Motorcycle transport capacity cant be less tan 1 or more than 5 people");
    }

    @Override
    public void validateModel(String model) throws Exception {
        if (model.length() < 2) throw new Exception("a Motorcycle model needs to be at least 3 letters");
    }

    @Override
    public void validateBrand(String brand) throws Exception {
        if (brand.length() < 2) throw new Exception("a Motorcycle brand needs to be at least 3 letters");
    }
}
