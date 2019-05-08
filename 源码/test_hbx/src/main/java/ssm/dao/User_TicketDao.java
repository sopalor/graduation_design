package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;
import ssm.model.Ticket;
import ssm.model.User_Ticket;

import java.util.List;

public interface User_TicketDao {

    List<User_Ticket> selectAllMyTickets(@Param("id")String id);
    User_Ticket selectOneMyTickets(@Param("id")String id);
    int insertOneTicket(@Param("uid")String uid,@Param("tid") String tid,@Param("sit")Integer sit);
    List<Integer> selectSitList(@Param("id")String id);
    int deleteOneTicket(@Param("id")String id);
    int deleteAllTicket(@Param("id")String id);
}
