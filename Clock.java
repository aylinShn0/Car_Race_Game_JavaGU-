public class Clock extends Thread {

    private int salise;
    private int saniye;
    private int dakika;
    private CarRace race;
    private boolean devam;
    public Clock(CarRace race){
        this.salise=0;
        this.saniye=0;
        this.dakika=0;
        this.race=race;
        devam=true;
    }
    
    public void run(){
        while(devam){
            try {
            sleep(1000/60);
            salise++;
            if(salise==59){
                salise=0;
                saniye++;
                if(saniye==59){
                    saniye=0;
                    dakika++;
                }
            }
            race.getLabel().setText(toString());
            } catch (Exception e) {
            }
        }
        
    }

    public String toString(){
        return dakika + ":" + saniye +":" + salise;
    }


    public int getSalise() {
        return this.salise;
    }

    public void setSalise(int salise) {
        this.salise = salise;
    }

    public int getSaniye() {
        return this.saniye;
    }

    public void setSaniye(int saniye) {
        this.saniye = saniye;
    }

    public int getDakika() {
        return this.dakika;
    }

    public void setDakika(int dakika) {
        this.dakika = dakika;
    }

    public CarRace getRace() {
        return this.race;
    }

    public void setRace(CarRace race) {
        this.race = race;
    }

    public boolean isDevam() {
        return this.devam;
    }

    public boolean getDevam() {
        return this.devam;
    }

    public void setDevam(boolean devam) {
        this.devam = devam;
    }

}
