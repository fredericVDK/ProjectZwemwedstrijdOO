package datalaag;

import logica.*;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataLayer {
    private String dbName = "zwemwedstrijden";
    private final String login = "root";
    private final String pass = "Maximus2045";
    private Connection con;

    public DataLayer() {
        makeConnection();
    }

    private void makeConnection() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + dbName + "?serverTimezone=UTC&allowMultiQueries=true", login, pass);

        } catch (SQLException ex) {
            Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void adresToevoegen(Adres adres) throws SQLException {
        PreparedStatement stmt = null;
            if (adresChecker(adres) == -1) {
                try {
                    stmt = this.con.prepareStatement("INSERT INTO adressen (straat,huisnummer,gemeente,postcode) VALUES (?,?,?,?)");
                    stmt.setString(1, adres.getStraat());
                    stmt.setString(2, adres.getHuisnummer());
                    stmt.setString(3, adres.getGemeente());
                    stmt.setInt(4, adres.getPostcode());
                    stmt.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (stmt != null) {
                        stmt.close();
                    }
                }
            }else throw new IllegalArgumentException("adres bestaat al");

    }

    public void zwembadToevoegen(Zwembad zwembad ,int adresId) throws SQLException {
        PreparedStatement stmt = null;
        if (zwembadChecker(zwembad)) {
            try {
                stmt = this.con.prepareStatement("INSERT INTO zwembaden (adres_id,naam,lengte,aantal_banen) VALUES (?,?,?,?)");
                stmt.setInt(1, adresId);
                stmt.setString(2, zwembad.getNaam());
                stmt.setString(3, zwembad.getLengte().toString().replace("_", ""));
                stmt.setString(4, zwembad.getAantalBanen().toString().replace("_", ""));
                stmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        }else throw new IllegalArgumentException("Zwembad bestaat al");
    }

    public int adresChecker(Adres adres) throws SQLException {
        Statement stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM adressen");

        while (rs.next()) {
            int id = rs.getInt("id");
            String straat = rs.getString("straat");
            String huisNummer = rs.getString("huisnummer");
            String gemeente = rs.getString("gemeente");
            int postcode = rs.getInt("postcode");
            Adres adresId = new Adres(straat, huisNummer, gemeente, postcode,id);
            if (adres.equals(adresId)) {
                return adresId.getId();
            }
        }
        return -1;
    }
    public boolean zwembadChecker(Zwembad zwembad) throws SQLException {
        Statement stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM zwembaden");

        while (rs.next()) {
            int id = rs.getInt("id");
            int adresId = rs.getInt("adres_id");
            String naam = rs.getString("naam");
            Lengte lengte = Lengte.valueOf(rs.getString("lengte").replaceFirst("","_"));
            Aantal_banen aantalBanen = Aantal_banen.valueOf(rs.getString("aantal_banen").replaceFirst("","_"));
            Zwembad zwembadcheck = new Zwembad(id,adresId,naam,aantalBanen,lengte);
            if (zwembad.equals(zwembadcheck)) {
                return false;
            }
        }
        return true;
    }
    public int zwembadIdChecker(int zwembadId) throws SQLException {
        Statement stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM zwembaden");

        while (rs.next()) {
            int id = rs.getInt("id");
            if (zwembadId == id) {
                return zwembadId;
            }
        }
        return -1;
    }

    public void wedstrijdToevoegen(Wedstrijd wedstrijd) throws SQLException {
        PreparedStatement stmt = null;

            try {
                stmt = this.con.prepareStatement("INSERT INTO wedstrijden (zwembad_id,naam,datum,tijdsregistratie,dagdeel) VALUES (?,?,?,?,?)");
                stmt.setInt(1, wedstrijd.getZwembad_id());
                stmt.setString(2, wedstrijd.getNaam());
                stmt.setString(3, wedstrijd.getDatum().toString());
                stmt.setString(4, wedstrijd.getTijdsregistratie().toString());
                stmt.setString(5, wedstrijd.getDagdeel().toString());
                stmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
    }
}
