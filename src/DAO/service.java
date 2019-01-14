package DAO;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;


public class service implements Cloneable, Serializable {

    private int ser_id;
    private String ser_lib;


    public service () {

    }

    public service (int ser_idIn) {

          this.ser_id = ser_idIn;

    }


    public int getSer_id() {
          return this.ser_id;
    }
    public void setSer_id(int ser_idIn) {
          this.ser_id = ser_idIn;
    }

    public String getSer_lib() {
          return this.ser_lib;
    }
    public void setSer_lib(String ser_libIn) {
          this.ser_lib = ser_libIn;
    }


    public void setAll(int ser_idIn,
          String ser_libIn) {
          this.ser_id = ser_idIn;
          this.ser_lib = ser_libIn;
    }

    public boolean hasEqualMapping(service valueObject) {

          if (valueObject.getSer_id() != this.ser_id) {
                    return(false);
          }
          if (this.ser_lib == null) {
                    if (valueObject.getSer_lib() != null)
                           return(false);
          } else if (!this.ser_lib.equals(valueObject.getSer_lib())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass service, mapping to table service\n");
        out.append("Persistent attributes: \n"); 
        out.append("ser_id = " + this.ser_id + "\n"); 
        out.append("ser_lib = " + this.ser_lib + "\n"); 
        return out.toString();
    }

    public Object clone() {
        service cloned = new service();

        cloned.setSer_id(this.ser_id); 
        if (this.ser_lib != null)
             cloned.setSer_lib(new String(this.ser_lib)); 
        return cloned;
    }



    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

