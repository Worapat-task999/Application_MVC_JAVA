import controller.*;
import model.*;
import view.*;
import javax.swing.JFrame;
public class Smain {
    public static void main(String []args) throws Exception{
        
        Sview view = new Sview();
        Smodel model = new Smodel();
        Scontroller controller = new Scontroller(view,model);
        view.registerListenerjPanel(controller);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }
}
