package Service;

import DAO.SocialMediaDAO;
import Model.*;

public class SocialMediaService{
   SocialMediaDAO socialmediaDAO;

   public SocialMediaService(){
    socialmediaDAO = new SocialMediaDAO();
   }

   public SocialMediaService(SocialMediaDAO socialmediaDAO){
    this.socialmediaDAO = socialmediaDAO;
   }

public Account createAccount(Account account){ 
    Account newAccount = SocialMediaDAO.createNewUserAccount(account);
    return newAccount;
    }
}