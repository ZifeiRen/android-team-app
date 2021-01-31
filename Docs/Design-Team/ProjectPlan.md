# Project Plan

**Author**: Team 4 (Patrick Ilker, Zifei Ren, Christen De Ocampo, Jianguo Jin, Anthony Gong, Wengang Zhang)

## 1 Introduction

GroceryListManager is an application designed for users to create and manage grocery lists.

## 2 Process Description

__Item Category Activity__

1. Find item category
    - Description: Find all items in the database and group them by category name. For items that cannot be found, the user selects a type for those items and then saves them.
    - Input: None
    - Output: All Item Categories
        - Success: For the item being specified, a similar item with a category is found in its database.

__Item Activities__

1. Find all items
     - Description: Function allows user to find all items
     - Input: none
     - Output: all items

2. Update item
     - Description: Function to update quantity of an item on a users list. 
     - Input: item category, item name, item quantity
     - Output: 
         - Success -- database update success
         - Fail -- database update fail

3. Add item
     - Description: Function allows user to add an item to their list.
     - Input: Item name, item category, item quantity
     - Output: 
         - Success -- Database update success
         - Fail -- Database update fail

4. Delete item
    - Description: Function allows user to delete item from their list.
    - Input: Item id
    - Output: 
        - Success -- database update success
        - Fail -- database update fail

__List Activities__

  1. Find all lists
     - Description: This activity allows users to search through the lists they created by name.
     - Input: List name
     - Output: all lists

  2. Add list
     - Description: Function to create a new list. 
     - Input: list name, add items
     - Output:
         - Success -- Database update success, list added
         - Fail -- Database update fail

  3. Delete list
     - Description: Function allows user to delete list.
     - Input: list id
     - Output: 
       - Success -- Database update success, list deleted
       - Fail -- Database update fail
     
  4. Checkoff item(s)
     - Description: Function to allow the user to mark/unmark items on a list. 
     - Input: Item ID(s)
     - Output: 
         - Success -- Database update success, item marked or clear mark
         - Fail -- Database update fail, item did not mark or clear

## 3 Team 
### Team Members
- Patrick Ilker
- Zifei Ren
- Christen De Ocampo
- Jianguo Jin
- Anthony Gong
- Wengang Zhang

### Roles
- __Project Manager:__ 
    1. Assigns tasks to project team members
    2. Develops a project plan
    3. Manages deliverables according to the plan

- __Database Developer:__
    1. Data managment: acquires and retrieves data
    2. Data and database organization

- __Front-End Developer:__
    1. Completes individual deliverables
    2. Documents the process
    3. Designs User interface(UI) and layout

- __Back-End Developer:__ 
    1. Completes individual deliverables and database communications
    2. Focuses on services and scripting behind the server
    3. Consists of the server which provides data on request, the application which channels it, and the database which organizes the information

- __QA Testing Developer:__
    1. Tests solutions to validate activties and objectives 
    2. Documents all test cases


### Table
Team Member | Team Role
------------ | -------------
Patrick Ilker | Front-end Developer
Zifei Ren | Back-end Developer
Christen De Ocampo | Project Manager
Jianguo Jin | Front-end Developer
Anthony Gong | Database Developer
Wengang Zhang | QA Testing Developer
