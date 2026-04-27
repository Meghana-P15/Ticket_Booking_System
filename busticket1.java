package p1;
import java.util.Scanner;
import java.io.*;

// ================= ARRAY CLASS =================
class TicketServiceArr {
    int size;
    int[] seatNumbers;
    int[] ticketNumbers;
    String[] routeCodes;
    String[] fareDetails;

    TicketServiceArr(int size) {
        this.size = size;

        seatNumbers = new int[size];
        ticketNumbers = new int[size];
        routeCodes = new String[size];
        fareDetails = new String[size];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < size; i++) {

            System.out.println("Passenger " + (i + 1));

            System.out.print("Seat Number: ");
            seatNumbers[i] = sc.nextInt();

            System.out.print("Ticket Number: ");
            ticketNumbers[i] = sc.nextInt();

            System.out.print("Route Code: ");
            routeCodes[i] = sc.next();

            System.out.print("Fare: ");
            fareDetails[i] = sc.next();
        }
    }

    void displayTickets() {

        System.out.println("\nTicket Details:");

        for (int i = 0; i < size; i++) {

            System.out.println("Seat: " + seatNumbers[i] +
                    " Ticket: " + ticketNumbers[i] +
                    " Route: " + routeCodes[i] +
                    " Fare: " + fareDetails[i]);
        }
    }
}

// ================= LINKED LIST NODE =================
class Passenger {
    int id;
    String name;
    Passenger next;
}

// ================= LINKED LIST =================
class PassengerList {

    Passenger head, cnode;

    void addPassenger(int id, String name) {

        Passenger newNode = new Passenger();
        newNode.id = id;
        newNode.name = name;

        if (head == null)
            head = newNode;
        else {

            cnode = head;

            while (cnode.next != null)
                cnode = cnode.next;

            cnode.next = newNode;
        }
    }

    Passenger removePassenger(int id) {

        if (head == null)
            return null;

        if (head.id == id) {
            Passenger temp = head;
            head = head.next;
            return temp;
        }

        cnode = head;

        while (cnode.next != null && cnode.next.id != id)
            cnode = cnode.next;

        if (cnode.next == null)
            return null;

        Passenger temp = cnode.next;
        cnode.next = temp.next;
        return temp;
    }

    Passenger removeFirst() {

        if (head == null)
            return null;

        Passenger temp = head;
        head = head.next;
        return temp;
    }

    int count() {

        int c = 0;
        Passenger temp = head;

        while (temp != null) {
            c++;
            temp = temp.next;
        }

        return c;
    }

    void display() {

        Passenger temp = head;

        while (temp != null) {
            System.out.println("ID: " + temp.id + " Name: " + temp.name);
            temp = temp.next;
        }
    }

    void saveToFile(String filename) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            Passenger temp = head;

            while (temp != null) {

                bw.write(temp.id + "," + temp.name);
                bw.newLine();
                temp = temp.next;
            }

            bw.close();

        } catch (Exception e) {
        }
    }

    void loadFromFile(String filename) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line;

            while ((line = br.readLine()) != null) {

                String p[] = line.split(",");

                int id = Integer.parseInt(p[0]);
                String name = p[1];

                addPassenger(id, name);
            }

            br.close();

        } catch (Exception e) {
        }
    }
}

// ================= STACK =================
class TicketStack {

    int stack[] = new int[100];
    int top = -1;

    void cancelTicket(int t) {

        stack[++top] = t;

        try {

            FileWriter fw = new FileWriter("stack.txt", true);
            fw.write(t + "\n");
            fw.close();

        } catch (Exception e) {
        }

        System.out.println("Ticket Cancelled: " + t);
    }

    void undoCancel() {

        if (top == -1) {
            System.out.println("Stack Empty");
            return;
        }

        int t = stack[top--];

        System.out.println("Undo Ticket: " + t);
    }

    void displayHistory() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("stack.txt"));
            String line;

            System.out.println("Cancelled Tickets History:");

            while ((line = br.readLine()) != null)
                System.out.println(line);

            br.close();

        } catch (Exception e) {
        }
    }
}

// ================= QUEUE =================
class QueueNode {
    int passengerId;
    QueueNode next;
}

class TicketQueue {

    QueueNode front, rear;

    void enqueue(int id) {

        QueueNode newNode = new QueueNode();
        newNode.passengerId = id;

        if (rear == null)
            front = rear = newNode;
        else {

            rear.next = newNode;
            rear = newNode;
        }

        try {

            FileWriter fw = new FileWriter("queue.txt", true);
            fw.write(id + "\n");
            fw.close();

        } catch (Exception e) {
        }

        System.out.println("Passenger Added: " + id);
    }

    void dequeue() {

        if (front == null) {
            System.out.println("Queue Empty");
            return;
        }

        int id = front.passengerId;
        front = front.next;

        System.out.println("Passenger Processed: " + id);
    }

    void displayHistory() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("queue.txt"));
            String line;

            System.out.println("Queue History:");

            while ((line = br.readLine()) != null)
                System.out.println(line);

            br.close();

        } catch (Exception e) {
        }
    }
}

// ================= SEARCH =================
class TicketSearch {

    int arr[];

    TicketSearch(int a[]) {
        arr = a;
    }

    int binarySearch(int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;

            else if (arr[mid] < key)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }

    // SAVE TICKETS
    void saveToFile() {

        try {

            FileWriter fw = new FileWriter("tickets.txt");

            for (int i = 0; i < arr.length; i++) {
                fw.write(arr[i] + "\n");
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("Error saving tickets");
        }
    }

    // LOAD TICKETS
    int[] loadFromFile() {

        int temp[] = new int[100];
        int count = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader("tickets.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                temp[count++] = Integer.parseInt(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No previous ticket file");
        }

        int arr2[] = new int[count];

        for (int i = 0; i < count; i++)
            arr2[i] = temp[i];

        return arr2;
    }
}

// ================= SORTING =================
class MergeSort {

    void sort(int arr[], int l, int r) {

        if (l < r) {

            int mid = (l + r) / 2;

            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // SAVE SORTED SEATS
    void saveToFile(int arr[]) {

        try {

            FileWriter fw = new FileWriter("seats.txt");

            for (int i = 0; i < arr.length; i++)
                fw.write(arr[i] + "\n");

            fw.close();

        } catch (Exception e) {
            System.out.println("Error saving seats");
        }
    }

    // LOAD PREVIOUS SEATS
    int[] loadFromFile() {

        int temp[] = new int[100];
        int count = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader("seats.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                temp[count++] = Integer.parseInt(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No previous seat file");
        }

        int arr[] = new int[count];

        for (int i = 0; i < count; i++)
            arr[i] = temp[i];

        return arr;
    }
}

// ================= MAIN CLASS =================
public class busticket1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicketServiceArr ts = new TicketServiceArr(3);
        ts.displayTickets();

        PassengerList confirmed = new PassengerList();
        PassengerList waiting = new PassengerList();

        TicketStack stack = new TicketStack();
        TicketQueue queue = new TicketQueue();

        confirmed.loadFromFile("confirmed.txt");
        waiting.loadFromFile("waiting.txt");

        System.out.println("\nEnter max seats:");
        int maxseats = sc.nextInt();

        int choice;

        do {

            System.out.println("\n------ BUS TICKET SYSTEM ------");
            System.out.println("1 Book Passenger");
            System.out.println("2 Cancel Passenger");
            System.out.println("3 Display Confirmed");
            System.out.println("4 Display Waiting");
            System.out.println("5 Stack Operations");
            System.out.println("6 Queue Operations");
            System.out.println("7 Search Ticket");
            System.out.println("8 Sort Seats");
            System.out.println("9 Exit");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Passenger ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Passenger Name: ");
                String name = sc.next();

                if (confirmed.count() < maxseats) {

                    confirmed.addPassenger(id, name);
                    System.out.println("Ticket CONFIRMED");

                } else {

                    waiting.addPassenger(id, name);
                    System.out.println("Added to WAITING LIST");
                }

                break;

            case 2:

                System.out.print("Enter Passenger ID to cancel: ");
                int cid = sc.nextInt();

                Passenger removed = confirmed.removePassenger(cid);

                if (removed != null) {

                    System.out.println("Cancelled from CONFIRMED");

                    Passenger w = waiting.removeFirst();

                    if (w != null) {

                        confirmed.addPassenger(w.id, w.name);
                        System.out.println("Waiting passenger moved to CONFIRMED");
                    }

                } else {

                    Passenger rw = waiting.removePassenger(cid);

                    if (rw != null)
                        System.out.println("Cancelled from WAITING");
                    else
                        System.out.println("Passenger not found");
                }

                break;

            case 3:

                System.out.println("\nConfirmed List:");
                confirmed.display();
                break;

            case 4:

                System.out.println("\nWaiting List:");
                waiting.display();
                break;

            case 5:

                int ch;

                do {

                    System.out.println("\n--- Stack Menu ---");
                    System.out.println("1 Cancel Ticket");
                    System.out.println("2 Undo Cancel");
                    System.out.println("3 Show History");
                    System.out.println("4 Back");

                    ch = sc.nextInt();

                    if (ch == 1) {

                        System.out.print("Enter Ticket Number: ");
                        int t = sc.nextInt();
                        stack.cancelTicket(t);

                    } else if (ch == 2) {

                        stack.undoCancel();

                    } else if (ch == 3) {

                        stack.displayHistory();
                    }

                } while (ch != 4);

                break;

            case 6:

                int q;

                do {

                    System.out.println("\n--- Queue Menu ---");
                    System.out.println("1 Add Passenger");
                    System.out.println("2 Process Passenger");
                    System.out.println("3 Queue History");
                    System.out.println("4 Back");

                    q = sc.nextInt();

                    if (q == 1) {

                        System.out.print("Enter Passenger ID: ");
                        int pid = sc.nextInt();
                        queue.enqueue(pid);

                    } else if (q == 2) {

                        queue.dequeue();

                    } else if (q == 3) {

                        queue.displayHistory();
                    }

                } while (q != 4);

                break;

            case 7:

                TicketSearch search = new TicketSearch(new int[0]);

                int oldTickets[] = search.loadFromFile();

                if (oldTickets.length > 0) {

                    System.out.println("Previously Stored Tickets:");

                    for (int i = 0; i < oldTickets.length; i++)
                        System.out.print(oldTickets[i] + " ");

                    System.out.println();
                }

                System.out.print("Enter number of new tickets: ");
                int n = sc.nextInt();

                int arr[] = new int[n];

                System.out.println("Enter ticket numbers in sorted order:");

                for (int i = 0; i < n; i++)
                    arr[i] = sc.nextInt();

                search = new TicketSearch(arr);

                search.saveToFile();

                System.out.print("Enter ticket number to search: ");
                int key = sc.nextInt();

                int res = search.binarySearch(key);

                if (res != -1)
                    System.out.println("Ticket FOUND at index " + res);
                else
                    System.out.println("Ticket NOT FOUND");

                break;

            case 8:

                MergeSort ms = new MergeSort();

                int oldSeats[] = ms.loadFromFile();

                if (oldSeats.length > 0) {

                    System.out.println("Previously Sorted Seats:");

                    for (int i = 0; i < oldSeats.length; i++)
                        System.out.print(oldSeats[i] + " ");

                    System.out.println();
                }

                System.out.print("Enter number of seats: ");
                int n1 = sc.nextInt();

                int seats[] = new int[n1];

                System.out.println("Enter seat numbers:");

                for (int i = 0; i < n1; i++)
                    seats[i] = sc.nextInt();

                ms.sort(seats, 0, n1 - 1);

                System.out.println("Sorted Seats:");

                for (int i = 0; i < n1; i++)
                    System.out.print(seats[i] + " ");

                ms.saveToFile(seats);

                break;

            case 9:

                confirmed.saveToFile("confirmed.txt");
                waiting.saveToFile("waiting.txt");

                System.out.println("Data saved. Exiting...");
                break;
            }

        } while (choice != 9);

        sc.close();
    }
}
