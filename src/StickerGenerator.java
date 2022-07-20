import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class StickerGenerator {
    public void create() throws Exception{
        BufferedImage originalImage = ImageIO.read(new File("entry/movie.jpg"));

        var width = originalImage.getWidth();
        var height = originalImage.getHeight();
        var newHeight = height + 200;

        var newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, width, height, null);

        ImageIO.write(newImage, "png", new File("output/sticker.png"));
    }

    public static void main(String[] args) throws Exception{
        var generator = new StickerGenerator();
        generator.create();
    }
}
