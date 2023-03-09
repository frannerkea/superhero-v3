package com.example.superherov3.repositories;

import com.example.superherov3.DTO.HeroCityDTO;
import com.example.superherov3.DTO.HeroPowerCountDTO;
import com.example.superherov3.DTO.HeroPowerDTO;
import com.example.superherov3.Model.SuperheroModel;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SuperheroRepository_DB {




    public SuperheroModel printSuperHero(String heroName) {
        // Initialize a new SuperheroModel object and set it to null
        SuperheroModel heroObj = null;
        // Create a new connection to the MySQL database using JDBC
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superhero", "root", "zombie123")) {
            // Create a SQL query string to select all columns from the superhero table where the superheroname matches the given heroName
            String SQL = "SELECT * FROM superhero.superhero where superheroname = ?;";
            // Prepare the SQL statement by setting the first parameter to the heroName argument
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, heroName);
            // Execute the SQL statement and get the result set
            ResultSet rs = stmt.executeQuery();
            // If the result set has at least one row, create a new SuperheroModel object with the values from the result set
            if (rs.next()) {
                String superheroname = rs.getString("superheroname");
                String realname = rs.getString("realname");
                int year = rs.getInt("creationyear");
                heroObj = new SuperheroModel(superheroname, realname, year);
            }
            // Return the SuperheroModel object (or null if no matching superhero was found)
            return heroObj;
        } catch (SQLException e) {
            // If an SQLException is thrown, wrap it in a RuntimeException and rethrow it
            throw new RuntimeException(e);
        }
    }





    public List<HeroPowerCountDTO> printHeroPowerCount() {
        List<HeroPowerCountDTO> heroObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superhero", "root", "zombie123")) {
            String SQL = "SELECT superhero.superheroname, superhero.realname, COUNT(superhero_power.powerid) as num_powers\n" +
                    "FROM superhero\n" +
                    "LEFT JOIN superhero_power ON superhero.superheroname = superhero_power.superheroname\n" +
                    "GROUP BY superhero.superheroname;";
            PreparedStatement stmt = con.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String superheroname = rs.getString("superheroname");
                String realname = rs.getString("realname");
                int numPowers = rs.getInt("num_powers");
                heroObj.add(new HeroPowerCountDTO(superheroname, realname, numPowers));
            }
            return heroObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HeroPowerDTO> printHeroPowers() {
        List<HeroPowerDTO> heroObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superhero", "root", "zombie123")) {
            String SQL = "SELECT \n" +
                    "    superhero.superheroname AS heroName, \n" +
                    "    superhero.realname AS realName, \n" +
                    "    GROUP_CONCAT(superpower.powername SEPARATOR ', ') AS superpowers \n" +
                    "FROM \n" +
                    "    superhero \n" +
                    "    INNER JOIN superhero_power ON superhero.superheroname = superhero_power.superheroname \n" +
                    "    INNER JOIN superpower ON superhero_power.powerid = superpower.powerid \n" +
                    "GROUP BY \n" +
                    "    superhero.superheroname;\n";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String superheroname = rs.getString("heroName");
                String realname = rs.getString("realName");
                List<String> powers = Arrays.asList(rs.getString("superpowers").split(","));
                heroObj.add(new HeroPowerDTO(superheroname, realname, powers));
            }
            return heroObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HeroCityDTO> printHeroCity() {
        List<HeroCityDTO> heroObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superhero", "root", "zombie123")) {
            String SQL = "SELECT superhero.superheroname AS heroName, city.cityname AS city\n" +
                    "FROM superhero\n" +
                    "INNER JOIN city ON superhero.cityid = city.cityid;\n";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String superheroname = rs.getString("heroName");
                String city = rs.getString("city");

                heroObj.add(new HeroCityDTO(superheroname, city));
            }
            return heroObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}
