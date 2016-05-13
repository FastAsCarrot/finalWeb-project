package dao.interfaces;

import dao.entities.Role;

import java.util.List;

/**
 * Created by vrama on 26.04.2016.
 */
public interface RoleDao {
    List<Role> getAllRoles();
    Role getRoleById(int id);
}
