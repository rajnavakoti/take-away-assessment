package api.themoviedb.v2.models

import groovy.json.JsonGenerator

class ItemMessageModel {
    String media_type = ""
    String media_id = ""
    String comment = ""

    def static addItemMessage(String mediaType, String mediaId) {
        new ItemMessageModel("media_type": mediaType, "media_id": mediaId)
    }

    def static updateItemMessage(String mediaType, String mediaId,String comment) {
        new ItemMessageModel("media_type": mediaType, "media_id": mediaId,"comment":comment)
    }

    def static deleteItemMessage(String mediaType, String mediaId){
        new ItemMessageModel("media_type": mediaType, "media_id": mediaId)
    }
}
