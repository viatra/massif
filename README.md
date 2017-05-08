# Massif: MATLAB Simulink Integration Framework for Eclipse

Massif is a new Eclipse feature to support the easy handling of MATLAB Simulink models by providing import and export capabilities to/from EMF. 

Just to highlight some of its unique features, Massif: 
 1. Uses a general MATLAB EMF metamodel that was designed to store all information for each MATLAB block and provide the type information as defined in MATLAB using library links
 1. Provides automated library reference processing when importing libraries and systems
 1. Supports easier bus creator and selector handling by using direct model referencing in the EMF representation that can be automatically translated into the required fqn format as used within MATLAB Simulink. 

Please note that importing and exporting is done using the command line interface of MATLAB (and not by directly parsing the mdl or slx files), which is the API recommended by MathWorks for accessing Simulink model information. As a consequence, for using the bridge you must have an installed MATLAB Simulink instance (with the appropriate licence) on your computer. The system was tested with Simulink R2012b, however, it should work with the newer versions (and some earlier ones as well).

The development of Massif was supported by multiple projects and partners, most notably:
 1. As the developer of the first verions the Budapest University of Technology and Economics
 1. Embraer through the Trans-IMA (TRANSformation methods applied to the design of Integrated Modular Avionics systems) project funded by Embraer S.A. 
 1. [CONCERTO](http://www.concerto-project.org/) Artemis EU project
 1. [IncQuery Labs Ltd](http://incquerylabs.com/) that provides professional support for Massif

## Known Users

 * [INTECS](http://www.intecs.it/)
 * [University of Padua](http://www.math.unipd.it/it/)
 * [CEA LIST](http://www-list.cea.fr/en/)

Please let us know if you use Massif (e.g. open an [issue](https://github.com/IncQueryLabs/massif/issues/new) or create a pull request with an edit on this file)!

## Update site:

### Prerequisites

 * Release 0.4.0: EMF-IncQuery 0.8 http://download.eclipse.org/incquery/updates/release/
 * Release 0.5.0: EMF-IncQuery 1.0 http://download.eclipse.org/incquery/updates/release/
 * Integration 0.6.0: VIATRA Query runtime http://download.eclipse.org/viatra/updates/release/
 * CI:  VIATRA Query runtime http://download.eclipse.org/viatra/updates/release/

### Latest release: 0.5.0

Releases: http://static.incquerylabs.com/projects/massif/release/0.4.0-0.5.0/repository
  
  * Command evaluation server archive [download](http://static.incquerylabs.com/projects/massif/release/0.4.0-0.5.0) 

### All releases

Release composite site: http://static.incquerylabs.com/projects/massif/release
  * Command evaluation server archive in folder of specific releases [download](http://static.incquerylabs.com/projects/massif/release/)

### Integration builds

Integration builds: http://static.incquerylabs.com/projects/massif/integration/
  * Command evaluation server archive in folder of specific releases [download](http://static.incquerylabs.com/projects/massif/integration/)
  * These are created regularly and old versions are discarded after a new release.

### CI update site

We also provide a [CI update site](https://build.incquerylabs.com/jenkins/job/Massif/lastSuccessfulBuild/artifact/releng/hu.bme.mit.massif.site/target/repository/).
  * Command evaluation server archive [download](https://build.incquerylabs.com/jenkins/job/Massif/lastSuccessfulBuild/artifact/releng/massif.commandevaluation.server-package/) 

[CI Build](https://build.incquerylabs.com/jenkins/job/Massif/) on Jenkins: 
[![Build Status](https://build.incquerylabs.com/jenkins/buildStatus/icon?job=Massif)](https://build.incquerylabs.com/jenkins/job/Massif/)

## I. Installation:

It is required to have the following tools:
 * Eclipse with Massif and prerequisites installed
 * MATLAB (recommended r2012a or later)

Details on the [wiki](../../wiki/UserGuide#installation)

## II. Usage:

Massif provides two basic model conversion functions:
 * Import from MATLAB to EMF (referred as import or importing)
 * Export from EMF to MATLAB (referred as export or exporting)

To use these features, choose a MATLAB provider. At this point you can choose between
 * MatlabControl, an existing MATLAB connector
 * Command Evaluation Server, which is provided as part of Massif.

The functions are available in the context menu commands of `.mdl`, `.slx` and `.simulink` files (right click on the files in `Package Explorer`) called `Import Simulink Model` and `Export Simulink Model`.

A detailed [user guide](../../wiki/UserGuide#model-importing-and-exporting) is available in the wiki.

The EclipseCon 2015 demo is available from [here](../../wiki/EclipseCon2015)
with its video presentation from [here](https://www.youtube.com/watch?v=6mv4m5UT9YE)

### Get help

If you run into any problems or have questions, do the following:
  1. Read the [wiki](../../wiki/Home)
  1. Look at the open and closed [issues](../../issues)

If you need more help, open a [new issue](../../issues/new) describing your problem.

## III. Contributing

We welcome contributors, read the [DeveloperGuide](../../wiki/DevelopersGuide) for setting up shop!
