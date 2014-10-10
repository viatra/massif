package hu.bme.mit.transima.models.simulink.validation;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.validation.runtime.Constraint;
import org.eclipse.incquery.validation.runtime.ValidationUtil;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import hu.bme.mit.transima.models.simulink.validation.ClashingChildNamesMatch;
import hu.bme.mit.transima.models.simulink.validation.util.ClashingChildNamesQuerySpecification;
import hu.bme.mit.transima.models.simulink.validation.ClashingChildNamesMatcher;

public class ClashingChildNamesConstraint0 extends Constraint<ClashingChildNamesMatch> {

	private ClashingChildNamesQuerySpecification querySpecification;

	public ClashingChildNamesConstraint0() throws IncQueryException {
		querySpecification = ClashingChildNamesQuerySpecification.instance();
	}

	@Override
	public String getMessage() {
		return "Child $child$ has a sibling in $parent$ with the same name!";
	}

	@Override
	public EObject getLocationObject(ClashingChildNamesMatch signature) {
		Object location = signature.get("child");
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
	public BaseGeneratedQuerySpecification<ClashingChildNamesMatcher> getQuerySpecification() {
		return querySpecification;
	}
}
