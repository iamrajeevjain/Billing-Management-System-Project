 package Project;

import com.mysql.cj.util.Util;
import java.sql.*;

public class UserDAO {


    private final String INSERT_USER = "insert into buyer (" 
            + "id,name,contactNo,email,address,gender) values(?,?,?,?,?,?)";
    private final String UPDATE_USER_BY_ID = "update buyer set name = ?,email = ?,address =?,gender = ? where contactNo=?";
    public final String FIND_BY_USER_ID = "select * from buyer where id=?";
    public final String FIND_BY_MOBILE = "select * from buyer where contactNo=?";
    public final String FIND_BY_NAME = "select * from buyer where name=?";
    public final String DELETE_BY_MOBILE = "delete from buyer where ContactNo=?";
    public final String GET_ALL = "select count(*) from buyer";
    private final String INSERT_PRODUCT = "insert into product (" + "pId,pName,rate,discription,activate) values(?,?,?,?,?)";
      private final String UPDATE_PRODUCT_BY_ID = "update product set pName = ?,rate = ?,discription =?,activate = ? where pId=?";
    public final String FIND_BY_PRODUCT_ID = "select * from product where pId=?";
    //  public final String FIND_BY_MOBILE = "select * from buyer where contactNo=?";
    public final String DELETE_BY_ID = "delete from product where pId=?";
    // public final String GET_ALL = "select count(*) from buyer";
    DBUtil dbUtil = new DBUtil();
    

    //insert 
    public int insert(UserDTO userDTO) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            System.out.println("INSERT_USER: " + INSERT_USER);
            pstmt = connection.prepareStatement(INSERT_USER);

            pstmt.setInt(1, userDTO.getId());
            pstmt.setString(2, userDTO.getName());
            pstmt.setString(3, userDTO.getContactNo());
            pstmt.setString(4, userDTO.getEmail());
            pstmt.setString(5, userDTO.getAddress());
            pstmt.setString(6, userDTO.getGender());

            
            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;

        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    // insert product
    public int insertProduct(UserDTO userDTO) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            System.out.println("INSERT_PRODUCT: " + INSERT_PRODUCT);
            pstmt = connection.prepareStatement(INSERT_PRODUCT);

            pstmt.setString(1, userDTO.getpId());
            pstmt.setString(2, userDTO.getpName());
            pstmt.setString(3, userDTO.getRate());
            pstmt.setString(4, userDTO.getDiscription());
            pstmt.setString(5, userDTO.getActivate());
            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;

        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    //update
    public int update(UserDTO userDTO) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(UPDATE_USER_BY_ID);
            pstmt.setString(1, userDTO.getName());
            pstmt.setString(2, userDTO.getEmail());
            pstmt.setString(3, userDTO.getAddress());
            pstmt.setString(4, userDTO.getGender());

            pstmt.setString(5, userDTO.getContactNo());

            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }
    // update product
       public int updateProduct(UserDTO userDTO,String pid) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
            pstmt.setString(1, userDTO.getpName());
            pstmt.setString(2, userDTO.getRate());
            pstmt.setString(3, userDTO.getDiscription());
            pstmt.setString(4, userDTO.getActivate());

            pstmt.setString(5,pid);

            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    //getById
    public UserDTO getById(String pId) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();

            pstmt = connection.prepareStatement(FIND_BY_PRODUCT_ID);
            pstmt.setString(1, pId);
            ResultSet resultSet = pstmt.executeQuery();
            UserDTO userDTO = null;
            if (resultSet.next()) {
                userDTO = new UserDTO();
                userDTO.setpId(resultSet.getString("pId"));
                userDTO.setpName(resultSet.getString("pName"));
                userDTO.setRate(resultSet.getString("rate"));

                userDTO.setDiscription(resultSet.getString("discription"));
                userDTO.setActivate(resultSet.getString("activate"));

            }
            return userDTO;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    //getByMobile
    public UserDTO getByMobile(String contactNo) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();

            pstmt = connection.prepareStatement(FIND_BY_MOBILE);
            pstmt.setString(1, contactNo);
            ResultSet resultSet = pstmt.executeQuery();
            UserDTO userDTO = null;
            if (resultSet.next()) {
                userDTO = new UserDTO();
                userDTO.setId(resultSet.getInt("id"));
                userDTO.setName(resultSet.getString("name"));
                userDTO.setContactNo(resultSet.getString("contactNo"));

                userDTO.setEmail(resultSet.getString("email"));
                userDTO.setAddress(resultSet.getString("address"));
                userDTO.setGender(resultSet.getString("gender"));

            }
            return userDTO;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }
    
     public UserDTO getByName(String name) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();

            pstmt = connection.prepareStatement(FIND_BY_NAME);
            pstmt.setString(1, name);
            ResultSet resultSet = pstmt.executeQuery();
            UserDTO userDTO = null;
            if (resultSet.next()) {
                userDTO = new UserDTO();
                userDTO.setId(resultSet.getInt("id"));
                userDTO.setName(resultSet.getString("name"));
                userDTO.setContactNo(resultSet.getString("contactNo"));

                userDTO.setEmail(resultSet.getString("email"));
                userDTO.setAddress(resultSet.getString("address"));
                userDTO.setGender(resultSet.getString("gender"));

            }
            return userDTO;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    //deleteById
    public int deleteByMobile(String mobile) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(DELETE_BY_MOBILE);
            pstmt.setString(1, mobile);

            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }
    // product delete
 public int deleteById(String pId) throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(DELETE_BY_ID);
            pstmt.setString(1, pId);

            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public int getTotalRecords() throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dbUtil.getConnection();

            pstmt = connection.prepareStatement(GET_ALL);
            ResultSet rs = pstmt.executeQuery();
            //Retrieving the result
            rs.next();
            int count = rs.getInt(1);

            return count;

        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;

        }

    }

    int updateProdBuct(UserDTO userDTO, String pid) throws Exception {

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = dbUtil.getConnection();
            pstmt = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
            pstmt.setString(1, userDTO.getpName());
            pstmt.setString(2, userDTO.getRate());
            pstmt.setString(3, userDTO.getDiscription());
            pstmt.setString(4, userDTO.getActivate());

            pstmt.setString(5,pid);

            int count = pstmt.executeUpdate();
            dbUtil.close(connection, pstmt);

            System.out.println("count: " + count);
            return count;
        } catch (Exception e) {
            dbUtil.close(connection, pstmt);
            System.err.println(e.getMessage());
            throw e;
        }    
    }
    
   
}
