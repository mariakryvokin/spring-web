package app.repositories;

import app.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query(value = "SELECT count (t.id) FROM tickets t where u.id=?1 and t.orders_id is null", nativeQuery = true)
    long countBookedTicketByUserId(long userId);

    @Query(value = "SELECT t.seat FROM tickets t where  t.auditoriums_name = ?1 and t.air_date=?2", nativeQuery = true)
    List<Integer> getAllByAuditoriumNameAndAirDateTime(String auditoriumName, Timestamp airDateTime);

    List<Ticket> findAllByUser_IdAndOrder_Id(Long userId, Long orderId);
}
