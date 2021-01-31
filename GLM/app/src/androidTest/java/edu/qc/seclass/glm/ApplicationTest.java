package edu.qc.seclass.glm;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onData;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {
    /**1. Initialize items to put into the DB
     * 2. Making new list, make sure it gets added to the DB
     * 3. Renaming list name
     * 4. Deleting list
     * 5. Adding new item to list (existing item)
     * 6. Changing item quantity
     * 7. Adding item to DB (adding brand new item to list
     * 9. deleting a item from a list
     * */
//    @Rule
//    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
//    private String listOne, listTwo;
//    private String searchByItemName,searchByItemType;
//    private String productName, category;
//    private int newItemQuantity;
//
//
//    @Before
//    public void initializeVars(){
//        listOne = "Monday's List";
//        listTwo = "Tuesday's List";
//
//        productName = "Kitkat";
//        category = "Snack";
//        newItemQuantity = 2;
//    }

//    @Test
//    public void testMakingList(){
//        //Adding lists
//       onView(withId(R.id.loginBttn)).perform(click());
//       onView(withId(R.id.createListBttn)).perform(click());
//       onView(withId(R.id.HPcreateNewListET)).perform(typeText(listOne), closeSoftKeyboard());
//       onView(withId(R.id.HPcreateNewBttn)).perform(click());
//
//
////        Testing that they have been added
//        onData(anything()).inAdapterView(withId(R.id.listsListView)).atPosition(0).onChildView(withId(R.id.listRowLabel)).check(matches(withText(listOne)));
//
//    }



//    @Test
//    public void deleteList(){
//        //deleting list
//        onView(withId(R.id.loginBttn)).perform(click());
//        onView(withId(R.id.deleteListBttn)).perform(click());
//        onData(anything()).inAdapterView(withId(R.id.DeleteListItemListView)).atPosition(0).onChildView(withId(R.id.deleteListCheckBox)).perform(click());
//        onView((withId(R.id.HPDeleteListBttn))).perform(click());
//
//        //Testing that list has been deleted
//        onData(anything()).inAdapterView(withId(R.id.listsListView)).atPosition(0).onChildView(withId(R.id.listRowLabel)).check(matches(withText(listTwo)));
//
//    }
//
//    @Test
//    public void addItemToList(){
//        //adding pre-existing item to list
//        //Testing that item has been added to list
//    }
//
//    @Test
//    public void addingNewItemToList(){
//        //adding new item to list
//        //Testing that item has been added to the list
//    }
//
//    @Test
//    public void changeItemQuantity(){
//        //changing item quantity
//        //Testing that item quantity has been updated
//    }
//
//    @Test
//    public void addingItemByName(){
//        //searching for item by name and adding it to the list
//        //Testing that item has been added to the list
//    }
//
//    @Test
//    public void deleteOneItem(){
//        //deleting one item from the list
//        //Testing that the item is no longer in the list
//    }

}