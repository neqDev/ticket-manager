package pl.ticket.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.ticket.common.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
    @Query("SELECT o FROM Order o WHERE o.id = :id")
    Order findOrderById(@Param("id") Long id);
}
