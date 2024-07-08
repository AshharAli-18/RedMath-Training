package com.Lec4.SnookerClubManagementSystem.frame;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class FrameController {
    private final FrameService frameService;

    public FrameController(FrameService frameService) {
        this.frameService = frameService;
    }

    @GetMapping("api/getFrame/{id}")
    public Frame getFrame(@PathVariable int id) {
        Optional<Frame> frame=frameService.findById(id);
        if(frame.isPresent()) {
            return frame.get();
        }
        return null;
    }

    @GetMapping("api/getFrames")
    public List<Frame> getFrames() {
        return frameService.findAll();
    }

    @PostMapping("api/addFrame")
    public ResponseEntity<Frame> addFrame(@RequestBody Frame frame) {
        frame=frameService.create(frame);
        return ResponseEntity.ok(frame);
    }






}
