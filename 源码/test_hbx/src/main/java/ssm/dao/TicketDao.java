package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import ssm.model.Ticket;

import java.util.List;
@Service
public interface TicketDao {
    List<Ticket> selectAll();
    List<Ticket> selectAllByTj(@Param("cfd") String cfd,@Param("mdd") String mdd,@Param("rq")String rq);
    List<Ticket> selectAllByZhongLei(@Param("id")String id);
    int deleteTicketByid(@Param("id")String id);
    int insertOneTicket(Ticket ticket);
}
