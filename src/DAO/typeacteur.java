package DAO;




import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;



public class typeacteur implements Cloneable, Serializable {

    private int typ_id;
    private String typ_lib;


    public typeacteur () {

    }

    public typeacteur (int typ_idIn) {

          this.typ_id = typ_idIn;

    }


    public int getTyp_id() {
          return this.typ_id;
    }
    public void setTyp_id(int typ_idIn) {
          this.typ_id = typ_idIn;
    }

    public String getTyp_lib() {
          return this.typ_lib;
    }
    public void setTyp_lib(String typ_libIn) {
          this.typ_lib = typ_libIn;
    }



    public void setAll(int typ_idIn,
          String typ_libIn) {
          this.typ_id = typ_idIn;
          this.typ_lib = typ_libIn;
    }

    public boolean hasEqualMapping(typeacteur valueObject) {

          if (valueObject.getTyp_id() != this.typ_id) {
                    return(false);
          }
          if (this.typ_lib == null) {
                    if (valueObject.getTyp_lib() != null)
                           return(false);
          } else if (!this.typ_lib.equals(valueObject.getTyp_lib())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass typeacteur, mapping to table typeacteur\n");
        out.append("Persistent attributes: \n"); 
        out.append("typ_id = " + this.typ_id + "\n"); 
        out.append("typ_lib = " + this.typ_lib + "\n"); 
        return out.toString();
    }

    public Object clone() {
        typeacteur cloned = new typeacteur();

        cloned.setTyp_id(this.typ_id); 
        if (this.typ_lib != null)
             cloned.setTyp_lib(new String(this.typ_lib)); 
        return cloned;
    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

