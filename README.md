# Massif: Matlab Simulink Integration Framework for Eclipse

Massif is a new Eclipse feature to support the easy handling of Matlab Simulink models by providing import and export capabilities to/from EMF. 

Just to highlight some of its unique features Massif: (i) uses a general matlab EMF metamodel that was designed to store all infomration for each matlab block and provide the type information as defined in Matlab using library links , (ii)  provides automated library reference processing when importing libraries and systems based on those libraries and (iii) supports easier bus creator and selector handling by using direct model referencing in the EMF representation that is automatically translated into the required fqn format as used within Matlab Simulink. 

Please note as importing and exporting is done using the command line interface of Matlab (and not by directly parsing the mdl or slx files) for using the bridge you must have an installed Matlab Simulink (with the appropriate licence) on your computer. The system was tested with Simulink R2012b, however, it should work with the newer versions.

Massif was developed in a cooperation between Embraer and the Budapest University of Technology and Economics, through the TRANS-IMA (TRANSformation methods applied to the design of Integrated Modular Avionics systems) project funded by Embraer S.A.

## Update site:

We only provide a [CI update site](https://build.inf.mit.bme.hu/jenkins/job/Massif/lastSuccessfulBuild/artifact/releng/hu.bme.mit.massif.site/target/repository/) at the moment, more stable versions will be published on a dedicated page.

[CI Build](https://build.inf.mit.bme.hu/jenkins/job/Massif/) on Jenkins.

## I. Installation:

It is required to have the following tools:
 * Eclipse modeling with EMF-IncQuery and Massif installed
 * MATLAB (recommended r2012a or later)

Details on the [wiki](https://github.com/FTSRG/massif/wiki/UserGuide#installation)

## II. Usage:

Massif provides two basic model conversion functions:
 * Import from MATLAB to EMF (referred as import or importing)
 * Export from EMF to MATLAB (referred as export or exporting)

To use these features, choose a MATLAB provider. At this point you can choose between
 * MatlabControl, an existing MATLAB connector
 * Command Evaluation Server, which is provided as part of Massif.

The functions are available in the context menu commands of `.mdl`, `.slx` and `.simulink` files (right click on the files in `Package Explorer`) called `Import Simulink Model` and `Export Simulink Model`.

A detailed [user guide](https://github.com/FTSRG/massif/wiki/UserGuide#model-importing-and-exporting) is available in the wiki.

## III. Contributing

We welcome contributors, read the [DeveloperGuide](https://github.com/FTSRG/massif/wiki/DevelopersGuide) for setting up shop!
