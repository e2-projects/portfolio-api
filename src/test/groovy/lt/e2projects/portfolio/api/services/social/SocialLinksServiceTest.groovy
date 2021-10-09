package lt.e2projects.portfolio.api.services.social

import lt.e2projects.portfolio.api.TestConstants
import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.constants.CollectionName
import lt.e2projects.portfolio.api.models.SocialLinks
import lt.e2projects.portfolio.api.services.repository.FirestoreService
import spock.lang.Specification
import spock.lang.Subject

class SocialLinksServiceTest extends Specification {

    @Subject
    private SocialLinksService service
    private FirestoreService repository = Mock()

    def "setup"() {
        service = new SocialLinksServiceImpl(repository)
    }

    def "Should call repository service to get Social Links object"() {
        given: "expected response"
            def socialLinks = TestObjects.getSocialLinks()
        when:
            def response = service.getDataObject()
        then: "call repo once with values"
            1 * repository.get(CollectionName.SOCIAL, SocialLinks) >> socialLinks
        expect:
            response == socialLinks
    }

    def "Should call repository service to create Social Links object"() {
        given: "request"
            def socialLinks = TestObjects.getSocialLinks()
        when:
            def id = service.createDataObject(socialLinks)
        then: "call repo once with values"
            1 * repository.create(CollectionName.SOCIAL, socialLinks) >> TestConstants.DOCUMENT_ID
        expect:
            id == TestConstants.DOCUMENT_ID
    }

    def "Should call repository service to update Social Links object"() {
        given: "update request"
            def newUrl = "https://www.facebook.com/vergara"
            def request = SocialLinks.builder().facebookUrl(newUrl).build()
            def updatedSocialLinks = TestObjects.getSocialLinks()
            updatedSocialLinks.setFacebookUrl(newUrl)
        when:
            def response = service.updateDataObject(request)
        then: "call repo once with values"
            1 * repository.update(CollectionName.SOCIAL, request) >> updatedSocialLinks
        expect:
            response == updatedSocialLinks
    }

}
