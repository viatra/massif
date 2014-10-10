/**
 */
package hu.bme.mit.transima.Simulink.provider;


import hu.bme.mit.transima.Simulink.Block;
import hu.bme.mit.transima.Simulink.SimulinkFactory;
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
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link hu.bme.mit.transima.Simulink.Block} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BlockItemProvider
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
    public BlockItemProvider(AdapterFactory adapterFactory) {
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

            addTriggerPropertyDescriptor(object);
            addEnablerPropertyDescriptor(object);
            addInportsPropertyDescriptor(object);
            addOutportsPropertyDescriptor(object);
            addSourceBlockPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Trigger feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTriggerPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Block_trigger_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Block_trigger_feature", "_UI_Block_type"),
                 SimulinkPackage.Literals.BLOCK__TRIGGER,
                 false,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Enabler feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEnablerPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Block_enabler_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Block_enabler_feature", "_UI_Block_type"),
                 SimulinkPackage.Literals.BLOCK__ENABLER,
                 false,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Inports feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addInportsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Block_inports_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Block_inports_feature", "_UI_Block_type"),
                 SimulinkPackage.Literals.BLOCK__INPORTS,
                 false,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Outports feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOutportsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Block_outports_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Block_outports_feature", "_UI_Block_type"),
                 SimulinkPackage.Literals.BLOCK__OUTPORTS,
                 false,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Source Block feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSourceBlockPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_Block_sourceBlock_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_Block_sourceBlock_feature", "_UI_Block_type"),
                 SimulinkPackage.Literals.BLOCK__SOURCE_BLOCK,
                 false,
                 false,
                 false,
                 null,
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
            childrenFeatures.add(SimulinkPackage.Literals.BLOCK__PROPERTIES);
            childrenFeatures.add(SimulinkPackage.Literals.BLOCK__PORTS);
            childrenFeatures.add(SimulinkPackage.Literals.BLOCK__SOURCE_BLOCK_REF);
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
     * This returns Block.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Block"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((Block)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_Block_type") :
            getString("_UI_Block_type") + " " + label;
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

        switch (notification.getFeatureID(Block.class)) {
            case SimulinkPackage.BLOCK__PROPERTIES:
            case SimulinkPackage.BLOCK__PORTS:
            case SimulinkPackage.BLOCK__SOURCE_BLOCK_REF:
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
                (SimulinkPackage.Literals.BLOCK__PROPERTIES,
                 SimulinkFactory.eINSTANCE.createProperty()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.BLOCK__PORTS,
                 SimulinkFactory.eINSTANCE.createInPort()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.BLOCK__PORTS,
                 SimulinkFactory.eINSTANCE.createOutPort()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.BLOCK__PORTS,
                 SimulinkFactory.eINSTANCE.createTrigger()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.BLOCK__PORTS,
                 SimulinkFactory.eINSTANCE.createEnable()));

        newChildDescriptors.add
            (createChildParameter
                (SimulinkPackage.Literals.BLOCK__SOURCE_BLOCK_REF,
                 SimulinkFactory.eINSTANCE.createLibraryLinkReference()));
    }

}
