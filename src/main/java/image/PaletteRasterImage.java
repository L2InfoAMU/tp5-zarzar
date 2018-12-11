package image;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions;

public class PaletteRasterImage implements Image {

    int width, height;
    Color color;
    List<Color> palette;
    int[][] indexesOfColor;

    public PaletteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels) {
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        this.width = pixels.length;
        this.height = pixels[0].length;
        createRepresentation();
        setPixelsColor(pixels);
    }

    public void createRepresentation() {
        palette = new ArrayList<Color>();
        indexesOfColor = new int[getWidth()][getHeight()];
    }


    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColor[x][y]);
    }

    public void setPixelColor(Color color, int x, int y) {
        if (!palette.contains(color))
            palette.add(color);
        indexesOfColor[x][y] = palette.indexOf(color);
    }

    public void setPixelsColor(Color[][] pixels){
        for(int x = 0; x<getWidth(); x++ )
            for(int y = 0; y<getHeight(); y++)
                setPixelColor(pixels[x][y], x, y);
    }

    public void setPixelsColor(Color color) {
        for (int x = 0; x < getWidth(); x++)
            for (int y = 0; y < getHeight(); y++)
                setPixelColor(color, x, y);
    }

    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public void setHeight(int height) {
        this.height = height;
    }

}
