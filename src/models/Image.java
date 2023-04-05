package models;

public class Image {
    Double label;
    Double[][] matrix;

    public Double[][] getMatrix() {
        return matrix;
    }

    public Double getLabel() {
        return label;
    }

    public void setLabel(Double label) {
        this.label = label;
    }

    public void setMatrix(Double[][] matrix) {
        this.matrix = matrix;
    }

    public Image(Double label, Double[][] matrix) {
        this.label = label;
        this.matrix = matrix;
    }
}
