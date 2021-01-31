Requirements:

1.	A grocery list consists of items the users want to buy at a grocery store. The application
	must allow users to add items to a list, delete items from a list, and change the quantity
	of items in the list (e.g., change from one to two pounds of apples).

1)  Needed in UML diagram
	Class: List
	The List class contains(among others) the methods add(), delete() and update(), which allows the user
	to add items to the list, delete items from the list and update amount of a specific item on the list.
	
	
2. 	The application must contain a database (DB) of items and corresponding item types
	
2)  Needed in UML diagram, DB modeling not in scope of this assignment
	Class: Database
	The application contains a Database(DB) with the required items to be put on the list. 
	
	
3.	Users must be able to add items to a list by picking them from a hierarchical list, where
	the first level is the item type (e.g., cereal), and the second level is the name of the
	actual item (e.g., shredded wheat). After adding an item, users must be able to specify a
	quantity for that item.
	
3)	Needed in UML diagram
	Class: ItemType
	The ItemType class inherits from the item class. In the ItemType class, the user can specify a type(name) of item
	and add the desired quantity. 
	
	
4.	Users must also be able to specify an item by typing its name. In this case, the
	application must look in its DB for items with similar names and ask the users, for each
	of them, whether that is the item they intended to add. If a match cannot be found, the
	application must ask the user to select a type for the item and then save the new item,
	together with its type, in its DB.
				
4)Needed in UML diagram
	Class: List	
	The searchItemName() method allows to search for an Item by name or smililar name in the DB. If the named Item doesnt exist,
	the searchItemType() method allows to search for the typ of item and specify if it should be added and saved to the DB. 
	
	
5.	Lists must be saved automatically and immediately after they are modified.
		
5)  Needed in UML diagram
	Class: List
	The saveList() method in the List class is automatically called if modification method(add(), delete(), update()) is called. 


6.	Users must be able to check off items in a list (without deleting them).

6)	Needed in UML diagram
	Class: List
	The check() method in the List class allows to check or mark items on the list. The functionallity can be imagined 
	similar to a boolean flag, where an item is either marked or not, and multiple marked items can be modified 
	at the same time. 


7.	Users must also be able to clear all the check-off marks in a list at once
	
7)	Needed in UML diagram
	Class: List
	The method checkClearAll() method allows the user to clear all the checked items in a List.
	
	
8.	Check-off marks for a list are persistent and must also be saved immediately.

8)	Needed in UML diagram 
	Class: List
	The saveList() method is also called when the check() or checkClearAll() methods are called. 
	
	
9.	The application must present the items in a list grouped by type, so as to allow users to
	shop for a specific type of products at once (i.e., without having to go back and forth
	between aisles).

9)	Needed in UML diagram
	Class: List
	The sortList() method is called when the add(), delete() or update() methods are being called. The sortList()
	method ensures that items are grouped by type. 
	
	
10.	The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
	farmer’s market list”). Therefore, the application must provide the users with the ability to
	create, (re)name, select, and delete lists.
	
10)	Needed in UML diagram
	Class: User
	The User class contains methods createList(), renameList(), selectList(), deleteList(), that allows the user
	to manage his lists and create and delete lists, but also rename lists or select multiple for deletion. 


11. The User Interface (UI) must be intuitive and responsive.

11)	NOT Needed in UML diagram
	-not considered because its not a design issue.