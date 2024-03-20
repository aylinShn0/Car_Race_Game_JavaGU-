public class Player extends Thread{
    private int x;
    private int y;
    private int heigth=10;
    private int width=10;
    private char current_char;
    private int current_int;
    private CarRace race;
    private boolean first_c;
    private boolean second_c;
    private boolean thrid_c;
    private boolean fourth_c;
    private boolean devam=true;

    public Player(CarRace c){
        this.race=c;
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

    public char getCurrent_char() {
        return this.current_char;
    }

    public void setCurrent_char(char current_char) {
        this.current_char = current_char;
    }

    public void run(){
        int x_tmp=x;
        int y_tmp=y;
        while(devam){
            
            if(current_char=='w'|| current_int==38){
            y_tmp=y-2;
            }
            if(current_char=='a'|| current_int==37){
            x_tmp=x-2;
            }
            if(current_char=='s'|| current_int==40){
            y_tmp=y+2;
            }
            if(current_char=='d'|| current_int==39){
            x_tmp=x+2;
            }
            try {
                sleep(25);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            if(Math.pow(x_tmp-370,2)+ Math.pow(y_tmp-390, 2)<Math.pow(350, 2)& Math.pow(x_tmp-370,2)+ Math.pow(y_tmp-390, 2)>Math.pow(200, 2)){
                x=x_tmp;
                y=y_tmp;
            }

            if(x<370&&y<390){
            first_c=true;
            }
            if(x>=370&&y<390){
            second_c=true;
            }
            if(x>=370&&y>=390){
            thrid_c=true;
            }
            if(y>=390&&x<370){
            fourth_c=true;
            }
            race.panel.repaint();

            if(this.winner()){
                CarRace.GameOver over = race.new GameOver(this);
                devam=false;

            }
        }
    }

    public int getCurrent_int() {
        return this.current_int;
    }

    public void setCurrent_int(int current_int) {
        this.current_int = current_int;
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

    public boolean winner(){
        if(first_c&&second_c&&thrid_c&&fourth_c&&(this.y<=390&&this.y>=380)&&(this.x>20 && this.x<170)){
            return true;
        }else return false;
    }
}


