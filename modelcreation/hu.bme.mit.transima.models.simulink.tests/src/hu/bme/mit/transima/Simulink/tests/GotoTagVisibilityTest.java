/**
 */
package hu.bme.mit.transima.Simulink.tests;

import hu.bme.mit.transima.Simulink.GotoTagVisibility;
import hu.bme.mit.transima.Simulink.SimulinkFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Goto Tag Visibility</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GotoTagVisibilityTest extends VirtualBlockTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GotoTagVisibilityTest.class);
	}

	/**
	 * Constructs a new Goto Tag Visibility test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GotoTagVisibilityTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Goto Tag Visibility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GotoTagVisibility getFixture() {
		return (GotoTagVisibility)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimulinkFactory.eINSTANCE.createGotoTagVisibility());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //GotoTagVisibilityTest
