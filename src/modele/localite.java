package modele;





import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;



public class localite implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String loc_ins;
    private String loc_cp;
    private String loc_lib;

    public localite () {

    }

    public localite (String loc_insIn) {

          this.loc_ins = loc_insIn;

    }


    public String getLoc_ins() {
          return this.loc_ins;
    }
    public void setLoc_ins(String loc_insIn) {
          this.loc_ins = loc_insIn;
    }

    public String getLoc_cp() {
          return this.loc_cp;
    }
    public void setLoc_cp(String loc_cpIn) {
          this.loc_cp = loc_cpIn;
    }

    public String getLoc_lib() {
          return this.loc_lib;
    }
    public void setLoc_lib(String loc_libIn) {
          this.loc_lib = loc_libIn;
    }


    public void setAll(String loc_insIn,
          String loc_cpIn,
          String loc_libIn) {
          this.loc_ins = loc_insIn;
          this.loc_cp = loc_cpIn;
          this.loc_lib = loc_libIn;
    }

    public boolean hasEqualMapping(localite valueObject) {

          if (this.loc_ins == null) {
                    if (valueObject.getLoc_ins() != null)
                           return(false);
          } else if (!this.loc_ins.equals(valueObject.getLoc_ins())) {
                    return(false);
          }
          if (this.loc_cp == null) {
                    if (valueObject.getLoc_cp() != null)
                           return(false);
          } else if (!this.loc_cp.equals(valueObject.getLoc_cp())) {
                    return(false);
          }
          if (this.loc_lib == null) {
                    if (valueObject.getLoc_lib() != null)
                           return(false);
          } else if (!this.loc_lib.equals(valueObject.getLoc_lib())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass localite, mapping to table localite\n");
        out.append("Persistent attributes: \n"); 
        out.append("loc_ins = " + this.loc_ins + "\n"); 
        out.append("loc_cp = " + this.loc_cp + "\n"); 
        out.append("loc_lib = " + this.loc_lib + "\n"); 
        return out.toString();
    }

    public Object clone() {
        localite cloned = new localite();

        if (this.loc_ins != null)
             cloned.setLoc_ins(new String(this.loc_ins)); 
        if (this.loc_cp != null)
             cloned.setLoc_cp(new String(this.loc_cp)); 
        if (this.loc_lib != null)
             cloned.setLoc_lib(new String(this.loc_lib)); 
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

