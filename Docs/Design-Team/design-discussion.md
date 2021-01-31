```﻿sh
Patrick Ilker, Zifei Ren, Christen De Ocampo, Jianguo Jin, Anthony Gong, Wengang Zhang
```
# Team 4: UML Design Grocery List Manager Discussion

__Table of Contents/Sections__
* [Design 1](#design-1)
* [Design 2](#design-2)
* [Design 3](#design-3)
* [Design 4](#design-4)
* [Design 5](#design-5)
* [Design 6](#design-6)
* [Team Design](#team-design)
* [Summary](#summary)

## Design 1
![Patrick Ilker's Design](https://user-images.githubusercontent.com/44532399/96287339-c8f31780-0faf-11eb-932b-8016309b9260.png)

`Patrick Ilker's Design`

`Pros:`
* Design satisfies the given requirements in Assignment 5.
* There exists a clear relationship between each class, as well as the multiplicities that are labeled appropriately (i.e. the 1 to 0 or more relationship between the classes __User__ and __List__).
* Design is straightforward and not filled with too many irrelevant attributes and methods.

`Cons:`
* __Item__ class and __ItemType__ class can be merged into a category table.
* There is no way to add or reduce the number of individual products purchased (missing methods).
* A redundant _amount_ attribute in __ItemType__ class.

## Design 2
![Zifei Ren's Design](https://user-images.githubusercontent.com/44532399/96287321-c1cc0980-0faf-11eb-8dca-b474707613ff.png)

`Zifei Ren's Design`

`Pros:`
* Design satisfies the given requirements in Assignment 5.
* There is a clear distinction between the objects and service. For instance, the interface classes __UserListService__ and __ItemService__ are separated from the other classes to distinguish the required methods.
* Methods include arguments and return types, which allow for clearer comprehension.

`Cons:`
* There are missing multiplicities between certain classes (i.e. __Product__ and __Item__).
* __Product__ class is not necessary as an __Item__ class with similar attributes and methods exist.

## Design 3
![Christen De Ocampo's Design](https://user-images.githubusercontent.com/44532399/96287316-c0024600-0faf-11eb-9a98-46008374ecbd.png)

`Christen De Ocampo's Design`

`Pros:`
* Design satisfies the given requirements in Assignment 5.
* Each class is color coded which allows for easy readability (i.e. __Items__ and __ItemTypes__ are colored orange to indicate they are part of the application's database).
* Most class relationships include the appropriate multiplicities.

`Cons:`
* The relationship between the classes __Items__ and __ItemTypes__ should be generalization, not aggregation.
* Attributes _itemLevel_ and _checkedOff_ in the __Items__ class are redundant.

## Design 4
![Jianguo Jin's Design](https://user-images.githubusercontent.com/44532399/96287311-bed11900-0faf-11eb-8d92-07eecb934a0f.png)

`Jianguo Jin's Design`

`Pros:`
* Design satisfies the given requirements in Assignment 5.
* The name labelings between certain classes help clarify the relationships (i.e. __User__ and __Category__ classes).
* Multiplicities are stated appropriately.

`Cons:`
* Redundant __LineItem__ class, which can be implemented in __Item__ class.
* There are missing variables in _GroceryList_ class (i.e. the ability to search and modify the list).

## Design 5
![Anthony Gong's Design](https://user-images.githubusercontent.com/44532399/96287123-7580c980-0faf-11eb-8f39-feea77d6d113.png)

`Anthony Gong's Design`

`Pros:`
* Design satisfies the given requirements in Assignment 5.
* Design is straightforward and easy to read as there is not too many redundant variables or methods.
* The relationship multiplicities are labeled appropriately.

`Cons:`
* There is a missing _modify_ method in __User__ class that would allow the user to change the list quantity.
* __User__ class should also have a _password_ attribute.
* __Item__ class needs a _quantity_ attribute.

## Design 6
![Wengang Zhang's Design](https://user-images.githubusercontent.com/44532399/96287324-c2fd3680-0faf-11eb-83f4-0df356bc8179.png)

`Wengang Zhang's Design`

`Pros:`
* Design satisfies the given requirements in Assignment 5.
* Design adds useful functionality that is beyond what is stated in Assignment 5 (i.e. __checkout__ class is included)
* Relationships between classes are name-labeled appropriately (i.e. __product__ "has" __category__)

`Cons:`
* The specific classes: __cereals__, __fruit__, and __wheat shreds__ are not needed; An __Item__ class would be more general.
* Some redundant variables and methods from certain classes (i.e. _tax_ in __checkout__ class).

## Team Design
![design-team](https://user-images.githubusercontent.com/44532399/96286698-c6dc8900-0fae-11eb-9626-4b3fc4aba7a1.png)

The final design we formulated is based on `Zifei Ren's` design with the addition of some structural modifications that implement certain aspects from the other individual designs:

`Commonalities Between Designs:`
* We noticed a similarity in structure of our __User__ and __Item__ classes compared to the final design, more specifically the attributes and methods we declared (i.e. the __User__ class having methods to create one or more lists, and the __Item__ class having an item ID as an attribute).
* We have similar dependency relationships between some classes, including __User__ and __UserList__, as well as __Item__ and __Categories__.
* We overall have similar attribute names, types and visibility for certain classes (i.e. most of our designs have the attributes of each class set to private like the final design).

`Differences Between Designs:`
* There are some designs that are too specific when it comes method arguments and return types (i.e. classifying two types of products: cereals and fruit as two classes rather than just generalizing it into one __Item__ class).
* One design, which is Zifei's, included class interfaces to declare the appropriate methods, while the other designs didn't and declared the methods in the appropriate classes.
* Some designs are missing the _check(off)_ method or class, which should be with the __Items__ class.
* Some designs are missing multiplicities among the relationships unlike the final design.

## Summary
* Through the peer review process, we identified pros and cons of each individual designs and explained to each other what to implement in our design for improvement.
* We identified redundant methods and variables in the individual designs.
* We broke down the assignment requirements and clarified outstanding discrepancies in order to come to a unified understanding regarding the requirements.
* As for teamwork, we utilized tools for collaborative work like LucidChart, Google Docs and Zoom, which allowed us to communicate efficiently.
* Furthermore, we comprehensively concluded to a final design of the team after going through the different designs of each individual.
* We also learned that the design should be simple and clear and the appropriate class relationships should be determined.
