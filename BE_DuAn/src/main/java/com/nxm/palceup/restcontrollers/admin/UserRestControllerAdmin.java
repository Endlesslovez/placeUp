package com.nxm.palceup.restcontrollers.admin;


import com.nxm.palceup.dto.AccountDTO;
import com.nxm.palceup.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/user")
public class UserRestControllerAdmin {

    @Autowired
    private AccountService accountService;
    @PostMapping("/updateAccountActive")
    public AccountDTO updateAccountActive(@RequestBody AccountDTO accountDTO){
        return accountService.updateAccountActive(accountDTO);
    }

}
