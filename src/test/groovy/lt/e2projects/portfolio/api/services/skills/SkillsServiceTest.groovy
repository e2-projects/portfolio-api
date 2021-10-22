package lt.e2projects.portfolio.api.services.skills

import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.constants.CollectionName
import lt.e2projects.portfolio.api.services.repository.FirestoreService
import spock.lang.Specification
import spock.lang.Subject

class SkillsServiceTest extends Specification {

    @Subject
    private SkillsService service
    private FirestoreService repository = Mock()

    def "setup"() {
        service = new SkillsServiceImpl(repository)
    }

    def "Should call firebase to create Skill Groups"() {
        given:
            def request = TestObjects.getSkillGroups()
        when:
            service.createDataObject(request)
        then:
            3 * repository.create(CollectionName.TAB_SKILLS, _)
    }

}
