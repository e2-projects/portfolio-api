package lt.e2projects.portfolio.api.commons

import lt.e2projects.portfolio.api.models.Profile
import spock.lang.Specification

class AppUtilsTest extends Specification {

    def "Should validate is object null or empty"() {
        expect:
            def result = AppUtils.isNullOrEmpty(value)
            expected == result
        where:
            value                   | expected
            ""                      | true
            "   "                   | true
            Collections.emptyList() | true
            null                    | true
            "a"                     | false
    }

    def "Should validate is object not null and not empty"() {
        expect:
            def result = AppUtils.isNotNullOrEmpty(value)
            expected == result
        where:
            value                      | expected
            "a"                        | true
            " b "                      | true
            Collections.singleton("c") | true
            1                          | true
            Profile.builder().build()  | true
            ""                         | false
    }

}
