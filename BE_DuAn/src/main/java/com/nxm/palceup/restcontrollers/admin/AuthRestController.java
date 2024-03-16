package com.nxm.palceup.restcontrollers.admin;

import com.nxm.palceup.dto.LoginDTO;
import com.nxm.palceup.dto.SignUpDTO;
import com.nxm.palceup.entities.Author;
import com.nxm.palceup.service.AuthService;
import com.nxm.palceup.utils.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDTO) throws Exception {
        return authService.authenticateUser(loginDTO);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDTO signUpDTO) {
        ResponseEntity<?> response = authService.registerUser(signUpDTO);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("alo");
        } else {
            // Đăng nhập thất bại, trả về response như cũ
            return response;
        }
    }

    @PostMapping
    public Author create(@RequestBody Author author) {

        return authService.save(author);
    }

    @PutMapping
    public Author update(@RequestBody Author author) {

        System.out.println(author.getAccount().getUsername());
        System.out.println(author.getRole().getIdRole());
        System.out.println(author.toString());


        return authService.save(author);
    }

    @GetMapping
    public List<Author> getAccount() {
        return authService.findAll();
    }

    @GetMapping("/searchUsername/{username}")
    public Author searchAccountByUsername(@PathVariable(value = "username") String username) {
        return authService.searchAccountByUsername(username);
    }

    @GetMapping("/searchAccount/{username}/{phone}/{fullname}/{email}/{status}/{rolename}")
    public List<Author> searchAccount(@PathVariable(value = "username") String username, @PathVariable(value = "phone") String phone,
                                      @PathVariable(value = "fullname") String fullname, @PathVariable(value = "email") String email,
                                      @PathVariable(value = "status") String status, @PathVariable(value = "rolename") String rolename) {
        if (fullname.equals(" ") || fullname.equals("undefined")) {
            fullname = " ";
        }
        if (phone.equals(" ") || phone.equals("undefined")) {
            phone = "0";
        }
        if (email.equals(" ") || email.equals("undefined")) {
            email = "@";
        }
        if (rolename.equals("undefined")) {
            rolename = "_";
        }
        System.out.println(username + "-2-" + status + "--" + rolename);
        if (username.equals(" ") || username.equals("undefined")) {
            if (status.equals("undefined")) {
                return authService.searchAccountNoUsernameNoStatus(phone, fullname, email, rolename);
            } else {
                int sts = Integer.parseInt(status);
                return authService.searchAccountNoUsername(phone, fullname, email, sts, rolename);
            }
        } else if (status.equals("undefined")) {
            return authService.searchAccountNoStatus(username, phone, fullname, email, rolename);
        } else {
            int sts = Integer.parseInt(status);
            return authService.searchAllAccount(username, phone, fullname, email, sts, rolename);
        }
    }
    @GetMapping("/getRole")
    public Author getRole(){
        return authService.getRoleByUserName(Username.getUserName());
    }
}
