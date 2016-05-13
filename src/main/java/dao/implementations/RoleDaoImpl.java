package dao.implementations;

import connectionPool.ConnectionPool;
import dao.entities.Role;
import dao.interfaces.RoleDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
public class RoleDaoImpl implements RoleDao {

    ConnectionPool connectionPool;

    public RoleDaoImpl() {

    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList = new ArrayList<>();

        String sqlQuery = "SELECT role_id, role_name FROM account_role";

        try (final Connection connection = ConnectionPool.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(sqlQuery)) {

            while (rs.next()) {
                roleList.add(new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_name")));
            }

            return roleList;
        } catch (SQLException e) {
            e.printStackTrace();

            return Collections.emptyList();
        }
    }

    @Override
    public Role getRoleById(int id) {
        String sqlQuery = "SELECT role_id, role_name FROM account_role " +
                "WHERE role_id ='" + id +  "'";

        try (final Connection connection = ConnectionPool.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(sqlQuery)) {

            if (rs.next()) {
                return new Role(
                        rs.getInt("role_id"),
                        rs.getString("role_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }

        return null;
    }
}
