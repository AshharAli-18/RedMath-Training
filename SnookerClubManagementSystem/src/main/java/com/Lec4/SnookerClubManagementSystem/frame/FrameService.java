package com.Lec4.SnookerClubManagementSystem.frame;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class FrameService {
    private final FrameRepository frameRepository;

    public FrameService(FrameRepository frameRepository) {
        this.frameRepository = frameRepository;
    }

    public Optional<Frame> findById(int id) {
        return frameRepository.findById(id);
    }

    public List<Frame> findAll() {
        return frameRepository.findAll();
    }

    public Frame create(Frame frame) {
        return frameRepository.save(frame);
    }
}
