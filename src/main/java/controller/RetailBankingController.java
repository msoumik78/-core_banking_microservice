package controller;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import security.JwtTokenUtil;
import service.AccountService;

@RestController
@RequestMapping({"/retailBanking"})
public class RetailBankingController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountService accountService;


    @RequestMapping(value="/getAccountBalance", method = RequestMethod.GET)
    public String getAccountBalance(@RequestHeader("Authorization") String requestTokenHeader, @RequestParam(value = "name", defaultValue = "World") String userName){
        if (validateJwtToken(requestTokenHeader, userName)) {
            return String.valueOf(accountService.getAccountBalance(userName));
        } else {
            return "User : "+userName +" is not authorized to access this service!";
        }
    }

    private boolean validateJwtToken(String requestTokenHeader, String userName){
        String userFromJwtToken = null;
        String jwtToken = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                userFromJwtToken = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }
        } else {
            System.out.println("User : " + userName + " is NOT allowed to access the service because he has not provided a JWT token");
            return false;
        }
        if (!(jwtTokenUtil.validateToken(jwtToken,userName))) {
            System.out.println("User : " + userName + " is NOT allowed to access the service as his JWT Token is invalid");
            return false;
        }
        return true;
    }


}
