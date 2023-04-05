package launchers;

import services.ImageCsvDAO;

import java.io.IOException;
import java.util.Arrays;

public class Launchers {
    public static void main(String[] args) throws IOException {
        ImageCsvDAO.getAllImages();
//        ImageCsvDAO.centroid();
    }
}
