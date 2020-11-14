# backend-task by Gustavo De Souza
This task is developed in JAVA 11, using core dependencies and maven for compilation

## ImportManager
Responsible to import data, subclass class can be implemented and inherit importData
to take take of different import data entities such as User(in this case), Address, etc...

## FileHandler
Responsible to handle the files, in this case we only have a Default implementation (DefaultFileHandler)
its current responsibilities are to get files of an entity type and get the MINE type of a file

## ExportManager
The ExportManager is responsible to mainly export a collection of entries, the implementation of this class
are responsible to export the different types of files, CsvExportManager implementation is responsible to export CSV files,
the JsonExportManager implementation is responsible to export JSON files, the XmlExportManager implementation is responsible
to export XML files, etc... we can add more

## DatasetHandler
DatasetHandler is responsible to read dataset of a given file, as we now have three different types of files, the dataset readings must
be handle differently, therefore the implementation subclasses are CsvDatasetHandler, JsonDatasetHandler and XmlDatasetHandler, but more types
can be implemented. Also responsible to convert String Date to ISO8601 Data string

## UserDataPopulator
The UserDataPopulator class is responsible  to populate the User entity with values collected by different type of files
also responsible to map the data from a collection of user objects into different type of files.
Each file type have it's on implementation because of the data format are different for every file type, and the header/key/element
have different names but representing the same thing. i.e. "User Type" / "user_type" / "type"

## UserImportManager
The UserImportManager is to top layer responsible for the importing process for the users where combining 
the user list using java composition pattern with the ability to add user entries to a user list  

## User
It's the user entity data

## UnitTests

## ProcessTest
* testUserProcess (This is an end-to-end test)

### DatasetHandlerTest
* testReadXmlDataset
* testReadCsvDataset

### ExportManagerTest
* testCsvExport
* testJsonExport
* testXmlExport

### FileHandlerTest
* testLoadUsersFiles

### UserImportTest
* testImporData
* testOrderOfData
