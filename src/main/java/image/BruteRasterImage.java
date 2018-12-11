package image;

import image.Image;
import javafx.scene.paint.Color;
import static util.Matrices.getRowCount;
import static util.Matrices.getColumnCount;

public class BruteRasterImage implements Image {

    int width;
    int height;
    Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor( color);

    }

    public BruteRasterImage(Color[][] color) {
        setHeight(getColumnCount(color));
        setWidth(getRowCount(color));
        createRepresentation();
        setPixelsColor(color);
    }



    public void createRepresentation() { //: aloue la matrice représentant l’image.
        this.pixels = new Color[this.width][this.height];
    }

    public void setPixelColor(Color color, int x, int y) // : fixe la couleur d’un pixel.
    {
        this.pixels[x][y] = color;
    }

    private void setPixelsColor(Color[][] pixels)// met à jour les valeurs de couleurs de l’image en utilisant les valeurs de la matrice donnée en paramètre.
    {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                this.pixels[i][j] = pixels[i][j];
            }
        }
    }

    private void setPixelsColor(Color color) //change les valeurs de tous les pixels pour qu’ils soient tous de la couleur donnée en paramètre.
    {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                setPixelColor(color, i , j);
            }
        }
    }

    @Override
    public int getWidth() //retourne la largeur de l’image.
    {
        return this.width;
    }
    @Override
    public int getHeight()//retourne la hauteur de l’image.
    {
        return this.height;
    }

    protected void setWidth(int width) //: fixe la largeur de l’image.
    {
        this.width = width;
    }

    protected void setHeight(int height)// : fixe la hauteur de l’image.
    {
        this.height = height;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return /*this.color;/*/this.pixels[x][y];
    }



}
