
package Code;

import java.awt.*;
import static java.lang.Math.round;
import javax.swing.*;

public class PnlBanderas extends JPanel{
    
    public PnlBanderas(){
    }
    
    @Override
    public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon fondo = new 
        ImageIcon(getClass().getResource(FrameGeneral.fondoFrame));
        g.drawImage(fondo.getImage(), 0, 0, tam.width, tam.height, null);
        setOpaque(false);
        super.paintComponents(g);
    }
    
    
    /* Creditos
    Cursor:
    Iconos diseñados por <a href="https://www.flaticon.es/autores/those-icons" title="Those Icons">Those Icons</a> from <a href="https://www.flaticon.es/" title="Flaticon"> www.flaticon.es</a>
    
    Fondo mapamundi
    https://mapamundiparaimprimir.com/continentes/
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
