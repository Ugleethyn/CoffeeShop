package coffeeshop.service;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ImgUploadServiceImpl implements ImgUploadService{

    @Override
    public void saveImage(MultipartFile fileImage) throws Exception {
        String folder = "C:\\Users\\asus\\Documents\\NetBeansProjects\\CoffeeShop\\src\\main\\resources\\static\\img\\";
        byte[] bytes = fileImage.getBytes();
        Path path = Paths.get(folder + fileImage.getOriginalFilename());
        Files.write(path, bytes);
    }
    
    
}
