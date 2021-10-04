package lt.e2projects.portfolio.api.services.social;

import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.constants.CollectionName;
import lt.e2projects.portfolio.api.models.SocialLinks;
import lt.e2projects.portfolio.api.services.repository.FirestoreService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SocialLinksServiceImpl implements SocialLinksService {

    private final FirestoreService repository;

    @Override
    public SocialLinks getDataObject() {
        return (SocialLinks) repository.get(CollectionName.SOCIAL, SocialLinks.class);
    }

    @Override
    public String createDataObject(SocialLinks socialLinks) {
        return repository.create(CollectionName.SOCIAL, socialLinks);
    }

    @Override
    public SocialLinks updateDataObject(SocialLinks socialLinks) {
        return (SocialLinks) repository.update(CollectionName.SOCIAL, socialLinks);
    }
}
