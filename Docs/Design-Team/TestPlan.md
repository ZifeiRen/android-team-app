# Test Plan

**Author**: Team 4 (Patrick Ilker, Zifei Ren, Christen De Ocampo, Jianguo Jin, Anthony Gong, Wengang Zhang)

## 1 Testing Strategy

### 1.1 Overall strategy
- Through JUnit we will be testing unit cases to find and keep track of bugs.
- _Integration testing_ will test interaction and integration between different units. 
- _System testing_ will test the system as a whole and ensure that functionality and performance goals are met. 
- _Regression testing_ will be utilized to ensure newly added components or functionality will not will cause bugs in the existing system. 

### 1.2 Test Selection
- _Black-Box Technique_: We will utilize system and regression testing to check and confirm that the behavior of the application works properly (i.e. activities produce expected outputs based on user input).
- _White-Box Technique_: We will test each function multiple times individually by going through the code structure and checking to see if each unit test that we made works.

### 1.3 Adequacy Criterion
- Make sure all test cases for components are covered through individual testing.
- Manually test interactions between units and ensure proper functionallity. 

### 1.4 Bug Tracking
- By testing one method at a time we can track which errors occur individually, thus making it concise and easy to keep track of bugs.

### 1.5 Technology
- For testing purposes, we will use the following technologies:
    - JUnit
    - IDE Debugging feature 
- We tested our cases manually.

## 2 Test Cases

| Purpose                 | Test Case                  | The Steps Necessary to Perform the Test | Expected Result                       | Actual Result                         | Pass/Fail |
| :---------------------- | -------------------------- | --------------------------------------- | :------------------------------------ | :------------------------------------ | :-------- |
| Test addList            | addList(String)             | Input: String: nameList                  | List has been **added**.                                 | List has been **added**.                                 | Pass      |
| Test addList            | addList(String)             | Input: String: nameList                  | List has been **added**.                                 | Warning: No success; Not successful, list has not been **added**.                | Fail      |
| Test addList            | addList(String)             | Input: String: nameList (duplicate)      | Warning: No success; List name can not be the same. | Warning: No success; List name can not be the same. | Pass      |
| Test addList            | addList(String)             | Input: String: nameList (duplicate)      | Warning: No success; List name can not be the same. | List has been **added**.                                 | Fail      |
| Test deleteList         | deleteList(String)         | Input: String: nameList                  | List has been **deleted**.                               | List has been **deleted**.                               | Pass      |
| Test deleteList         | deleteList(String)         | Input: String: nameList                  | List has been **deleted**.                               | Warning: No success; List name has not been deleted.                   | Fail      |
| Test updateList         | updateList(String)         | Input: String: nameList                  | List name has been changed.                          | List name has been changed.                          | Pass      |
| Test updateList         | updateList(String)         | Input: String: nameList                  | List name has been changed.                          | Warning: No success; List name has not been changed.                   | Fail      |
| Test updateList         | updateList(String)         | Input: String: nameList (duplicate)      | Warning: List name cannot be the same. | Warning: List name cannot be the same. | Pass      |
| Test updateList         | updateList(String)         | Input: String: nameList (duplicate)      | Warning: List name can not be the same. | List has been **added**.                                 | Fail      |
| Test addItemFromList    | addItemFromList(String)    | Input: String: nameItem                  | Item has been **added**.                                 | Item has been **added**.                                   | Pass      |
| Test addItemFromList    | addItemFromList(String)    | Input: String: nameItem                  | Item has been **added**.                                   | Warning: No success, item has not been added.                   | Fail      |
| Test deleteItemFromList | deleteItemFromList(String) | Input: String: nameItem                  | Item has been **deleted** from list.                               | Item has been **deleted** from list                               | Pass      |
| Test deleteItemFromList | deleteItemFromList(String) | Input: String: nameItem                  | Item has been **deleted** from list                               | Warning: No success, item has not been deleted from list.                   | Fail      |
| Test addItem            | addItem(String)             | Input: String: nameItem                  | Item has been **added**.                                 | Item has been **added**.                           | Pass      |
| Test addItem            | addItem(String)             | Input: String: nameItem                  | Item has been **added**.                                 | Warning: No success, item has not been added.                  | Fail      |
| Test addItem            | addItem(String)             | Input: String: nameItem(duplicate)       | Warning: Item name can not be the same. | Warning: Item name can not be the same. | Pass      |
| Test addItem            | addItem(String)             | Input: String: nameItem(duplicate)       | Warning: Item name can not be the same. | Warning: No success, item has not been added.                                 | Fail      |
| Test deleteItem         | deleteItem(String)         | Input: String: nameItem                  | Item has been **deleted**.                               | Item has been **deleted**.                               | Pass      |
| Test deleteItem         | deleteItem(String)         | Input: String: nameItem                  | Item has been **deleted**.                               | Warning: No success, item has not been deleted.                   | Fail      |
| Test updateItem         | updateItem(String)         | Input: String: nameItem                  | Item name has been **changed**.                          | Item name has been **changed**.                          | Pass      |
| Test updateItem         | updateItem(String)         | Input: String: nameItem                  | Item name has been **changed**.                          | Warning: No success, item name has not been changed.                  | Fail      |
