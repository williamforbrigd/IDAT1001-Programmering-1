import javax.swing.JOptionPane;

public class Skuddår {
    public static void main(String[]args) {
        String string = JOptionPane.showInputDialog("Tast inn årstallet!");
        int årstall = Integer.parseInt(string);

        boolean skuddår = false;
        boolean hundreår = false;

        if (årstall % 400 == 0) {
            hundreår = true;
            skuddår = true;
        }
        else if(årstall % 4 == 0)
            skuddår = true;

        if(hundreår && skuddår)
            JOptionPane.showMessageDialog(null, årstall + " er et skuddår og dermed et hundreår.");
        else if(skuddår && hundreår == false)
            JOptionPane.showMessageDialog(null, årstall + " er et skuddår.");
        else
            JOptionPane.showMessageDialog(null, årstall + " er ikke et skuddår.");
        }


    }
