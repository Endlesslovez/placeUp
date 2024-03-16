package com.nxm.palceup.restcontrollers.admin;

import com.nxm.palceup.dto.AddressDTO;
import com.nxm.palceup.entities.Account;
import com.nxm.palceup.entities.Author;
import com.nxm.palceup.service.AccountService;
import com.nxm.palceup.service.AuthService;
import com.nxm.palceup.service.ProductService;
import com.nxm.palceup.utils.Username;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/rest/user")
@CrossOrigin("*")
@Component
@RequiredArgsConstructor
public class UserRestController {
    private final AccountService accountService;

    @Autowired
    ProductService productSV;

    @Autowired
    private AuthService authService;

    @Autowired
    ModelMapper modelMapper;



    Account account = null;

    @GetMapping("/getAccountActive")
    public Account getAccountActive() {
        Account account = accountService.findByUsername(Username.getUserName());
        return account;
    }
    @GetMapping("/getAccount")
    public Author getAccountActives() {
        System.out.println(Username.getUserName() + "nullcuatenthkdangnhap");
        Author author = authService.searchAccountByUsername(Username.getUserName());
        return author;
    }

    @GetMapping("/getAddress")
    public AddressDTO getAddress(){
        return accountService.getAddress();
    }

    @PostMapping("/setaddressdefault")
    public void setaddressdefault(@RequestBody Integer id){
        accountService.setAddressDefault(id);
    }
}
