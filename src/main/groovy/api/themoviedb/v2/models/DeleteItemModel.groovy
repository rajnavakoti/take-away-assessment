package api.themoviedb.v2.models

import groovy.json.JsonGenerator

/***
 * Delete Item API request json generator
 */
class DeleteItemModel {
    ArrayList<ItemMessageModel> items = null

    def static deleteItem(String mediaType,String mediaId){
        new DeleteItemModel(items: [new ItemMessageModel().deleteItemMessage(mediaType,mediaId)]) }

    def toJson(){
        JsonGenerator jg = new JsonGenerator.Options()
                .excludeNulls()
                .build()
        jg.toJson(this) }
}
