package ssm.dao;

import org.springframework.stereotype.Service;
import ssm.model.Ticket;

import java.util.List;
@Service
public interface TicketDao {
    List<Ticket> selectAll();
}
