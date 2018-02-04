package testapp

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

/**
 * Created by François Martin on 04.02.2018.
 */
@Integration
@Rollback
class FoodSpec extends GebSpec {

    void "Edit nothing, German Locale"() {
        // Test
        when:
        go '/food/index?lang=de'
        then:
        title == "Food Liste"

        when: "Click on food 'Test Food 1'"
        $("a", text:"Test Food 1").click()
        then:
        title == "Food anzeigen"
        $("span#" + "name" + "-label + div").text() == "Test Food 1"
        $("span#" + "amount" + "-label + div").text() == "100"

        when: "Click on edit"
        $("a", text:"Bearbeiten").click()
        then:
        title == "Food bearbeiten"

        when: "Save"
        $("input", type: "submit").click()
        then:
        title == "Food anzeigen"
        $("span#" + "amount" + "-label + div").text() == "100"
    }

}
