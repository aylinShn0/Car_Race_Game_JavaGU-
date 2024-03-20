import java.util.Random;

public class Bot extends Thread {
    private int x;
    private int y;
    private int yon;
    private int speed;
    private Random random;
    private boolean first_c;
    private boolean second_c;
    private boolean thrid_c;
    private boolean fourth_c;
    private boolean devam=true;
    private CarRace race;
    private int heigth=10;
    private int width=10;
    private int x_tmp;
    private int y_tmp;

    public Bot(CarRace c) {
        random = new Random();
        race=c;
        first_c=false;
        second_c=false;
        thrid_c=false;
        fourth_c=false;
    }

    public boolean getFirst_c() {
        return this.first_c;
    }

    public void setFirst_c(boolean first_c) {
        this.first_c = first_c;
    }

    public boolean getSecond_c() {
        return this.second_c;
    }

    public void setSecond_c(boolean second_c) {
        this.second_c = second_c;
    }

    public boolean getThrid_c() {
        return this.thrid_c;
    }

    public void setThrid_c(boolean thrid_c) {
        this.thrid_c = thrid_c;
    }

    public boolean getFourth_c() {
        return this.fourth_c;
    }

    public void setFourth_c(boolean fourth_c) {
        this.fourth_c = fourth_c;
    }

    public boolean getDevam() {
        return this.devam;
    }

    public void setDevam(boolean devam) {
        this.devam = devam;
    }

    public int getX_tmp() {
        return this.x_tmp;
    }

    public void setX_tmp(int x_tmp) {
        this.x_tmp = x_tmp;
    }

    public int getY_tmp() {
        return this.y_tmp;
    }

    public void setY_tmp(int y_tmp) {
        this.y_tmp = y_tmp;
    }

    public int getYon() {
        return this.yon;
    }

    public void setYon(int yon) {
        this.yon = yon;
    }

    public Random getRandom() {
        return this.random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CarRace getRace() {
        return this.race;
    }

    public void setRace(CarRace race) {
        this.race = race;
    }

    public int getHeigth() {
        return this.heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void run(){
        while(devam){
            try {
                sleep(1000/speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(move()){
                x=x_tmp;
                y=y_tmp;
            }else move();
                race.panel.repaint();
                if(this.winner()){
                    CarRace.GameOver over = race.new GameOver(this);
                    devam=false;
                }
            }
        }

        public boolean winner(){
            if(first_c&&second_c&&thrid_c&&fourth_c&&(this.y<=390&&this.y>=380)&&(this.x>20 && this.x<170)){
                return true;
            }else return false;
        }

        public boolean move(){
            x_tmp=x;
            y_tmp=y;
            yon = random.nextInt(4);
            if(x<370&y<390){
                if(yon==1){
                x_tmp=x+1;
            }if(yon==0){
                y_tmp=y-1;
            }
            first_c=true;
            }
            if(x>=370&y<390){
                if(yon==1){
                x_tmp=x+1;
            }if(yon==2){
                y_tmp=y+1;
            }
            second_c=true;
            }
            if(x>=370& y>=390){
                if(yon==3){
                x_tmp=x-1;
            }if(yon==2){
                y_tmp=y+1;
            }
            thrid_c=true;
            }
            if(y>=390&x<370){
                if(yon==3){
                x_tmp=x-1;
            }if(yon==0){
                y_tmp=y-1;
            }
            fourth_c=true;
            }
            if(Math.pow(x_tmp-370,2)+ Math.pow(y_tmp-390, 2)<Math.pow(350, 2)&&Math.pow(x_tmp-370,2)+ Math.pow(y_tmp-390, 2)>Math.pow(200, 2)){
                return true;
            }else return false;
        }

    }


