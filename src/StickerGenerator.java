import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class StickerGenerator {
    public void create(InputStream imageURL, String fileName) throws Exception{
        BufferedImage originalImage = ImageIO.read(imageURL);
        var width = originalImage.getWidth();
        var height = originalImage.getHeight();
        var newImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        var graphics = (Graphics2D) newImage.getGraphics();
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 50);

        graphics.drawImage(originalImage, 0, 0, null);                
        graphics.setColor(Color.GREEN);
        graphics.setFont(font);
        graphics.drawString("by StickerGenerator", Math.round(width/20), Math.round((height-(height/20))));

        ImageIO.write(newImage, "png", new File("output/".concat(fileName)));
    }
}