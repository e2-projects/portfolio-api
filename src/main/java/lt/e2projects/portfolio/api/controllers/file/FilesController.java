package lt.e2projects.portfolio.api.controllers.file;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.constants.FilesFolder;
import lt.e2projects.portfolio.api.services.repository.FireStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = {"Files"})
@Controller
@RequiredArgsConstructor
public class FilesController implements FilesMapping {

    private final FireStorageService storageService;

    @Override
    public void uploadFile(FilesFolder folderName, MultipartFile file) {
        storageService.uploadFile(folderName.getValue(), file);
    }
}
