package lt.e2projects.portfolio.api.constants

import spock.lang.Specification

class PathTest extends Specification {

    def "Should validate that paths match requirements"() {
        expect: "expected paths"
            value == given
        where:
            value        | given
            "/profile"   | Path.PROFILE
            "/social"    | Path.SOCIAL
            "/tabs/home" | Path.TAB_HOME
    }

}
