import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ArrayList<String> lista = new ArrayList<>(); //lista

        while (running) {
            System.out.println("---MENU---\n 1. Dodaj Element\n 2. Usuń element\n 3. Edytuj Element\n 4. Pokaż liste\n 5. Wyjdź");
            int choice = czytajLiczbe(scanner, "Wybierz opcje: ");

            switch (choice) {
                case 1:
                    dodajElement(scanner, lista);
                    break;

                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("Lista jest pusta nic do usuniecia ");
                    }else{
                    usunElement(scanner, lista);
                    }
                    break;

                case 3:
                    if (lista.isEmpty()) {
                        System.out.println("Lista jest pusta nic do edycji ");
                    }else{
                    edytujElement(scanner, lista);
                    }
                    break;

                case 4:
                    pokazliste(lista);
                    break;

                case 5:
                    running = false;
                    System.out.print("Koniec Programu");
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór");
                }
            }
        scanner.close();
        }
            //1. dodawanie Elementów
            public static void dodajElement(Scanner scanner ,ArrayList<String> lista) {

                    int n = czytajLiczbe(scanner, "Ile chcesz dodać nowych elementów listy? (wpisz anuluj aby cofnąć): ");

                    if (n == -1) { //anulowanie
                        return;
                    }
                        System.out.println("Podaj " + n + " nowych elementów");
                        for (int i = 0; i < n; i++) {
                            String nowyElement = scanner.nextLine(); // czyta wartość
                            lista.add(nowyElement); //dodaje nowy element
                            System.out.println("Dodano " + nowyElement + " pozostało " + (n- i - 1));
                        }
            }

            //2. usuwanie Elementów
            public static void usunElement(Scanner scanner ,ArrayList<String> lista) {
                while (true) {
                    pokazliste(lista);
                    int n = czytajLiczbe(scanner, "który Element chcesz Usunąć (wpisz anuluj aby cofnąć): ");

                    if (n == -1) { //anulowanie
                        return;
                    }

                    int indeks = n - 1;

                    if (indeks < 0 || indeks >= lista.size()) {
                        System.out.println("Nieprawidłowy numer pozycji!");
                        continue;
                    }
                        System.out.println("Usunieto " + n + " Element o wartości " + lista.get(indeks));
                        lista.remove(indeks); //usuwa element
                        break;
                    }
                }

            //3. Edycja Elementów
            public static void edytujElement(Scanner scanner ,ArrayList<String> lista) {
                while(true){
                pokazliste(lista);
                    int n = czytajLiczbe(scanner, "który Element chcesz edytować (wpisz anuluj aby cofnąć): ");

                    if (n == -1) { //anulowanie
                        return;
                    }

                    int indeks = n-1; //konwersja na indeks 1++

                    if (indeks < 0 || indeks >= lista.size()) {
                        System.out.println("Nieprawidłowy numer pozycji!");
                    }else {
                        System.out.print("Podaj Wartość " + n + " :");
                        String text = scanner.nextLine(); //czytanie wartości
                        lista.set(indeks, text); //podmiana
                        System.out.println("Edytowano "+ n +" linię o wartość " + text);
                        pokazliste(lista);
                        System.out.print("Koniec? (tak/nie): ");
                        String koniec = scanner.nextLine().toLowerCase();
                        if (koniec.equals("tak")) {
                            break;
                        }
                    }
                }
            }
            //funkcja odpowiedzialna za pokazanie listy
            public static void pokazliste (ArrayList<String> lista){
            if (lista.isEmpty()){
                System.out.println("Lista jest pusta ");
            }else
                for (int i = 0; i < lista.size(); i++) {
                    System.out.println((i+1) +": " +lista.get(i));
                }

            }
            //funkcja sprawdzajaca liczbe czy spełnia warunki
        public static int czytajLiczbe (Scanner scanner ,String komunikat){
        while(true){
            System.out.print(komunikat);
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.equals("anuluj")) {
                return -1;
            }
            if (input.isEmpty()){
                System.out.println("Brak wartości");
                continue;
            }

            if (!input.matches("\\d+")) {
                System.out.println("Wykryto wartość, która nie jest liczbą.");
                continue;
            }

            try {
                int liczba = Integer.parseInt(input);
                return liczba;
            } catch (NumberFormatException e) {
                System.out.println("Wystąpił błąd przy konwersji liczby.");
            }

        }
    }
}


