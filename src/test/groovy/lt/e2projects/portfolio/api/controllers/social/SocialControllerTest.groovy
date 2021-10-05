package lt.e2projects.portfolio.api.controllers.social

import lt.e2projects.portfolio.api.TestConstants
import lt.e2projects.portfolio.api.TestObjects
import lt.e2projects.portfolio.api.models.SocialLinks
import lt.e2projects.portfolio.api.services.social.SocialLinksService
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class SocialControllerTest extends Specification {

    @Subject
    private SocialMapping controller
    private SocialLinksService socialLinksService = Mock()

    def "setup"() {
        controller = new SocialController(socialLinksService)
    }

    def "Should call service to get Social Links data object"() {
        given: "expected response"
            def socialLinks = TestObjects.getSocialLinks()
        when: "calling get endpoint method"
            def response = controller.getSocialLinks()
        then: "get profile from service"
            1 * socialLinksService.getDataObject() >>> socialLinks
        expect: "equals"
            response == socialLinks
    }

    def "Should call service to create Social Links object"() {
        given: "request"
            def socialLinks = TestObjects.getSocialLinks()
        when: "calling create endpoint method"
            def response = controller.createSocialLinks(TestConstants.LINKEDIN_URL, TestConstants.FACEBOOK_URL,
                                                                TestConstants.STACKOVERFLOW_URL, TestConstants.GITHUB_URL)
        then: "call service and get document ID"
            1 * socialLinksService.createDataObject(socialLinks) >> TestConstants.DOCUMENT_ID
        expect: "equals"
            response == TestConstants.DOCUMENT_ID
    }

    def "Should call service only with updated Social Links values"() {
        given:
            def newUrl = "https://www.facebook.com/vergara"
            def request = SocialLinks.builder().facebookUrl(newUrl).build()
            def responseObject = TestObjects.getSocialLinks()
            responseObject.setFacebookUrl(newUrl)
        when: "calling update endpoint method"
            def response = controller.updateSocialLinks(null, newUrl, null, null)
        then: "call service and get updated social links"
            1 * socialLinksService.updateDataObject(request) >> responseObject
        expect: "updated"
            response == responseObject
    }

}
