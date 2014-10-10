/**
 */
package hu.bme.mit.transima.Simulink.tests;

import hu.bme.mit.transima.Simulink.LibraryLinkReference;
import hu.bme.mit.transima.Simulink.SimulinkFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Library Link Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryLinkReferenceTest extends SimulinkReferenceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LibraryLinkReferenceTest.class);
	}

	/**
	 * Constructs a new Library Link Reference test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryLinkReferenceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Library Link Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LibraryLinkReference getFixture() {
		return (LibraryLinkReference)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimulinkFactory.eINSTANCE.createLibraryLinkReference());
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

} //LibraryLinkReferenceTest
