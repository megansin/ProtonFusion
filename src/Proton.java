import java.awt.*;

public class Proton {

    private int x, y, diameter, vx, vy;
    private Color color;

    public Proton(int x, int y, int diameter){
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = Color.green;
        vx = 10;
        vy = 10;
    }
    public void draw(Graphics2D g2){

        g2.setColor(color);
        g2.fillOval(x, y, diameter, diameter);

    }

    public boolean contains(int x, int y){
        int centerX = this.x + diameter/2;
        int centerY = this.y + diameter/2;

        int dx = x - centerX;
        int dy = y - centerY;
        double dist = Math.sqrt(dx*dx + dy*dy);

        if(dist < diameter/2)
            return true;
        else
            return false;
    }

    //w, h are width and height of the window.
    public void move(int w, int h) {

        x += vx;
        y += vy;

        if (y + diameter >= h) {
            vy = -Math.abs(vy);
            y = h - diameter;
        } else if (y <= 0) {
            vy = Math.abs(vy);
            y = 0;
        } else if (x + diameter >= w) {
            vx = -Math.abs(vx);
            x = w - diameter;
        } else if (x <= 0) {
            vx = Math.abs(vx);
            x = 0;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
