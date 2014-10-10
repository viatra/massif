package hu.bme.mit.transima.models.simulink.validation;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.transima.models.simulink.validation.IdentifierNameContainsSlashMatch;
import hu.bme.mit.transima.models.simulink.validation.util.IdentifierNameContainsSlashQuerySpecification;
import hu.bme.mit.transima.models.simulink.validation.IdentifierNameContainsSlashMatcher;

public class IdentifierNameContainsSlashConstraint0 extends Constraint<IdentifierNameContainsSlashMatch> {

	private IdentifierNameContainsSlashQuerySpecification querySpecification;

	public IdentifierNameContainsSlashConstraint0() throws IncQueryException {
		querySpecification = IdentifierNameContainsSlashQuerySpecification.instance();
	}

	@Override
	public String getMessage() {
		return "Identifier $id$ must not contain \'/\'!";
	}

	@Override
	public EObject getLocationObject(IdentifierNameContainsSlashMatch signature) {
		Object location = signature.get("id");
		if(location instanceof EObject){
			return (EObject) location;
		}
		return null;
	}

	@Override
	public int getSeverity() {
		return ValidationUtil.getSeverity("error");
	}

	@Override
	public BaseGeneratedQuerySpecification<IdentifierNameContainsSlashMatcher> getQuerySpecification() {
		return querySpecification;
	}
}
