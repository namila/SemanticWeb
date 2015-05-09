/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstOntology;


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
        
        Model schema = FileManager.get().loadModel("E:\\Academics\\Level 4 Semister 1\\Semantic Web\\Ontologies\\SampleOntology\\owlDemoSchema.owl");
        Model data = FileManager.get().loadModel("E:\\Academics\\Level 4 Semister 1\\Semantic Web\\Ontologies\\SampleOntology\\owlDemoData.rdf");
        Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
        reasoner = reasoner.bindSchema(schema);
        InfModel infmodel = ModelFactory.createInfModel(reasoner, data);
        Resource nForce = infmodel.getResource("urn:x-hp:eg/nForce");
        System.out.println("nForce *:");
        printStatements(infmodel, nForce, null, null);
    }

    private static void printStatements(Model infmodel, Resource nForce, Property object, Resource object0) {
        
        for (StmtIterator i = infmodel.listStatements(nForce,object,object0); i.hasNext(); ) {
        Statement stmt = i.nextStatement();
        System.out.println(" - " + PrintUtil.print(stmt));
        
    }
  }
    
}
