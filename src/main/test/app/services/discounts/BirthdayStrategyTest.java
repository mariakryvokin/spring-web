package app.services.discounts;

import app.models.EventHasAuditorium;
import app.models.User;
import app.services.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class BirthdayStrategyTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private BirthdayStrategy birthdayStrategy;

    @BeforeEach
    public void init(){
        Mockito.when(userService.exists(Mockito.any())).thenReturn(true);
    }

    @ParameterizedTest
    @MethodSource("getBirthdayParameters")
    public void calculateDiscount(LocalDateTime birthday, LocalDateTime eventDateTime, boolean isInInterval) {
        User user = new User();
        user.setBirthday(Date.valueOf(birthday.toLocalDate()));
        EventHasAuditorium eventHasAuditorium = new EventHasAuditorium();
        eventHasAuditorium.setAirDate(Timestamp.valueOf(eventDateTime));
        if(isInInterval){
            Assert.assertEquals(birthdayStrategy.calculateDiscount(user,eventHasAuditorium,1,100),5, 0.001);
        }else {
            Assert.assertNotEquals(birthdayStrategy.calculateDiscount(user,eventHasAuditorium,1,100),5, 0.001);
        }
    }

    public static Stream<Arguments> getBirthdayParameters(){
        LocalDateTime nowDateTime = LocalDateTime.now();
        return Stream.of(Arguments.of(nowDateTime, nowDateTime.minusDays(5), true),
                Arguments.of(nowDateTime, nowDateTime.plusDays(5),true),
                Arguments.of(nowDateTime, nowDateTime.plusDays(6),false),
                Arguments.of(nowDateTime, nowDateTime.minusDays(6),false),
                Arguments.of(nowDateTime,nowDateTime, true),
                Arguments.of(nowDateTime, nowDateTime.plusDays(2), true));
    }
}