package api.themoviedb.v2.models

import groovy.json.JsonGenerator

/***
 * Add item API request json generator
 */
class AddItemModel {
    ArrayList<ItemMessageModel> items = null

    def static addItem(String mediaType,String mediaId){
        new AddItemModel(items: [new ItemMessageModel().addItemMessage(mediaType,mediaId)]) }

    def toJson(){
        JsonGenerator jg = new JsonGenerator.Options()
                .excludeNulls()
                .build()
        jg.toJson(this) }
}
