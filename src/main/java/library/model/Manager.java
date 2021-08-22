package library.model;

public class Manager extends Person {
    private int id;
    private String username;
    private static int userAdmin = 0;

    // TODO mahi: set password directly
    public Manager() {
        super("firstName", "lastName", 1, null, "123456");
        id = ++userAdmin;
        username = "admin"; // hard code
    }

    public int getAdminNumber() {
        return userAdmin;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "AdminNumber is:" + userAdmin + "\n" + "id is:" + id;
    }

    public void changePassword(String password, String newPassword) throws Exception {
        if (super.getPassword().equals(password)) {
            super.setPassword(newPassword);
        } else
            throw new Exception("Old Password incorrect!");
    }
    // TODO mahi: add register for manager


}
