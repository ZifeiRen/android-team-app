Wengang Zhang
cs370assignment5
student id 23550585
1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).
To realize this requirement, I added to the design a class shopping cart with attributes product id, product name, product price and quantity of item, and function change_quantity_items(), remove_items() and add_items().Customers find the product id (barcode) in the product list through the product name and add it to the shopping cart through the product id. Add items by function, delete items from the list and change the number of items in the list.
2. The application must contain a database (DB) of items and corresponding item types.
To realize this requirement, I added to the design a class product with attributes product id and category id and add class category with attribute category id and category name.Products can be found by searching category id for category name, and products are classified by category.
3. Users must be able to add items to a list by picking them from a hierarchical list, where
the first level is the item type (e.g., cereal), and the second level is the name of the
actual item (e.g., shredded wheat). After adding an item, users must be able to specify a
quantity for that item.
To realize this requirement, I let the product class find different categories through the category id, and divide the product list into different categories according to the category. The product class is the first class, the next level is the product type (for example, grain), and the next level is the actual product name (for example, wheat shreds), and the attribute is the product id. The user can find the product type by searching for the category name. , To find the id through the product name, and then find the desired product at the product type level, and add it to your shopping cart through the function
4. Users must also be able to specify an item by typing its name. In this case, the
application must look in its DB for items with similar names and ask the users, for each
of them, whether that is the item they intended to add. If a match cannot be found, the
application must ask the user to select a type for the item and then save the new item,
together with its type, in its DB.
Through class product, you can find the product id by name to find the product. Find items with similar names Not considered because it does not affect the design directly.
5. Lists must be saved automatically and immediately after they are modified.
Not considered because it does not affect the design directly.
6. Users must be able to check off items in a list (without deleting them).
Of course users can browse products
To realize this requirement, I added function browse_products() in the user class. Browse products by product name to view the detailed information of the product
7. Users must also be able to clear all the check-off marks in a list at once.
Not considered because it does not affect the design directly.
8. Check-off marks for a list are persistent and must also be saved immediately.
Not considered because it does not affect the design directly.
9. The application must present the items in a list grouped by type, so as to allow users to
shop for a specific type of products at once (i.e., without having to go back and forth
between aisles).
To realize this requirement, I added to the design a class cereals with attributes and product name and product price. The same other product type grouping lists also have these attributes, because they are the next level of the product and inherit the attributes of the previous level. Users can view the products in the list grouped by type, so as to allow users to purchase specific types of products immediately .
10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
farmer’s market list”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete lists.
To realize this requirement, I added to the design a class user with function view list()， create list() and delete list() 
11. The User Interface (UI) must be intuitive and responsive.
Not considered because it does not affect the design directly.