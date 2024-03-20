import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarRace extends JFrame implements KeyListener {
    
    private Player first_player;
    private Player second_player;
    private Bot bot1;
    private Bot bot2;
    private Bot bot3;
    private Bot bot4;
    private Bot bot5;
    private Clock clock;
    private JLabel label;

    GamePanel panel;
    class GamePanel extends JPanel{
        public GamePanel(){
            setVisible(true);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawOval(20,40,700,700);
            g.drawOval(170, 190, 400, 400);
            g.drawLine(20, 390, 170, 390);
            g.setColor(Color.green);
            g.fillRect(first_player.getX(),first_player.getY(),10,10);
            g.setColor(Color.red);
            g.fillRect(second_player.getX(),second_player.getY(),10,10);
            g.setColor(Color.black);
            g.fillRect(bot1.getX(),bot1.getY(),10,10);
            g.fillRect(bot2.getX(),bot2.getY(),10,10);
            g.fillRect(bot3.getX(),bot3.getY(),10,10);
            g.fillRect(bot4.getX(),bot4.getY(),10,10);
            g.fillRect(bot5.getX(),bot5.getY(),10,10);
        }
    }
    public CarRace() {
        clock= new Clock(this);
        first_player= new Player(this);
        second_player= new Player(this);
        bot1 = new Bot(this);
        bot2 = new Bot(this);
        bot3 = new Bot(this);
        bot4 = new Bot(this);
        bot5 = new Bot(this);
        panel = new GamePanel();
        first_player.setX(25);
        first_player.setY(385);
        second_player.setX(45);
        second_player.setY(385);
        bot1.setX(65);
        bot1.setY(385);
        bot2.setX(85);
        bot2.setY(385);
        bot3.setX(105);
        bot3.setY(385);
        bot4.setX(125);
        bot4.setY(385);
        bot5.setX(145);
        bot5.setY(385);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addKeyListener(this);
        JPanel time_panel= new JPanel();
        time_panel.setLayout(new BorderLayout());
        label = new JLabel();
        label.setText(clock.toString());
        time_panel.add(label, BorderLayout.WEST);
        add(panel, BorderLayout.CENTER);
        add(time_panel, BorderLayout.NORTH);
        first_player.start();
        second_player.start();
        clock.start();
        setVisible(true);

    }

    public void game(int speed){
        bot1.setSpeed(speed);
        bot2.setSpeed(speed);
        bot3.setSpeed(speed);
        bot4.setSpeed(speed);
        bot5.setSpeed(speed);
        bot1.start();
        bot2.start();
        bot3.start();
        bot4.start();
        bot5.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode()== KeyEvent.VK_UP){
            second_player.setCurrent_int(e.getKeyCode());
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            second_player.setCurrent_int(e.getKeyCode());
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            second_player.setCurrent_int(e.getKeyCode());
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            second_player.setCurrent_int(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        first_player.setCurrent_char('k');
        second_player.setCurrent_int(0);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='w'){
            first_player.setCurrent_char(e.getKeyChar());
        } 
        if(e.getKeyChar()=='a'){
            first_player.setCurrent_char('a');
        }
        if(e.getKeyChar()=='s'){
            first_player.setCurrent_char('s');
        }
        if(e.getKeyChar()=='d'){
            first_player.setCurrent_char('d');
        }

    }

    public Clock getClock() {
        return this.clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public JLabel getLabel() {
        return this.label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Player getFirst_player() {
        return this.first_player;
    }

    public void setFirst_player(Player first_player) {
        this.first_player = first_player;
    }

    public Player getSecond_player() {
        return this.second_player;
    }

    public void setSecond_player(Player second_player) {
        this.second_player = second_player;
    }

    public Bot getBot1() {
        return this.bot1;
    }

    public void setBot1(Bot bot1) {
        this.bot1 = bot1;
    }

    public Bot getBot2() {
        return this.bot2;
    }

    public void setBot2(Bot bot2) {
        this.bot2 = bot2;
    }

    public Bot getBot3() {
        return this.bot3;
    }

    public void setBot3(Bot bot3) {
        this.bot3 = bot3;
    }

    public Bot getBot4() {
        return this.bot4;
    }

    public void setBot4(Bot bot4) {
        this.bot4 = bot4;
    }

    public Bot getBot5() {
        return this.bot5;
    }

    public void setBot5(Bot bot5) {
        this.bot5 = bot5;
    }

    public GamePanel getPanel() {
        return this.panel;
    }

    public void setPanel(GamePanel panel) {
        this.panel = panel;
    }

    class GameOver extends JFrame{
        Player player;
        Bot bot;
        public GameOver(Player p){
            setSize(400,200);
            setLayout(new BorderLayout());
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JLabel label= new JLabel();
            panel.add(label,BorderLayout.CENTER);
            add(panel,BorderLayout.CENTER);

            if(p==first_player){
                label.setText("1. Oyuncu Kazandı! Süresi: " + clock.toString());
                clock.setDevam(false);
                first_player.setDevam(false);
                second_player.setDevam(false);
                bot1.setDevam(false);
                bot2.setDevam(false);
                bot3.setDevam(false);
                bot4.setDevam(false);
                bot5.setDevam(false);
            }
            else if(p==second_player){
                label.setText("2. Oyuncu Kazandı! Süresi: " + clock.toString());
                clock.setDevam(false);
                first_player.setDevam(false);
                second_player.setDevam(false);
                bot1.setDevam(false);
                bot2.setDevam(false);
                bot3.setDevam(false);
                bot4.setDevam(false);
                bot5.setDevam(false);
                
            }
            setVisible(true);

        }
        
        public GameOver(Bot p){
            setSize(400,200);
            setLayout(new BorderLayout());
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JLabel label= new JLabel();
            panel.add(label,BorderLayout.CENTER);
            add(panel,BorderLayout.CENTER);

            if(p==bot1){
                label.setText("1. Bot Kazandı! Süresi: " + clock.toString());
                clock.setDevam(false);
                first_player.setDevam(false);
                second_player.setDevam(false);
                bot1.setDevam(false);
                bot2.setDevam(false);
                bot3.setDevam(false);
                bot4.setDevam(false);
                bot5.setDevam(false);
            }
            else if(p==bot2){
                label.setText("2. Bot Kazandı! Süresi: " + clock.toString());
                clock.setDevam(false);
                first_player.setDevam(false);
                second_player.setDevam(false);
                bot1.setDevam(false);
                bot2.setDevam(false);
                bot3.setDevam(false);
                bot4.setDevam(false);
                bot5.setDevam(false);
            }
            else if(p==bot3){
                label.setText("3. Bot Kazandı! Süresi: " + clock.toString());
                clock.setDevam(false);
                first_player.setDevam(false);
                second_player.setDevam(false);
                bot1.setDevam(false);
                bot2.setDevam(false);
                bot3.setDevam(false);
                bot4.setDevam(false);
                bot5.setDevam(false);
            }
            else if(p==bot4){
                label.setText("4. Bot Kazandı! Süresi: " + clock.toString());
                clock.setDevam(false);
                first_player.setDevam(false);
                second_player.setDevam(false);
                bot1.setDevam(false);
                bot2.setDevam(false);
                bot3.setDevam(false);
                bot4.setDevam(false);
                bot5.setDevam(false);
            }
            else if(p==bot5){
                label.setText("5. Bot Kazandı! Süresi: " + clock.toString());
                clock.setDevam(false);
                first_player.setDevam(false);
                second_player.setDevam(false);
                bot1.setDevam(false);
                bot2.setDevam(false);
                bot3.setDevam(false);
                bot4.setDevam(false);
                bot5.setDevam(false);
            }
            setVisible(true);

        }

    }
}
