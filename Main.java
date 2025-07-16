import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Autenticazione auth = new Autenticazione();
        Box.inizializzaBox(5);
        Box box = new Box(0);
        Boolean dentro = true;

        System.out.println("Benvenuto al sistema Locker!");

        while (dentro) {
            System.out.println("--- Menu ---");
            System.out.println("1. Admin");
            System.out.println("2. Deposita");
            System.out.println("3. Mostra lista box");
            System.out.println("4. Ritira");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Username: ");
                    String user = input.nextLine();
                    System.out.print("Password: ");
                    String pass = input.nextLine();
                    String token = auth.login(user, pass);

                    if (token != null) {
                        System.out.println(" Login riuscito!");
                        System.out.println("1. Libera un box");
                        System.out.println("2. Disabilita/ Abilita un box");
                        System.out.println("3. Assegnare manualmente un codice");
                        System.out.println("4. Logout/fermo attività");
                        System.out.print("Scegli:");
                        int adminScelta = input.nextInt();

                        Box.mostraStatoBox();
                            if (adminScelta == 1){
                                System.out.println("Inserisci il numero del box da liberare");
                                int nBox = input.nextInt();
                                Box.liberaBox(nBox);
                                break;
                                
                            }else if(adminScelta == 2){
                                System.out.println("Inserisci il numero del box");
                                int nBox2 = input.nextInt();
                                System.out.println("Per disabilitare premi 1");
                                System.out.println("Per abilitare premi 2");
                                int scelta2 = input.nextInt();
                                if(scelta2 == 1){
                                    Box.disabilitaBox(nBox2);
                                }else
                                    Box.abilitaBox(nBox2);
                                break;
                                
                            }else if(adminScelta == 3){
                                System.out.println("Che box vuoi occupare? : ");
                                int sceltaBox = input.nextInt();
                                System.out.println("Inserisci la password del box: ");
                                int passwordbox = input.nextInt();
                                box.prenotaBox(sceltaBox, passwordbox);
                                break;
                                
                            }else 
                                System.out.println("Logout/fermo attività");
                                dentro = false;
                                break;
                            }else{
                                System.out.println("Login non riuscito");
                            }
                            break;

                        case 2:
                            System.out.println("Che box vuoi utilizzare? : ");
                            int sceltaBox = input.nextInt();
                            System.out.println("Inserisci la password del box(4-6 cifre): ");
                            int passwordbox = input.nextInt();
                            box.prenotaBox(sceltaBox, passwordbox);
                            break;

                        case 3:
                            Box.mostraStatoBox();
                            break;

                        case 4:
                            System.out.println("Inserisci il numero del box che vuoi ritirare: ");
                            int sceltaBox2 = input.nextInt();
                            System.out.println("Inserisci la password del box: ");
                            int passwordbox2 = input.nextInt();
                            box.ritiraBox(sceltaBox2, passwordbox2);
                            break;

                        default:
                            System.out.println("Scelta non valida.");
            }
        }
    }
}