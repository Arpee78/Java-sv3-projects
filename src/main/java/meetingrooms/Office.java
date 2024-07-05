package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(String name, int width, int length) {
        MeetingRoom meetingRoom = new MeetingRoom(name, width, length);
        meetingRooms.add(meetingRoom);
    }

    public List<MeetingRoom> getMeetingRooms() {
        return new ArrayList<>(meetingRooms);
    }

    public List<MeetingRoom> getMeetingRoomsInReverseOrder() {
        List<MeetingRoom> result = new ArrayList<>();
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            result.add(meetingRooms.get(i));
        }
        return result;
    }

    public List<MeetingRoom> getEverySecondMeetingRoom(int number) {
        List<MeetingRoom> result = new ArrayList<>();
        for (int i = number - 1; i < meetingRooms.size(); i += 2) {
            result.add(meetingRooms.get(i));
        }
        return result;
    }

    public MeetingRoom getMeetingRoomWithGivenName(String name) {
        for (MeetingRoom actual : meetingRooms) {
            if (actual.getName().equals(name)) {
                return actual;
            }
        }
        return null;
    }

    public List<MeetingRoom> getMeetingRoomsWithGivenNamePart(String namePart) {
        List<MeetingRoom> result = new ArrayList<>();
        for (MeetingRoom actual : meetingRooms) {
            if (actual.getName().contains(namePart)) {
                result.add(actual);
            }
        }
        return result;
    }

    public List<MeetingRoom> getMeetingRoomsWithAreaLargerThan(int area) {
        List<MeetingRoom> result = new ArrayList<>();
        for (MeetingRoom actual : meetingRooms) {
            if (actual.getArea() > area) {
                result.add(actual);
            }
        }
        return result;
    }


}
