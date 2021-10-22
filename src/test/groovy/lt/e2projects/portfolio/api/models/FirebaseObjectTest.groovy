package lt.e2projects.portfolio.api.models

import lt.e2projects.portfolio.api.TestObjects
import spock.lang.Specification

class FirebaseObjectTest extends Specification {

    def "Should get all Company object values as map"() {
        given:
            FirebaseObject company = TestObjects.getCompany()
        when:
            def map = company.valuesMap()
        then:
            map.keySet().size() == 2
            map.get("name") == company.getName()
            map.get("url") == company.getUrl()
    }

    def "Should get all Profile object values as map"() {
        given:
            FirebaseObject profile = TestObjects.getProfile()
        when:
            def map = profile.valuesMap()
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
            def map = socialLinks.valuesMap()
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
            def map = homeTabData.valuesMap()
        then:
            map.keySet().size() == 5
            map.get("fullName") == homeTabData.getFullName()
            map.get("position") == homeTabData.getPosition()
            map.get("address") == homeTabData.getAddress()
            map.get("description") == homeTabData.getDescription()
            map.get("company") == homeTabData.getCompany().valuesMap()
    }

    def "Should get all Skill group object values as map"() {
        given:
            FirebaseObject skillGroup = TestObjects.getSkillGroups().get(0)
        when:
            def map = skillGroup.valuesMap()
        then:
            map.keySet().size() == 3
            map.get("name") == skillGroup.getName()
            map.get("position") == skillGroup.getPosition()
            map.get("skills") == skillGroup.getSkills()
    }

}
