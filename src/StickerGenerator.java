import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;

public class StickerGenerator {
    public void create() throws Exception{
        BufferedImage originalImage = ImageIO.read(new File("entry/movie.jpg"));

        var width = originalImage.getWidth();
        var height = originalImage.getHeight();
        var newHeight = height + 500;

        var newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        var font = new Font(Font.SANS_SERIF, Font.BOLD, 200);        
        graphics.setColor(Color.BLACK);
        graphics.setFont(font);

        graphics.drawString("MY STRING", (width / 5), (newHeight - 250));

        ImageIO.write(newImage, "png", new File("output/sticker.png"));
    }

    public static void main(String[] args) throws Exception{
        var generator = new StickerGenerator();
        generator.create();
    }
}
