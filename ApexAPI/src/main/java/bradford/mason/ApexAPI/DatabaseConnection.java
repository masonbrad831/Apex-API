package bradford.mason.ApexAPI;

import java.sql.*;


public class DatabaseConnection {

    private final String url = "jdbc:postgresql://localhost/ApexAPI";
    private final String user = "postgres";
    private final String password = "123";
    
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getCount (String tableName) throws SQLException {
    	String SQL = "SELECT COUNT(*) FROM " + tableName;
    	int count = 0;
        try (Connection connection = DriverManager.getConnection(url,user,password);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
        	rs.next();
        	count = rs.getInt(1);
        }
     
		return count;
    }

    

    public String findByTable(String tableName) {
        String SQL = "SELECT row_to_json(" + tableName + ") FROM "+ tableName;
        String result = "";
        try (Connection connection = DriverManager.getConnection(url,user,password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)){
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                for (int i=1; i<=rsmd.getColumnCount(); i++) {

                    result += rs.getString(1) + "\n";

                }
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return result;
    }

    public String findByID(int id, String tableName) {
        String SQL = "SELECT row_to_json(" + tableName + ") FROM "+ tableName + " WHERE id=" + id;
        String result = "";
        try (Connection connection = DriverManager.getConnection(url,user,password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)){
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                for (int i=1; i<=rsmd.getColumnCount(); i++) {

                    result += rs.getString(1) + "\n";

                }
            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return result;
  
    }


    public void deleteById(int id, String tableName) {
        String SQL = "DELETE FROM " + tableName + " WHERE id = " + id;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void CreateMap(String mapName) {
        String SQL = "INSERT INTO Maps (id , mapName) VALUES ((SELECT COUNT(*) FROM MAPS) + 1,'" + mapName + "')";
    

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void CreateAbilities(int legendId, String abilityName, String description ) {
        String SQL = "INSERT INTO abilities (id, legendid, abilityName, description) VALUES ((SELECT COUNT(*) FROM Abilities) + 1,"+ legendId + "," + "'" + abilityName + "'" + "," + "'" + description + "'" + ")";
    

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void CreateLegends(String legendName, String passive, String tactical, String ultimate, String description) {
        String SQL = "INSERT INTO LEGENDS (id, legendName, passive, tactical, ultimate, description) VALUES ((SELECT COUNT(*) FROM LEGENDS) + 1,'" + legendName + "'" + "," + "'" + passive + "'" + "," + "'" + tactical + "'" + "," + "'" + ultimate + "'" + "," + "'" + description + "'" + ")";
    

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void CreateWeapons(String weaponName, String weaponClass, String ammoType,int bodyDamage, int headDamage, int legDamage, int magSize, int bodyDPS, int RPM, String firemodes) {
        String SQL = "INSERT INTO WEAPONS (weaponName, weaponClass, ammoType, bodyDamage, headDamage, legDamage, magSize, bodyDPS, RPM, Firemodes, id) VALUES ('" + weaponName + "'" + "," + "'" + weaponClass + "'" + "," + "'" + ammoType + "'" + ","  + bodyDamage  + "," + headDamage  + "," + legDamage + "," + magSize
        		+ "," + bodyDPS + "," + RPM + "," + "'" + firemodes + "'" + ",(SELECT COUNT(*) FROM weapons) + 1)";
    

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void update(String tableName, String collumnName, String value, int id) {
    	String SQL = "UPDATE " + tableName + " SET " + collumnName + " = " + "'" + value + "'" + " WHERE id = " + id;
    	
        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
               rs.next();
           }
           catch (SQLException ex) {
               System.out.println(ex.getMessage());
           }
    }
    





    public static void main(String[] args)  {
    	DatabaseConnection dc = new DatabaseConnection();
    	System.out.println(dc.findByTable("maps"));
    }
}

