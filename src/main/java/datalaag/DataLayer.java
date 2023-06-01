package datalaag;

import logica.*;

import java.sql.*;
import java.util.ArrayList;
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
        } else throw new IllegalArgumentException("adres bestaat al");

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
            Adres adresId = new Adres(straat, huisNummer, gemeente, postcode, id);
            if (adres.equals(adresId)) {
                return adresId.getId();
            }
        }
        return -1;
    }

    public void zwembadToevoegen(Zwembad zwembad, int adresId) throws SQLException {
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
        } else throw new IllegalArgumentException("Zwembad bestaat al");
    }

    public boolean zwembadChecker(Zwembad zwembad) throws SQLException {
        Statement stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM zwembaden");

        while (rs.next()) {
            int id = rs.getInt("id");
            int adresId = rs.getInt("adres_id");
            String naam = rs.getString("naam");
            Lengte lengte = Lengte.valueOf(rs.getString("lengte").replaceFirst("", "_"));
            Aantal_banen aantalBanen = Aantal_banen.valueOf(rs.getString("aantal_banen").replaceFirst("", "_"));
            Zwembad zwembadcheck = new Zwembad(id, adresId, naam, aantalBanen, lengte);
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
        if (wedstrijd.getZwembad_id() > 0) {
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
        } else throw new IllegalArgumentException("Zwembad bestaad niet");
    }

    public ArrayList<Offiacial> officialLijst(int wedstrijd_id) throws SQLException {
        ArrayList<Offiacial> officials = new ArrayList<>();
        Statement stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT official_id,functie from jury\n" +
                "WHERE wedstrijd_id = " + wedstrijd_id + " order by official_id");

        while (rs.next()) {
            int officialId = rs.getInt("official_id");
            String functie = rs.getString("functie");
            Offiacial offiacial = new Offiacial(officialId, Functie.valueOf(functie));
            officials.add(offiacial);
        }
        return officials;
    }

    public void juryVerwijderen(int wedstrijd_id, int official_id) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = this.con.prepareStatement("DELETE FROM jury WHERE wedstrijd_id=? AND official_id=?");
            stmt.setInt(1, wedstrijd_id);
            stmt.setInt(2, official_id);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void juryToevoegen(Offiacial official, int wedstrijd_id) throws SQLException {
        PreparedStatement stmt = null;
        if (samenstellingJury(wedstrijd_id, zwembadIdZoeken(wedstrijd_id), official.getFunctie())) {
            if (officialCheck(official, wedstrijd_id)) {
                if (functieUitvoeren(official, diplomaCheck(official))) {
                    try {
                        stmt = this.con.prepareStatement("INSERT INTO jury (wedstrijd_id,official_id,functie) VALUES (?,?,?)");
                        stmt.setInt(1, wedstrijd_id);
                        stmt.setInt(2, official.getOfficalId());
                        stmt.setString(3, String.valueOf(official.getFunctie()));
                        stmt.executeUpdate();

                    } catch (SQLException ex) {
                        Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if (stmt != null) {
                            stmt.close();
                        }
                    }
                } else throw new IllegalArgumentException("Geen bevoegd diploma");
            } else throw new IllegalArgumentException("Jury bestaad al in de wedstrijd");
        }
    }

    public int diplomaCheck(Offiacial official) throws SQLException {
        Statement stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM officials WHERE persoon_id = " + official.getOfficalId());

        while (rs.next()) {
            int id = rs.getInt("persoon_id");
            boolean kamprechter = rs.getBoolean("kamprechter");
            boolean jurysecretaris = rs.getBoolean("jurysecretaris");
            boolean starter = rs.getBoolean("starter");
            boolean tak = rs.getBoolean("tak");
            if (kamprechter) return 1;
            if (jurysecretaris) return 2;
            if (starter) return 3;
            if (tak) return 4;
        }
        return -1;
    }

    public boolean functieUitvoeren(Offiacial offiacial, int diploma) {
        if (offiacial.getFunctie().equals(Functie.KAMPRECHTER) && diploma != 1) return false;
        if (offiacial.getFunctie().equals(Functie.JURYSECRETARIS) && (diploma != 1 && diploma != 2)) return false;
        if (offiacial.getFunctie().equals(Functie.STARTER) && diploma != 3) return false;
        return true;
    }


    public boolean officialCheck(Offiacial official, int wedstrijd_id) throws SQLException {
        String query = "SELECT * FROM jury WHERE official_id = ? AND wedstrijd_id = ?";
        try (PreparedStatement stmt = this.con.prepareStatement(query)) {
            stmt.setInt(1, official.getOfficalId());
            stmt.setInt(2, wedstrijd_id);
            ResultSet rs = stmt.executeQuery();
            return !rs.next();
        }
    }

    public boolean samenstellingJury(int wedstrijdId, int zwembad_id, Functie functie) throws SQLException {
        int kamprechter = 0;
        int jurysecr = 0;
        int starter = 0;
        int zwemrechters = 0;
        int tijdopnemer = 0;
        int keerpunt = 0;
        ArrayList<Offiacial> jury = officialLijst(wedstrijdId);
        for (Offiacial of : jury) {
            if (of.getFunctie() == Functie.KAMPRECHTER) kamprechter++;
            if (of.getFunctie() == Functie.JURYSECRETARIS) jurysecr++;
            if (of.getFunctie() == Functie.STARTER) starter++;
            if (of.getFunctie() == Functie.ZWEMRECHTER) zwemrechters++;
            if (of.getFunctie() == Functie.TIJDOPNEMER) tijdopnemer++;
            if (of.getFunctie() == Functie.KEERPUNTRECHTER) keerpunt++;
        }
        if (kamprechter < 1 && functie.equals(Functie.KAMPRECHTER)) {
            return true;
        } else if (jurysecr < 1 && functie.equals(Functie.JURYSECRETARIS)) {
            return true;
        } else if (starter < 1 && functie.equals(Functie.STARTER)) {
            return true;
        } else if (zwemrechters < 2 && functie.equals(Functie.ZWEMRECHTER)) {
            return true;
        } else if (tijdopnemer < zwembadBanen(zwembad_id) && functie.equals(Functie.TIJDOPNEMER)) {
            return true;
        } else if (keerpunt < zwembadBanen(zwembad_id) && functie.equals(Functie.KEERPUNTRECHTER)) {
            return true;
        } else if (kamprechter == 1 && jurysecr == 1 && starter == 1 && zwemrechters == 2 && tijdopnemer == zwembadBanen(zwembad_id) && keerpunt == zwembadBanen(zwembad_id)) {
            throw new IllegalArgumentException("Alle functies zijn bezet");
        } else throw new IllegalArgumentException("Deze functie is al volzet");
    }

    public int zwembadBanen(int zwembad_id) throws SQLException {
        Statement stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT aantal_banen FROM zwembaden WHERE zwembaden.id = " + zwembad_id);
        int aantalBanen = 0;
        while (rs.next()) {
            aantalBanen = rs.getInt("aantal_banen");
        }
        return aantalBanen;
    }

    public int zwembadIdZoeken(int wedstrijd_id) {
        int id = 0;
        try {
            PreparedStatement stmt = this.con.prepareStatement("SELECT zwembad_id FROM wedstrijden WHERE id = ?");
            stmt.setInt(1, wedstrijd_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("zwembad_id");
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void wedstijdprogrammaAanmaken(WedstrijdProgramma wedstrijdProgramma) throws SQLException {
        PreparedStatement stmt = null;
            if (wedstijdChecker(wedstrijdProgramma)) {
                if (programmaChecker(wedstrijdProgramma)) {
                    if (programmanummerChecker(wedstrijdProgramma)) {
                        try {
                            stmt = this.con.prepareStatement("INSERT INTO wedstrijdprogrammas (id,wedstrijd_id,programma_id,programmanummer,leeftijdscategorie,aanvangsuur) VALUES (?,?,?,?,?,?)");
                            stmt.setInt(1, aantalWedstijdprogrammas() + 1);
                            stmt.setInt(2, wedstrijdProgramma.getWedstijdId());
                            stmt.setInt(3, wedstrijdProgramma.getProgrammaId());
                            stmt.setInt(4, wedstrijdProgramma.getProgrammanummer());
                            stmt.setString(5, wedstrijdProgramma.getLeeftijdscategorie().toString());
                            stmt.setTime(6, (Time) wedstrijdProgramma.getAanvangsuur());
                            stmt.executeUpdate();

                        } catch (SQLException ex) {
                            Logger.getLogger(DataLayer.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            if (stmt != null) {
                                stmt.close();
                            }
                        }
                    } else throw new IllegalArgumentException("Programmanummer wordt al gebruikt");
                } else throw new IllegalArgumentException("Programma ID bestaat niet");
            }else throw new IllegalArgumentException("Wedstrijd ID bestaat niet");
    }
    public int aantalWedstijdprogrammas() throws SQLException {
        Statement stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("Select COUNT(*) AS aantal FROM wedstrijdprogrammas");
        int aantal = 0;
        while (rs.next()) {
            aantal = rs.getInt("aantal");
        }
        return aantal;
    }
    public boolean wedstijdChecker(WedstrijdProgramma wedstrijdProgramma) throws SQLException {
        String query = "SELECT id FROM wedstrijden WHERE wedstrijden.id = ?";
        try (PreparedStatement stmt = this.con.prepareStatement(query)) {
            stmt.setInt(1, wedstrijdProgramma.getWedstijdId());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
    public boolean programmaChecker(WedstrijdProgramma wedstrijdProgramma) throws SQLException {
        String query = "SELECT id FROM programmas WHERE programmas.id = ?";
        try (PreparedStatement stmt = this.con.prepareStatement(query)) {
            stmt.setInt(1, wedstrijdProgramma.getProgrammaId());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
    public boolean programmanummerChecker(WedstrijdProgramma wedstrijdProgramma) throws SQLException {
        String query = "SELECT programmanummer FROM wedstrijdprogrammas WHERE programmanummer = ?";
        try (PreparedStatement stmt = this.con.prepareStatement(query)) {
            stmt.setInt(1, wedstrijdProgramma.getProgrammanummer());
            ResultSet rs = stmt.executeQuery();
            return !rs.next();
        }
    }
}
