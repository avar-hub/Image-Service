package com.socials.ImageService.service;

import com.socials.ImageService.entity.UserImage;
import com.socials.ImageService.repository.UserImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserImageService {

    private final UserImageRepo repo;

    private final String FOLDER= "C:/Users/avarm/OneDrive/Documents/Socials/User_Images";
    public String uploadImage(MultipartFile file,String email) throws IOException {

        String filePath= FOLDER+file.getOriginalFilename();

        UserImage userImage= repo.save(UserImage.builder()
                .name(file.getOriginalFilename()).type(file.getContentType())
                .filepath(filePath).email(email).build());

        file.transferTo(new File(filePath));
        if(userImage!=null)
            return "Image saved Sucessfully";
        return "Please upload again";
    }

    public  byte[] downloadImage(String fileName) throws IOException {
        Optional<UserImage> userImage= repo.findByEmail(fileName);
        String filePath = userImage.get().getFilepath();
        byte[] image= Files.readAllBytes(new File(filePath).toPath());
        return image;
    }
}
