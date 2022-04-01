# Note Web App

<br>

## Programme Features:

The programme is used to store, search, and view note collections. It features an index that keeps track of the text-based notes. The complete content of a note can be accessed by clicking on it. Notes are displayed as a list of their names. They can be sorted based on their name and date of creation. They can be searched by looking up their titles. Notes can be added and removed, as well as renamed and their contents changed. The notes are automatically loaded when a note is displayed. While adding a new note or updating an existing one, changes are saved as soon as the "Done" button is clicked. The input is checked to ensure that the note's name isn't blank. An existing note's name can be reused, and the programme will automatically add a number to the front of the name to distinguish it.

<br>

## UML Diagram

![UML Diagram](https://github.com/aryanagarwal9/Notes-Web-App/blob/main/UML.jpg)

## Design & Programming Process:

The requirements were the starting point for the design process. Because the application required a user interface (View) as well as a back-end (Model) to fulfil additional functional needs, the Model-View-Controller (MVC) design pattern was used. During the design phase, an iterative approach was used. The Model's required classes were initially determined: a Note Class to represent each note and an Index Class to handle the collection of Notes. The View was chosen to be created using Java Server Pages, whereas the Controller was chosen to be done using Servlet Classes. The Model, View, and Controller were all built at the same time, rather than separately. Working on each requirement, the programme was created in stages.

Almost every need was approached in the following way: 
* Chose the required methods
* Assign methods to each class based on its specific function. 
* Determine how requests and answers will flow between the Model, View, and Controller. 
* Write the code
* Refactor 

There are three main classes in the Model: Note, Index, and Model. The Note class is used to represent each note. This class is in charge of saving the note's name and handling the text file that goes with it. The Index class is responsible for keeping track of the collection of Note instances. The Model never interacts with the Note class directly. The Index class is in charge of passing information between the Model and the Note classes. The Model instructs the Index of operations such as updating or deleting a note, and the Index locates the required Note and conducts the requested action. The Index also supplies the Model with necessary data, such as a list of note names that may be sent to the View to be shown. When a note with the same name already exists, the Index warns the model by throwing an exception which is handled by the model. 

Java Server Pages (JSPs) have been used for the View which takes user input and displays the appropriate results by communicating with the Model through the Controller.

For the Controller, Servlets have been used, and each Servlet acts as a Controller. The Servlets communicate with the Model and the View. A Model Factory is used to provide the controller with a Model and ensures that only one Model instance is created.

The code is written in an object-oriented manner. The Note, Index, and Model classes make great use of abstraction. They are a unified group with unique roles. The code for the Controller and View has been separated into several Servlet classes and JSPs, which makes the code more readable and maintainable. The only way to communicate between the Model and the Note is through the Index, and the only way to communicate between the Model and the View is through the controller. Thus, maintainability improves as dependencies are decreased. All classes and methods don’t have public access. They are restricted in their ability to emphasise the concept of encapsulation.
