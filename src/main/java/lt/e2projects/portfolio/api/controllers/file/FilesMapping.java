package lt.e2projects.portfolio.api.controllers.file;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.portfolio.api.constants.FilesFolder;
import lt.e2projects.portfolio.api.constants.Headers;
import lt.e2projects.portfolio.api.constants.Path;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
public interface FilesMapping {

    @ApiOperation(
            value = "Upload file",
            notes = "Upload file to Firebase Storage",
            response = void.class
    )
    @PostMapping(Path.FILE)
    void uploadFile(@RequestHeader(Headers.STORAGE_FOLDER_NAME) FilesFolder folderName,
                    @RequestPart MultipartFile file);

}
