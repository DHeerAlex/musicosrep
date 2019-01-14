package modele;



import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;


public class propose implements Cloneable, Serializable {

    private int ser_id;
    private String act_log;
    private BigDecimal pro_tar;
    private String pro_typ;


    public propose () {

    }

    public propose (int ser_idIn) {

          this.ser_id = ser_idIn;

    }


    public int getSer_id() {
          return this.ser_id;
    }
    public void setSer_id(int ser_idIn) {
          this.ser_id = ser_idIn;
    }

    public String getAct_log() {
          return this.act_log;
    }
    public void setAct_log(String act_logIn) {
          this.act_log = act_logIn;
    }

    public BigDecimal getPro_tar() {
          return this.pro_tar;
    }
    public void setPro_tar(BigDecimal pro_tarIn) {
          this.pro_tar = pro_tarIn;
    }

    public String getPro_typ() {
          return this.pro_typ;
    }
    public void setPro_typ(String pro_typIn) {
          this.pro_typ = pro_typIn;
    }


    public void setAll(int ser_idIn,
          String act_logIn,
          BigDecimal pro_tarIn,
          String pro_typIn) {
          this.ser_id = ser_idIn;
          this.act_log = act_logIn;
          this.pro_tar = pro_tarIn;
          this.pro_typ = pro_typIn;
    }

    public boolean hasEqualMapping(propose valueObject) {

          if (valueObject.getSer_id() != this.ser_id) {
                    return(false);
          }
          if (this.act_log == null) {
                    if (valueObject.getAct_log() != null)
                           return(false);
          } else if (!this.act_log.equals(valueObject.getAct_log())) {
                    return(false);
          }
          if (this.pro_tar == null) {
                    if (valueObject.getPro_tar() != null)
                           return(false);
          } else if (!this.pro_tar.equals(valueObject.getPro_tar())) {
                    return(false);
          }
          if (this.pro_typ == null) {
                    if (valueObject.getPro_typ() != null)
                           return(false);
          } else if (!this.pro_typ.equals(valueObject.getPro_typ())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass propose, mapping to table propose\n");
        out.append("Persistent attributes: \n"); 
        out.append("ser_id = " + this.ser_id + "\n"); 
        out.append("act_log = " + this.act_log + "\n"); 
        out.append("pro_tar = " + this.pro_tar + "\n"); 
        out.append("pro_typ = " + this.pro_typ + "\n"); 
        return out.toString();
    }

    public Object clone() {
        propose cloned = new propose();

        cloned.setSer_id(this.ser_id); 
        if (this.act_log != null)
             cloned.setAct_log(new String(this.act_log)); 
        if (this.pro_tar != null)
             cloned.setPro_tar(new BigDecimal(this.pro_tar.doubleValue())); 
        if (this.pro_typ != null)
             cloned.setPro_typ(new String(this.pro_typ)); 
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

