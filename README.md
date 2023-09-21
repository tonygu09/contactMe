# ContactMe

## What Will the Application Do?
ContactMe will be a contacts application that creates groups for contacts to be slotted into. The different groups will
be **clients**, **friends**, and **services**. For clients, there are two types of clients: Those who are looking to buy and those
who are looking to sell. When the user selects that their client is looking to buy, the UI will prompt them to enter:
-  The client's name,
-  Phone number,
-  Email,
-  The client's current address,
-  The client's interested listing,
-  Notes regarding the client

For those who are looking to sell, the UI will prompt them to enter the same, except it will exclude the client's
interested listing option.

For friends, the UI will prompt the user to enter:
- The friend's name,
- Birthday,
- Phone Number,
- Home Address.

Lastly, for services, the UI will prompt the user to enter in:
- The service's name,
- The service's phone number,
- What type of service it is providing

As a user who is troubled with keeping track of all the contacts in this modern age, I want to be able to store contacts
into different groups, view contacts, whether it be a list of all of them or their respective groups, edit contacts with
new and updated information later, and create new contacts. Additionally, as a user, I want to be able to save my
contacts that I have created to a file (if I choose so) as well as be given the option to view one previously created
contacts through loading the information through the file.

## Who Will Use It?
This application will be primarily for **Real Estate** agents who have to keep track of many different people, all of whom
serve a distinct purpose. By using this application, they are easily able to find the people that they are looking to
contact.

## Why is this project of interest to me?
As a child growing up, I would always love to tamper with phones. I remember distinctly going through my mom's phone and
seeing the massive amount of contacts. I was deeply intimidated by the sheer number of contacts and still to this day,
my mom does not have an efficient solution to the problem. Thinking about this more broadly, many Real Estate agents
face similar issues where there are so many contacts that they forget. As a result, this project is of deep interest to
me to help my mom solve a long-lasting problem.

## Instructions for Grader
When a user first runs the project, they are prompted with two options: Create Contact or Edit/View Contacts. **This is
also where one of the visual components of the project are, as it displays a picture of a person holding a thumbs up**.


If a user decides to try and view a contact before creating a contact, the page will display that the user has not
created any contacts. After pressing creating contact, the user has 4 options to choose from. Each option is a group
which the contact will be stored under. **This is where the first user story comes in as you are able to store multiple
contacts before actually saving to a file, or store one X to the Y, or store multiple X's to the Y at the same time.**


This is most profoundly demonstrated after creating a singular contact. At
that point, the user will be prompted to either save, create new, or go to menu. By saving, the data will be saved to a
file. If a user decides to create another contact, and then save, the user will now save two contacts at the same time.
Lastly, when the user is satisfied they may go back to the main menu. Now that the user has created a contact, they can
fully access the edit/view page. After clicking this button, the user is once again prompted with 4 groups they can
choose to view from. **After clicking into any one of the groups, if the user has created a contact under the group they
will be displayed in a table, yet another visual component.**

The table itself not only serves as a visual component but also is **able to filter through the list of X's**. This
would be a visual representation of the X's that have been added to the Y's. By
clicking the top right corner of the top column, one is able to sort through the names alphabetically (through first
name) as well as sort through the date that they were created. Furthermore, this table serves as the basis for viewing.
If a user wishes to see one of the previously stored clients, they can simply double-click one of the names that they
see and the data of that individual will be loaded. After clicking into any individual, any previously stored data about
the person will be loaded and there is an option to delete the contact in its entirety or to edit the contact.

## Future Improvements
If you had more time to work on the project, one major thing I would do is use abstract classes and interfaces. While
coding this project, I was often confused about how to implement it and even when I tried, my code would result in
errors. As a result, I hard-coded a lot of things. Furthermore, to improve the project in the future, I would add more
information that the user can filter through. Currently, the user is only able to filter through the contact's first
name or the date in which they created the contact. Because there were so many things that I had learned during the
CPSC210 semester, I really wish that I had the proper time to go through my code and implement as many concepts as I
possibly could. 