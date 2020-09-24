package api.themoviedb.v2.models

import org.apache.commons.lang3.RandomStringUtils
import groovy.json.JsonGenerator

class CreateListModel {
    String name = "Test Name"
    String iso_639_1 = "en"
    String description = "List for test purpose"

    static def createList(String listName,String iso, String description) {
        new CreateListModel("name" : listName, "iso_639_1":iso, "description":description)
    }

    def toJson(){
        JsonGenerator jg = new JsonGenerator.Options()
                .excludeNulls()
                .build()
        jg.toJson(this)
    }
}
