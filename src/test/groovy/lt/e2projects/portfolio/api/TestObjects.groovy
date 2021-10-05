package lt.e2projects.portfolio.api

import lt.e2projects.portfolio.api.models.Company
import lt.e2projects.portfolio.api.models.Profile
import lt.e2projects.portfolio.api.models.SocialLinks

class TestObjects {

    static Profile getProfile() {
        Profile.builder()
            .name(TestConstants.PROFILE_NAME)
            .surname(TestConstants.PROFILE_SURNAME)
            .address(TestConstants.PROFILE_ADDRESS)
            .position(TestConstants.PROFILE_POSITION)
            .company(getCompany())
            .build()
    }

    static Company getCompany() {
        Company.builder()
            .name(TestConstants.PROFILE_COMPANY_NAME)
            .url(TestConstants.PROFILE_COMPANY_URL)
            .build()
    }

    static SocialLinks getSocialLinks() {
        SocialLinks.builder()
            .linkedinUrl(TestConstants.LINKEDIN_URL)
            .facebookUrl(TestConstants.FACEBOOK_URL)
            .overflowUrl(TestConstants.STACKOVERFLOW_URL)
            .githubUrl(TestConstants.GITHUB_URL)
            .build()
    }

}
