package coffeeshop.service;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface ImgUploadService {
    
    void saveImage(MultipartFile fileImage) throws Exception;
    
}
