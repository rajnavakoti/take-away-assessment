package api.themoviedb.v2.models

import com.github.javafaker.Faker
import groovy.json.JsonGenerator

class CreateListModel {
    String name = "Test Name"
    String iso_639_1 = "en"
    String description = "List for test purpose"

    static def createList(String listName) {
        new CreateListModel("name" : listName)
    }

    def toJson(){
        JsonGenerator jg = new JsonGenerator.Options()
                .excludeNulls()
                .build()
        jg.toJson(this)
    }
}
