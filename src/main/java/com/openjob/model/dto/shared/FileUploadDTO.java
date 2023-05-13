package com.openjob.model.dto.shared;

import com.openjob.model.dto.enums.FileCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileUploadDTO {
    private MultipartFile file;
    private String objectId;
    private FileCategory category;
}
