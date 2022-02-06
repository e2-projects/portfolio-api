package lt.e2projects.portfolio.api.services.repository;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@Service
@RequiredArgsConstructor
class FireStorageServiceImpl implements FireStorageService {

    private final Bucket fileBucket;
    private final Storage fileStorage;

    private static final String FOLDER_SEPARATOR = "/";

    @SneakyThrows
    @Override
    public void uploadFile(String folder, MultipartFile file) {
        cleanFolder(folder);
        fileBucket.create(getFileName(folder, file.getOriginalFilename()), file.getBytes(), file.getContentType());
    }

    private void cleanFolder(String folder) {
        var files = fileBucket.list(Storage.BlobListOption.startOffset(folder));
        for (var file : files.getValues()) {
            var fileNameParts = file.getName().split(FOLDER_SEPARATOR);
            if (fileNameParts.length > 1) {
                fileStorage.delete(fileBucket.getName(), getFileName(folder, fileNameParts[1]));
            }
        }
    }

    private String getFileName(String folderName, String fileName) {
        return folderName + FOLDER_SEPARATOR + fileName;
    }
}
