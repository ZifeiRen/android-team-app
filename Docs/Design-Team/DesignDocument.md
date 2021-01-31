# Design Document

**Author**: Team 4 (Patrick Ilker, Zifei Ren, Christen De Ocampo, Jianguo Jin, Anthony Gong, Wengang Zhang)

## 1 Design Considerations

### 1.1 Assumptions
- User has an android environment that can run this app.
- The app is dependent on a Database for storing/retriving items.

### 1.2 Constraints
- The screen size of mobile apps affects UI design.
- App is designed for Android platforms; may not work on other mobile platforms. 

### 1.3 System Environment
- This app is designed to run on Android mobile devices, specifically smartphones.
- Minimum Android 5.0 (API Level 21, Lollipop).

## 2 Architectural Design

### 2.1 Component Diagram
![Software Component Diagram](https://user-images.githubusercontent.com/44532399/96930431-af5b3f80-1489-11eb-8584-928bcd87c45e.png)
- For our prototype system, we included three classes: _User List, User, and Item_, as well as two class interfaces: _UserList Interface and Item Service_ Interface as displayed above. These are essential in ensuring the functionality of our application.
- The UserList Interface has a dependency with UserList class, while Item Service Interface has a dependency with Item Service. As for User and UserList and User and Item, the user should be able to add a new list and add a new item to the list.

### 2.2 Deployment Diagram
- In the scope of this project, a deployment diagram is not necessary. The only hardware interaction is between the App and the Database. 

## 3 Low-Level Design
- User component can create a new list or add a new item to an existing list.
- UserList interface has the *addList, deleteList, findAllList* methods.
- ItemService interface contains *addItem, deleteItem, findAll, findByName methods*.
- Both UserList and ItemService interfaces will auto update and save.

### 3.1 Class Diagram Prototype (Old)
![design-team-old](https://user-images.githubusercontent.com/44532399/96286698-c6dc8900-0fae-11eb-9626-4b3fc4aba7a1.png)

### 3.1.1 Updated Class Diagram 
- After the code was implemented we found ourselves with redundant variables. Hence they were removed.
- We ended up not using the UserList and ItemService interfaces so we removed them as well.
![design-team](https://user-images.githubusercontent.com/44532399/98454417-3ff47980-2132-11eb-814f-76613d120920.png)

### 3.2 Other Diagrams
- Below is our Use-Case diagram, which displays different scenarios of our app functionalities, including *adding a list, deleting a list, adding an item, etc.*
![GroceryListManager Use-Case Diagram](https://user-images.githubusercontent.com/44532399/96925881-d5c9ac80-1482-11eb-90d8-9de3b84de694.png)

## 4 User Interface Design
- App should be easy for user to follow and transition between tasks should be smooth.
- Here is our **Prototype UI** for our app:

    ![Home-Page-Old](https://user-images.githubusercontent.com/44532399/97623315-da024680-19fb-11eb-86d1-5c6b80f4b132.png)

- Here is our **Final UI** for our app:

    ![Home-Page](https://user-images.githubusercontent.com/70495621/98297258-244a7100-1f82-11eb-8a4e-dc3ae8d061c6.png)
