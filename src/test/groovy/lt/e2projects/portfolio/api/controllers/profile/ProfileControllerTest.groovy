package lt.e2projects.portfolio.api.controllers.profile

import lt.e2projects.portfolio.api.TestConstants
import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.models.Company
import lt.e2projects.portfolio.api.models.Profile
import lt.e2projects.portfolio.api.services.profile.ProfileService
import spock.lang.Specification
import spock.lang.Subject

class ProfileControllerTest extends Specification {

    @Subject
    private ProfileMapping controller
    private ProfileService profileService = Mock()

    def "setup"() {
        controller = new ProfileController(profileService)
    }

    def "Should be created Profile controller"() {
        expect:
            controller != null
    }

    def "Should call service to get Profile data object"() {
        given: "expected response"
            def profile = TestObjects.getProfile()
        when: "calling get endpoint method"
            def response = controller.getProfile()
        then: "get profile from service"
            1 * profileService.getDataObject() >>> profile
        expect: "equals"
            response == profile
    }

    def "Should call service to create Profile object"() {
        given: "request"
            def profile = TestObjects.getProfile()
        when: "calling create endpoint method"
            def response = controller.createProfile(profile)
        then: "call service and get document ID"
            1 * profileService.createDataObject(profile) >> TestConstants.DOCUMENT_ID
        expect: "equals"
            response == TestConstants.DOCUMENT_ID
    }

    def "Should call service only with updated Profile values"() {
        given:
            def newPosition = "Unemployed"
            def request = Profile.builder().position(newPosition).company(Company.builder().build()).build()
            def responseObject = TestObjects.getProfile()
            responseObject.setPosition(newPosition)
        when: "calling update endpoint method"
            def response = controller.updateProfile(null, null, newPosition, null, null, null)
        then: "call service and get updated profile"
            1 * profileService.updateDataObject(request) >> responseObject
        expect: "updated"
            response == responseObject
    }
}
