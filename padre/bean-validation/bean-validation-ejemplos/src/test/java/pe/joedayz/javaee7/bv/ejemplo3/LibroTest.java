package pe.joedayz.javaee7.bv.ejemplo3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class LibroTest {

	  // ======================================
	  // =             Attributes             =
	  // ======================================

	  protected static ValidatorFactory vf;
	  protected static Validator validator;

	  // ======================================
	  // =          Lifecycle Methods         =
	  // ======================================

	  @BeforeClass
	  public static void init() {
	    vf = Validation.buildDefaultValidatorFactory();
	    validator = vf.getValidator();
	  }

	  @AfterClass
	  public static void close() {
	    vf.close();
	  }

	  // ======================================
	  // =              Methods               =
	  // ======================================

	  @Test
	  public void shouldRaiseNoConstraintViolation() throws NoSuchMethodException {

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Constructor<Libro03> constructor = Libro03.class.getConstructor(String.class, Float.class, String.class, String.class, Integer.class, Boolean.class);
	    Set<ConstraintViolation<Libro03>> violations = methodValidator.validateConstructorParameters(constructor, new Object[]{"H2G2", 12.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false});
	    assertEquals(0, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintViolationCausePriceLow() throws NoSuchMethodException {

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Constructor<Libro03> constructor = Libro03.class.getConstructor(String.class, Float.class, String.class, String.class, Integer.class, Boolean.class);
	    Set<ConstraintViolation<Libro03>> violations = methodValidator.validateConstructorParameters(constructor, new Object[]{"H2G2", 0.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false});
	    displayContraintViolations(violations);
	    assertEquals(1, violations.size());
	  }

	  @Test
	  public void shouldRaiseConstraintsViolationCauseTitleAndPriceNull() throws NoSuchMethodException {

	    ExecutableValidator methodValidator = validator.forExecutables();
	    Constructor<Libro03> constructor = Libro03.class.getConstructor(String.class, Float.class, String.class, String.class, Integer.class, Boolean.class);
	    Set<ConstraintViolation<Libro03>> violations = methodValidator.validateConstructorParameters(constructor, new Object[]{null, null, null, null, null, null});
	    displayContraintViolations(violations);
	    assertEquals(2, violations.size());
	  }

	  private void displayContraintViolations(Set<ConstraintViolation<Libro03>> constraintViolations) {
	    for (ConstraintViolation constraintViolation : constraintViolations) {
	      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
	              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

	    }
	  }
}
