Massif: Matlab Simulink Integration Framework for Eclipse
======

Massif is a new Eclipse feature to support the easy handling of Matlab Simulink models by providing import and export capabilities to/from EMF. 

Just to highglight some of its unique features Massif: (i) uses a general matlab EMF metamodel that was designed to store all infomration for each matlab block and provide the type information as defined in Matlab using library links , (ii)  provides automated library reference processing when importing libraries and systems based on those libraries and (iii) supports easier bus creator and selector handling by using direct model referencing in the EMF representation that is automatically translated into the required fqn format as used within Matlab Simulink. 

Please note as importing and exporting is done using the command line interface of Matlab (and not by directly parsing the mdl or slx files) for using the bridge you must have an installed Matlab Simulink (with the appropriate licence) on your computer. The system was tested with Simulink R2012b, however, it should work with the newer versions.

Massif was developed in a cooperation between Embraer and the Budapest University of Technology and Economics, through the TRANS-IMA (TRANSformation methods applied to the design of Integrated Modular Avionics systems) project funded by Embraer S.A.

Update site:
------------
https://build.inf.mit.bme.hu/jenkins/job/Massif/lastSuccessfulBuild/artifact/releng/hu.bme.mit.massif.site/target/repository/

I. Installation:
---------------------------
It is required to have the following tools:
 * Eclipse modeling with EMF-IncQuery and Massif installed
 * MATLAB (recommended r2012a or later)


II. Usage:
----------
Massif provides two basic model conversion functions:
 * Import from MATLAB to EMF (referred as import or importing)
 * Export from EMF to MATLAB (referred as export or exporting)

To use these features, choose a MATLAB provider. At this point you can choose between A) MatlabControl, an existing MATLAB connector, and B) Command Evaluation Server, which is provided as part of Massif.
After MATLAB is set up, Eclipse configurations has to be set.

1. Set up MATLAB:
-----------------
A) MatlabControl: You have two options to interact with MATLAB. In its current state, MatlabControl can be used to start a new MATLAB instance, run the import/export, than close the session.

B) Command Evaluation Server: In order to carry out import/export with , a running MATLAB instance is required, which runs a MatlabServer. Download the MatlabServer from here: 
https://build.inf.mit.bme.hu/jenkins/job/Massif/lastSuccessfulBuild/artifact/releng/massif.commandevaluation.server-package/
Extract it to a folder, add the contained folder named 'matlab' to the MATLAB path (e.g. use the MATLAB addpath command, or navigate to this folder within MATLAB), then run the setup script named 'setup_remote.m'. Further configuration settings can be set in 'matlabserverconfig.properties' in the same folder (modify this prior running the setup script). If everything works well, you should get an output similat to the followings:

```
>> setup_remote
Configuration path not provided, considering the following path: PATH\matlabserverconfig.properties

Host address = 127.0.0.1
Host port: 1098
Debug mode: null
Starting Matlab RMI Server...

Address = 127.0.0.1
port = 1098
serviceName = MatlabModelProviderr2012a480

Matlab RMI Server Started!
```

2. Configurations in Eclipse
---------------------------
Under Window/Preferences/SimulinkPreferences choose the desired connector with the radio button. For Command Evaluation Server set the other properties on the same page as well. Advanced import and export settings are located under SimulinkPreferences/Model Import Preferences and SimulinkPreferences/Model Export Preferences.

Under the Model Import Preferences the user can customize which model elements are imported. This can be done with import filters. By default there are 4 types of filters provided, which affect the handling of model reference blocks and library links:
 * Shallow: for each model reference block a model reference block is placed in the created EMF model, but the referenced model is not processed.
 * Deep: for each model reference block a new EMF model is created for the referenced model. The referenced models are saved under the same directory using the name of the referenced Simulink model.
 * Flattening: imports model reference blocks as though they were subsystems. This means, that the model reference is imported as a subsystem block, and the referenced model components are placed (copied) into the subsystem.
 * Referencing: each block with active library link is handled in the following way: if the library, in wihch its source block (in MATLAB terminology Reference block) is located is not yet imported, then the importer imports the corresponding library. If the library of the source block is already imported, creates a model element with a link to the specified library block.

After setting the mentioned configurations, the context menu commands of .mdl and .simulink files (right click on the files in Eclipse package explorer) called Import Simulink Model and Export Simulink Model can be used.

3. Contributing
---------------

We welcome contributors, read the [[DeveloperGuide]] for getting set up!
