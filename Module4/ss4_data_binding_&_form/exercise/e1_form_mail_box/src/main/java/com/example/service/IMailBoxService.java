package com.example.service;

import com.example.model.Mailbox;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMailBoxService {
    List<Mailbox> fileAll();
    void update(Mailbox mailbox);
    Mailbox findById(int id);

}
