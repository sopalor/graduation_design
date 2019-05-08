package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import ssm.model.Ticket;

import java.util.List;
@Service
public interface TicketDao {
    List<Ticket> selectAll();
    List<Ticket> selectAll1();
    List<Ticket> selectAllByTj(@Param("cfd") String cfd,@Param("mdd") String mdd,@Param("rq")String rq);
    List<Ticket> selectAllByTj1(@Param("cfd") String cfd,@Param("mdd") String mdd,@Param("rq")String rq);
    List<Ticket> selectAllByTj2(@Param("cfd") String cfd,@Param("mdd") String mdd,@Param("rq")String rq);
    List<Ticket> selectAllByZhongLei(@Param("id")String id);
    Ticket selectAllById(@Param("id")String id);
    List<Ticket> selectAllDiscount();
    int deleteTicketByid(@Param("id")String id);
    int insertOneTicket(Ticket ticket);
    int updateOneTicket(Ticket ticket);
    List<String> selectCfdList();
    List<String> selectMddList();
    List<String> selectRqList();
    List<String> selectCfdList1();
    List<String> selectMddList1();
    List<String> selectRqList1();
    List<String> selectCfdList2();
    List<String> selectMddList2();
    List<String> selectRqList2();

}
