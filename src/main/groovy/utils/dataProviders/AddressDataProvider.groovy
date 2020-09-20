package utils.dataProviders

import org.testng.annotations.DataProvider

class AddressDataProvider {
    @DataProvider(name="validAddress")
    static Object[][] validAddress(){
        def array = [["Test1","Test2"],["Test3","Test4"]]
        return array
    }
}
