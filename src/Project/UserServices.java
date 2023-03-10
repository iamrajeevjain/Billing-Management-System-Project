package Project;


public class UserServices {

    private UserDAO userDAO = new UserDAO();
    UserDTO userDTO = new UserDTO();
   

    public int insert(UserDTO userDTO) throws Exception {
        return userDAO.insert(userDTO);
    }
     public int insertProduct(UserDTO userDTO) throws Exception {
        return userDAO.insertProduct(userDTO);
    }

    public int update(UserDTO userDTO) throws Exception {
        return userDAO.update(userDTO);
    }
   


    public  UserDTO getById(String pId) throws Exception {
        return userDAO.getById(pId);
    }
    public  UserDTO getByMobile(String contactNo) throws Exception {
        return userDAO.getByMobile(contactNo);
    }
      public  UserDTO getByName(String name) throws Exception {
        return userDAO.getByName(name);
    }
    public void getAll() {
    }

    public  int deleteByMobile(String contactNo) throws Exception {
        return userDAO.deleteByMobile(contactNo);
    }
     public  int deleteById(String pId) throws Exception {
        return userDAO.deleteById(pId);
    }
    public int getTotalRecords()  throws Exception {
        return userDAO.getTotalRecords() ;
    }

   
    public int  updateProduct(UserDTO userDTO, String pId) throws Exception {
         return userDAO.updateProdBuct(userDTO,pId);
    }
}
