package com.openjob.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Component
public class CloudinaryUtils {
    private Cloudinary cloudinary;

    @Value("${cloudinary.cloud_name}")
    private String cloudName;
    @Value("${cloudinary.api_key}")
    private String apiKey;
    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    @PostConstruct
    private void initialize() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    public String upload(MultipartFile file, String objectId) throws IOException {
        if (Objects.isNull(cloudinary))
            throw new IOException("Cloudinary instance is null");
        try {
            Map uploadResults = cloudinary.uploader().upload(
                    file.getBytes(), ObjectUtils.asMap("public_id", objectId)
            );
            return uploadResults.get("url").toString();
        } catch (Exception ex) {
            throw new IOException(NestedExceptionUtils.getMostSpecificCause(ex).getMessage());
        }
    }
    public String upload(byte[] bytes, String objectId) throws IOException {
        if (Objects.isNull(cloudinary))
            throw new IOException("Cloudinary instance is null");
        try {
            Map uploadResults = cloudinary.uploader().upload(
                    bytes, ObjectUtils.asMap("public_id", objectId)
            );
            return uploadResults.get("url").toString();
        } catch (Exception ex) {
            throw new IOException(NestedExceptionUtils.getMostSpecificCause(ex).getMessage());
        }
    }

    public void delete(String objectId) throws IOException {
        if (Objects.isNull(cloudinary))
            throw new IOException("Cloudinary instance is null");
        try {
            cloudinary.uploader().destroy(objectId, ObjectUtils.emptyMap());
        } catch (Exception ex) {
            throw new IOException(NestedExceptionUtils.getMostSpecificCause(ex).getMessage());
        }
    }
}
