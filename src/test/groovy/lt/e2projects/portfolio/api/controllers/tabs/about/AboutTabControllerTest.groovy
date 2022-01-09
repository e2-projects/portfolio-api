package lt.e2projects.portfolio.api.controllers.tabs.about

import lt.e2projects.portfolio.api.TestConstants
import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.services.tabs.about.AboutTabService
import spock.lang.Specification
import spock.lang.Subject

class AboutTabControllerTest extends Specification {

    @Subject
    private AboutTabMapping controller
    private AboutTabService service = Mock()

    def "setup"() {
        controller = new AboutTabController(service)
    }

    def "Should call service to get About Tab data"() {
        given: "expected response"
            def expectedResponse = TestObjects.getAboutTabDataItems()
        when:
            def response = controller.getAboutData()
        then:
            1 * service.getDataObject() >> expectedResponse
        and:
            expectedResponse === response
    }

    def "Should call service to create About Tab data"() {
        given:
            def request = TestObjects.getAboutTabDataItems()
        when:
            def id = controller.createAboutData(request)
        then:
            1 * service.createDataObject(request) >> TestConstants.DOCUMENT_ID
        and:
            id === TestConstants.DOCUMENT_ID
    }
}
