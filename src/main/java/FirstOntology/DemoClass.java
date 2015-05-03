/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstOntology;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.VCARD;

/**
 *
 IT Faculty domain
 * @author User
 */
public class DemoClass {
    
    public static void main(String[] args) {
        
        Model facultyModel=ModelFactory.createDefaultModel();
        
        
        // Uris
        
        // Departments
        String ITDeapartmentUri="http://ITFaculty/Department/IT";
        String CMDepartmentUri="http://ITFaculty/Department/CM";
        String ISDepartmentUri="http://ITFaculty/Department/IS";
               
        // Resources
        
        //Departments
        Resource ITDepartment=facultyModel.createResource(ITDeapartmentUri);
        Resource CMDepartment=facultyModel.createResource(CMDepartmentUri);
        Resource ISDepartment=facultyModel.createResource(ISDepartmentUri);
       
        //Setting Properties
        ITDepartment.addProperty(VCARD.TITLE,"Department Of Information Technology");
              
        CMDepartment.addProperty(VCARD.TITLE,"Department Of Computational Mathematics");
               
        ISDepartment.addProperty(VCARD.TITLE,"Department Of Interdiciplinary Studies");
        
        StmtIterator statementIterator=facultyModel.listStatements();
        while(statementIterator.hasNext()){
            Statement currentStatment=statementIterator.nextStatement();
            Resource subject=currentStatment.getSubject();
            Property predicate=currentStatment.getPredicate();
            RDFNode object=currentStatment.getObject();
            
            System.out.println("Subject "+subject.toString());
            System.out.println("Predicate "+predicate.toString());
            if(object instanceof Resource){
                System.out.println(object.toString());
            }
            else{
                System.out.println("'"+object.toString()+"'");
            }
            System.out.println("\n\n");
        }
        
        
        
        
        
        
        
        
        
        
    }
    
}
