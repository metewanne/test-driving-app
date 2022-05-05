# test-driving-app

There's a need for a new dealership booking app. The idea is to have a console interface that is able to take user input to book a car of their choice for a test drive, which is available onsite in the dealership. The user will be wanting to look for an existing car that exists on the system. When the user visits, they'll be required to input some basic details, e.g. name, surname, email.

 Now they'll be asked for what car brand they're looking for specifically, if it matches, they'll be presented with all the cars available for that specific brand, and if otherwise, be told they were incorrect and presented with a list of ALL the vehicles available.

 If the car exists, the user will be presented with all the car information and prompted to ask whether they'll like to book this car, or if they'd like to search for another car, or even exit.

 Following on from searching another car, when the user books a car, they'll be asked if they would like another booking, they'll be presented with the list of vehicles following the same format as above - the existing car should be removed

Now, we've got a car booking app but we'd like to expand the functionality presented to the user; we'd like to include an advanced options section that lets the user filter the cars they can see in the following order:
* 		Year (Newest to oldest)
* 		Price (low to high)
* 		Brand (alphabetical)
* 		Mileage (low to high)
 

There's currently a new need for a new dealership booking app for customers to book to. You'll have cars available for booking a test drive…
Users will want to look for a car of interest, (can look up by what the user inputs, or present them the list of available cars to use that they can choose from - include error handling of user input e.g. if the car doesn't exist, try again). When a match is found, display the car information and ask the user if they want to confirm this booking and provide the current date time, off when this booking was made in the print line.

Once the user confirms they want to book the specific car, I want it to be removed from the availability list and added to a confirmed bookings list. Ask the user if they would like to book another car too?

Now expand this, as a user I want to list the cars from highest to lowest in regards to price or mileage as a search option, this would be optional to use. I could either book a specific car because I'm certain, or use this search to give me good options.
![image](https://user-images.githubusercontent.com/33934181/166900380-74f9ca2d-9ef7-4694-8f66-086dafc002fa.png)
