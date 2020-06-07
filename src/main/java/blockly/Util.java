package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Util {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_userJira
 * @param param_tokenJira
 * @return Var
 */
// Util
public static Var setTokenUserJira(Var param_userJira, Var param_tokenJira) throws Exception {
 return new Callable<Var>() {

   // param
   private Var userJira = param_userJira;
   private Var tokenJira = param_tokenJira;
   // end

   public Var call() throws Exception {
    cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update User set userJira = :userJira, tokenJira = :tokenJira where userName = :userName"),Var.valueOf("userJira",userJira),Var.valueOf("tokenJira",tokenJira),Var.valueOf("userName",cronapi.util.Operations.getCurrentUserName()));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Usuário do Jira Salvo!"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

