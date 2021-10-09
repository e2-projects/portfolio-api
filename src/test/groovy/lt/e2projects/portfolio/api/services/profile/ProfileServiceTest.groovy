package lt.e2projects.portfolio.api.services.profile

import lt.e2projects.portfolio.api.TestConstants
import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.constants.CollectionName
import lt.e2projects.portfolio.api.models.Profile
import lt.e2projects.portfolio.api.services.repository.FirestoreService
import spock.lang.Specification
import spock.lang.Subject

class ProfileServiceTest extends Specification {

    @Subject
    private ProfileService service
    private FirestoreService repository = Mock()

    def "setup"() {
        service = new ProfileServiceImpl(repository)
    }

    def "Should call repository service to get Profile object"() {
        given: "expected response"
            def profile = TestObjects.getProfile()
        when:
            def response = service.getDataObject()
        then: "call repo once with values"
            1 * repository.get(CollectionName.PROFILE, Profile) >> profile
        expect:
            response == profile
    }

    def "Should call repository service to create Profile object"() {
        given: "request"
            def profile = TestObjects.getProfile()
        when:
            def id = service.createDataObject(profile)
        then: "call repo once with values"
            1 * repository.create(CollectionName.PROFILE, profile) >> TestConstants.DOCUMENT_ID
        expect:
            id == TestConstants.DOCUMENT_ID
    }

    def "Should call repository service to update Profile object"() {
        given: "update request"
            def newPosition = "Unemployed"
            def request = Profile.builder().position(newPosition).build()
            def updatedProfile = TestObjects.getProfile()
            updatedProfile.setPosition(newPosition)
        when:
            def response = service.updateDataObject(request)
        then: "call repo once with values"
            1 * repository.update(CollectionName.PROFILE, request) >> updatedProfile
        expect:
            response == updatedProfile
    }

}
