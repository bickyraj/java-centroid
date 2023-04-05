package services;

import models.Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageCsvDAO {

    private static String file1_path = "src/mnist_train.csv";
    private static String file2_path = "src/mnist_test.csv";

    public static void getAllImages() throws IOException {
        List<Image> images = readAll();
        showMatrix(images.get(23).getMatrix());
    }
    public static List<Image> readAll() throws IOException {
        List<String> train_data = Files.readAllLines(Path.of(file1_path));
        List<String> mnisttest_data = Files.readAllLines(Path.of(file2_path));
        // removing the headers of the csv file.
        train_data.remove(0);
        mnisttest_data.remove(0);
        // String first_line_mnistrain = train_data.get(26);
        // String first_line_mnisttest = mnisttest_data.get(0);

        List<Image> images = new ArrayList<Image>();
        for (String line: train_data) {
            String[] a = line.split(",");
            Double[] first_line_to_array = new Double[a.length];
            // converting to double
            for (int i=0; i<a.length; i++) {
                first_line_to_array[i] = Double.parseDouble(a[i]);
            }

            Double[] matrix_data = new Double[first_line_to_array.length - 1];
            // taking out 1st column
            for (int i = 0; i < first_line_to_array.length - 1; i++) {
                matrix_data[i] = first_line_to_array[i + 1];
            }

            // getting label
            Double label = first_line_to_array[0];
            // converting remaining columns to matrix
            Double[][] matrix = convertToMatrix(matrix_data);

            // creating an image object
            Image image = new Image(label, matrix);
            images.add(image);
        }
        return images;
    }

    public static Double[][] convertToMatrix(Double[] arr) {
        Double[][] new_array = new Double[28][28];
        int counter = 0;
        for (int i=0;i<28; i++) {
            for (int j=0;j<28;j++) {
                new_array[i][j] = arr[counter];
                counter++;
            }
        }
        return new_array;
    }

    public static void showMatrix(Double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 100d) {
                    System.out.print("xx");
                } else {
                    System.out.print("..");
                }
            }
            System.out.println();
        }
    }

    public static void centroid() {
        double[][] publishedArticles = {{100, 50, 200}, {50, 30, 100}, {200, 100, 500}};
        int numOfArticles = publishedArticles.length;
        int numbOfDimension = publishedArticles[0].length;
        double[] centroid = new double[numbOfDimension];
        for (int i=0; i<numOfArticles; i++) {
            for (int j=0; j<numbOfDimension; j++) {
                centroid[j] += publishedArticles[i][j];
            }
        }

        for (int j =0; j<numbOfDimension; j++) {
            centroid[j] = centroid[j]/numOfArticles;
        }

        System.out.println("Centroid of published articles:");
        for (int j = 0; j < numbOfDimension; j++) {
            System.out.print(centroid[j] + " ");
        }
    }
}
