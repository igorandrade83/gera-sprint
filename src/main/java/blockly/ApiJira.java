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
public static Var ObterIssuesSprintApiJira(Var projectName, Var sprintName) throws Exception {
 return new Callable<Var>() {

   private Var arrayIssue = Var.VAR_NULL;
   private Var jql = Var.VAR_NULL;

   public Var call() throws Exception {
    jql = Var.valueOf(blockly.URLEncodeDecode.encode(Var.valueOf(Var.valueOf("project = ").toString() + Var.valueOf(Var.valueOf("\"").toString() + projectName.toString() + Var.valueOf("\"").toString()).toString() + Var.valueOf(" AND ").toString() + Var.valueOf(" Sprint = ").toString() + Var.valueOf(Var.valueOf("\"").toString() + sprintName.toString() + Var.valueOf("\"").toString()).toString() + Var.valueOf(" ORDER BY priority DESC").toString())));
    arrayIssue = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"), Var.valueOf("application/json"), Var.valueOf(Var.valueOf("https://cronapp.atlassian.net/rest/api/3/search?jql=").toString() + jql.toString()), Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("Authorization",Var.valueOf(Var.valueOf("Basic ").toString() + Var.valueOf(ObterTokenJira()).toString()))), Var.VAR_NULL);
    return cronapi.json.Operations.toJson(arrayIssue);
   }
 }.call();
}

/**
 *
 * @param projectName
 * @param sprintName
 * @return Var
 */
// Descreva esta função...
public static Var AlimentarBDIssuesSprint(Var projectName, Var sprintName) throws Exception {
 return new Callable<Var>() {

   private Var arrayIssue = Var.VAR_NULL;
   private Var contaArray = Var.VAR_NULL;
   private Var baseArray = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    arrayIssue = Var.valueOf(ObterIssuesSprintApiJira(projectName, sprintName));
    contaArray = Var.valueOf(-1);
    for (long count = 0; count < cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf("total")).getObjectAsLong();count++) {
            contaArray = cronapi.math.Operations.sum(contaArray,Var.valueOf(1));
        baseArray = Var.valueOf(Var.valueOf("issues[").toString() + contaArray.toString() + Var.valueOf("].").toString());
        item = Var.valueOf(obterIssueApiJira(cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("key").toString()))));
        item = cronapi.object.Operations.newObject(Var.valueOf("app.entity.Issue"),Var.valueOf("id",cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("id").toString()))),Var.valueOf("key",cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("key").toString()))),Var.valueOf("nameProject",cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("fields.project.name").toString()))),Var.valueOf("priority",cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("fields.priority.name").toString()))),Var.valueOf("summary",cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("fields.summary").toString()))),Var.valueOf("timeSpent",cronapi.json.Operations.getJsonOrMapField(item, Var.valueOf("fields.timetracking.timeSpent"))),Var.valueOf("sprintName",sprintName),Var.valueOf("timeEstimate",cronapi.json.Operations.getJsonOrMapField(item, Var.valueOf("fields.timetracking.remainingEstimate"))),Var.valueOf("aggregateTimeOriginalEstimate",cronapi.json.Operations.getJsonOrMapField(item, Var.valueOf("fields.timetracking.originalEstimate"))),Var.valueOf("assignee",cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("fields.assignee.emailAddress").toString()))),Var.valueOf("statusId",cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("fields.status.id").toString()))),Var.valueOf("statusName",cronapi.json.Operations.getJsonOrMapField(arrayIssue, Var.valueOf(baseArray.toString() + Var.valueOf("fields.status.name").toString()))));
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Issue"),item);
    } // end for
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
 * @param issueId
 * @return Var
 */
// Descreva esta função...
public static Var obterIssueApiJira(Var issueId) throws Exception {
 return new Callable<Var>() {

   private Var arrayIssue = Var.VAR_NULL;

   public Var call() throws Exception {
    arrayIssue = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"), Var.valueOf("application/json"), Var.valueOf(Var.valueOf("https://cronapp.atlassian.net/rest/api/3/issue/").toString() + issueId.toString()), Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("Authorization",Var.valueOf(Var.valueOf("Basic ").toString() + Var.valueOf(ObterTokenJira()).toString()))), Var.VAR_NULL);
    return cronapi.json.Operations.toJson(arrayIssue);
   }
 }.call();
}

}

