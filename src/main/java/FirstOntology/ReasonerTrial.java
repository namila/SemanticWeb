/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstOntology;


import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ReasonerRegistry;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.PrintUtil;

/**
 *
 * @author User
 */
public class ReasonerTrial {

    public static void main(String[] args) {

      printStatements("Namila");
       
    }

    public static String printStatements(String resourceName) { 
        Model schema = FileManager.get().loadModel("C:\\Users\\User\\Documents\\NetBeansProjects\\SemanticWebLatest\\SemanticWeb\\protege_files\\faculty_rdf.owl");
        Model data = FileManager.get().loadModel("C:\\Users\\User\\Documents\\NetBeansProjects\\SemanticWebLatest\\SemanticWeb\\protege_files\\instances.rdf");
        
        Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
        reasoner = reasoner.bindSchema(schema);
        InfModel infmodel = ModelFactory.createInfModel(reasoner, data);
        Resource nForce = infmodel.getResource("http://www.semanticweb.org/tmkasun/ontologies/2015/4/FIT#"+resourceName);
        Property currentProperty=null;
        Resource currentResouce=null;
        StringBuilder myStringBuilder=new StringBuilder();
        
        for (StmtIterator i = infmodel.listStatements(nForce, currentProperty, currentResouce); i.hasNext();) {
            Statement stmt = i.nextStatement();
            myStringBuilder.append(PrintUtil.print(stmt)+"\n");          
        }
        
        String resultString=myStringBuilder.toString();
        return resultString;
    }

//    private static void printProperties(Model infmodel, Resource nForce) {
//        StmtIterator myIterator = nForce.listProperties();
//
//        while (myIterator.hasNext()) {
//            Statement currentStatement = myIterator.nextStatement();
//            System.out.println(PrintUtil.print(currentStatement)+"\n\n");
//        }
//    }

}
