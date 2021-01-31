# Use Case Model

**Author**: Team 4 (Patrick Ilker, Zifei Ren, Christen De Ocampo, Jianguo Jin, Anthony Gong, Wengang Zhang)

## 1 Use Case Diagram

![GroceryListManager Use-Case Diagram ](https://user-images.githubusercontent.com/44532399/96925881-d5c9ac80-1482-11eb-90d8-9de3b84de694.png)

## 2 Use case Descriptions

- *Requirements*: User installs the app.
- *Pre-conditions*: User initiated project with no problems.
- *Post-conditions*: The user enters the main interface and user information is displayed, such as previously saved lists. If no list has been created, user can add new list. Function keys: add list, query item. 
- *Scenarios*: 
  - Add a new list:	
    1. Allow user to add list name
    2. Allow user to add items into the list
    3. Allow user to save list
  - Delete list(s):
    1. Allow user to delete one or more lists at same time
  - Update list:
    1. Allow user to change list's name
    2. Allow user to add or delete items in the list
  - Add a new item:
    1. If there is no item the user wants in the items database, the user is allowed to add a new item to the items' database and its category.
  - Delete item(s):
    1. Allow user to delete one or more items from database
  - Update item:
    1. Allow user to change item's category and name
    2. Allow user to change item's quantity
  - Checkoff item:
    1. Allow user to checkoff one items or more
    2. Allow user to delete checkoff 
