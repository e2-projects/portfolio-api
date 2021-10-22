package lt.e2projects.portfolio.api.controllers.tabs.skills

import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.services.skills.SkillsService
import spock.lang.Specification
import spock.lang.Subject

class SkillsControllerTest extends Specification {

    @Subject
    private SkillsMapping controller
    private SkillsService skillsService = Mock()

    def "setup"() {
        controller = new SkillsController(skillsService)
    }

    def "Should call service to get list of Skills Group"() {
        given: "expected response"
            def skillGroups = TestObjects.getSkillGroups()
        when:
            def response = controller.getData()
        then:
            1 * skillsService.getDataObject() >> skillGroups
        and:
            skillGroups === response
    }

    def "Should call service to create Skills group list"() {
        given:
            def request = TestObjects.getSkillGroups()
        when:
            controller.createData(request)
        then:
            1 * skillsService.createDataObject(request)
    }

}
