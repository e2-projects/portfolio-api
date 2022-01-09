package lt.e2projects.portfolio.api.services.tabs.about

import lt.e2projects.portfolio.api.TestConstants
import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.constants.CollectionName
import lt.e2projects.portfolio.api.services.repository.FirestoreService
import spock.lang.Specification
import spock.lang.Subject

class AboutTabServiceTest extends Specification {

    @Subject
    private AboutTabService service
    private FirestoreService repository = Mock()

    def "setup"() {
        service = new AboutTabServiceImpl(repository)
    }

    def "Should call firebase to create About Tab data"() {
        given:
            def request = TestObjects.getAboutTabDataItems()
        when:
            def ids = service.createDataObject(request)
        then:
            1 * repository.create(CollectionName.TAB_ABOUT, request.get(0)) >> TestConstants.DOC_ID_1
            1 * repository.create(CollectionName.TAB_ABOUT, request.get(1)) >> TestConstants.DOC_ID_2
        and:
            ids == TestConstants.DOC_IDS
    }

}
