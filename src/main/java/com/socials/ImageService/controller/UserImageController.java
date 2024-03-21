package com.socials.ImageService.controller;

import com.socials.ImageService.service.UserImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class UserImageController {

    private final UserImageService userImageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("image")MultipartFile file,@RequestParam String email)
            throws IOException {
        String uploadFile = userImageService.uploadImage(file,email);
        return ResponseEntity.ok().body(uploadFile);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String email) throws IOException {
        byte[] image= userImageService.downloadImage(email);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("image/png")).body(image);
    }
}
