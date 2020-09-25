package api.themoviedb.v2.models

import groovy.json.JsonGenerator

/***
 * Update List API request json generator
 */
class UpdateListModel {
    String description = "Test Description"

    static def updateList(String description) {
        new UpdateListModel("description" : description) }

    def toJson(){
        JsonGenerator jg = new JsonGenerator.Options()
                .excludeNulls()
                .build()
        jg.toJson(this) }
}
