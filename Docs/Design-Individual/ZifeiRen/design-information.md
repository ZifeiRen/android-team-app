#### DataBase

- User table contains: user_id and user_name
- Grocery_list is a helpful table that lets User and List connect. One User can have one or more lists. Each list only belongs to one user.
- Users can cross the list table to look for the Products table. Users can get products and put them into the List table as an Item object. Each list can have one or more different items and quantity. 
- Categories group the products. Products_to_categories is a help table to connect products' first_level_name and second_level_name.

#### UML Class

- In the UML Class, I made five objects which are User, Item, UserList, Product, and Categories. 

- In the user object, it contains userList object. When the user login he(she) account. He(She) can look for his(her) own list. 

- Each list contains their items and quantities. 

- Item objects connect the product object and categories table. 

- The service interface provides the functions of add, find, findAll, edit, and save methods. The UserList object and the Item object can have those functions. Users can use those functions to make the user's lists. 

- We do not need to consider that requirement, such as: 

- - Lists must be saved automatically and immediately after they are modified.
  - Users must be able to check off items in a list (without deleting them).
  - Users must also be able to clear all the check-off marks in a list at once.

- Those requirements do not affect the design. Those requirements are inside in those services.