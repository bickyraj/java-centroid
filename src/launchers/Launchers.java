package launchers;

import models.Passenger;
import models.PassengerClass;
import services.ImageCsvDAO;

import java.io.IOException;
import java.util.Arrays;

public class Launchers {
    public static void main(String[] args) throws IOException {
//        ImageCsvDAO.getAllImages();
//        ImageCsvDAO.centroid();

        PassengerClass pClass = PassengerClass.getPassengerClassByValue("1st");
        Passenger tony = new Passenger(pClass, "tony");

        System.out.println(tony);

    }
}
