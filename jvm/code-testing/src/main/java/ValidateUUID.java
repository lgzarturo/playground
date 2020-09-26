import java.util.UUID;

public class ValidateUUID {
    public static void main(String[] args) {
        String[] uuids = {
            "a6404c74-747a-46d5-bdc3-cc505c6bab31",
            "ac72804a-ffa7-11ea-adc1-0242ac120002",
            "77da92db-0791-491e-8c58-1a969e67d2fe",
            "4q88DvL",
            "4e027544-5a95-4760-97e9-0b454442ab7b",
            "dv3573mF",
            "e0a08259-409c-4fa0-aa31-36746ef3dfed",
            "8nGQFIST",
            "3b97a861-e64c-46e2-ab82-3235dc05d79a",
            "station",
            "123456789012345678901234567890123456",
            "1h6o",
            "a36a27e1-820d-4e61-8038-a0cf26882790",
            "58728b69-0cd2-42a6-8d00-",
            "addon",
            "account/3b97a861-e64c-46e2-ab82-3235dc05d79a/add/9/MXN/web",
            "3b97a861-e64c-46e2-ab82-3235dc05d79a-addon-9-MXN-web",
            UUID.fromString("3b97a861-e64c-46e2-ab82-3235dc05d79a").toString(),
            UUID.randomUUID().toString(),
            UUID.nameUUIDFromBytes("Example UUID".getBytes()).toString()
        };

        int index = 1;
        for(String uuid : uuids) {
            System.out.println(index + ". " + isUUID(uuid));
            index += 1;
        }
    }

    static boolean isUUID(String string) {
        try {
            int version = UUID.fromString(string).version();
            System.out.println(string + " V"+4);
            return version >= 1 && version <= 4;
        } catch (Exception ex) {
            return false;
        }
    }
}
