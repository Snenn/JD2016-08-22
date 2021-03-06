package by.it.filimonchik.jd03_03.DAO;

import by.it.filimonchik.jd03_03.Connection.ConnectionCreator;
import by.it.filimonchik.jd03_03.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class UsersDAO extends AbstractDAO implements IDAO<User> {
    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFK_Role(rs.getInt("FK_Role"));
                users.add(user);
            }
        } catch (SQLException e) {
        }
        return users;
    }

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(User user) {
        String sql = String.format(
                "insert INTO users(Login,Password,Email,FK_Role)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_Role()
        );
        user.setID(executeUpdate(sql));
        return (user.getID()>0);
    }
    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE `users` SET `Login` = '%s', `Password` = '%s', `Email` = '%s', `FK_Role` = '%d' WHERE `users`.`ID` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_Role(), user.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", user.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
