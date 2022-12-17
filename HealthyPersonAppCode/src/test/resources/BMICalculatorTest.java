import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.healthypersonapp.BMICalculator;
import com.healthypersonapp.Person;
public class BMICalculatorTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Initializing SetUp at Class Level");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("De Initializing SetUp at Class Level");
	}
	@Before
	public void setUp() throws Exception {
		System.out.println("Initializing SetUp at Method Level");
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("De Initializing SetUp at Method Level");
	}
	
	@Test
	public void  should_ReturnTrue_When_DietRecommended() {
		assertEquals(BMICalculator.isDietRecommended(160.0, 2.0),true);	
	}
	@Test
	public void  should_ReturnFalse_When_DietNotRecommended() {
		assertEquals(BMICalculator.isDietRecommended(40.0, 3.0),false);	
	}
	@Test(expected=ArithmeticException.class)
	public void  should_ThrowArithmeticException_When_HeightZero(){
		BMICalculator.isDietRecommended(50.0, 0.0);	//When height=0,throws an ArithmeticException.		
	}
	@Test()
	public void should_ReturnPersonWithWorstBMI_When_PersonListNotEmpty() {
		List<Person> persons=Arrays.asList(
				new Person(2.0, 60.0, 10),
				new Person(3.0,40.0,20),
				new Person(2.5,150.0,19),
				new Person(4.0,100.0,26));
		BMICalculator.findPersonWithWorstBMI(persons);
		//returns with worstBMI when list is not empty. 
	}
}
