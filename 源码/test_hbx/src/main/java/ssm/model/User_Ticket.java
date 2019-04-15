package ssm.model;

public class User_Ticket {
    private String CId;
    private User UUser;
    private Ticket TTicket;
    private Integer NSit;

    @Override
    public String toString() {
        return "User_Ticket{" +
                "CId='" + CId + '\'' +
                ", UUser=" + UUser +
                ", TTicket=" + TTicket +
                ", NSit=" + NSit +
                '}';
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public User getUUser() {
        return UUser;
    }

    public void setUUser(User UUser) {
        this.UUser = UUser;
    }

    public Ticket getTTicket() {
        return TTicket;
    }

    public void setTTicket(Ticket TTicket) {
        this.TTicket = TTicket;
    }

    public Integer getNSit() {
        return NSit;
    }

    public void setNSit(Integer NSit) {
        this.NSit = NSit;
    }
}
