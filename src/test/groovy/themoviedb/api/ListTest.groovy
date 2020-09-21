package themoviedb.api

import api.themoviedb.v2.models.AddItemModel
import api.themoviedb.v2.models.CreateListModel
import api.themoviedb.v2.models.UpdateItemModel
import api.themoviedb.v2.models.UpdateListModel
import api.themoviedb.v2.request.AddItemRequest
import api.themoviedb.v2.request.CreateListRequest
import api.themoviedb.v2.request.GetListRequest
import api.themoviedb.v2.request.UpdateItemRequest
import api.themoviedb.v2.request.UpdateListRequest
import com.mysql.cj.xdevapi.UpdateResult
import io.qameta.allure.Story
import org.testng.annotations.Test

class ListTest {
    CreateListModel createListModel = null
    UpdateListModel updateListModel = null
    AddItemModel addItemModel = null
    UpdateItemModel updateItemModel = null

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

    @Story("")
    @Test()
    void addItemToList(){
        addItemModel = AddItemModel.addItem("movie","550")
        AddItemRequest.addItemsToList(addItemModel.toJson(),"7059051")
    }

    @Story("")
    @Test()
    void updateItem(){
        updateItemModel = UpdateItemModel.updateItem("Movie","550","comment")
        UpdateItemRequest.updateItem(updateItemModel.toJson(),"7059051")
    }
}
