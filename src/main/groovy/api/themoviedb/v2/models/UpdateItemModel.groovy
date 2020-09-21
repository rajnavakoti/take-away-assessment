package api.themoviedb.v2.models

import groovy.json.JsonGenerator

class UpdateItemModel {
    ArrayList<ItemMessageModel> items = null

    def static updateItem(String mediaType,String mediaId,String comment){
        new UpdateItemModel(items: [new ItemMessageModel().updateItemMessage(mediaType,mediaId,comment)])
    }

    def toJson(){
        JsonGenerator jg = new JsonGenerator.Options()
                .excludeNulls()
                .build()
        jg.toJson(this)
    }
}
