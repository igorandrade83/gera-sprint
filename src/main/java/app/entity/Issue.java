package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela ISSUE
* @generated
*/
@Entity
@Table(name = "\"ISSUE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Issue")
public class Issue implements Serializable {

    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.Integer id;

    /**
    * @generated
    */
    @Column(name = "key", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String key;

    /**
    * @generated
    */
    @Column(name = "name_project", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nameProject;

    /**
    * @generated
    */
    @Column(name = "priority", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String priority;

    /**
    * @generated
    */
    @Column(name = "summary", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String summary;

    /**
    * @generated
    */
    @Column(name = "sprint", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer sprint;

    /**
    * @generated
    */
    @Column(name = "sprint_name", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String sprintName;

    /**
    * @generated
    */
    @Column(name = "time_estimate", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String timeEstimate;

    /**
    * @generated
    */
    @Column(name = "aggregate_time_original_estimate", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String aggregateTimeOriginalEstimate;

    /**
    * @generated
    */
    @Column(name = "assignee", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String assignee;

    /**
    * @generated
    */
    @Column(name = "statusId", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer statusId;

    /**
    * @generated
    */
    @Column(name = "StatusName", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String statusName;

    /**
    * Construtor
    * @generated
    */
    public Issue(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    
    public java.lang.Integer getId(){
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Issue setId(java.lang.Integer id){
        this.id = id;
        return this;
    }
    /**
    * Obtém key
    * return key
    * @generated
    */
    
    public java.lang.String getKey(){
        return this.key;
    }

    /**
    * Define key
    * @param key key
    * @generated
    */
    public Issue setKey(java.lang.String key){
        this.key = key;
        return this;
    }
    /**
    * Obtém nameProject
    * return nameProject
    * @generated
    */
    
    public java.lang.String getNameProject(){
        return this.nameProject;
    }

    /**
    * Define nameProject
    * @param nameProject nameProject
    * @generated
    */
    public Issue setNameProject(java.lang.String nameProject){
        this.nameProject = nameProject;
        return this;
    }
    /**
    * Obtém priority
    * return priority
    * @generated
    */
    
    public java.lang.String getPriority(){
        return this.priority;
    }

    /**
    * Define priority
    * @param priority priority
    * @generated
    */
    public Issue setPriority(java.lang.String priority){
        this.priority = priority;
        return this;
    }
    /**
    * Obtém summary
    * return summary
    * @generated
    */
    
    public java.lang.String getSummary(){
        return this.summary;
    }

    /**
    * Define summary
    * @param summary summary
    * @generated
    */
    public Issue setSummary(java.lang.String summary){
        this.summary = summary;
        return this;
    }
    /**
    * Obtém sprint
    * return sprint
    * @generated
    */
    
    public java.lang.Integer getSprint(){
        return this.sprint;
    }

    /**
    * Define sprint
    * @param sprint sprint
    * @generated
    */
    public Issue setSprint(java.lang.Integer sprint){
        this.sprint = sprint;
        return this;
    }
    /**
    * Obtém sprintName
    * return sprintName
    * @generated
    */
    
    public java.lang.String getSprintName(){
        return this.sprintName;
    }

    /**
    * Define sprintName
    * @param sprintName sprintName
    * @generated
    */
    public Issue setSprintName(java.lang.String sprintName){
        this.sprintName = sprintName;
        return this;
    }
    /**
    * Obtém timeEstimate
    * return timeEstimate
    * @generated
    */
    
    public java.lang.String getTimeEstimate(){
        return this.timeEstimate;
    }

    /**
    * Define timeEstimate
    * @param timeEstimate timeEstimate
    * @generated
    */
    public Issue setTimeEstimate(java.lang.String timeEstimate){
        this.timeEstimate = timeEstimate;
        return this;
    }
    /**
    * Obtém aggregateTimeOriginalEstimate
    * return aggregateTimeOriginalEstimate
    * @generated
    */
    
    public java.lang.String getAggregateTimeOriginalEstimate(){
        return this.aggregateTimeOriginalEstimate;
    }

    /**
    * Define aggregateTimeOriginalEstimate
    * @param aggregateTimeOriginalEstimate aggregateTimeOriginalEstimate
    * @generated
    */
    public Issue setAggregateTimeOriginalEstimate(java.lang.String aggregateTimeOriginalEstimate){
        this.aggregateTimeOriginalEstimate = aggregateTimeOriginalEstimate;
        return this;
    }
    /**
    * Obtém assignee
    * return assignee
    * @generated
    */
    
    public java.lang.String getAssignee(){
        return this.assignee;
    }

    /**
    * Define assignee
    * @param assignee assignee
    * @generated
    */
    public Issue setAssignee(java.lang.String assignee){
        this.assignee = assignee;
        return this;
    }
    /**
    * Obtém statusId
    * return statusId
    * @generated
    */
    
    public java.lang.Integer getStatusId(){
        return this.statusId;
    }

    /**
    * Define statusId
    * @param statusId statusId
    * @generated
    */
    public Issue setStatusId(java.lang.Integer statusId){
        this.statusId = statusId;
        return this;
    }
    /**
    * Obtém statusName
    * return statusName
    * @generated
    */
    
    public java.lang.String getStatusName(){
        return this.statusName;
    }

    /**
    * Define statusName
    * @param statusName statusName
    * @generated
    */
    public Issue setStatusName(java.lang.String statusName){
        this.statusName = statusName;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Issue object = (Issue)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}