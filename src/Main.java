import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JPanel {

    private ArrayList<Proton> protons;
    private Timer timer;
    private int x, y;

    //HI

    public Main(int w, int h) {
        setSize(w, h);
        protons = new ArrayList<Proton>();

        setUpTimer(1000/60);


        JButton addP = new JButton("Add +");

        addP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                x = (int)(Math.random()*w);
                y = (int)(Math.random()*h);

                if (protons.size()<20){
                    protons.add(new Proton(x,y,30));

                }
            }
        });

        setLayout(null);
        addP.setBounds(100, 100, 100, 20);
        add(addP);

        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                protons.clear();

            }
        });

        setLayout(null);
        restart.setBounds(100, 200, 100, 20);
        add(restart);

    }

    public void setUpTimer(int delay){
        if(timer == null) {
            timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //this code executes each frame!

                    for(Proton proton: protons)
                        proton.move(getWidth(), getHeight());

                    repaint();

                }
            });
        }

        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(Proton p: protons)
            p.draw(g2);

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulation");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 800;
        int height = 800;
        frame.setPreferredSize(new Dimension(width, height + 24));


        JPanel panel = new Main(width, height);
        panel.setFocusable(true);
        panel.grabFocus();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
