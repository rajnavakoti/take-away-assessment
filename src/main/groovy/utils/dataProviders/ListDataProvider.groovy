package utils.dataProviders

import org.testng.annotations.DataProvider
import org.apache.commons.lang3.RandomStringUtils

/***
 * Data provider class for List,Item test cases (add,get,update,remove)
 */
class ListDataProvider {
    static int randomStringLength = 6
    static String charset = (('0'..'9')).join()
    @DataProvider(name="validListDetails")
    static Object[][] validListDetails(){
        String listName = "Test List Name " + RandomStringUtils.random(randomStringLength, charset.toCharArray())
        String listDescription = "Test Description " + RandomStringUtils.random(randomStringLength, charset.toCharArray())
        def array = [[listName,"en",listDescription]]
        return array }

    @DataProvider(name="updateListData")
    static Object[][] updateListData(){
        String listDescription = "Test Description " + RandomStringUtils.random(randomStringLength, charset.toCharArray())
        def array = [[listDescription,"1","The item/record was updated successfully.","true"]]
        return array }

    @DataProvider(name="addItemToListData")
    static Object[][] addItemToListData(){
        def array = [["","movie","284053","1","Success.","true"],
                     ["77777","movie","284053","34","The resource you requested could not be found.","false"]]
        return array }

    @DataProvider(name="updateItemToListData")
    static Object[][] updateItemToListData(){
        def array = [["","movie","284054","1","Success.","true","Random Comment"],
                     ["999999","movie","284054","34","The resource you requested could not be found.","false","Random Comment"]]
        return array }

    @DataProvider(name="removeItemToListData")
    static Object[][] removeItemToListData(){
        def array = [["","movie","284055","1","Success.","true"],
                     ["999999","movie","284055","34","The resource you requested could not be found.","false"]]
        return array }
}
