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
    public ResponseEntity<String> uploadFile(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadFile = userImageService.uploadImage(file);
        return ResponseEntity.ok().body(uploadFile);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String fileName) throws IOException {
        byte[] image= userImageService.downloadImage(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("image/png")).body(image);
    }
}
