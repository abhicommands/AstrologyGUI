package src.astro;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Astrology extends JPanel {
    String[] planet;
    String[] nakShyatra;
    double[] degree;
    public Astrology(String[] a, String[] b, double[] c) {
        planet = a;
        nakShyatra = b;
        degree = c;
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        int cntrX = getWidth()/2;
        int cntrY = getHeight()/2;
        int radius = getWidth()/6;
        double startAngle = 90;
        double increment = 13.3333333;
        for(int i = 1; i <= 27; i++) {
            double y = radius*(Math.sin(Math.toRadians(startAngle)));
            double x = radius*(Math.cos(Math.toRadians(startAngle)));
            g2.setPaint(getColorRN(i));
            g2.fillOval(60, 10+(25*i), 7, 7);
            g2.fill(new Arc2D.Double(cntrX-radius, cntrY-radius, radius*2, radius*2,  startAngle, increment, Arc2D.PIE));
            g2.setColor( Color.BLACK );
            g2.setStroke(new BasicStroke(2));
            g2.draw(new Arc2D.Double(cntrX-radius, cntrY-radius, radius*2, radius*2,  startAngle, increment, Arc2D.PIE));
            g2.setPaint(Color.BLACK);
            g2.draw(new Line2D.Double(cntrX, cntrY, (cntrX+x), (cntrY-y)));
            startAngle = startAngle + 13.3333333;
        }
        double newDegree = 0;
        for(int i = 0; i < 9; i++) {
            newDegree = 90 + (getDegree(nakShyatra[i], degree[i]));
            double y = (radius)*(Math.sin(Math.toRadians(newDegree)));
            double x = (radius)*(Math.cos(Math.toRadians(newDegree)));
            g2.setColor( Color.RED );
            g2.fill(new Ellipse2D.Double((cntrX+x)-4, (cntrY-y)-4, 8, 8));
            g2.setColor( Color.BLACK );
            if(newDegree >=90 && newDegree <= 270) {
                g2.drawString(planet[i], (int)(cntrX+x + ((Math.cos(Math.toRadians(newDegree)))*60)), (int)(cntrY-y-((Math.sin(Math.toRadians(newDegree)))*15)));
                g2.drawString("" + degree[i], (int)(cntrX+x + ((Math.cos(Math.toRadians(newDegree)))*100)), (int)(cntrY-y-((Math.sin(Math.toRadians(newDegree)))*30)));
            }
            else if((newDegree) >= 270 && (newDegree) <= 360) {
                g2.drawString(planet[i], (int) (cntrX+x+10), (int) (cntrY-y+10));
                g2.drawString("" + degree[i], (int) (cntrX+x+10), (int) (cntrY-y+30));
            }
            else {
                g2.drawString(planet[i], (int) (cntrX+x+5), (int) (cntrY-y-10));
                g2.drawString("" + degree[i], (int) (cntrX+x+30), (int) (cntrY-y-20));
            }
            

        }

    }
    public double getDegree(String nakShyatra, double degree) {
        switch(nakShyatra) {
            case "Ashwini":
                return degree;
            case "Bharani":
                return degree + 13.3333333;
            case "Krittika":
                return degree + 26.6666667;
            case "Rohini":
                return degree + 40;
            case "Mrigashira":
                return degree + 53.3333333;
            case "Ardra":
                return degree + 66.6666667;
            case "Punarvasu":
                return degree + 80;
            case "Pushya":
                return degree + 93.3333333;
            case "Ashlesha":
                return degree + 106.6666667;
            case "Magha":
                return degree + 120;
            case "Purva_Phalguni":
                return degree + 133.3333333;
            case "Uttara_Phalguni":
                return degree + 146.6666667;
            case "Hasta":
                return degree + 160;
            case "Chitra":
                return degree + 173.3333333;
            case "Swati":
                return degree + 186.6666667;
            case "Vishakha":
                return degree + 200;
            case "Anuradha":
                return degree + 213.3333333;
            case "Jyeshtha":
                return degree + 226.6666667;
            case "Mula":
                return degree + 240;
            case "Purva_Ashadha":
                return degree + 253.3333333;
            case "Uttara_Ashadha":
                return degree + 266.6666667;
            case "Shravana":
                return degree + 280;
            case "Dhanishta":
                return degree + 293.3333333;
            case "Shatabhisha":
                return degree + 306.6666667;
            case "Purva_Bhadrapada":
                return degree + 320;
            case "Uttara_Bhadrapada":
                return degree + 333.3333333;
            case "Revati":
                return degree + 346.6666667;
            default:
                return 0;
        }
    }
    public Color getColorRN(int i) {
        switch(i) {
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.RED;
            case 5:
                return Color.PINK;
            case 6:
                return Color.MAGENTA;
            case 7:
                return Color.CYAN;
            case 8: 
                return Color.GRAY;
            case 9:
                return Color.WHITE;
            case 10:
                return Color.BLACK;
            case 11:
                return Color.LIGHT_GRAY;
            case 12:
                return Color.DARK_GRAY;
            case 13:
                return Color.RED;
            case 14:
                return Color.BLUE;
            case 15:
                return Color.GREEN;
            case 16:
                return Color.YELLOW;
            case 17:
                return Color.RED;
            case 18:
                return Color.PINK;
            case 19:
                return Color.MAGENTA;
            case 20:
                return Color.CYAN;
            case 21:
                return Color.GRAY;
            case 22:
                return Color.WHITE;
            case 23:
                return Color.BLACK;
            case 24:
                return Color.LIGHT_GRAY;
            case 25:
                return Color.DARK_GRAY;
            case 26:
                return Color.RED;
            default:
                return Color.DARK_GRAY;

        }
    }
    public JLabel getNameLabelToAdd(int i) {
        int value = i * 25;
        String text = "";
        JLabel label;
        switch(i) {
            case 1:
                text = "Ashwini";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 2:
                text = "Bharani";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 3:
                text = "Krittika";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 4:
                text = "Rohini";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 5:
                text = "Mrigashira";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 6:
                text = "Ardra";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 7:
                text = "Punarvasu";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 8:
                text = "Pushya";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 9:
                text = "Ashlesha";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 10:
                text = "Magha";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 11:
                text = "Purva_Phalguni";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 12:
                text = "Uttara_Phalguni";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 13:
                text = "Hasta";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 14:
                text = "Chitra";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 15:
                text = "Swati";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 16:
                text = "Vishakha";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 17:
                text = "Anuradha";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 18:
                text = "Jyeshtha";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 19:
                text = "Mula";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 20:
                text = "Purva_Ashadha";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 21:
                text = "Uttara_Ashadha";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 22:
                text = "Shravana";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 23:
                text = "Dhanishta";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 24:
                text = "Shatabhisha";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 25:
                text = "Purva_Bhadrapada";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 26:
                text = "Uttara_Bhadrapada";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            case 27:
                text = "Revati";
                label = new JLabel(text, JLabel.LEFT);
                label.setBounds(70, value, 100, 25);
                return label;
            default:
                return null;
        }
    }
    public static void main(String[] args){
        String[] planet = new String[9];
        String[] nakShyatra = new String[9];
        double[] degree = new double[9];
        JFrame frame = new JFrame();
        frame.setSize(1920, 800);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                Scanner sc = new Scanner(selectedFile);
                for (int i = 0; i < 9; i++) {
                    planet[i] = sc.next();
                    nakShyatra[i] = sc.next();
                    degree[i] = sc.nextDouble();
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Astrology a = new Astrology(planet, nakShyatra, degree);
        for(int i =1; i <= 27; i++) {
            frame.add(a.getNameLabelToAdd(i));
        }
        frame.add(a);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}