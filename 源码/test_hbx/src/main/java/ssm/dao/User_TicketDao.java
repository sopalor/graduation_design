package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.model.Ticket;
import ssm.model.User_Ticket;

import java.util.List;

public interface User_TicketDao {

    List<User_Ticket> selectAllMyTickets(@Param("id")String id);
}
