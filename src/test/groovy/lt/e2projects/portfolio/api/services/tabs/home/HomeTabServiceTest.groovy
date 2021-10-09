package lt.e2projects.portfolio.api.services.tabs.home

import lt.e2projects.portfolio.api.TestConstants
import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.constants.CollectionName
import lt.e2projects.portfolio.api.models.Company
import lt.e2projects.portfolio.api.models.tabs.HomeTabData
import lt.e2projects.portfolio.api.services.repository.FirestoreService
import spock.lang.Specification
import spock.lang.Subject

class HomeTabServiceTest extends Specification {

    @Subject
    private HomeTabService service
    private FirestoreService repository = Mock()

    def "setup"() {
        service = new HomeTabServiceImpl(repository)
    }

    def "Should call repository service to get Home tab data object"() {
        given: "expected response"
            def data = TestObjects.getHomeTabData()
        when:
            def response = service.getDataObject()
        then: "call repo once with values"
            1 * repository.get(CollectionName.TAB_HOME, HomeTabData) >> data
        expect:
            response == data
    }

    def "Should call repository service to create Home tab data object"() {
        given: "request"
            def data = TestObjects.getHomeTabData()
        when:
            def id = service.createDataObject(data)
        then: "call repo once with values"
            1 * repository.create(CollectionName.TAB_HOME, data) >> TestConstants.DOCUMENT_ID
        expect:
            id == TestConstants.DOCUMENT_ID
    }

    def "Should call repository service to update Home tab data object"() {
        given: "update request"
            def newPosition = "Model"
            def request = HomeTabData.builder().position(newPosition).company(new Company()).build()
            def updatedData = TestObjects.getHomeTabData()
            updatedData.setPosition(newPosition)
        when:
            def response = service.updateDataObject(request)
        then: "call repo once with values"
            1 * repository.update(CollectionName.TAB_HOME, request) >> updatedData
        expect:
            response == updatedData
    }

}
