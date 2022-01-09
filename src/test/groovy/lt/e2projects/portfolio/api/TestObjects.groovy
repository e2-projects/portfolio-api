package lt.e2projects.portfolio.api

import lt.e2projects.portfolio.api.models.Company
import lt.e2projects.portfolio.api.models.Profile
import lt.e2projects.portfolio.api.models.Skill
import lt.e2projects.portfolio.api.models.SkillGroup
import lt.e2projects.portfolio.api.models.SocialLinks
import lt.e2projects.portfolio.api.models.tabs.AboutTabData
import lt.e2projects.portfolio.api.models.tabs.HomeTabData

import static lt.e2projects.portfolio.api.TestConstants.*
import static lt.e2projects.portfolio.api.TestConstants.SKILLS_NAME_1
import static lt.e2projects.portfolio.api.TestConstants.SKILL_1_1
import static lt.e2projects.portfolio.api.TestConstants.SKILL_1_2
import static lt.e2projects.portfolio.api.TestConstants.SKILL_1_3

class TestObjects {

    static Profile getProfile() {
        Profile.builder()
            .name(PROFILE_NAME)
            .surname(PROFILE_SURNAME)
            .position(PROFILE_POSITION)
            .build()
    }

    static Company getCompany() {
        Company.builder()
            .name(PROFILE_COMPANY_NAME)
            .url(PROFILE_COMPANY_URL)
            .build()
    }

    static SocialLinks getSocialLinks() {
        SocialLinks.builder()
            .linkedinUrl(LINKEDIN_URL)
            .facebookUrl(FACEBOOK_URL)
            .overflowUrl(STACKOVERFLOW_URL)
            .githubUrl(GITHUB_URL)
            .build()
    }

    static HomeTabData getHomeTabData() {
        HomeTabData.builder()
            .fullName(PROFILE_FULL_NAME)
            .position(PROFILE_POSITION)
            .address(PROFILE_ADDRESS)
            .description(PROFILE_DESCRIPTION)
            .company(getCompany())
            .build()
    }

    static List<SkillGroup> getSkillGroups() {
        return ArrayList.of(
                SkillGroup.builder()
                       .name(SKILLS_NAME_1)
                       .position(1)
                       .skills(ArrayList.of(
                               Skill.builder().name(SKILL_1_1).level(5).build(),
                               Skill.builder().name(SKILL_1_2).level(3).build(),
                               Skill.builder().name(SKILL_1_3).level(1).build()
                       )).build(),

                SkillGroup.builder()
                        .name(SKILLS_NAME_3)
                        .position(3)
                        .skills(ArrayList.of(
                                Skill.builder().name(SKILL_3_1).level(1).build(),
                                Skill.builder().name(SKILL_3_2).level(1).build(),
                                Skill.builder().name(SKILL_3_3).level(1).build(),
                        )).build(),

                SkillGroup.builder()
                        .name(SKILLS_NAME_2)
                        .position(2)
                        .skills(ArrayList.of(
                                Skill.builder().name(SKILL_2_1).level(1).build(),
                                Skill.builder().name(SKILL_2_2).level(1).build(),
                        )).build(),
        )
    }

    static List<AboutTabData> getAboutTabDataItems() {
        return Arrays.asList(
            AboutTabData.builder()
                .title("Short title 1")
                .content("Short text\nabout some things.")
                .build(),
            AboutTabData.builder()
                .title("Some Long title about some interesting things")
                .content("Some text about things which should be interesting, but it isn\'t.")
                .build()
        )
    }

}
