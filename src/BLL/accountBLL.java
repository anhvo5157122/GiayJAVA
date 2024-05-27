/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author it200
 */
import DTO.account;
import DAL.accountDAL;
public class accountBLL {
    
    
    
    public static account getAccountByUsername(String username){
        return accountDAL.getAccountByUsername(username);
    }
    
}
