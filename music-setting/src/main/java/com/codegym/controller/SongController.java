package com.codegym.musicapp.controller;

import com.codegym.musicapp.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class SongController {

    private List<Song> songs = new ArrayList<>();

    // Danh sách đuôi file hợp lệ
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("mp3", "wav", "ogg", "m4p");

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/upload")
    public String uploadForm(Model model) {
        model.addAttribute("song", new Song());
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadSong(@ModelAttribute Song song,
                             @RequestParam("file") MultipartFile file,
                             Model model) throws IOException {

        if (file.isEmpty()) {
            model.addAttribute("error", "Please select a file to upload.");
            return "upload";
        }

        // Lấy phần mở rộng file
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();

        if (!ALLOWED_EXTENSIONS.contains(extension)) {
            model.addAttribute("error", "Invalid file type. Only mp3, wav, ogg, m4p allowed.");
            return "upload";
        }

        // Lưu file vào thư mục uploads
        String uploadDir = "uploads/";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String filePath = uploadDir + UUID.randomUUID() + "_" + originalFilename;
        file.transferTo(new File(filePath));

        // Lưu thông tin bài hát
        song.setFilePath(filePath);
        songs.add(song);

        return "redirect:/";
    }
}
