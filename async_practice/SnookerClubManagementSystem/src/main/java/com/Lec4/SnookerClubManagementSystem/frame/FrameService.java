package com.Lec4.SnookerClubManagementSystem.frame;

import org.springframework.scheduling.annotation.Async;
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

    @Async
    public void sendEmail(Frame frame)  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("email sent successfully :" + Thread.currentThread().getName());

    }

    @Async
    public void sendNotification(Frame frame) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("notification sent successfully :" + Thread.currentThread().getName());


    }


}
