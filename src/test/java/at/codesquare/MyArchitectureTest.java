package at.codesquare;

import at.codesquare.annotation.Entity;
import at.codesquare.annotation.Service;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class MyArchitectureTest {
    static JavaClasses importedClasses;

    @BeforeAll
    static void importClasses() {
        importedClasses = new ClassFileImporter().importPackages("at.codesquare");
    }

    @Test
    void testServiceRules() {
        ArchRule rule = classes().that().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("Service")
                .andShould().resideInAPackage("..service..")
                .as("Services should reside in a package '..service..'");

        rule.check(importedClasses);
    }

    @Test
    void testEntityRules() {
        ArchRule rule = classes().that().areAnnotatedWith(Entity.class)
                .should().resideInAPackage("..entity..")
                .as("Entities should reside in a package '..entity..'");

        rule.check(importedClasses);
    }
}
