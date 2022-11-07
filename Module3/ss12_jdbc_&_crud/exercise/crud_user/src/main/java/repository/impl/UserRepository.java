package repository.impl;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final String SELECT_ALL = "SELECT * FROM user_database.users";
    private final String INSERT_USER = "insert into users(name, email, country) values(?,?,?);";
    private final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private final String FIND_USER = "SELECT * FROM users where country like ?;";


    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        //Kết nối DB và lấy data từ DB lên
        Connection connection = BaseRepository.getConnectDB();

        try {
            // Đưa câu truy vấn về DB
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL + " order by name DESC ");
            //Lấy kết quả từ câu truy vấn executeQuery(dùng cho SELECT)
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); //columnLabel=tên thuộc tính trong DB
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public boolean add(User user) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            //
            PreparedStatement ps = connection.prepareStatement(INSERT_USER);
            //  Insert đối tượng mới vào DB
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findByID(int id) {
        User user = null;
        // Tạo kết nối vs DB
        Connection connection = BaseRepository.getConnectDB();

        // Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            //Thực thi truy vấn hoặc cập nhật truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý đối tượng ResultSet.
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findByCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER);
            preparedStatement.setString(1, "%" + country + "");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country1 = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean update(int id, User user) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        boolean rowDeleted = false;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
