package iuh.se.fit.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import iuh.se.fit.dao.UserDao;
import iuh.se.fit.entity.Role;
import iuh.se.fit.entity.User;
import iuh.se.fit.model.RoleDTO;
import iuh.se.fit.model.UserDTO;
import iuh.se.fit.model.UserPrincipal;
import iuh.se.fit.service.UserService;



@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insert(UserDTO userDTO, InputStream avatar) {
        Role role = new Role();
        role.setRoleId(userDTO.getRoleDTO().getRoleId());

        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setUserName(userDTO.getUserName());
        user.setVerify(userDTO.isVerify());
        user.setSex(userDTO.isSex());
        user.setPassword(userDTO.getPassword());
        user.setRole(role);

        userDao.insert(user, avatar);
    }

    @Override
    public void update(UserDTO userDTO, InputStream avatar) {
        Role role = new Role();
        role.setRoleId(userDTO.getRoleDTO().getRoleId());

        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setUserName(userDTO.getUserName());
        user.setVerify(userDTO.isVerify());
        user.setSex(userDTO.isSex());
        user.setPassword(userDTO.getPassword());
        user.setRole(role);

        userDao.update(user, avatar);

    }

    @Override
    public void delete(long userId) {
        userDao.delete(userId);

    }

    @Override
    public UserDTO findById(long user_id_dto) {
        User user = userDao.findById(user_id_dto);
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(user.getRole().getRoleId());
        roleDTO.setRoleName(user.getRole().getRoleName());

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());

        Blob blob = user.getAvatar();
        if (blob != null) {
            InputStream inputStream;
            try {
                inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String avatar = Base64.getEncoder().encodeToString(imageBytes);
                userDTO.setAvatar(avatar);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        userDTO.setUserName(user.getUserName());
        userDTO.setVerify(user.isVerify());
        userDTO.setSex(user.isSex());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoleDTO(roleDTO);
        return userDTO;
    }

    @Override
    public List<UserDTO> findAll(int pageIndex, int PageSize) {
        List<User> users = userDao.findAll(pageIndex, PageSize);
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(user.getRole().getRoleId());
            roleDTO.setRoleName(user.getRole().getRoleName());

            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setAddress(user.getAddress());

            Blob blob = user.getAvatar();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String avatar = Base64.getEncoder().encodeToString(imageBytes);
                    userDTO.setAvatar(avatar);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            userDTO.setUserName(user.getUserName());
            userDTO.setVerify(user.isVerify());
            userDTO.setSex(user.isSex());
            userDTO.setPassword(user.getPassword());
            userDTO.setRoleDTO(roleDTO);

            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public UserDTO findByEmailOrPhoneAndPassword(String email, String password, boolean verify) {
        User user = userDao.findByEmailOrPhoneAndPassword(email, password, verify);
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(user.getRole().getRoleId());
        roleDTO.setRoleName(user.getRole().getRoleName());

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());
        Blob blob = user.getAvatar();
        if (blob != null) {
            InputStream inputStream;
            try {
                inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String avatar = Base64.getEncoder().encodeToString(imageBytes);
                userDTO.setAvatar(avatar);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        userDTO.setUserName(user.getUserName());
        userDTO.setVerify(user.isVerify());
        userDTO.setSex(user.isSex());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoleDTO(roleDTO);
        return userDTO;
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userDao.findByEmail(email);
        if (user != null) {
            UserDTO userDTO = new UserDTO();
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(user.getRole().getRoleId());
            roleDTO.setRoleName(user.getRole().getRoleName());

            userDTO.setUserId(user.getUserId());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setAddress(user.getAddress());
            Blob blob = user.getAvatar();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String avatar = Base64.getEncoder().encodeToString(imageBytes);
                    userDTO.setAvatar(avatar);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            userDTO.setUserName(user.getUserName());
            userDTO.setVerify(user.isVerify());
            userDTO.setSex(user.isSex());
            userDTO.setPassword(user.getPassword());
            userDTO.setRoleDTO(roleDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not Found!");
        }

        List<SimpleGrantedAuthority> roleList = new ArrayList<>();

        roleList.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));

        UserPrincipal userPrincipal = new UserPrincipal(user.getEmail(), user.getPhone(), user.getPassword(), roleList);
        userPrincipal.setUserId(user.getUserId());
        userPrincipal.setEmail(user.getEmail());
        userPrincipal.setPhone(user.getPhone());
        userPrincipal.setAddress(user.getAddress());
        Blob blob = user.getAvatar();
        if (blob != null) {
            InputStream inputStream;
            try {
                inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String avatar = Base64.getEncoder().encodeToString(imageBytes);
                userPrincipal.setAvatar(avatar);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        userPrincipal.setFullname(user.getUserName());
        userPrincipal.setVerify(user.isVerify());
        userPrincipal.setGender(user.isSex());
        userPrincipal.setPassword(user.getPassword());
        userPrincipal.setRole(user.getRole());
        return userPrincipal;
    }

}
