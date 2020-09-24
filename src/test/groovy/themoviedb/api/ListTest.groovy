package themoviedb.api

import api.themoviedb.v2.models.AddItemModel
import api.themoviedb.v2.models.CreateListModel
import api.themoviedb.v2.models.DeleteItemModel
import api.themoviedb.v2.models.UpdateItemModel
import api.themoviedb.v2.models.UpdateListModel
import api.themoviedb.v2.request.AddItemRequest
import api.themoviedb.v2.request.ClearListRequest
import api.themoviedb.v2.request.CreateListRequest
import api.themoviedb.v2.request.DeleteItemRequest
import api.themoviedb.v2.request.GetListRequest
import api.themoviedb.v2.request.UpdateItemRequest
import api.themoviedb.v2.request.UpdateListRequest
import io.qameta.allure.Story
import io.restassured.response.ValidatableResponse
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import org.apache.commons.lang3.RandomStringUtils
import utils.dataProviders.ListDataProvider

class ListTest {
    CreateListModel createListModel = null
    UpdateListModel updateListModel = null
    AddItemModel addItemModel = null
    UpdateItemModel updateItemModel = null
    DeleteItemModel deleteItemModel = null
    ValidatableResponse createListResponse, getListResponse, updateListResponse, addItemResponse, UpdateItemResponse, deleteItemResponse, clearListResponse
    String listId
    int randomStringLength = 6
    String charset = (('0'..'9')).join()

    @BeforeMethod()
        before(){
        String listName = "Test List Name " + RandomStringUtils.random(randomStringLength, charset.toCharArray())
        String listDescription = "Test Description " + RandomStringUtils.random(randomStringLength, charset.toCharArray())
        createListModel = CreateListModel.createList(listName,"en",listDescription)
        createListResponse = CreateListRequest.createANewList(createListModel.toJson())
        CreateListRequest.assertSuccessResponse(createListResponse,"1","The item/record was created successfully.","true")
        listId = CreateListRequest.getListId(createListResponse) }

    @Story("")
    @Test()
    void getList(){
        getListResponse = GetListRequest.getList(listId)
        GetListRequest.assertListId(getListResponse,listId) }

    @Story("")
    @Test(dataProvider = "updateListData", dataProviderClass = ListDataProvider)
    void updateMovieList(String description,String statusCode,String statusMessage,String successFlag){
        updateListModel = UpdateListModel.updateList(description)
        updateListResponse = UpdateListRequest.updateList(updateListModel.toJson(),listId)
        UpdateItemRequest.assertSuccessResponse(updateListResponse,statusCode,statusMessage,successFlag)
    }

    @Story("")
    @Test(dataProvider = "addItemToListData", dataProviderClass = ListDataProvider)
    void addItemToList(String listIdExt,String mediaType,String mediaId,String statusCode,String statusMessage,String successFlag){
        addItemModel = AddItemModel.addItem(mediaType,mediaId)
        addItemResponse = AddItemRequest.addItemsToList(addItemModel.toJson(),listId+listIdExt)
        AddItemRequest.assertSuccessResponse(addItemResponse,statusCode,statusMessage,successFlag)
    }


    @Story("")
    @Test(dataProvider = "updateItemToListData", dataProviderClass = ListDataProvider)
    void updateItem(String listIdExt,String mediaType,String mediaId,String statusCode,String statusMessage,String successFlag,String randomComment){
        addItemModel = AddItemModel.addItem(mediaType,mediaId)
        addItemResponse = AddItemRequest.addItemsToList(addItemModel.toJson(),listId)
        AddItemRequest.assertSuccessResponse(addItemResponse,"1","Success.","true")
        updateItemModel = UpdateItemModel.updateItem(mediaType,mediaId,randomComment)
        UpdateItemResponse = UpdateItemRequest.updateItem(updateItemModel.toJson(),listId+listIdExt)
        UpdateItemRequest.assertSuccessResponse(UpdateItemResponse,statusCode,statusMessage,successFlag)
    }

    @Story("")
    @Test(dataProvider = "removeItemToListData", dataProviderClass = ListDataProvider)
    void removeItem(String listIdExt,String mediaType,String mediaId,String statusCode,String statusMessage,String successFlag){
        addItemModel = AddItemModel.addItem(mediaType,mediaId)
        addItemResponse = AddItemRequest.addItemsToList(addItemModel.toJson(),listId)
        AddItemRequest.assertSuccessResponse(addItemResponse,"1","Success.","true")
        deleteItemModel = DeleteItemModel.deleteItem(mediaType,mediaId)
        deleteItemResponse = DeleteItemRequest.deleteItemFromList(deleteItemModel.toJson(),listId+listIdExt)
        DeleteItemRequest.assertSuccessResponse(deleteItemResponse,statusCode,statusMessage,successFlag)
    }

    @Story("")
    @AfterMethod()
    void clearList(){
        clearListResponse = ClearListRequest.clearList(listId)
        ClearListRequest.assertSuccessResponse(clearListResponse,"1","Success.","true")
        }
}
