public class Box {
    private static Box[] boxArray;
    private int[] Arraypass = new int[5];

    public int id;
    public boolean occupato; 
    public boolean disabilitato;

    public Box(int id) {
        this.id = id;
        this.occupato = false;
        this.disabilitato = false;
    }

    private Boolean getDisabilitato(){
        return disabilitato;
    }

    private void setDisabilitato(boolean disabilitato){
        this.disabilitato = disabilitato;
    }


    private Boolean getOccupato(){
        return occupato;
    }
    private int getId() {
        return id;
    }

    private void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }     

    public static void inizializzaBox(int numeroBox) {
        boxArray = new Box[numeroBox];
        for (int i = 0; i < numeroBox; i++) {
            boxArray[i] = new Box(i + 1);
        }
    }

    public static void mostraStatoBox() {
        System.out.println("Stato dei box: "); 
        for (Box box : boxArray) {
            if (box.getDisabilitato()){
                System.out.println("Disabilitato");
                }else if(box.getOccupato()){
                    System.out.println("Occupato");
                    }else
                        System.out.println("Disponibile");
        } 
    }

    public boolean ritiraBox(int sceltaBox2, int passwordbox){
        if (boxArray[sceltaBox2 -1].getOccupato()) {
            if(Arraypass[sceltaBox2 -1]  == passwordbox){
                System.out.println("Sportello aperto, riponi l'oggetto");
                boxArray[sceltaBox2 -1].setOccupato(false);
                return false;
            }else
                System.out.println("Contattare assistenza!");
        }else
            System.out.println("Box vuoto. Riprovare un altro box.");
        return true;
    }

    public  boolean prenotaBox(int sceltaBox, int passwordbox2) {
        if(boxArray[sceltaBox -1].getDisabilitato()){
            System.out.println("Box Disabilitato");
            return true;
            }else if (boxArray[sceltaBox -1].getOccupato()) {
                System.out.println("Box non disponibile.");
                return false;
                }else
                    boxArray[sceltaBox -1].setOccupato(true);
                    System.out.println(" Hai prenotato il box " + boxArray[sceltaBox -1].getId());
                    Arraypass[sceltaBox -1] = 0;
                    Arraypass[sceltaBox -1] = passwordbox2;
                    return true;
    }
    
    public static void liberaBox(int nBox) {
        boxArray[nBox -1].setOccupato(false);
    }

    public static void disabilitaBox(int nBox){
        boxArray[nBox -1].setDisabilitato(true);
        System.out.println("Box disabilitato");
    }

    public static void abilitaBox(int nBox){
        boxArray[nBox -1].setDisabilitato(false);
        System.out.println("Box abilitato");
    }
}