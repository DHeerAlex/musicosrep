package modele;





import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;


public class acteur implements Cloneable, Serializable {

    private String act_log;
    private String act_nom;
    private String act_pre;
    private String act_tel;
    private String act_mai;
    private String act_pho;
    private String act_grp;
    private int act_ok;
    private String loc_ins;
    private int typ_id;
    private String act_log_acteur;

    public acteur () {

    }

    public acteur (String act_logIn) {

          this.act_log = act_logIn;

    }


    public String getAct_log() {
          return this.act_log;
    }
    public void setAct_log(String act_logIn) {
          this.act_log = act_logIn;
    }

    public String getAct_nom() {
          return this.act_nom;
    }
    public void setAct_nom(String act_nomIn) {
          this.act_nom = act_nomIn;
    }

    public String getAct_pre() {
          return this.act_pre;
    }
    public void setAct_pre(String act_preIn) {
          this.act_pre = act_preIn;
    }

    public String getAct_tel() {
          return this.act_tel;
    }
    public void setAct_tel(String act_telIn) {
          this.act_tel = act_telIn;
    }

    public String getAct_mai() {
          return this.act_mai;
    }
    public void setAct_mai(String act_maiIn) {
          this.act_mai = act_maiIn;
    }

    public String getAct_pho() {
          return this.act_pho;
    }
    public void setAct_pho(String act_phoIn) {
          this.act_pho = act_phoIn;
    }

    public String getAct_grp() {
          return this.act_grp;
    }
    public void setAct_grp(String act_grpIn) {
          this.act_grp = act_grpIn;
    }

    public int getAct_ok() {
          return this.act_ok;
    }
    public void setAct_ok(int act_okIn) {
          this.act_ok = act_okIn;
    }

    public String getLoc_ins() {
          return this.loc_ins;
    }
    public void setLoc_ins(String loc_insIn) {
          this.loc_ins = loc_insIn;
    }

    public int getTyp_id() {
          return this.typ_id;
    }
    public void setTyp_id(int typ_idIn) {
          this.typ_id = typ_idIn;
    }

    public String getAct_log_acteur() {
          return this.act_log_acteur;
    }
    public void setAct_log_acteur(String act_log_acteurIn) {
          this.act_log_acteur = act_log_acteurIn;
    }


    public void setAll(String act_logIn,
          String act_nomIn,
          String act_preIn,
          String act_telIn,
          String act_maiIn,
          String act_phoIn,
          String act_grpIn,
          int act_okIn,
          String loc_insIn,
          int typ_idIn,
          String act_log_acteurIn) {
          this.act_log = act_logIn;
          this.act_nom = act_nomIn;
          this.act_pre = act_preIn;
          this.act_tel = act_telIn;
          this.act_mai = act_maiIn;
          this.act_pho = act_phoIn;
          this.act_grp = act_grpIn;
          this.act_ok = act_okIn;
          this.loc_ins = loc_insIn;
          this.typ_id = typ_idIn;
          this.act_log_acteur = act_log_acteurIn;
    }

    public boolean hasEqualMapping(acteur valueObject) {

          if (this.act_log == null) {
                    if (valueObject.getAct_log() != null)
                           return(false);
          } else if (!this.act_log.equals(valueObject.getAct_log())) {
                    return(false);
          }
          if (this.act_nom == null) {
                    if (valueObject.getAct_nom() != null)
                           return(false);
          } else if (!this.act_nom.equals(valueObject.getAct_nom())) {
                    return(false);
          }
          if (this.act_pre == null) {
                    if (valueObject.getAct_pre() != null)
                           return(false);
          } else if (!this.act_pre.equals(valueObject.getAct_pre())) {
                    return(false);
          }
          if (this.act_tel == null) {
                    if (valueObject.getAct_tel() != null)
                           return(false);
          } else if (!this.act_tel.equals(valueObject.getAct_tel())) {
                    return(false);
          }
          if (this.act_mai == null) {
                    if (valueObject.getAct_mai() != null)
                           return(false);
          } else if (!this.act_mai.equals(valueObject.getAct_mai())) {
                    return(false);
          }
          if (this.act_pho == null) {
                    if (valueObject.getAct_pho() != null)
                           return(false);
          } else if (!this.act_pho.equals(valueObject.getAct_pho())) {
                    return(false);
          }
          if (this.act_grp == null) {
                    if (valueObject.getAct_grp() != null)
                           return(false);
          } else if (!this.act_grp.equals(valueObject.getAct_grp())) {
                    return(false);
          }
          if (valueObject.getAct_ok() != this.act_ok) {
                    return(false);
          }
          if (this.loc_ins == null) {
                    if (valueObject.getLoc_ins() != null)
                           return(false);
          } else if (!this.loc_ins.equals(valueObject.getLoc_ins())) {
                    return(false);
          }
          if (valueObject.getTyp_id() != this.typ_id) {
                    return(false);
          }
          if (this.act_log_acteur == null) {
                    if (valueObject.getAct_log_acteur() != null)
                           return(false);
          } else if (!this.act_log_acteur.equals(valueObject.getAct_log_acteur())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Acteur, mapping to table acteur\n");
        out.append("Persistent attributes: \n"); 
        out.append("act_log = " + this.act_log + "\n"); 
        out.append("act_nom = " + this.act_nom + "\n"); 
        out.append("act_pre = " + this.act_pre + "\n"); 
        out.append("act_tel = " + this.act_tel + "\n"); 
        out.append("act_mai = " + this.act_mai + "\n"); 
        out.append("act_pho = " + this.act_pho + "\n"); 
        out.append("act_grp = " + this.act_grp + "\n"); 
        out.append("act_ok = " + this.act_ok + "\n"); 
        out.append("loc_ins = " + this.loc_ins + "\n"); 
        out.append("typ_id = " + this.typ_id + "\n"); 
        out.append("act_log_acteur = " + this.act_log_acteur + "\n"); 
        return out.toString();
    }

    public Object clone() {
        acteur cloned = new acteur();

        if (this.act_log != null)
             cloned.setAct_log(new String(this.act_log)); 
        if (this.act_nom != null)
             cloned.setAct_nom(new String(this.act_nom)); 
        if (this.act_pre != null)
             cloned.setAct_pre(new String(this.act_pre)); 
        if (this.act_tel != null)
             cloned.setAct_tel(new String(this.act_tel)); 
        if (this.act_mai != null)
             cloned.setAct_mai(new String(this.act_mai)); 
        if (this.act_pho != null)
             cloned.setAct_pho(new String(this.act_pho)); 
        if (this.act_grp != null)
             cloned.setAct_grp(new String(this.act_grp)); 
        cloned.setAct_ok(this.act_ok); 
        if (this.loc_ins != null)
             cloned.setLoc_ins(new String(this.loc_ins)); 
        cloned.setTyp_id(this.typ_id); 
        if (this.act_log_acteur != null)
             cloned.setAct_log_acteur(new String(this.act_log_acteur)); 
        return cloned;
    }

   public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

