//Calls the Service class to do the real work
package ngdemo.drooltest.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import ngdemo.drooltest.domain.DroolObject;


public class DroolObjectService 
{
	
   public void executeDrools()
   {
	   try
	   {
	   PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		DroolObject product = new DroolObject();
		product.setType("gold");

		workingMemory.insert(product);
		workingMemory.fireAllRules();

		System.out.println("The discount for the product " + product.getType()
				+ " is " + product.getDiscount()); 
		
		DroolObject product2 = new DroolObject();
		product2.setType("diamond");
		workingMemory.insert(product2);
		workingMemory.fireAllRules();
		System.out.println("The discount for the product " + product2.getType()
		+ " is " + product2.getDiscount()); 
		
	   }
	   catch (Exception ee)
	   {
	       System.out.println(ee);	
	   }
   }
}