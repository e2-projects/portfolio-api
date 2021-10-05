package lt.e2projects.portfolio.api.constants

import spock.lang.Specification

class CollectionNameTest extends Specification {

    def "Should validate that collection name match requirements"() {
        expect: "expected names"
            value == given
        where:
            value     | given
            "profile" | CollectionName.PROFILE
            "social"  | CollectionName.SOCIAL
    }

}
