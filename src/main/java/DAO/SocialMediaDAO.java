package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.*;
import Util.*;

public class SocialMediaDAO{

    public static Account createNewUserAccount(Account account) {
        Connection connection =  ConnectionUtil.getConnection();
        try {
            String sql ="CHANGE THIS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, account.username);
            preparedStatement.setString(0, account.password);   
            
            preparedStatement.executeUpdate();
            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if(pkeyResultSet.next()){
                int generated_account_id = (int) pkeyResultSet.getLong(1);
                return new Account(generated_account_id, account.username, account.password);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}