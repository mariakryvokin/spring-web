package app.services.discounts;

import app.models.EventHasAuditorium;
import app.models.User;
import app.services.TicketService;
import app.services.UserService;
import app.services.discounts.TenthTicketStrategy;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.*;

import java.util.stream.Stream;

class TenthTicketStrategyTest {
    @Mock
    private TicketService ticketService;
    @InjectMocks
    private TenthTicketStrategy tenthTicketStrategy;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @MethodSource("getParametersForDiscount")
    void calculateDiscount(long amountOfBookedTickets,double totalPrice, double actualDiscount) {
        Mockito.when(ticketService.countBookedTicketByUserId(Mockito.anyLong())).thenReturn(amountOfBookedTickets);
        User user = new User();
        user.setId(1L);
        Assert.assertEquals(tenthTicketStrategy.calculateDiscount(user, new EventHasAuditorium(), amountOfBookedTickets, totalPrice), actualDiscount, 0.001);
    }

    public static Stream<Arguments> getParametersForDiscount() {
        return Stream.of(Arguments.of(11, 1100, 50),
                Arguments.of(1, 100, 0),
                Arguments.of(19, 1900, 50),
                Arguments.of(20, 2000, 100));
    }
}