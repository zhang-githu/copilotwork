package com.example.photo_copilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.photo_copilot.service.ImageService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Controller
public class ImageController {

    private final Path rootLocation;

    @Autowired
    public ImageController(ImageService imageService) {
        this.rootLocation = imageService.getRootLocation();
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", Files.walk(this.rootLocation, 1)
                .filter(path -> !path.equals(this.rootLocation))
                .map(this.rootLocation::relativize)
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        return "redirect:/";
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            String encodedFilename = URLEncoder.encode(resource.getFilename(), StandardCharsets.UTF_8.toString());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + encodedFilename + "\"").body(resource);
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        } catch (IOException e) {
            throw new RuntimeException("FAIL!");
        }
    }
}