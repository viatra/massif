/**
 */
package hu.bme.mit.massif.simulink.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>simulink</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulinkTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new SimulinkTests("simulink Tests");
		suite.addTestSuite(BlockTest.class);
		suite.addTestSuite(InPortTest.class);
		suite.addTestSuite(OutPortTest.class);
		suite.addTestSuite(TriggerTest.class);
		suite.addTestSuite(EnableTest.class);
		suite.addTestSuite(BusSelectorTest.class);
		suite.addTestSuite(BusCreatorTest.class);
		suite.addTestSuite(GotoTest.class);
		suite.addTestSuite(FromTest.class);
		suite.addTestSuite(SimulinkModelTest.class);
		suite.addTestSuite(MultiConnectionTest.class);
		suite.addTestSuite(SingleConnectionTest.class);
		suite.addTestSuite(OutPortBlockTest.class);
		suite.addTestSuite(InPortBlockTest.class);
		suite.addTestSuite(TriggerBlockTest.class);
		suite.addTestSuite(EnableBlockTest.class);
		suite.addTestSuite(GotoTagVisibilityTest.class);
		suite.addTestSuite(SubSystemTest.class);
		suite.addTestSuite(ModelReferenceTest.class);
		suite.addTestSuite(LibraryLinkReferenceTest.class);
		suite.addTestSuite(IdentifierReferenceTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkTests(String name) {
		super(name);
	}

} //SimulinkTests
