package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ApiJira {

public static final int TIMEOUT = 300;

/**
 *
 * @param projectName
 * @param sprintName
 * @return Var
 */
// ApiJira
public static Var ObterIssueDeSprint(Var projectName, Var sprintName) throws Exception {
 return new Callable<Var>() {

   private Var jql = Var.VAR_NULL;
   private Var arrayIssue = Var.VAR_NULL;

   public Var call() throws Exception {
    jql = Var.valueOf(blockly.URLEncodeDecode.encode(Var.valueOf(Var.valueOf("project = ").toString() + Var.valueOf(Var.valueOf("\"").toString() + projectName.toString() + Var.valueOf("\"").toString()).toString() + Var.valueOf(" AND ").toString() + Var.valueOf(" Sprint = ").toString() + Var.valueOf(Var.valueOf("\"").toString() + sprintName.toString() + Var.valueOf("\"").toString()).toString() + Var.valueOf(" ORDER BY priority DESC").toString())));
    arrayIssue = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"), Var.valueOf("application/x-www-form-urlencoded"), Var.valueOf(Var.valueOf("https://cronapp.atlassian.net/rest/api/3/search?jql=").toString() + jql.toString()), Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("Authorization",Var.valueOf(Var.valueOf("Basic ").toString() + Var.valueOf(ObterTokenJira()).toString()))), Var.VAR_NULL);
    System.out.println(arrayIssue.getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var ObterTokenJira() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var autorizacao = Var.VAR_NULL;

   public Var call() throws Exception {
    lista = cronapi.json.Operations.toJson(cronapi.database.Operations.queryPaged(Var.valueOf("app.entity.User"),Var.valueOf("select u.userJira, u.tokenJira from User u where u.userName = :userName"),Var.valueOf(true),Var.valueOf("userName",cronapi.util.Operations.getCurrentUserName())));
    autorizacao = cronapi.conversion.Operations.StringToBase64(Var.valueOf(cronapi.object.Operations.getObjectField(cronapi.list.Operations.getFirst(lista), Var.valueOf("userJira")).toString() + Var.valueOf(":").toString() + cronapi.object.Operations.getObjectField(cronapi.list.Operations.getFirst(lista), Var.valueOf("tokenJira")).toString()));
    return autorizacao;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var teste() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item = Var.valueOf(blockly.URLEncodeDecode.encode(Var.valueOf("project = DI AND Sprint = 82 ORDER BY priority DESC")));
    System.out.println(Var.valueOf(Var.valueOf("encode").toString() + item.toString()).getObjectAsString());
    System.out.println(Var.valueOf(Var.valueOf("decode: ").toString() + item.toString()).getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

}

