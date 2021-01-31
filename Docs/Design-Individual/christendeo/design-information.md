```sh
Christen De Ocampo
```
# Grocery Store Manager (Design Analysis)
For each design requirement that is listed for the application, there are certain aspects I considered to determine whether or not that requirement should be implemented in my design or not.

__Below you will find the explanation for each requirement in terms of their functionality in the app:__

> * [Requirement 1](#requirement-1)
> * [Requirement 2](#requirement-2)
> * [Requirement 3](#requirement-3)
> * [Requirement 4](#requirement-4)
> * [Requirement 5](#requirement-5)
> * [Requirement 6](#requirement-6)
> * [Requirement 7](#requirement-7)
> * [Requirement 8](#requirement-8)
> * [Requirement 9](#requirement-9)
> * [Requirement 10](#requirement-10)
> * [Requirement 11](#requirement-11)

### Requirement 1
_A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples)._
- For this, I added a class named GroceryList with methods addItems(), deleteItems(), and changeItemQuantity(). addItems() permits users to add items to a list; deleteItems() permits users to delete items from a list; changeItemQuanity() permits users to change the item quantity in the list.
- I also added a class named GroceryUsers dedicated for the application users. The relationship between GroceryList and GroceryUsers is composition because without a user, there would be no list.

### Requirement 2
_The application must contain a database (DB) of items and corresponding item types._
- Here, I added two classes: A class named Items starting with attributes itemName and itemType, and another class named ItemTypes starting with attribute itemType. These classes will serve an integral purpose for the rest of the remaining requirements of the database. The relationship of these classes is aggregation since the type of an item is part of item overall.
- I also added a comment: "The Application's Database (DB)" connecting the two classes for indication.

### Requirement 3
_Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item._
- Here, I added an attribute to the Items class named itemQuantity, which specifies the quantity of the item they add. Then I added the changeItemQuantity() method to the same class since it has stated that the user must be able to set the items' quantity.
- I also added two more attributes to the same class: itemIdentifier, which contains the unique ID of the item for sorting purposes, and itemLevel as part of the hierarchical list.

### Requirement 4
_Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB._
- For this requirement, I decided to add two methods: searchName(), which looks for items by the name provided by the user, and searchType(), which looks for items by type, to the Items class.
- The application will look for similar items based on the name and detect whether the item is specified with a type or not. Hence, I made two methods for the ItemTypes class: setItemType() to set the type for the item and getItemType() to retrieve the type for the item.

### Requirement 5
_Lists must be saved automatically and immediately after they are modified._
- This requirement is not necessarily implemented into the design since it does not affect it directly.

### Requirement 6
_Users must be able to check off items in a list (without deleting them)._
- Here, I decided to create a class called CheckOffItem, which contains the boolean attribute isItemChckedOff for letting the application know whether the item is checked off or not, as well as the two methods: addCheckOff() and removeCheckOff() to ensure that the items being checked off are only being checked, not deleted.

### Requirement 7
_Users must also be able to clear all the check-off marks in a list at once._
- For this, I added a method in the GroceryList class called clearCheckMarks() that will allow the user to simoustaneously remove all the check-off marks they put. This method would be activated by a button in the application.

### Requirement 8
_Check-off marks for a list are persistent and must also be saved immediately._
- This requirement is not necessarily implemented into the design since it does not affect it directly.

### Requirement 9
_The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles)._
- For this, I added a method in the GroceryList class called groupItemsByType(), which makes the application categorize the selected items by type so that it would be more convenient for the user to view a certain type of products.

### Requirement 10
_The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists._
- Here, I went on to add four methods in the GroceryUsers class: createList(), which permits the user to make a new list; renameList(), which permits the user to change the name of a list; selectList(), which permits the user to choose any list they created; and finally deleteList(), which permits the user to remove the list(s) they created. 

### Requirement 11
_The User Interface (UI) must be intuitive and responsive._
- This requirement is not necessarily implemented into the design since it does not affect it directly.