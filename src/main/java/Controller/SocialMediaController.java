package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Account;
import Service.SocialMediaService;
import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {

    SocialMediaService socialMediaService;

    public SocialMediaController(){
        socialMediaService = new SocialMediaService();
    }
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.post("/register", this::postNewAccountHandler);
        app.post("/login", this::postLoginHandler);
        app.post("/messages", this::postMessagesHandler);
        app.get("/messages", this::getMessagesHandler);
        app.get("/messages/{message_id}", this::getRetrieveMessagesHandler);
        app.delete("/messages/{message_id}", this::deleteMessagesHandler);
        app.patch("/messages/{message_id}", this::updateMessagesHandler);
        app.get("/accounts/{account_id}/messages", this::getAllUserMessagesHandler);


        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void postNewAccountHandler (Context ctx) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);
        Account newAccount = socialMediaService.createAccount(account);
        if(newAccount != null ){
            ctx.status(400);
        }else{ 
            ctx.json(mapper.writeValueAsString(newAccount));
        }

    }

    private void postLoginHandler(Context context) {
        context.json("sample text");
    }

    private void postMessagesHandler(Context context) {
        context.json("sample text");
    }

    private void getMessagesHandler(Context context) {
        context.json("sample text");
    }

    private void getRetrieveMessagesHandler(Context context) {
        context.json("sample text");
    }

    private void deleteMessagesHandler(Context context) {
        context.json("sample text");
    }

    private void updateMessagesHandler(Context context) {
        context.json("sample text");
    }

    private void getAllUserMessagesHandler(Context context) {
        context.json("sample text");
    }
    
}