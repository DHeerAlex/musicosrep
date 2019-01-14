package DAO;



import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;


public class droits implements Cloneable, Serializable {

    private String dro_log;
    private String dro_app;
    private String dro_aut;


    public droits () {

    }

    public droits (String dro_logIn) {

          this.dro_log = dro_logIn;

    }

    public String getDro_log() {
          return this.dro_log;
    }
    public void setDro_log(String dro_logIn) {
          this.dro_log = dro_logIn;
    }

    public String getDro_app() {
          return this.dro_app;
    }
    public void setDro_app(String dro_appIn) {
          this.dro_app = dro_appIn;
    }

    public String getDro_aut() {
          return this.dro_aut;
    }
    public void setDro_aut(String dro_autIn) {
          this.dro_aut = dro_autIn;
    }


    public void setAll(String dro_logIn,
          String dro_appIn,
          String dro_autIn) {
          this.dro_log = dro_logIn;
          this.dro_app = dro_appIn;
          this.dro_aut = dro_autIn;
    }

    public boolean hasEqualMapping(droits valueObject) {

          if (this.dro_log == null) {
                    if (valueObject.getDro_log() != null)
                           return(false);
          } else if (!this.dro_log.equals(valueObject.getDro_log())) {
                    return(false);
          }
          if (this.dro_app == null) {
                    if (valueObject.getDro_app() != null)
                           return(false);
          } else if (!this.dro_app.equals(valueObject.getDro_app())) {
                    return(false);
          }
          if (this.dro_aut == null) {
                    if (valueObject.getDro_aut() != null)
                           return(false);
          } else if (!this.dro_aut.equals(valueObject.getDro_aut())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass droits, mapping to table droits\n");
        out.append("Persistent attributes: \n"); 
        out.append("dro_log = " + this.dro_log + "\n"); 
        out.append("dro_app = " + this.dro_app + "\n"); 
        out.append("dro_aut = " + this.dro_aut + "\n"); 
        return out.toString();
    }

    public Object clone() {
        droits cloned = new droits();

        if (this.dro_log != null)
             cloned.setDro_log(new String(this.dro_log)); 
        if (this.dro_app != null)
             cloned.setDro_app(new String(this.dro_app)); 
        if (this.dro_aut != null)
             cloned.setDro_aut(new String(this.dro_aut)); 
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

