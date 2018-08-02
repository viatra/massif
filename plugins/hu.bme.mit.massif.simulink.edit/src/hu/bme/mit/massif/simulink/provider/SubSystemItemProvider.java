/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Abel Hegedus, Akos Horvath - initial API and implementation 
 *******************************************************************************/

package hu.bme.mit.massif.simulink.provider;


import hu.bme.mit.massif.simulink.SimulinkFactory;
import hu.bme.mit.massif.simulink.SimulinkPackage;
import hu.bme.mit.massif.simulink.SubSystem;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.massif.simulink.SubSystem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SubSystemItemProvider extends BlockItemProvider {
	/**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SubSystemItemProvider(AdapterFactory adapterFactory) {
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

            addTagPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

	/**
     * This adds a property descriptor for the Tag feature.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void addTagPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_SubSystem_tag_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_SubSystem_tag_feature", "_UI_SubSystem_type"),
                 SimulinkPackage.Literals.SUB_SYSTEM__TAG,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
            childrenFeatures.add(SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS);
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
     * This returns SubSystem.gif.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/SubSystem"));
    }

	/**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String getText(Object object) {
        String label = ((SubSystem)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_SubSystem_type") :
            getString("_UI_SubSystem_type") + " " + label;
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

        switch (notification.getFeatureID(SubSystem.class)) {
            case SimulinkPackage.SUB_SYSTEM__TAG:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case SimulinkPackage.SUB_SYSTEM__SUB_BLOCKS:
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
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createBusSelector()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createBusCreator()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createGoto()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createFrom()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createOutPortBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createInPortBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createTriggerBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createEnableBlock()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createGotoTagVisibility()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createSubSystem()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.SUB_SYSTEM__SUB_BLOCKS,
                 SimulinkFactory.eINSTANCE.createModelReference()));
    }

}
