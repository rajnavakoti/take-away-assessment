package themoviedb.api

import api.themoviedb.v2.models.CreateListModel
import api.themoviedb.v2.models.UpdateListModel
import api.themoviedb.v2.request.CreateListRequest
import api.themoviedb.v2.request.GetListRequest
import api.themoviedb.v2.request.UpdateListRequest
import io.qameta.allure.Story
import org.testng.annotations.Test
import com.github.javafaker.Faker
import utils.dataProviders.AddressDataProvider

class ListTest {
    CreateListModel createListModel = null
    UpdateListModel updateListModel = null

    @Story("")
    @Test()
    void getListOfItems(){
        GetListRequest.getList(1)
    }

    @Story("")
    @Test()
    void createANewMovieList(){
        createListModel = CreateListModel.createList("Test List Name 3")
        CreateListRequest.createANewList(createListModel.toJson())
    }

    @Story("")
    @Test()
    void updateMovieList(){
        updateListModel = UpdateListModel.updateList("Test Description")
        UpdateListRequest.updateList(updateListModel.toJson(),"7059051")
    }

}
