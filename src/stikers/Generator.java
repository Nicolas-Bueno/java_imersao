package stikers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Generator {

    public void create(InputStream inputStream, String newFile) throws Exception {
        // leitura imagem 

        
        //InputStream inputStream = 
        // new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg");

            BufferedImage imgOrigin = ImageIO.read(inputStream);

        // criar nova imagem com trasparecia e com novo tamanho

        int largura = imgOrigin.getWidth();
        int altura = imgOrigin.getHeight();
        int novaAltura = altura + 200;
        BufferedImage newImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memoria)

        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(imgOrigin, 0, 0, null);

        // escrever na nova imagem em um arquivo

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 150, novaAltura - 100);

        ImageIO.write(newImg, "png", new File(newFile));
    }
}
