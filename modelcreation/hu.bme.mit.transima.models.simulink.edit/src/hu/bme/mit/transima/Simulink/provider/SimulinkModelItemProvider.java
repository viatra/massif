/**
 */
package hu.bme.mit.transima.Simulink.provider;


import hu.bme.mit.transima.Simulink.SimulinkFactory;
import hu.bme.mit.transima.Simulink.SimulinkModel;
import hu.bme.mit.transima.Simulink.SimulinkPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.transima.Simulink.SimulinkModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulinkModelItemProvider
    extends SimulinkElementItemProvider
    implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimulinkModelItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addVersionPropertyDescriptor(object);
            addFilePropertyDescriptor(object);
            addLibraryPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Version feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVersionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SimulinkModel_version_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_SimulinkModel_version_feature", "_UI_SimulinkModel_type"),
                 SimulinkPackage.Literals.SIMULINK_MODEL__VERSION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the File feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFilePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SimulinkModel_file_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_SimulinkModel_file_feature", "_UI_SimulinkModel_type"),
                 SimulinkPackage.Literals.SIMULINK_MODEL__FILE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Library feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addLibraryPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SimulinkModel_library_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_SimulinkModel_library_feature", "_UI_SimulinkModel_type"),
                 SimulinkPackage.Literals.SIMULINK_MODEL__LIBRARY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

				/**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns SimulinkModel.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/SimulinkModel"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((SimulinkModel)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_SimulinkModel_type") :
            getString("_UI_SimulinkModel_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(SimulinkModel.class)) {
            case SimulinkPackage.SIMULINK_MODEL__VERSION:
            case SimulinkPackage.SIMULINK_MODEL__FILE:
            case SimulinkPackage.SIMULINK_MODEL__LIBRARY:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case SimulinkPackage.SIMULINK_MODEL__CONTAINS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createBusSelector()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createBusCreator()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createGoto()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createFrom()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createOutPortBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createInPortBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createTriggerBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createEnableBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createGotoTagVisibility()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createSubSystem()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SIMULINK_MODEL__CONTAINS,
                 SimulinkFactory.eINSTANCE.createModelReference()));
    }

}
