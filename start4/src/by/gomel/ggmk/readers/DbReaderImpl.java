package by.gomel.ggmk.readers;

import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.exceptions.SourceException;
import by.gomel.ggmk.factories.CarFactory;
import by.gomel.ggmk.interfaces.ReaderDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DbReaderImpl implements ReaderDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private static final String URL_KEY = "url";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String SELECT_QUERY = "select * from table1";
    private static final int INDEX_TYPE = 1;
    private static final int INDEX_NAME = 2;
    private static final int INDEX_MASS = 3;
    private static final int INDEX_PLACE = 4;


    public DbReaderImpl(ResourceBundle rb) throws SourceException{
        try {
            con = DriverManager.getConnection(rb.getString(URL_KEY),rb.getString(USERNAME_KEY),rb.getString(PASSWORD_KEY));
            ps = con.prepareStatement(SELECT_QUERY);
            rs = ps.executeQuery();
        } catch (SQLException e){
            throw new SourceException();
        }
    }

    @Override
    public boolean hasNext() throws SourceException{
        try {
            return rs.next();
        } catch (SQLException e){
            throw new SourceException();
        }

    }

    @Override
    public Car nextCar() throws SourceException{
        try {
            List<String> list = new ArrayList<>();
            list.add(rs.getString(INDEX_TYPE));
            list.add(rs.getString(INDEX_NAME));
            list.add(rs.getString(INDEX_MASS));
            list.add(rs.getString(INDEX_PLACE));
            return CarFactory.getCarFromFactory(list);
        } catch (SQLException e){
            throw new SourceException();
        }

    }

    @Override
    public void close() {
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (ps != null){
                ps.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if (con != null){
                con.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
