package lt.e2projects.portfolio.api.models

import lt.e2projects.portfolio.api.TestObjects
import spock.lang.Specification

class FirebaseObjectTest extends Specification {

    def "Should get all Company object values as map"() {
        given:
            FirebaseObject company = TestObjects.getCompany()
        when:
            def map = company.getValuesMap()
        then:
            map.keySet().size() == 2
            map.get("name") == company.getName()
            map.get("url") == company.getUrl()
    }

    def "Should get all Profile object values as map"() {
        given:
            FirebaseObject profile = TestObjects.getProfile()
        when:
            def map = profile.getValuesMap()
        then:
            map.keySet().size() == 3
            map.get("name") == profile.getName()
            map.get("surname") == profile.getSurname()
            map.get("position") == profile.getPosition()
    }

    def "Should get all Social Links object values as map"() {
        given:
            FirebaseObject socialLinks = TestObjects.getSocialLinks()
        when:
            def map = socialLinks.getValuesMap()
        then:
            map.keySet().size() == 4
            map.get("linkedinUrl") == socialLinks.getLinkedinUrl()
            map.get("facebookUrl") == socialLinks.getFacebookUrl()
            map.get("overflowUrl") == socialLinks.getOverflowUrl()
            map.get("githubUrl") == socialLinks.getGithubUrl()
    }

    def "Should get all Home tab data object values as map"() {
        given:
            FirebaseObject homeTabData = TestObjects.getHomeTabData()
        when:
            def map = homeTabData.getValuesMap()
        then:
            map.keySet().size() == 5
            map.get("fullName") == homeTabData.getFullName()
            map.get("position") == homeTabData.getPosition()
            map.get("address") == homeTabData.getAddress()
            map.get("description") == homeTabData.getDescription()
            map.get("company") == homeTabData.getCompany().getValuesMap()
    }

}
