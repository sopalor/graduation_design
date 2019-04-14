package ssm.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Ticket {
    private String  CId;
    private String  CCfd;
    private String  CMdd;
    private Date DRq;
    private Integer  NSyzw;
    private String  CHkgs;
    private Timestamp  DCfsj;
    private Timestamp DDdsj;
    private BigDecimal  NJg;

    @Override
    public String toString() {
        return "Ticket{" +
                "CId='" + CId + '\'' +
                ", CCfd='" + CCfd + '\'' +
                ", CMdd='" + CMdd + '\'' +
                ", DRq=" + DRq +
                ", NSyzw=" + NSyzw +
                ", CHkgs='" + CHkgs + '\'' +
                ", DCfsj=" + DCfsj +
                ", DDdsj=" + DDdsj +
                ", NJg=" + NJg +
                '}';
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCCfd() {
        return CCfd;
    }

    public void setCCfd(String CCfd) {
        this.CCfd = CCfd;
    }

    public String getCMdd() {
        return CMdd;
    }

    public void setCMdd(String CMdd) {
        this.CMdd = CMdd;
    }

    public Date getDRq() {
        return DRq;
    }

    public void setDRq(Date DRq) {
        this.DRq = DRq;
    }

    public Integer getNSyzw() {
        return NSyzw;
    }

    public void setNSyzw(Integer NSyzw) {
        this.NSyzw = NSyzw;
    }

    public String getCHkgs() {
        return CHkgs;
    }

    public void setCHkgs(String CHkgs) {
        this.CHkgs = CHkgs;
    }

    public Timestamp getDCfsj() {
        return DCfsj;
    }

    public void setDCfsj(Timestamp DCfsj) {
        this.DCfsj = DCfsj;
    }

    public Timestamp getDDdsj() {
        return DDdsj;
    }

    public void setDDdsj(Timestamp DDdsj) {
        this.DDdsj = DDdsj;
    }

    public BigDecimal getNJg() {
        return NJg;
    }

    public void setNJg(BigDecimal NJg) {
        this.NJg = NJg;
    }
}
