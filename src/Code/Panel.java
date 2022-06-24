
package Code;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author windows
 */
public class Panel extends JPanel{
    Panel(){}
        
    @Override
    public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon fondo = new 
        ImageIcon(getClass().getResource(FrameGeneral.fondoBanderas));
        g.drawImage(fondo.getImage(), 0, 0, tam.width, tam.height, null);
        setOpaque(false);
        super.paintComponents(g);
    }
}
