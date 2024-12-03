package iuh.se.fit.service;


import java.io.InputStream;
import java.util.List;

import iuh.se.fit.model.UserDTO;

public interface UserService {

    public void insert(UserDTO userDTO, InputStream avatar);

    public void update(UserDTO userDTO, InputStream avatar);

    public void delete(long userId);

    public UserDTO findById(long userIdDTO);

    public List<UserDTO> findAll(int pageIndex, int PageSize);

    public UserDTO findByEmailOrPhoneAndPassword(String email, String password, boolean verify);

    public UserDTO findByEmail(String email);

    public int count();
}
