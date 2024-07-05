package meetingrooms;

import java.util.List;
import java.util.Scanner;

public class MeetingRoomController {

    private Office office = new Office();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new MeetingRoomController().runMenu();
    }

    private void runMenu() {
        System.out.print("Üdvözöljük! Hány tárgyalót szeretne rögzíteni? ");
        int meetingroomCount = scanner.nextInt();
        scanner.nextLine();

        readMeetingRooms(meetingroomCount);

        boolean run = true;
        while(run){
            printMenu();

            int menuItem = scanner.nextInt();
            scanner.nextLine();

            run=chooseMenuItem(menuItem);
        }

    }

    private boolean chooseMenuItem(int menuItem) {

        switch (menuItem) {
            case 1:
                System.out.println("A tárgyalók neve sorrendben:");
                printNames(office.getMeetingRooms());
                break;
            case 2:
                System.out.println("A tárgyalók neve fordított sorrendben:");
                printNames(office.getMeetingRoomsInReverseOrder());
                break;
            case 3:
                System.out.print("A páratlan(1) vagy a páros(2) tárgyalókat szeretné lekérni? ");
                int number = scanner.nextInt();
                scanner.nextLine();
                printNames(office.getEverySecondMeetingRoom(number));
                System.out.println(number==1 ? "A páratlan számú tárgyalók:" : "A páros számú tárgyalók:");
                break;
            case 4:
                System.out.println("A rendszerben található tárgyalók adatai: ");
                printMeetingRooms(office.getMeetingRooms());
                break;
            case 5:
                System.out.print("Add meg a tárgyaló nevét: ");
                String name = scanner.nextLine();
                System.out.println("A kért tárgyaló adatai:");
                printMeetingRoom(office.getMeetingRoomWithGivenName(name));
                break;
            case 6:
                System.out.print("Add meg a névtöredéket, amely alapján keresni szeretne: ");
                String namePart = scanner.nextLine();
                System.out.println("A kért tárgyalók adatai:");
                printMeetingRooms(office.getMeetingRoomsWithGivenNamePart(namePart));
                break;
            case 7:
                System.out.print("Add meg a területet amelynél nagyobb tárgyalókra kíváncsi: ");
                int area = scanner.nextInt();
                scanner.nextLine();
                printMeetingRooms(office.getMeetingRoomsWithAreaLargerThan(area));
                break;
            case 8:
                System.out.println("Viszontlátásra!");
                return false;
            default:
                System.out.println("Ismeretlen menüpont");
        }

        return true;
    }

    private void printMeetingRooms(List<MeetingRoom> meetingRooms) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            printMeetingRoom(meetingRoom);
        }
    }

    private void printMeetingRoom(MeetingRoom meetingRoom) {
        System.out.print("Név: " + meetingRoom.getName() + ", ");
        System.out.print("szélesség: " + meetingRoom.getWidth() + " m, ");
        System.out.print("hosszúság: " + meetingRoom.getLength() + " m, ");
        System.out.print("terület: " + meetingRoom.getArea() + " m2");
        System.out.println();
    }

    private void printNames(List<MeetingRoom> meetingRooms) {

        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName() + " ");
        }
    }

    private void readMeetingRooms(int meetingroomCount) {
        for (int i = 1; i <= meetingroomCount; i++) {

            System.out.println("Adja meg a " + i + ". tárgyaló adatait:");

            System.out.print("Név: ");
            String name = scanner.nextLine();

            System.out.print("Szélesség: ");
            int width = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Hosszúság: ");
            int length = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            office.addMeetingRoom(name, width, length);
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Válassz az alábbi opciók közül:");

        System.out.println("1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafele sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján\n" +
                "8. Kilépés");
    }
}
