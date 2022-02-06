package lt.e2projects.portfolio.api.services.repository;

import org.springframework.web.multipart.MultipartFile;

public interface FireStorageService {

    void uploadFile(String folder, MultipartFile file);

}
