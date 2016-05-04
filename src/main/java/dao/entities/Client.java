package dao.entities;

/**
 * Created by vrama on 26.04.2016.
 */
public class Client {
   private int id;
   private String name;
   private String login;
   private String password;
   private int roleId;

    public Client(int id, String name, String login, String password, int roleId) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
