package modele;




import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 

public class mdp extends Observable implements Cloneable, Serializable  {

    private String mdp_log;
    private String mdp_pw;

    public mdp () {

    }

    public mdp (String mdp_logIn) {

          this.mdp_log = mdp_logIn;
          setChanged();
          notifyObservers();
    }


    public String getmdp_log() {
          return this.mdp_log;
    }
    public void setmdp_log(String mdp_logIn) {
          this.mdp_log = mdp_logIn;
          setChanged();
          notifyObservers();
    }

    public String getmdp_pw() {
          return this.mdp_pw;
    }
    public void setmdp_pw(String mdp_pwIn) {
          this.mdp_pw = mdp_pwIn;
          setChanged();
          notifyObservers();
    }



    public void setAll(String mdp_logIn,
          String mdp_pwIn) {
          this.mdp_log = mdp_logIn;
          this.mdp_pw = mdp_pwIn;
          setChanged();
          notifyObservers();
    }

    public boolean hasEqualMapping(mdp valueObject) {

          if (this.mdp_log == null) {
                    if (valueObject.getmdp_log() != null)
                           return(false);
          } else if (!this.mdp_log.equals(valueObject.getmdp_log())) {
                    return(false);
          }
          if (this.mdp_pw == null) {
                    if (valueObject.getmdp_pw() != null)
                           return(false);
          } else if (!this.mdp_pw.equals(valueObject.getmdp_pw())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass mdp, mapping to table mdp\n");
        out.append("Persistent attributes: \n"); 
        out.append("mdp_log = " + this.mdp_log + "\n"); 
        out.append("mdp_pw = " + this.mdp_pw + "\n"); 
        return out.toString();
    }

    public Object clone() {
        mdp cloned = new mdp();

        if (this.mdp_log != null)
             cloned.setmdp_log(new String(this.mdp_log)); 
        if (this.mdp_pw != null)
             cloned.setmdp_pw(new String(this.mdp_pw)); 
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}
