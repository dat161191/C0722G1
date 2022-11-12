package repository.impl;

import model.Customer;
import model.Facility;
import repository.BaseRepository;
import repository.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String INSERT_FACILITY_SQL =
            "INSERT INTO facility (name, area, cost, max_people, standard_room, description_other_convenience, pool_area, number_of_floors,facility_free,rent_type_id,facility_type_id)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_FACILITY_SQL =
            "SELECT facility.*, rent_type.name AS rent_type_name, facility_type.name AS facility_type_name FROM facility JOIN rent_type ON facility.rent_type_id = rent_type.id JOIN facility_type ON facility.facility_type_id = facility_type.id WHERE facility.is_delete = 0;";
    private final String DELETE_FACILITY_SQL = "UPDATE facility SET is_delete =1 WHERE id = ?;";

    private final String SEARCH_FACILITY_BY_NAME = "SELECT * FROM facility WHERE is_delete =0 and name LIKE ? ;";
    private final String UPDATE_FACILITY_SQL =
            "UPDATE facility SET name = ? ,area = ?, cost = ?, max_people = ?, standard_room = ?, description_other_convenience = ?, pool_area = ?, number_of_floors = ?,facility_free =?,rent_type_id =?,facility_type_id=? WHERE is_delete=0 AND id = ?;";


    @Override
    public List<Facility> findAllFacility() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_FACILITY_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");/// sao thèn đây hiển thị k ra tiền đc
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                String facilityTyeName = resultSet.getString("facility_type_name");
                boolean isDelete = resultSet.getBoolean("is_delete");
                Facility facility = new Facility(id, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                        poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId, rentTypeName, facilityTyeName, isDelete);
                facilityList.add(facility);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityList;
    }

    /*===============ADD=============*/

    @Override
    public boolean addFacility(Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_FACILITY_SQL);
            preparedStatement.setString(1, facility.getName());
            preparedStatement.setInt(2, facility.getArea());
            preparedStatement.setDouble(3, facility.getCost());
            preparedStatement.setInt(4, facility.getMaxPeople());
            preparedStatement.setString(5, facility.getStandardRoom());
            preparedStatement.setString(6, facility.getDescriptionOtherConvenience());
            preparedStatement.setDouble(7, facility.getPoolArea());
            preparedStatement.setInt(8, facility.getNumberOfFloors());
            preparedStatement.setString(9, facility.getFacilityFree());
            preparedStatement.setInt(10, facility.getRentTypeId());
            preparedStatement.setInt(11, facility.getFacilityTypeId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*======== REMOVE ==============*/
    @Override
    public boolean removeFacility(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_FACILITY_SQL);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*===========EDIT=============*/
    @Override
    public boolean editFacility(int id, Facility facility) {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_FACILITY_SQL);
            preparedStatement.setString(1, facility.getName());
            preparedStatement.setInt(2, facility.getArea());
            preparedStatement.setDouble(3, facility.getCost());
            preparedStatement.setInt(4, facility.getMaxPeople());
            preparedStatement.setString(5, facility.getStandardRoom());
            preparedStatement.setString(6, facility.getDescriptionOtherConvenience());
            preparedStatement.setDouble(7, facility.getPoolArea());
            preparedStatement.setInt(8, facility.getNumberOfFloors());
            preparedStatement.setString(9, facility.getFacilityFree());
            preparedStatement.setInt(10, facility.getRentTypeId());
            preparedStatement.setInt(11, facility.getFacilityTypeId());
            preparedStatement.setInt(12, facility.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Facility findByID(int id) {
        return null;
    }

    /*================SEARCH=====================*/
    @Override
    public List<Facility> searchByName(String name) {
        List<Facility> facilityList = new ArrayList<>();

        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_FACILITY_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameFind = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");

                facilityList.add(new Facility(id, nameFind, area, cost, maxPeople, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityList;
    }

}
