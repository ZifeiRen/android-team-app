
1.	The grocery list must allow users to add items to a list, delete items from a list, and change the quantity of items in the list.  To fulfill this requirement the GroceryList class I added has the following fields ListID, ListName, ListQuantity and TotalPrice. The methods that come with it are createList() to create a new list, addItem() which adds an item to the list, deleteItem() which removes an item from the list, deleteList() to delete an existing list and renameList() to rename a list.

2.	The application must contain a database (DB) of items and corresponding item types. To realize this requirement, I add an Item class and an ItemType class which have a composition relationship to each other. The Item class has the fields itemID and itemName witch the methods addItem() and deleteItem(). The itemType class has the fields ItemTypeID and ItemTypeName and has the methods addItemType() and deleteItemType(). 

3.	Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item. To realize this requirement I created a user class with the fields userID and usersName with the methods createUser() and deleteUser(). The user can add items to the list using methods that are in the GroceryList class which has a composite relationship with the User class.

4.	Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add.  This does not affect the design of the class directly but rather what is in the database. 

5.	Lists must be saved automatically and immediately after they are modified. The addItem() and deleteItem() from GroceryList class will do this.

6.	Users must be able to check off items in a list (without deleting them). I added a CheckOff class which has a composite relationship with the GroceryList class.  The CheckOff class consists of the fields listID, ItemID and checkoff Boolean value. The methods are setCheckedOff and clearCheckedOff() to set and clear the items chosen from the list.

7.	User must be able to clear all the check marks from the list at once. We can use the clearCheckedOff() method to clear all the checked marks from the list.

8.	Check-off marks for a list are persistent and must also be saved immediately. The setCheckedOff() method will do this.

9.	The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once.  Through the ItemType class we can do this. The itemType class has the fields ItemTypeID and ItemTypeName and has the methods addItemType() and deleteItemType(). 

10.	The application must support multiple lists at a time and must provide the users with the ability to create, (re)name, select, and delete lists.  We design this through the GroceryList class which a User can create multiple lists but every list must have an existing user. The class has the method createList(), addItem(), deleteItem(), renameList() and deleteList() methods.

11.	The User Interface (UI) must be intuitive and responsive. Not considered because it is not part of the class design.


