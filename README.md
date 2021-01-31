# android-team-app
Background
Brad and Janet are tired of doing grocery lists with pencil and paper and are unhappy with each and every existing app for managing grocery lists. Because they are rich and bored, they decide to hire a team of programmers to develop ​GroceryListManager​, an Android app for managing grocery lists that works exactly the way they want it. Your team has been contacted by Brad and Janet, who provided the set of requirements listed below and want to see a possible design for the system before moving forward and formally hire your team. Because Brad and Janet studied computer science in college and are familiar with UML, they want the design to be represented using a UML class diagram. Luckily, the members of your team already have experience designing systems of this kind, so the team should be able to hit the ground running and produce a good design quickly.
Goals
● Develop an Android app that implements the grocery list manager that Brad and Janet envisioned (and that your team already designed).
● Get experience with (a simplified version of) the Unified Software Process.

Requirements
1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).
2. The application must contain a database (DB) of ​items​ and corresponding ​item types​.
    
3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.
4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.
5. Lists must be saved automatically and immediately after they are modified.
6. Users must be able to check off items in a list (without deleting them).
7. Users must also be able to clear all the check-off marks in a list at once.
8. Check-off marks for a list are persistent and must also be saved immediately.
9. The application must present the items in a list grouped by type, so as to allow users to
shop for a specific type of products at once (i.e., without having to go back and forth
between aisles).
10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
farmer’s market list”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete lists.
11. The User Interface (UI) must be intuitive and responsive.
