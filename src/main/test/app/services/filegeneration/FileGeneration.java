package app.services.filegeneration;

import app.models.Event;
import app.models.Role;
import app.models.User;
import app.models.enums.Rating;
import app.models.enums.RoleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration("/dispatcher-servlet.xml")*/
public class FileGeneration {

/*    @Autowired
    private ObjectMapper objectMapper;*/

    private ObjectMapper objectMapper = new ObjectMapper();

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    public void generateUsersFile() {
        Role role = new Role();
        role.setName(RoleEnum.RESGISTERED_USER.name());
        User userFirst = new User("FirstUserFN", "FirstUserLN", "FUemail@gmail.com", Date.valueOf(LocalDate.now()), bCryptPasswordEncoder.encode("FUpassword"), Arrays.asList(role));
        User userSecond = new User("SecondUserFN", "SecondUserLN", "SUemail@gmail.com", Date.valueOf(LocalDate.now().minusDays(10)), bCryptPasswordEncoder.encode("SUpassword"), Arrays.asList(role));
        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writer().writeValue(new File("C:\\TMP\\users.json"), Arrays.asList(userFirst,userSecond));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateEventsFile(){
        Event firstEvent = new Event("FirstEvent",100.00,Rating.LOW);
        Event secondEvent = new Event("SecondEvent", 200, Rating.HIGH);
        try {
            Path eventJsonPath = Paths.get("C:\\TMP\\events.json");
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writer().writeValue(new File(eventJsonPath.toString()), Arrays.asList(firstEvent,secondEvent));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
