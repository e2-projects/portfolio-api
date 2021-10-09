package lt.e2projects.portfolio.api

import lt.e2projects.portfolio.api.models.Company
import lt.e2projects.portfolio.api.models.Profile
import lt.e2projects.portfolio.api.models.SocialLinks
import lt.e2projects.portfolio.api.models.tabs.HomeTabData

class TestObjects {

    static Profile getProfile() {
        Profile.builder()
            .name(TestConstants.PROFILE_NAME)
            .surname(TestConstants.PROFILE_SURNAME)
            .position(TestConstants.PROFILE_POSITION)
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

    static HomeTabData getHomeTabData() {
        HomeTabData.builder()
            .fullName(TestConstants.PROFILE_FULL_NAME)
            .position(TestConstants.PROFILE_POSITION)
            .address(TestConstants.PROFILE_ADDRESS)
            .description(TestConstants.PROFILE_DESCRIPTION)
            .company(getCompany())
            .build()
    }

}
