public class motor {

    private int caballos;
    

    public motor(int caballos){
        this.caballos = caballos;
        
    }
    public void encender(){
        System.out.println("motor de " + caballos +"caballos");
    }

    @Override
    public String toString(){
        return "motor " + caballos + "Hp";
    }
}